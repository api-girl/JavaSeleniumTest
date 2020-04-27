package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Page {
    protected static WebDriver driver;

    public void setPageDriver(WebDriver driver){
        Page.driver = driver;
    }

    public WebElement getElement(By locator){
        return driver.findElement(locator);
    }

    public void sendTextToField(By locator, String text){
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();
    }

    public void clickByLinkText(String linkText){
        getElement(By.linkText(linkText)).click();
    }

    public void clickById(String id){
        getElement(By.id(id)).click();
    }

    public void clickByName(String name){
        getElement(By.name(name)).click();
    }

    public void clickByTagName(String tagName){
        getElement(By.tagName(tagName)).click();
    }

    public void clickByXPath(String xPath){
        getElement(By.xpath(xPath)).click();
    }

    public void clickByClassName(String className){
        getElement(By.className(className)).click();
    }

    public void clickByCssSelector(String cssSelector){
        getElement(By.cssSelector(cssSelector)).click();
    }

    public void waitForElementVisibility(By locator){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
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

    public String getTabHandle(){
        return driver.getWindowHandle();
    }

    public void waitForAllTabsToLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        int complete = driver.getWindowHandles().size();
        wait.until(ExpectedConditions.numberOfWindowsToBe(complete));
    }

    public void waitForElementStalness(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.stalenessOf(element));
    }

    public void deleteCookiesAfterEachTest() {
        driver.manage().deleteAllCookies();
    }


}
