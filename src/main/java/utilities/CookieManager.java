package utilities;

import org.openqa.selenium.Cookie;

public class CookieManager extends Page {
    private static final String url = "the-internet.herokuapp.com";

    public void setCookie(String name, String value){
        Cookie cookie = new Cookie.Builder(name, value)
                .domain(url)
                .build();
        driver.manage().addCookie(cookie);
    }

    public Cookie getCookie(String cookieName){
        return driver.manage().getCookieNamed(cookieName);
    }

    public void deleteACookie(String cookieName){
        driver.manage().deleteCookieNamed(cookieName);
    }

}
