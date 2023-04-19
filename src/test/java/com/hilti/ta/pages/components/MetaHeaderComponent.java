package com.hilti.ta.pages.components;

import com.hilti.ta.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MetaHeaderComponent extends PageObject {
    public WebDriver driver;

    public MetaHeaderComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(css = "#search_input")
    WebElement searchField;

    @FindBy(css = ".m-nav-meta-search [type='submit']")
    WebElement loopIcon;

    public void searchTermAndClickLoopIcon(String term){
        searchField.sendKeys(term);
        loopIcon.click();
    }

}
