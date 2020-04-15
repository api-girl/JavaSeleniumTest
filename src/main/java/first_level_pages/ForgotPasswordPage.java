package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import second_level_pages.ConfPage;

public class ForgotPasswordPage extends Page{
    private WebDriver driver;
    private By emailField = By.id("email");

    private By submitButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
    }

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
