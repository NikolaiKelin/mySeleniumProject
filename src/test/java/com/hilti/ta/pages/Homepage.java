package com.hilti.ta.pages;

import com.hilti.ta.utils.Country;
import com.hilti.ta.utils.WebDriverFactory;

/**
 * Page Object Model representing Homepage.
 */
public class Homepage extends PageObject {

	private static final String HILTI_URL = "https://www.hilti";
	private static final String EVISA = "https://pedidodevistos.mne.gov.pt/VistosOnline/";

	/**
	 * Opens homepage for given country.
	 * 
	 * @param country
	 *            {@link Country}
	 */
	public void navigateTo(final Country country) {
		WebDriverFactory.getDriver().get(HILTI_URL + country.getDomain());
	}

	public void openMainPage() {
		WebDriverFactory.getDriver().get(EVISA);
	}
}
