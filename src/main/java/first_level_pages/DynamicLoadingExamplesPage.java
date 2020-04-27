package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.Page;
import second_level_pages.Example1Page;
import second_level_pages.Example2Page;

public class DynamicLoadingExamplesPage extends Page {
    private String example1 = "a[href='/dynamic_loading/1']";
    private String example2 = "a[href='/dynamic_loading/2']";

    public Example1Page goToExample1Page(){
        clickByCssSelector(example1);
        return new Example1Page();
    }

    public Example2Page goToExample2Page(){
        clickByCssSelector(example2);
        return new Example2Page();
    }

    public WebElement findLinkForOpeningANewPage(String locator){
        return driver.findElement(By.cssSelector(locator));
    }

      public Example1Page openExampleWithSendingKeys(String cssSelector){
        findLinkForOpeningANewPage(cssSelector).sendKeys(Keys.CONTROL, Keys.ENTER);
        return new Example1Page();
    }



}
