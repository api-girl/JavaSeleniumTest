package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.Page;

public class LargeDeepDomPage extends Page {
    private By table = By.id("large-table");

    public WebElement getTable(){
        return driver.findElement(table);
    }

    public void scrollToTable(){
        WebElement largeTable = getTable();
        String script = "arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(script, largeTable);
    }

}
