package dropdown;

import base.BaseTest;
import first_level_pages.DropdownPage;
import first_level_pages.HomePage;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {
DropdownPage dropdown;
    @Test
    public void testSelectAnOption(){
        dropdown = homePage.goToDropdownPage();
        String optionText1 = "Option 1";
        dropdown.selectFromDropDown(optionText1);
        List<String> selectedOptions = dropdown.getSelectedOptions();

        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections.");
        assertTrue(selectedOptions.contains(optionText1), "Option not selected");
    }

    @Test
    public void testHackDropDownAndSelectBothOptions(){
        dropdown = homePage.goToDropdownPage();
        dropdown.injectJSScript();                                        // enables selection of multiple dropdown options
        var optionsToSelect = List.of("Option 1", "Option 2");            // creates a list of options names that should be passed to selectFromDropDown method to be selected
        optionsToSelect.forEach(dropdown::selectFromDropDown);            // ArrayList forEach() method loops through options list and passes each option to selecFromDropDown
                                                                           // method and object dropdown
        assertEquals(dropdown.getSelectedOptions().size(), optionsToSelect.size(), "Number of options does not equal number of selected options.");
        assertTrue(dropdown.getSelectedOptions().containsAll(optionsToSelect), "Not all the options are selected.");
    }

}
