package com.hilti.ta.pages;

import com.hilti.ta.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import java.time.Duration;

public abstract class PageObject {

    private final WebDriver driver = WebDriverFactory.getDriver();

    protected boolean isElementVisible(final By locator) {
        try {
            final WebElement consentBanner = WebDriverFactory.getWebDriverWait(2)
                    .until(ExpectedConditions.presenceOfElementLocated(locator));
            return consentBanner.isDisplayed();
        } catch (final TimeoutException e) {
            return false; // Element not found
        }
    }

    /**
     * Navigate to page based on current url
     */
    public void navigateTo(String page) {
        String currentUrl = driver.getCurrentUrl();
        driver.get(currentUrl + page);
    }

    /**
     * Check element is clickable and click
     *
     * @param element which should be clicked
     */
    public void clickOn(By element) {
        WebDriverFactory.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        WebDriverFactory.getDriver().findElement(element).click();
    }

    /**
     * Check visibility and click on checkboxes one by one
     *
     * @param checkBox to click on
     * @param howMany  of checkboxes to click
     */
    public void checkVisibilityAndClickOn(By checkBox, int howMany) {
        WebDriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(checkBox));
        List<WebElement> elements = WebDriverFactory.getDriver().findElements(checkBox);
        elements.stream().limit(howMany).forEach(WebElement::click);
    }
}
