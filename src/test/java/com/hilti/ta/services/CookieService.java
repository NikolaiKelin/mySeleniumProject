package com.hilti.ta.services;

import java.util.Date;
import java.util.Objects;

import org.openqa.selenium.Cookie;

import com.hilti.ta.utils.WebDriverFactory;

public class CookieService {

    public void createCookie(final String name, final String value, String path) {
        if (path == null) {
            path = "/";
        }

        Date expire = new Date(new Date().getTime() + 100000000);
        final Cookie cookie = new Cookie(name, value, "pedidodevistos.mne.gov.pt", path, expire);
        WebDriverFactory.getDriver().manage().addCookie(cookie);
    }

    public void setCookies() {
        String visitosSid = "O4Pz3AK9A5+NpbbLuXaeEgPbHSbMx/uJhMhtfBgxymXhAZCWB7crqbnPC6S1lMwacKq+aGNCh/ZzGrrb7MwDlgh18b1Vz7FnnvyZxA==";
        String vistosGa = "GA1.4.694425802.1681064918";
        String vistosGaGid = "GA1.4.198634698.1681064918";
        String cookiesession1 = "678B28721F40DE5594C70ECDBEBCA61C";

        CookieService cookieService = new CookieService();
        cookieService.createCookie("_gat_gtag_UA_91078343_6", "1", null);
        cookieService.createCookie("cookiesession1", cookiesession1, null);
        cookieService.createCookie("Vistos_ga_gid", vistosGaGid, null);
        cookieService.createCookie("Vistos_ga", vistosGa, null);
        cookieService.createCookie("user_consent", "1", null);
        cookieService.createCookie("Vistos_sid", visitosSid, "/VistosOnline/");
    }
}
