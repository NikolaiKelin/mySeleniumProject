package com.hilti.ta.pages;

import com.hilti.ta.utils.WebDriverFactory;

/**
 * Page Object Model representing Homepage.
 */
public class FormularioPage extends PageObject {

    private static final String FORMULARIO = "https://pedidodevistos.mne.gov.pt/VistosOnline/Formulario";

    public void openFormularioPage() {
        WebDriverFactory.getDriver().get(FORMULARIO);
    }
}
