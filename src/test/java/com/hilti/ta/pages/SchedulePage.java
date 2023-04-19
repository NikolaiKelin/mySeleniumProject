package com.hilti.ta.pages;

import com.hilti.ta.utils.WebDriverFactory;

/**
 * Page Object Model representing Homepage.
 */
public class SchedulePage extends PageObject {

    private static final String EVISA_SH = "https://pedidodevistos.mne.gov.pt/VistosOnline/Agendamento";
    private static final String APP = "https://pedidodevistos.mne.gov.pt/VistosOnline/Pedidos";

    public void navigateToApp() {
        WebDriverFactory.getDriver().get(APP);
    }

    public void navigateTo() {
        WebDriverFactory.getDriver().get(EVISA_SH);
    }
}
