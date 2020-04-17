package horizontalSlider;

import base.BaseTest;
import first_level_pages.HomePage;
import first_level_pages.HorizontalSliderPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;

public class HorizontalSliderTest extends BaseTest {
    HorizontalSliderPage slider;
    private String expectedPosition = "4";

    @Test
    public void testMoveSliderToNumberFourWithSendingKeys(){
        slider = homePage.goToHorizontalSliderPage();
        slider.sendArrows(""+Keys.RIGHT, "4");

        assertEquals(slider.getNumberOfArrows(), expectedPosition, "The actual number of arrows does not match the expected.");

    }

    @Test
    public void testMoveSliderToNumberFourWithMouse(){
        slider = homePage.goToHorizontalSliderPage();
        slider.moveSliderToSpecificPosition("2.5");

        assertEquals(slider.getNumberOfArrows(), "2.5", "The actual number of arrows does not match the expected.");
    }

}
