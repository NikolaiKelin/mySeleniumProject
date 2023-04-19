package com.hilti.ta.utils;

import org.openqa.selenium.By;

/**
 * Enumeration class containing radio buttons for Selected submittal options.
 */
public enum OptionsRadioButton {
    NO_COVER("No cover page", "//label[contains(@for, 'noCover')]"),
    NO_NUMBERS("Do not include page numbers", "//label[contains(@for, 'page-numbers-no')]");

    private final String description;
    private final String locator;

    OptionsRadioButton(final String description, final String locator) {
        this.description = description;
        this.locator = locator;
    }

    public String getDescription() {
        return description;
    }

    public By getLocator() {
        return By.xpath(locator);
    }
}
