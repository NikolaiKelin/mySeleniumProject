package com.hilti.ta.steps;

import com.hilti.ta.pages.components.MetaHeaderComponent;
import com.hilti.ta.pages.components.SearchResultComponent;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

import static com.hilti.ta.steps.BackgroundSteps.driver;

public class SearchSteps {

    private final MetaHeaderComponent metaHeaderComponent = new MetaHeaderComponent(driver);
    private final SearchResultComponent searchResultComponent = new SearchResultComponent(driver);

    @When("User navigates to search page for search term {}")
    public void navigateToSearchPage(String searchTerm) {
        metaHeaderComponent.searchTermAndClickLoopIcon(searchTerm);
    }

    @When("User selects technical documents tab")
    public void selectTechnicalDocsTab() {
        searchResultComponent.selectTechnicalDocsTab();
    }

    @When("User selects videos tab")
    public void selectVideosTab() {
        searchResultComponent.selectVideosTab();
    }

    @When("User selects editorials tab")
    public void selectEditorialsTab() {
        searchResultComponent.selectEditorialsTab();
    }

    @Then("User can see product results in the search page")
    public void verifyProductResultsInSearchPage() {
        searchResultComponent.verifyProductTabIsSelected();
        // taking screenshot into a specific step
        Allure.addAttachment("Product results step screenshot",
                new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
        searchResultComponent.verifyProductListIsNotEmpty();
    }

    @Then("User can see technical document results in the search page")
    public void verifyTechnicalDocsResults() {
        searchResultComponent.verifyTechnicalDocsListIsNotEmpty();
        searchResultComponent.verifyTechnicalDocsExtensions();
    }

    @Then("User can see video results in the search page")
    public void verifyVideoResults() {
        searchResultComponent.verifyVideosListIsNotEmpty();
    }

    @Then("User can see editorial results in the search page")
    public void verifyEditorialResults() {
        searchResultComponent.verifyEditorialsListIsNotEmpty();
    }

}
