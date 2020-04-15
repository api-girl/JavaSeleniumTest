package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import second_level_pages.SecureAreaPage;

public class FormAuthPage{
    private WebDriver driver;
    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private By username = By.id("username");
    private By password = By.id("password");
    private String loginButton = ".radius .fa-sign-in";

    public FormAuthPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickByCssSelector(String cssSelector){
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    public void setUsername(){
        WebElement uField = driver.findElement(username);
        uField.sendKeys(USERNAME);
    }

    public void setPassword(){
        WebElement pField = driver.findElement(password);
        pField.sendKeys(PASSWORD);

    }

    public SecureAreaPage clickLoginButton(){
        clickByCssSelector(loginButton);
        return new SecureAreaPage(driver);
    }
}
