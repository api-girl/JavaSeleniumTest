package dynamicLoading;

import base.BaseTest;
import first_level_pages.DynamicLoadingExamplesPage;
import org.testng.annotations.Test;
import second_level_pages.Example1Page;
import second_level_pages.Example2Page;

import static org.testng.Assert.assertEquals;

public class DynamicLoadingTest extends BaseTest {
    Example1Page example1;
    Example2Page example2;

    @Test
    public void testExample1GetTextAfterItBecomesVisible(){
        example1 = homePage.goToDynamicLoadingPage().goToExample1Page();
        example1.triggerLoading();

        assertEquals(example1.getLoadedText(), "Hello World!", "The loaded text does not match expected.");
    }

    @Test
    public void testExample1GetTextAfterLoadingIndicatorBecomesInvisible(){
        example1 = homePage.goToDynamicLoadingPage().goToExample1Page();
        example1.triggerLoading();

        assertEquals(example1.getLoadedTextAfterLoadingEnds(), "Hello World!", "The loaded text does not match expected.");
    }


    @Test
    public void testExample2GetTextAfterLoadingIndicatorBecomesInvisible(){
        example2 = homePage.goToDynamicLoadingPage().goToExample2Page();
        example2.triggerLoading();

        assertEquals(example2.getLoadedText(), "Hello World!", "The loaded text does not match expected.");
    }

    @Test
    public void testExample2GetTextOnceItBecomesPresent(){
        example2 = homePage.goToDynamicLoadingPage().goToExample2Page();
        example2.triggerLoading();

        assertEquals(example2.getTextAfterElementIsPresent(), "Hello World!", "The loaded text does not match expected.");

    }

}
