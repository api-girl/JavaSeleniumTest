package menuItems;

import base.BaseTest;
import org.testng.annotations.Test;
import second_level_pages.MenuElementPage;
import first_level_pages.ShiftingContentPage;
import static org.testng.Assert.assertEquals;

public class MenuItemsTest extends BaseTest {
    private int expectedMenuItemsNumber = 5;

    @Test
    public void testCountMenuItems(){
        ShiftingContentPage shContent = homePage.goToShiftingContentPage();
        MenuElementPage menuElement = shContent.gotoMenuElementPage();

        assertEquals(menuElement.countMenuItems(), expectedMenuItemsNumber, "Menu Items number does not equal to "+ expectedMenuItemsNumber);
    }

}
