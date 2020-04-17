package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Page {
    protected static WebDriver driver;

    public void setPageDriver(WebDriver driver){
        Page.driver = driver;
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


}
