package com.hilti.ta.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioComponentDocTab {
    public WebDriver driver;

    public FormularioComponentDocTab(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='f14']")
    WebElement passport;

    @FindBy(xpath = "//select[@name='f15']/option[@value='RUS']")
    WebElement countryPass;

    @FindBy(xpath = "//input[@name='f16']")
    WebElement passStart;

    @FindBy(xpath = "//input[@name='f17']")
    WebElement passEnd;

    @FindBy(xpath = "//input[@name='f45']")
    WebElement countryRus;

    @FindBy(xpath = "//input[@name='f46']")
    WebElement phone;

    @FindBy(xpath = "//a[@rel='#tab_3_contents']")
    WebElement travelTab;

    public void setPass() {
        passport.sendKeys("766325917");
    }

    public void selectCountryPass() {
        countryPass.click();
    }

    public void setPassStart() {
        passStart.sendKeys("2022/01/12");
    }

    public void setPassEnd() {
        passEnd.sendKeys("2032/01/12");
    }

    public void setCountryRus() {
        countryRus.sendKeys("RUSSIA");
    }

    public void setPhone() {
        phone.sendKeys("+79817953180");
    }

    public void selectTravelTab() {
        travelTab.click();
    }
}
