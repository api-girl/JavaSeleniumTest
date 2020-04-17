package hover;

import base.BaseTest;
import first_level_pages.HomePage;
import first_level_pages.HoverPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import static org.testng.Assert.*;

public class HoverTest extends BaseTest {
    private HoverPage hoverPage;

    @Test
    public void testHoveringOverFigureDisplaysCaption(){
        hoverPage = homePage.goToHoverPage();
        HoverPage.Caption caption = hoverPage.hoversOverFigure(2);

       assertTrue(caption.isCaptionDisplayed(), "Caption is not displayed.");
    }

    @Test
    public void testHoveringOverFigureDisplaysCaptionWithCorrectTitle(){
        hoverPage = homePage.goToHoverPage();
        HoverPage.Caption caption = hoverPage.hoversOverFigure(2);

        assertEquals(caption.getHeaderText(), "name: user2", "Header text is not correct.");
    }

    @Test
    public void testHoveringOverFigureDisplaysCaptionWithCorrectLink(){
        hoverPage = homePage.goToHoverPage();
        HoverPage.Caption caption = hoverPage.hoversOverFigure(2);

        assertTrue(caption.getLink().endsWith("/users/2"), "The link does not end correctly.");
    }
}
