package forgotPassword;

import base.BaseTest;
import org.testng.annotations.Test;
import first_level_pages.ForgotPasswordPage;
import second_level_pages.ConfPage;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordTest extends BaseTest {

    private String confirmationMessage = "Your e-mail's been sent!";
    private static final String EMAIL = "test@yopmail.com";
    private static final String INVALIDEMAIL = "tttt.com";

    @Test
    public void testPasswordRecoveryEmailSuccessfullySent(){
        ForgotPasswordPage forgotPassword = homePage.goToForgotPasswordPage();
        ConfPage confPage = forgotPassword.retrievePassword(EMAIL);

        assertTrue(confPage.getConfirmationMessage().contains(confirmationMessage),
                "The confirmation message does not match the expected.");
    }

    @Test
    public void testPasswordRecoveryEmailInvalidEmail(){
        ForgotPasswordPage forgotPassword = homePage.goToForgotPasswordPage();
        ConfPage confPage = forgotPassword.retrievePassword(INVALIDEMAIL);
        System.out.println(confPage.getConfirmationMessage());
        assertTrue(confPage.getConfirmationMessage().contains(confirmationMessage),
                "The confirmation message does not match the expected.");
    }
}
