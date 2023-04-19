package com.hilti.ta.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioComponentInfoTab {
    public WebDriver driver;

    public FormularioComponentInfoTab(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='f34']")
    WebElement name;

    @FindBy(xpath = "//input[@name='f34sf2']")
    WebElement address;

    @FindBy(xpath = "//select[@name='f34sf5']/option[@value='80']")
    WebElement region;

    @FindBy(xpath = "//select[@name='cmbDespesasRequerente_1']/option[@value='3']")
    WebElement pay;

    public void setName() {
        name.sendKeys("HOTEL");
    }

    public void setAddress() {
        address.sendKeys("HOTEL");
    }

    public void selectRegion() {
        region.click();
    }

    public void selectPayment() {
        pay.click();
    }

}
