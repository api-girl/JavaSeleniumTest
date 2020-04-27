package handlingCookies;

import base.BaseTest;
import org.testng.annotations.Test;
import utilities.CookieManager;

import static org.testng.Assert.*;

public class HandlingCookiesTest extends BaseTest {
    private CookieManager cookies = new CookieManager();

    @Test
    public void setAnIndividualCookie(){
        cookies.setCookie("Nevenin kolacic", "%pojela sam sve%");

        assertNotNull(cookies.getCookie("Nevenin kolacic"));
    }

    @Test
    public void deleteAnExistingCookie(){
        cookies.deleteACookie("optimizelyBuckets");

        assertNull(cookies.getCookie("optimizelyBuckets"));
        assertNotNull(cookies.getCookie("optimizelyPendingLogEvents"));
    }

}
