package com.hilti.ta.steps;

import com.hilti.ta.pages.components.FirestopsComponent;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import static com.hilti.ta.pages.FirestopsPage.FIRESTOPS;

/**
 * Cucumber steps definition class for generator page steps.
 */
public class FirestopsGeneratorSteps {

    private final FirestopsComponent firestopsComponent = new FirestopsComponent();

    @Given("User navigates to Firestop submittal generator page")
    public void userOpensHiltiFirestopsPage() {
        firestopsComponent.navigateTo(FIRESTOPS);
    }

    @And("User creates submittal")
    public void submitCreateButton(){
        firestopsComponent.clickOn();
    }

    @And("User starts submittal generation process")
    public void startSubmittal(){
        firestopsComponent.checkPageOpened();
    }

    @And("User selects Firestop systems: {}")
    public void setCheckBox(int howMany){
        firestopsComponent.setCheckBoxes(howMany);
    }
}
