package com.hilti.ta.steps;

import com.hilti.ta.pages.Homepage;
import com.hilti.ta.pages.components.*;
import com.hilti.ta.services.BannersService;
import com.hilti.ta.services.BrowserService;
import com.hilti.ta.services.CookieService;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static com.hilti.ta.steps.BackgroundSteps.driver;
import static java.lang.Thread.sleep;

/**
 * Cucumber steps definition class for general purpose steps.
 */
public class GeneralSteps {

	private final Homepage homepage = new Homepage();
	private final CookieService cookieService = new CookieService();
	private final BrowserService browserService = new BrowserService();
	private final SearchResultComponent searchResultComponent = new SearchResultComponent(driver);
	private final FormularioComponentIdentity formularioComponent = new FormularioComponentIdentity(driver);
	private final FormularioComponentDocTab formularioComponentDocTab = new FormularioComponentDocTab(driver);
	private final FormularioComponentTravelTab formularioComponentTravelTab = new FormularioComponentTravelTab(driver);
	private final FormularioComponentInfoTab formularioComponentInfoTab = new FormularioComponentInfoTab(driver);

	@Given("User opens EVISA website")
	public void userOpensEVisaWebsite() {
		homepage.openMainPage();

		cookieService.setCookies();

		browserService.refreshPage();
	}

	@Then("Click Apply")
	public void clickApply() {
		searchResultComponent.clickApply();
	}

	@Then("Choose Russia first dropdown")
	public void chooseRussia1() {
		searchResultComponent.pickRussia1();
	}

	@Then("Choose Russia second dropdown")
	public void chooseRussia2() {
		searchResultComponent.pickRussia2();
	}

	@Then("Choose Bio Passport")
	public void chooseBioPass() {
		searchResultComponent.pickPassportBio();
	}

	@Then("Choose more than 90 days")
	public void chooseMoreDays() {
		searchResultComponent.pick90DaysMore();
	}

	@Then("Choose NO")
	public void chooseNO() {
		searchResultComponent.pickNO();
	}

	@Then("Choose more than year")
	public void chooseYearPlus() {
		searchResultComponent.pickYearPlus();
	}

	@Then("Choose DN")
	public void chooseDN() {
		searchResultComponent.pickDN();
	}

	@Then("Click on Анкета")
	public void clickSubmitBtn() {
		searchResultComponent.clickSubmit();
	}

	@Then("Choose consul")
	public void chooseConsul() {
		formularioComponent.pickConsul();
	}

	@Then("Set family name")
	public void setFamilyName() {
		formularioComponent.setFamily();
	}

	@Then("Set family name before marriage")
	public void setFamilyNameBeforeMarriage() {
		formularioComponent.setFamilyBeforeMarriage();
	}

	@Then("Set first name")
	public void setFirstName() {
		formularioComponent.setFirstName();
	}

	@Then("Set birth date")
	public void setBirthDate() {
		formularioComponent.setBirthDate();
	}

	@Then("Set birth place")
	public void setBirthPlace() {
		formularioComponent.setBirthPlace();
	}

	@Then("Select country")
	public void selectCountry() {
		formularioComponent.selectCountry();
	}

	@Then("Select birth country")
	public void selectBirthCountry() {
		formularioComponent.selectBirthCountry();
	}

	@Then("Select married")
	public void selectMarried() {
		formularioComponent.selectMarried();
	}

	@Then("Select man")
	public void selectSex() {
		formularioComponent.selectSex();
	}

	@Then("Switch to Doc Tab")
	public void clickDoc() {
		formularioComponent.switchToTabDoc();
	}

	@Then("Set passport")
	public void setPass() {
		formularioComponentDocTab.setPass();
	}

	@Then("Set passport country")
	public void setPassCountry() {
		formularioComponentDocTab.selectCountryPass();
	}

	@Then("Set passport start")
	public void setPassStart() {
		formularioComponentDocTab.setPassStart();
	}

	@Then("Set passport end")
	public void setPassEnd() {
		formularioComponentDocTab.setPassEnd();
	}

	@Then("Set country RUS")
	public void setCountry() {
		formularioComponentDocTab.setCountryRus();
	}

	@Then("Set phone")
	public void setPhone() {
		formularioComponentDocTab.setPhone();
	}

	@Then("Switch to travel tab")
	public void switchToTravelTab() {
		formularioComponentDocTab.selectTravelTab();
	}

	@Then("Select profession")
	public void selectProf() {
		formularioComponentTravelTab.selectProf();
	}

	@Then("Set work")
	public void setWork() {
		formularioComponentTravelTab.setWork();
	}

	@Then("Set work2")
	public void setWork2() {
		formularioComponentTravelTab.setWork2();
	}

	@Then("Set extra info")
	public void setExtraInfo() {
		formularioComponentTravelTab.setExtraInfo();
	}

	@Then("Select Portugal")
	public void selectPRT() {
		formularioComponentTravelTab.selectPRT();
	}

	@Then("Select Info Tab")
	public void selectInfo() {
		formularioComponentTravelTab.selectInfo();
	}

	@Then("Set Name")
	public void setName() {
		formularioComponentInfoTab.setName();
	}

	@Then("Set Address")
	public void setAddress() {
		formularioComponentInfoTab.setAddress();
	}

	@Then("Select region")
	public void selectRegion() {
		formularioComponentInfoTab.selectRegion();
	}

	@Then("Select pay")
	public void selectPay() {
		formularioComponentInfoTab.selectPayment();
	}
}
