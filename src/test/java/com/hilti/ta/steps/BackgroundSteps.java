package com.hilti.ta.steps;

import com.hilti.ta.pages.components.RescheduleComponents;
import com.hilti.ta.utils.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

/**
 * Cucumber hook steps definition class responsible for actions taken before and after test execution.
 */
public class BackgroundSteps {
    public static WebDriver driver;
    private final RescheduleComponents rescheduleComponents = new RescheduleComponents(driver);

    @Before
    public void beforeUITests() {
        WebDriverFactory.initialize();
        driver = WebDriverFactory.getDriver();
    }

    @After
    public void afterUITests(final Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.embed(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES),
                    "image/png",
                    "screen");
            rescheduleComponents.sendProgramStopsMessageToTelegramBot();
            driver.close();
            driver.quit();
        } else {
            rescheduleComponents.sendProgramStopsMessageToTelegramBot();
            WebDriverFactory.quitCurrentDriver();
        }
    }
}
