package com.hilti.ta.pages.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularioComponentIdentity {
    public WebDriver driver;

    public FormularioComponentIdentity(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//select[@name='f0sf1']/option[@value='1067']")
    WebElement consul;

    @FindBy(xpath = "//input[@title='Фамилия']")
    WebElement family;

    @FindBy(xpath = "//input[@title='Фамилия до брака']")
    WebElement familyBeforeMarriage;

    @FindBy(xpath = "//input[@title='Имя / именa']")
    WebElement firstName;

    @FindBy(xpath = "//input[@title='Дата рождения год/месяц/день (гггг/мм/дд)']")
    WebElement birthDate;

    @FindBy(xpath = "//input[@title='Место рождения']")
    WebElement birthPlace;

    @FindBy(xpath = "//select[@title='Страна']/option[@value='RUS']")
    WebElement country;

    @FindBy(xpath = "//select[@title='Гражданство (при рождении)']/option[@value='RUS']")
    WebElement birthCountry;

    @FindBy(xpath = "//select[@title='Семейное положение']/option[@value='2']")
    WebElement married;

    @FindBy(xpath = "//select[@title='Пол']/option[@value='M']")
    WebElement sex;

    @FindBy(xpath = "//a[@rel='#tab_2_contents']")
    WebElement docTab;

    public void pickConsul() {
        consul.click();
    }

    public void setFamily() {
        family.sendKeys("KELIN");
    }

    public void setFamilyBeforeMarriage() {
        familyBeforeMarriage.sendKeys("KELIN");
    }

    public void setFirstName() {
        firstName.sendKeys("NIKOLAI");
    }

    public void setBirthDate() {
        birthDate.sendKeys("1986/11/26");
    }

    public void setBirthPlace() {
        birthPlace.sendKeys("USSR");
    }

    public void selectCountry() {
        country.click();
    }

    public void selectBirthCountry() {
        birthCountry.click();
    }

    public void selectMarried() {
        married.click();
    }

    public void selectSex() {
        sex.click();
    }

    public void switchToTabDoc() {
        docTab.click();
    }

}
