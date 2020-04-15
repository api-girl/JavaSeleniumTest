package dropdown;

import base.BaseTest;
import first_level_pages.DropdownPage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    @Test
    public void testSelectOption(){
        DropdownPage dropdown = homePage.goToDropdownPage();
        String optionText1 = "Option 1";
        dropdown.selectFromDropDown(optionText1);
        List<String> selectedOptions = dropdown.getSelectedOptions();

        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections.");
        assertTrue(selectedOptions.contains(optionText1), "Option not selected");
    }


}
