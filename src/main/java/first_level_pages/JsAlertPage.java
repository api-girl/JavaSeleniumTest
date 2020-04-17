package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.Page;

public class JsAlertPage extends Page {
    private By triggerAlertButton = By.cssSelector("button[onclick='jsAlert()']");
    private By triggerConfirmButton = By.cssSelector("button[onclick='jsConfirm()']");
    private By triggerPromptButton = By.cssSelector("button[onclick='jsPrompt()']");

    private By resultMessage = By.id("result");

    public void activateAlert(By locator){
        driver.findElement(locator).click();
    }

    public void alert_clickToAccept(){
        driver.switchTo().alert().accept();
    }

    public WebElement getResult(){
        return driver.findElement(resultMessage);
    }

    public void alert_clickToCancel(){
        driver.switchTo().alert().dismiss();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void sendTextToPrompt(String input){
        driver.switchTo().alert().sendKeys(input);
    }
}
