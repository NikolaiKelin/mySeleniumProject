package com.hilti.ta.pages.components;

import com.hilti.ta.pages.PageObject;
import com.hilti.ta.utils.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.testng.Assert;


public class FirestopsBuilderComponent extends PageObject {

    private final By check_box = By.xpath("//*[contains(text(), 'Select item for submittal')]/..");
    private final By submit = By.xpath("//span[contains(text(),'Generate submittal')]/..");
    private final By downloadButton = By.xpath("//*[contains(@id,'download-link')]");
    private final static String HREF = "href";

    public void unsetCheckBoxes(int howMany) {
        checkVisibilityAndClickOn(check_box, howMany);
    }

    public void clickOn() {
        clickOn(submit);
        WebDriverFactory.getWebDriverWait().until(ExpectedConditions.visibilityOfElementLocated(downloadButton));
    }

    public void checkDownloadButton() {
        WebDriverFactory.getWebDriverWait().until(ExpectedConditions.elementToBeClickable(downloadButton));
        WebElement downloadBtn = WebDriverFactory.getDriver().findElement(downloadButton);
        String uri = downloadBtn.getAttribute(HREF);
        checkURI(uri);
    }

    /**
     * Check uri is valid
     *
     * @param uri from download button
     */
    private void checkURI(String uri) {
        try {
            URL url = new URL(uri);
            HttpURLConnection huc = (HttpURLConnection) url.openConnection();
            int responseCode = huc.getResponseCode();
            Assert.assertEquals(HttpURLConnection.HTTP_OK, responseCode);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
