package com.hilti.ta.pages.components;

import com.hilti.ta.pages.PageObject;
import com.hilti.ta.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

import static org.testng.Assert.*;

public class SearchResultComponent extends PageObject {
    public WebDriver driver;

    public SearchResultComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "#tab-button-tab-products")
    WebElement productsTab;

    @FindBy(css = "#tab-button-tab-technical-documents")
    WebElement technicalDocsTab;

    @FindBy(css = "#tab-button-tab-videos")
    WebElement videosTab;

    @FindBy(css = "#tab-button-tab-editorials")
    WebElement editorialsTab;

    @FindBy(css = ".o-prod-grid--list .m-grid-tile--link")
    List<WebElement> productList;

    @FindBy(css = ".m-library-items .m-library-item")
    List<WebElement> technicalDocsList;

    @FindBy(css = ".o-prod-grid--list .m-product-videos-item")
    List<WebElement> videosList;

    @FindBy(css = ".m-library-items .m-library-item--search-pages")
    List<WebElement> editorialsList;

    @FindBy(css = ".js-preloader-message")
    WebElement preloaderMessage;

    @FindBy(xpath = "//a[@class='dj-up_a']")
    WebElement applyBtn;

    @FindBy(xpath = "//select[@id='cb_question_1']/option[@value='RUS']")
    WebElement dropdown1;

    @FindBy(xpath = "//select[@id='cb_question_21']/option[@value='RUS']")
    WebElement dropdown2;

    @FindBy(xpath = "//select[@id='cb_question_2']/option[@value='01'][2]")
    WebElement passportBio;

    @FindBy(xpath = "//select[@id='cb_question_3']/option[@value='NAC']")
    WebElement more90Days;

    @FindBy(xpath = "//select[@id='cb_question_18']/option[@value='N']")
    WebElement pickNO;

    @FindBy(xpath = "//select[@id='cb_question_7']/option[@value='N']")
    WebElement pickMoreThanOneYear;

    @FindBy(xpath = "//select[@id='cb_question_9']/option[@value='REM']")
    WebElement pickDN;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement submit;



    public void clickApply() {
        applyBtn.click();
    }

    public void pickRussia1() {
        dropdown1.click();
    }

    public void pickRussia2() {
        dropdown2.click();
    }

    public void pickPassportBio() {
        passportBio.click();
    }

    public void pick90DaysMore() {
        more90Days.click();
    }

    public void pickNO() {
        pickNO.click();
    }

    public void pickYearPlus() {
        pickMoreThanOneYear.click();
    }

    public void pickDN() {
        pickDN.click();
    }

    public void clickSubmit() {
        submit.click();
    }


    public void selectTechnicalDocsTab() {
        technicalDocsTab.click();
        verifyTabIsSelected(technicalDocsTab);
    }

    public void selectVideosTab() {
        videosTab.click();
        verifyTabIsSelected(videosTab);
    }

    public void selectEditorialsTab() {
        editorialsTab.click();
        verifyTabIsSelected(editorialsTab);
    }

    public void verifyProductListIsNotEmpty() {
        waitForElementToDisappear(preloaderMessage);
        assertFalse(productList.isEmpty(), "Product list is empty, but it shouldn't");
    }

    public void verifyProductTabIsSelected() {
        verifyTabIsSelected(productsTab);
    }

    public void verifyTechnicalDocsListIsNotEmpty() {
        waitForElementToDisappear(preloaderMessage);
        assertFalse(technicalDocsList.isEmpty(), "Technical documents list is empty, but it shouldn't");
    }

    public void verifyVideosListIsNotEmpty() {
        waitForElementToDisappear(preloaderMessage);
        assertFalse(videosList.isEmpty(),"Videos list is empty, but it shouldn't");
    }

    public void verifyEditorialsListIsNotEmpty() {
        waitForElementToDisappear(preloaderMessage);
        assertFalse(editorialsList.isEmpty(),"Editorials list is empty, but it shouldn't");
    }

    // method for use Stream API (I don't think it's necessary here)
    public void verifyTechnicalDocsExtensions(){
        List<String> docs = technicalDocsList
                .stream()
                .map(document -> document
                        .findElement(By.cssSelector(".a-link-download"))
                        .getAttribute("data-track-label"))
                .collect(Collectors.toList());
        List<String> docFileExtensions = docs
                .stream()
                .map(docName -> docName.substring(docName.length()-4,docName.length()))
                .collect(Collectors.toList());
        assertTrue(docFileExtensions.contains(".pdf"));
    }

    private void waitForElementToAppear(WebElement element) {
        WebDriverFactory.getWebDriverWait(2).until(ExpectedConditions.visibilityOf(element));
    }

    private void waitForElementToDisappear(WebElement element) {
        WebDriverFactory.getWebDriverWait(2).until(ExpectedConditions.invisibilityOf(element));
    }

    private void verifyTabIsSelected(WebElement tab) {
        waitForElementToAppear(tab);
        assertEquals(tab.getAttribute("aria-selected"), "true");
    }



}
