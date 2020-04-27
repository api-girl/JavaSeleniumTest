package formy;

import base.BaseTestFormy;
import first_level_pages.Calendar;
import first_level_pages.FormyPage;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.testng.Assert.*;

public class FormyTest extends BaseTestFormy {
    private static final FormyPage formy = new FormyPage();
    private static final Calendar calendar = new Calendar();
    private static List<Boolean> expectedStatesFalse = List.of(false, false, false);
    private static List<Boolean> expectedStatesTrue = List.of(true, true, true);

    @Test
    public void testAreTextFieldsEnabledForEnteringText() {
        assertTrue(formy.istFirstNameFieldEnabled(), "The firstName field is not enabled.");
        stepInfo("Check if the field Last Name is enabled");
        stepInfo("Check if the field Job Title is enabled");

    }

    @Test
    public void testVerifyNoneRadioButtonIsSelected() {
        /*
            1. get a list of radio buttons and
            2. confirm that none is selected
         */
        List<Boolean> actualStates = formy.checkRadioButtonsState();

        assertEquals(actualStates, expectedStatesFalse, "Radio buttons state is incorrect.");
    }

    @Test
    public void testClickAllRadioButtonsAndCheckTheirState() {
        /*
            1. get a list of radio buttons and click on every one of them
            2. get all radio buttons again and confirm that all of them are selected
         */
        formy.clickOnAllRadioButtons();
        var actualStatesAfterClick = formy.checkRadioButtonsState();

        assertEquals(actualStatesAfterClick, expectedStatesTrue);

    }


    @Test
    public void testUnclickAllRadioButtonsAndConfirmAllStaySelected() throws InterruptedException {
        /*
            1. get a list of radio buttons
            2. click on every radio button in a list
            3. unclick all radio buttons in a list
            4. get all radio buttons again and confirm that all of them are still selected
         */

        formy.clickOnAllRadioButtons();
        formy.clickOnAllRadioButtons();

        assertEquals(formy.checkRadioButtonsState(), expectedStatesTrue);
    }

    @Test
    public void testVerifyNoneCheckboxIsSelected(){

        assertEquals(formy.checkCheckBoxesStates(), expectedStatesFalse);
    }

    @Test
    public void testClickAllCheckBoxes() {
         /*
            1. get a list of checkboxes and click on every checkbox in a list
            2. get all checkboxes again and confirm that all of them are selected
         */
        formy.clickOnAllCheckBoxes();

        assertEquals(formy.checkCheckBoxesStates(), expectedStatesTrue);
    }

    @Test
    public void testUnclickAllCheckBoxes() {
        /*
            1. get a list of checkboxes and click on every checkbox in a list
            2. unclick every checkbox in a list
            3. get all checkboxes again and confirm that none of them are selected
         */
        formy.clickOnAllCheckBoxes();
        formy.clickOnAllCheckBoxes();

        assertEquals(formy.checkCheckBoxesStates(), expectedStatesFalse);
    }

    @Test
    public void testCheckIfTheDefaultOptionIsSelected() {

        assertEquals(formy.getDropDownField().getFirstSelectedOption().getText(), formy.getDefaultOptionsText());
    }

    @Test
    public void testConfirmTheNumberOfAvailableOptions(){
        /*
        get the last option attribute's "value" value and add 1 to compare it with the list of elements
         */
        int expectedNumberOfOptions = formy.getSpecificOptionsIndex(4);
        int actualNumberOfOptions = formy.getNumberOfOptionsInDropDown();
        assertEquals(actualNumberOfOptions, expectedNumberOfOptions);
    }

    @Test
    public void testSelectARandomOption(){
        /*
        confirm that one option is selected
        read the text of the selected option
         */
        formy.selectRandomOptionFromDropDown();
        System.out.println(formy.getSelectedOptionText());

        assertEquals(formy.getDropDownField().getAllSelectedOptions().size(), 1);
    }

    @Test
    public void testVerifyCalendarPlaceholderIsCorrect() {
        /*
        1. get text from calendar menu before opening it
        2. verify that it is displayed and that the placeholder message is correct
         */
        var expectedPlaceholder = "mm/dd/yyyy";
        assertTrue(calendar.isDatePlaceholderCorrect(expectedPlaceholder));
    }

    @Test
    public void testVerifyIsCalendarPopupDisplayedWhenFieldIsClicked() {
        /*
        1. get text from calendar menu before opening it
        2. verify that it is displayed and that the placeholder message is correct
         */
        calendar.openCalendar();
        assertTrue(calendar.isCalendarPopupOpen());
    }

//    @Test
//    public void testVerifyIfCalendarPopupIsClosedWhenItIsClickedOutsideOfCalendarField(){
//        calendar.openCalendar();
//        calendar.clickOutsideOfCalendarField();
//          doesn't work - element disappears from DOM before assertion
//
//        assertFalse(calendar.isCalendarPopupClosed());
//    }

