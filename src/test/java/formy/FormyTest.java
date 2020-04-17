package formy;

import base.BaseTestFormy;
import first_level_pages.FormyPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class FormyTest extends BaseTestFormy {
    FormyPage formyPage;

//    @Test
//     public void testTextFields(){
//            FormyPage formyPage = new FormyPage(driver);
//          formyPage.setFirstName("Miriam");
////        WebElement lastName =
//          formyPage.setLastName(lastName);
////        WebElement jobTitle =
//          formyPage.setJobTitle(jobTitle);
//
//        assertSame("Miriam",firstName.getText(), "First name is not displayed.");
//        assertTrue(lastName.isDisplayed(), "Last name is not displayed.");
//        assertTrue(jobTitle.isDisplayed(), "Job title is not displayed.");
//}

    @Test
    public void testVerifyNoneRadioButtonIsSelected() {
        /*
            1. get a list of radio buttons and
            2. confirm that none is selected
         */
        assertFalse(formyPage.checkRadioButtonState(), "Radio buttons state is incorrect.");

       // assertFalse(, "The radio button is selected and should not be.");

    }

    @Test
    public void testClickAllRadioButtons() {
        /*
            1. get a list of radio buttons and confirm that none is selected
            2. click on every radio button in a list
            3. get all radio buttons again and confirm that all of them are selected
         */
    }
    @Test
    public void testUnclickAllRadioButtonsAndConfirmAllStaySelected(){
        /*
            1. get a list of radio buttons and confirm that none is selected
            2. click on every radio button in a list
            3. unclick all radio buttons in a list
            4. get all radio buttons again and confirm that all of them are still selected

         */
    }

    @Test
    public void testClickAllCheckBoxes() {
         /*
            1. get a list of checkboxes and confirm that none is selected
            2. click on every checkbox in a list
            3. get all checkboxes again and confirm that all of them are selected
         */
    }

    @Test
    public void testUnclickAllCheckBoxes(){
        /*
            1. get a list of checkboxes and confirm that none is selected
            2. click on every checkbox in a list
            3. unclick every checkbox in a list
            3. get all checkboxes again and confirm that none of them are selected
         */
    }


    @Test
    public void testDropdownMenu() {

    }



    @Test
    public void testVerifyCalendarPlaceholderIsDisplayed(){
        /*
        1. get text from calendar menu before opening it
        2. verify that it is displayed and that the placeholder message is correct
         */
    }

    @Test
    public void testVerifyDefaultDateIsSelected() {
        /*
        1. click on a calendar
        2. verify that todays's date is selected
         */
    }

    @Test
    public void testSelectDateInSameMonth(){
        /*
        1. click on a calendar
        2. click on another day in the same month
        3. verify that calendar menu is closed
        4. verify that the new date shows in calendar field
         */
    }

    @Test
    public void testChangeMonth(){
        /*
        1. click on a calendar
        2. change the month
        3. verify that the correct month name is displayed in calendar header
         */
    }

    @Test
    public void testSelectDateInAnotherMonth(){
        /*
        1. click on a calendar
        2. change the month
        3. select a date
        4. verify that the new date shows in calendar field
         */
    }

    @Test
    public void testSelectDateInAnotherYear(){
        /*
        1. click on a calendar
        2. click on the month
        3. click on the year
        4. change year
        5. select month
        6. select a date
        7. verify that the new date shows in calendar field
         */
    }

    @Test
    public void testEnterDateCorrectFormatCalendarMenuChanges(){
        /*
        1. click on a calendar - clear input
        2. send keys: '06/02/1989'
        3. verify that the correct day, month and year are showing up selected in calendar menu
         */
    }

    @Test
    public void testEnterDateCorrectFormatFieldSavesValue(){
        /*
        1. click on a calendar - clear input
        2. send keys: '06/02/1989'
        3. click on a blank space outside of field (maybe .submit()?)
        4. verify that the correct date is saved in the field
         */
    }

    @Test
    public void testEnterDateIncorrectFormatCalendarMenuChanges(){
        /*
        1. click on a calendar - clear input
        2. send keys: '77777809po'
        3. verify that instead of another date, today's date is showing up in the calendar menu
        */
    }

    @Test
    public void testEnterDateIncorrectFormatFieldSavesValue(){
        /*
        1. click on a calendar - clear input
        2. send keys: '77777809po'
        3. click on a blank space outside of field
        4. verify that today's date is saved in the field
         */
    }

}
