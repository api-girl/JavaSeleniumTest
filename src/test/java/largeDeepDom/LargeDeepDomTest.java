package largeDeepDom;

import base.BaseTest;
import first_level_pages.LargeDeepDomPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LargeDeepDomTest extends BaseTest {
    LargeDeepDomPage deepDom;

    @Test
    public void testScrollingToTableElement(){
        deepDom = homePage.goToLargeDeepDomPage();
        deepDom.scrollToTable();

        assertTrue(deepDom.getTable().isDisplayed(), "The table is not displayed.");
    }
}