    @Test
    public void testEnterDateCorrectFormatCalendarDefaultDateChanges() {
        /*
        1. click on a calendar - clear input
        2. send keys: '06/02/1989'
        3. verify that the correct day, month and year are showing up selected in calendar menu
         */
        calendar.openCalendar();
        var initiallyMarkedDate = calendar.getTodaysDateShownOnCalendar();
        calendar.sendTextToDateField("06/04/2020");
        var selectedDate = calendar.getSelectedDate();

        assertNotEquals(initiallyMarkedDate, selectedDate);
    }

    @Test
    public void testEnterTextDateCorrectFormatAndVerifyDateOnCalendarPopup(){
        /*
        1. click on a calendar - clear input
        2. send keys: '06/02/1989'
        3. click on a blank space outside of field (maybe .submit()?)
        4. verify that the correct date is saved in the field
         */
        String date = "06/04/3457";
        calendar.openCalendar();
        calendar.sendTextToDateField(date);

        var sentText = calendar.parseTextDateToLocalDate(date);
        var actualSelectedDate = calendar.getSelectedDate();

        assertEquals(actualSelectedDate, sentText);
    }

    @Test
    public void testEnterTextDateIncorrectFormatAndVerifyThatCalendarPopUpSelectsTodaysDate(){
        /*
        1. click on a calendar - clear input
        2. send keys: '77777809po'
        3. verify that instead of another date, today's date is showing up in the calendar menu
        */
        var expectedDate = LocalDate.now();
        calendar.sendTextToDateField("77777809po");
        var actualDate = calendar.getSelectedDate();

        assertEquals(actualDate, expectedDate, "The date showing on the calendar popup is not current.");
    }

    @Test
    public void testEnterDateIncorrectFormatFieldSavesValue(){
        /*
        1. click on a calendar - clear input
        2. send keys: '77777809po'
        3. click on a blank space outside of field
        4. verify that today's date is saved in the field
         */
        var expectedDate = LocalDate.now();
        calendar.sendTextToDateField("77777809po");
        calendar.clickOutsideOfCalendarField();
        var savedDate = calendar.getSelectedDate();

        assertEquals(savedDate, expectedDate);
    }


    @Test
    public void testVerifyDefaultDateIsTodaysDate() {
        /*
        1. click on a calendar
        2. verify that todays's date is marked
         */
        var today = LocalDate.now();
        var defaultDateOnCalendar = calendar.getTodaysDateShownOnCalendar();
        assertEquals(defaultDateOnCalendar, today);
    }

    @Test
    public void testSelectFutureDate(){
        /*
        1. click on a calendar
        2. click on a date in future
        3. verify that the future day is selected
        4. verify that the new date shows in calendar field
         */
        var dateToSelect = LocalDate.now().plusMonths(9);
        var selectedDate = calendar.chooseDate(dateToSelect);
        assertEquals(selectedDate, dateToSelect);
    }

    @Test
    public void testSelectPastDate(){
        /*
        1. click on a calendar
        2. select a date in past
        3. verify that the new date shows in calendar field
         */
        var dateToSelect = LocalDate.of(2019, Month.NOVEMBER, 23);
        var selectedDate = calendar.chooseDate(dateToSelect);
        assertEquals(selectedDate, dateToSelect);
    }

    @Test
    public void testSelectDateInCurrentMonthBeforeToday(){
        var dateToSelect = LocalDate.now().minusDays(4);
        var selectedDate = calendar.chooseDate(dateToSelect);

        assertEquals(selectedDate, dateToSelect);
    }

    @Test
    public void testSelectDateInCurrentMonthAfterToday(){
        var dateToSelect = LocalDate.now().plusDays(5);
        var selectedDate = calendar.chooseDate(dateToSelect);

        assertEquals(selectedDate, dateToSelect);
    }

    @Test
    public void testSelectDateFromPreviousMonthShownInCurrentMonth(){
        var dateToSelect = LocalDate.of(2020, Month.MARCH, 31);
        var selectedDate = calendar.chooseDate(dateToSelect);

        assertEquals(selectedDate, dateToSelect);
    }


//    @Test
//    public void testSelectDateByChangingCenturies() {
//        /*
//        1. click on a calendar
//        2. click on the month
//        3. click on the year
//        4. change year
//        5. select month
//        6. select a date
//        7. verify that the new date shows in calendar field
//         */
//        var dateToSelect = LocalDate.of(2456, Month.AUGUST, 31);
//        var selectedDate = calendar.chooseDateFromTogglingLevels(dateToSelect);
//
//        assertEquals(selectedDate, dateToSelect);
//    }



}
