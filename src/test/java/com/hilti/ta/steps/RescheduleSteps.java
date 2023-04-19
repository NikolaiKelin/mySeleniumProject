package com.hilti.ta.steps;

import com.hilti.ta.pages.SchedulePage;
import com.hilti.ta.pages.components.FormularioComponentIdentity;
import com.hilti.ta.pages.components.RescheduleComponents;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.hilti.ta.steps.BackgroundSteps.driver;

/**
 * Cucumber steps definition class for general purpose steps.
 */
public class RescheduleSteps {

    boolean isNeedToProceed = true;

    private final RescheduleComponents rescheduleComponents = new RescheduleComponents(driver);

    @Then("User clicks on APP")
    public void userClickOnAPP() {
        rescheduleComponents.clickOnApp();
        rescheduleComponents.sendMessageStartToTelegramBot();
    }

    @Then("User clicks on calendar")
    public void userClickOnCalendar() {
        rescheduleComponents.clickOnCalendar();
        sleep(2);
    }

    @Then("User clicks on Main calendar")
    public void userClickOnMainCalendar() {
        rescheduleComponents.clickOnMainCalendar();
        sleep(3);
    }

    @Then("User click left-right until available day is shown")
    public void userSearchAndWait() {
        rescheduleComponents.clickOnLeft();
        sleep(2);

        while (isNeedToProceed) {
            goLeft();
            goRigth();
        }
    }

    private void goLeft() {

        if (rescheduleComponents.isSeptember()) {
            checkWeeks();
            rescheduleComponents.clickOnLeft();
        }

        if (rescheduleComponents.isAugust()) {
            checkWeeks();
            rescheduleComponents.clickOnLeft();
        }

        if (rescheduleComponents.isJuly()) {
            checkWeeks();
            rescheduleComponents.clickOnLeft();
        }
    }

    private void goRigth() {
        if (rescheduleComponents.isJune()) {
            checkWeeks();
            rescheduleComponents.clickOnRigth();
        }

        if (rescheduleComponents.isJuly()) {
            checkWeeks();
            rescheduleComponents.clickOnRigth();
        }

        if (rescheduleComponents.isAugust()) {
            checkWeeks();
            rescheduleComponents.clickOnRigth();
        }
    }

    private void sleep(long sec) {
        try {
            Thread.sleep(sec * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void checkWeeks() {
        List<WebElement> weeks = rescheduleComponents.getWeeks();
        for (WebElement week : weeks) {
            String xpathExpression = "//*[starts-with(text(), '1') or starts-with(text(), '2') or starts-with(text(), '3')][string-length(text()) = 2]";
            List<WebElement> elements = week.findElements(By.xpath(xpathExpression));
            ArrayList<Object> words = new ArrayList<>();
            words.add("day wn");
            words.add("day disabled");
            words.add("day false");

            for (WebElement element : elements) {
                if (!words.contains(element.getAttribute("class"))) {
                    rescheduleComponents.sendMessageToTelegramBot();
                    isNeedToProceed = false;
                }
            }
        }
    }
}
