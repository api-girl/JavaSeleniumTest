package keyPresses;

import base.BaseTest;
import first_level_pages.HomePage;
import first_level_pages.KeyPresses;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class KeyPressesTest extends BaseTest {
    KeyPresses keyPresses;
    private String message = "You entered: DELETE";
    private String message1 = "You entered:";

    @Test
    public void testEnterKeyboardKeyInTextField(){
        keyPresses = homePage.goToKeyPressesPage();
        keyPresses.enterText("C"+ Keys.DELETE);

        assertEquals(keyPresses.getResult(), message, "The actual message does not match the expected.");
    }

    @Test
    public void testEnterPiSymbol(){
        keyPresses = homePage.goToKeyPressesPage();
        keyPresses.enterText("\u03C0");                        //Unicode character for Pi: "\u03C0"

         assertEquals(keyPresses.getResult(), message1, "The actual message does not match the expected.");
    }


}
