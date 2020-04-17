package first_level_pages;

import org.openqa.selenium.By;
import page.Page;
import second_level_pages.ConfPage;

public class ForgotPasswordPage extends Page {
    private By emailField = By.id("email");
    private By submitButton = By.id("form_submit");

    public void setEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

   public ConfPage clickOnRetrievePasswordButton() {
        driver.findElement(submitButton).click();
        return new ConfPage(driver);
    }

    public ConfPage retrievePassword(String email){
        setEmail(email);
        return clickOnRetrievePasswordButton();

    }
}
