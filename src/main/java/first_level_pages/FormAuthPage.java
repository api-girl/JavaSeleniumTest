package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.Page;
import second_level_pages.SecureAreaPage;

public class FormAuthPage extends Page {
    private static final String USERNAME = "tomsmith";
    private static final String PASSWORD = "SuperSecretPassword!";
    private By username = By.id("username");
    private By password = By.id("password");
    private String loginButton = ".radius .fa-sign-in";

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
        return new SecureAreaPage();
    }
}
