package com.hilti.ta.pages.components;

import com.hilti.ta.pages.PageObject;
import com.hilti.ta.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class FirestopsComponent extends PageObject {

    private final By btn_create_submittal = By.xpath("//*[contains(text(), 'Create submittal')]/..");
    private final By check_box = By.xpath("//*[contains(@class, 'js-firestop-checkbox')]/..");
    private final By title = By.xpath("//div[contains(text(),'Documents and video library')]");

    public void clickOn() {
        clickOn(btn_create_submittal);
    }

    public void setCheckBoxes(int howMany) {
        checkVisibilityAndClickOn(check_box, howMany);
    }

    public void checkPageOpened() {
        WebDriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(title));
        Assert.assertTrue(WebDriverFactory.getDriver().findElement(title).isDisplayed());
    }
}
