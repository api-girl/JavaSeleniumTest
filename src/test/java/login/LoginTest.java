package login;

import base.BaseTest;
import first_level_pages.HomePage;
import org.testng.annotations.Test;
import first_level_pages.FormAuthPage;
import second_level_pages.SecureAreaPage;

import static org.testng.Assert.*;

public class LoginTest extends BaseTest {
    private String expectedPromptMessage = "You logged into a secure area!";

    @Test
    public void testSuccessfulLogin(){
        FormAuthPage formAuth = homePage.goToFormAuthPage();
        formAuth.setUsername();
        formAuth.setPassword();
        SecureAreaPage secureAreaPage = formAuth.clickLoginButton();

        assertTrue(secureAreaPage.getPromptMessage().contains(expectedPromptMessage), "Actual message differs from the expected.");
    }
}
