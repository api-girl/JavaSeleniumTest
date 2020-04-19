package contextMenu;

import base.BaseTest;
import first_level_pages.ContextMenu;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTest extends BaseTest {
    ContextMenu contextMenu;

    @Test
    public void testGetModalTextAndCloseIt(){
        contextMenu = homePage.goToContextMenuPage();
        contextMenu.rightClickOnBox();
        String actualAlertText = contextMenu.getAlertText();
        contextMenu.closeAlert();
        String expectedAlertText = "You selected a context menu";

        assertEquals(actualAlertText, expectedAlertText, "Actual text does not match the expected.");
    }
}
