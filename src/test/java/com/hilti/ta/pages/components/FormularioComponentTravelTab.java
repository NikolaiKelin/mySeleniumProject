package com.hilti.ta.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioComponentTravelTab {
    public WebDriver driver;

    public FormularioComponentTravelTab(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//select[@name='f19']/option[@value='17']")
    WebElement profession;

    @FindBy(xpath = "//input[@name='f20sf1']")
    WebElement workPlace;

    @FindBy(xpath = "//input[@name='f20sf2']")
    WebElement workPlace2;

    @FindBy(xpath = "//input[@name='txtInfoMotEstada']")
    WebElement extraInfo;

    @FindBy(xpath = "//select[@name='f35']/option[@value='PRT']")
    WebElement border;

    @FindBy(xpath = "//a[@rel='#tab_5_contents']")
    WebElement infoTab;

    public void selectProf() {
        profession.click();
    }

    public void setWork() {
        workPlace.sendKeys("Ralf von Grafenstein");
    }

    public void setWork2() {
        workPlace2.sendKeys("Bank of Beneficiary: Bank of Georgia/+49 (0)331-867501-10");
    }

    public void setExtraInfo() {
        extraInfo.sendKeys("Work");
    }

    public void selectPRT() {
        border.click();
    }

    public void selectInfo() {
        infoTab.click();
    }
}
