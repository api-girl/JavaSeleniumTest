package infiniteScroll;

import base.BaseTest;
import first_level_pages.InfiniteScroll;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class InfiniteScrollTest extends BaseTest {
    InfiniteScroll scroll;

    @Test
    public void testFindParagraphByScrolling(){
        scroll = homePage.goToInfiniteScrollPage();

        assertTrue(scroll.scrollUntilParagraph(18).isDisplayed(), "The paragraph is not displayed.");
    }
}
