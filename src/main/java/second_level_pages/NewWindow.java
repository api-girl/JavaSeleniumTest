package second_level_pages;

import org.openqa.selenium.By;
import utilities.Page;

public class NewWindow extends Page {
    private By text = By.cssSelector("h3");


    public String getPageTitle (){
        return driver.getTitle();
    }

    public String getPageContent(){
        return driver.findElement(text).getText();
    }


}
