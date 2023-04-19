package com.hilti.ta.steps;

import com.hilti.ta.pages.components.FirestopsBuilderComponent;
import com.hilti.ta.utils.OptionsRadioButton;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

/**
 * Cucumber steps definition class for generator page steps.
 */
public class FirestopsBuilderSteps {
    private final FirestopsBuilderComponent firestopsComponent = new FirestopsBuilderComponent();

    @And("User deselects Firestop products: {}")
    public void unselectCheckBoxes(int howMany) {
        firestopsComponent.unsetCheckBoxes(howMany);
    }

    @And("User selects submittals options: {}, {}")
    public void selectOptionsRadioButtons(final OptionsRadioButton cover, final OptionsRadioButton numbers) {
        firestopsComponent.clickOn(cover.getLocator());
        firestopsComponent.clickOn(numbers.getLocator());
    }

    @And("User finalizes submittal generation process")
    public void clickOnSubmitButton() {
        firestopsComponent.clickOn();
    }

    @Then("User can download the generated document")
    public void checkPossibilityToDownloadFile() {
        firestopsComponent.checkDownloadButton();
    }
}
