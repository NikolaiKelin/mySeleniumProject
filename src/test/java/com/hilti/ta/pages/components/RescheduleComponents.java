package com.hilti.ta.pages.components;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.request.SendMessage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Page Object Model representing Legal Consents Banner and Popup.
 */
public class RescheduleComponents {
    public WebDriver driver;
    TelegramBot bot = new TelegramBot("6028811704:AAFh8306eSveHtiDzxlJcVME7sl3_ukTX-A");
    String chatIdKelin = "256562172";
    String chatIdPerova = "921171975";



    public RescheduleComponents(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//i[@class='fa fa-calendar ']")
    WebElement calendar;

    @FindBy(xpath = "//div[@id='navall']//a[@href='/VistosOnline/Pedidos']")
    WebElement app;

    @FindBy(xpath = "//i[@class='fa-calendar fa-lg']")
    WebElement mainCalendar;

    @FindBy(xpath = "//td[@class='title']")
    WebElement title;

    @FindBy(xpath = "//td[contains(text(),'October, 2023')]")
    WebElement october;

    @FindBy(xpath = "//td[contains(text(),'June, 2023')]")
    WebElement june;

    @FindBy(xpath = "//td[contains(text(),'September, 2023')]")
    WebElement september;

    @FindBy(xpath = "//td[contains(text(),'July, 2023')]")
    WebElement july;

    @FindBy(xpath = "//td[contains(text(),'August, 2023')]")
    WebElement august;

    @FindBy(xpath = "//tr[@class='headrow']//td[@colspan='1'][2]")
    WebElement leftArrow;

    @FindBy(xpath = "//tr[@class='headrow']//td[@colspan='1'][3]")
    WebElement rightArrow;

    public void clickOnApp() {
        app.click();
    }

    public void clickOnCalendar() {
        calendar.click();
    }

    public void clickOnMainCalendar() {
        mainCalendar.click();
    }

    public void clickOnRigth() {
        rightArrow.click();
    }

    public void clickOnLeft() {
        leftArrow.click();
    }

    public boolean isOctober() {
        return october.isDisplayed();
    }

    public boolean isSeptember() {
        return september.isDisplayed();
    }
    public boolean isAugust() {
        return august.isDisplayed();
    }

    public boolean isJuly() {
        return july.isDisplayed();
    }

    public boolean isJune() {
        return june.isDisplayed();
    }

    public List<WebElement> getWeeks() {
      return driver.findElements(By.xpath("//div[@class='calendar']//tbody//tr"));
    }

    public void sendMessageStartToTelegramBot() {
        SendMessage message1 = new SendMessage(chatIdKelin, "Program is running...");
        SendMessage message2 = new SendMessage(chatIdPerova, "Program is running...");
        bot.execute(message1);
        bot.execute(message2);
    }

    public void sendMessageToTelegramBot() {
        SendMessage message1 = new SendMessage(chatIdKelin, "CHECK the site!!!");
        SendMessage message2 = new SendMessage(chatIdPerova, "CHECK the site!!!");
        bot.execute(message1);
        bot.execute(message2);
    }

    public void sendProgramStopsMessageToTelegramBot() {
        SendMessage message1 = new SendMessage(chatIdKelin, "Program has stopped.");
        SendMessage message2 = new SendMessage(chatIdPerova, "Program has stopped.");
        bot.execute(message1);
        bot.execute(message2);
    }
}
