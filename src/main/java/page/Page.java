package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
    protected static WebDriver driver;

    public void setPageDriver(WebDriver driver){
        Page.driver = driver;
    }

    public void clickByLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public void clickById(String id){
        driver.findElement(By.id(id)).click();
    }

    public void clickByXPath(String xPath){
        driver.findElement(By.xpath(xPath)).click();
    }

    public void clickByClassName(String className){
        driver.findElement(By.className(className)).click();
    }

    public void clickByCssSelector(String cssSelector){
        driver.findElement(By.cssSelector(cssSelector)).click();
    }

    public void waitForElementVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
    }

    public void waitForElementClickability(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitForElementInvisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 6);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    public void waitForElementsPresence(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 7);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }




}
