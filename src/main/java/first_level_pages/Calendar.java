package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.Page;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.ChronoUnit;


public class Calendar extends Page {
    private By datePickerInputField = By.id("datepicker");
    private By calendarPopUp = By.className("datepicker-dropdown");

    private By thisDayShownOnCalendarPopup = By.xpath("//td[@class = 'today day']");
    private By thisMonthAndYearOnCalendarPopup = By.cssSelector("div.datepicker-days th.datepicker-switch");
    private String goLevelUp_FORMAT = "div.datepicker-%s th.datepicker-switch";
    private By goLevelUpClass = By.className("datepicker-switch");
    private By thisMonthShownOnCalendarPopup = By.xpath("//span[@class = 'month focused']");
    private By thisYearShownOnCalendarPopup = By.xpath("//span[@class = 'year focused']");

    private By selectedDayOnCalendarPopup = By.xpath("//td[contains(@class, 'active day')]");

    private By selectedItemOnCalendarPopup = By.xpath("//span[contains(@class, 'active focused')]");

    private String arrowLeft = ".datepicker-days .prev";
    private String arrowRight = ".datepicker-days .next";
    private String day_FORMAT = "//td[@class='day'][contains(.,%d)]";


    public void sendTextToDateField(String date) {
        sendTextToField(datePickerInputField, date);
    }

    public String getDateFieldsPlaceholder() {
        return getElement(datePickerInputField).getAttribute("placeholder");
    }

    public boolean isDatePlaceholderCorrect(String placeholder) {
        return getDateFieldsPlaceholder().equalsIgnoreCase(placeholder);
    }

    public boolean isCalendarPopupOpen() {
        return getElement(calendarPopUp).isDisplayed();
    }

    public boolean isCalendarPopupClosed() {
        waitForElementStalness(getElement(calendarPopUp));
        return getElement(calendarPopUp).isDisplayed();
    }

    public void openCalendar() {
        clickById("datepicker");
    }

    private String[] getCurrentMonthAndYear() {
        return getElementText(thisMonthAndYearOnCalendarPopup).split(" ");
    }

    public LocalDate getTodaysDateShownOnCalendar() {
        openCalendar();
        String today = getElementText(thisDayShownOnCalendarPopup);
        return LocalDate.of(
                Integer.parseInt(getCurrentMonthAndYear()[1]),
                Month.valueOf(getCurrentMonthAndYear()[0].toUpperCase()),
                Integer.parseInt(today)
        );
    }

    public LocalDate getCurrentPeriodForComparison() {
        openCalendar();
        return LocalDate.of(
                Integer.parseInt(getCurrentMonthAndYear()[1]),
                Month.valueOf(getCurrentMonthAndYear()[0].toUpperCase()),
                1
        );
    }

    public LocalDate parseTextDateToLocalDate(String date) {   //"mm/dd/yyyy"
        openCalendar();
        var d = date.split("/");
        return LocalDate.of(
                Integer.parseInt(d[2]),
                Integer.parseInt(d[0]),
                Integer.parseInt(d[1])
        );
    }

    public LocalDate chooseDate(LocalDate date) {
        openCalendar();
        chooseMonthAndYear(date);
        chooseDay(date.getDayOfMonth());
        return getSelectedDate();
    }

    public void chooseMonthAndYear(LocalDate date) {
        var currentPeriod = getCurrentPeriodForComparison();
        long monthsAway = ChronoUnit.MONTHS.between(currentPeriod, date.withDayOfMonth(1));

        String arrow = monthsAway <= 0 ? arrowLeft : arrowRight;

        for (int i = 0; i < Math.abs(monthsAway); i++) {
            clickByCssSelector(arrow);
        }
    }

    public void chooseDay(int dayOfMonth) {
        clickByXPath(String.format(day_FORMAT, dayOfMonth));
    }

    public LocalDate getSelectedDate() {
        openCalendar();
        String selectedDay = getElementText(selectedDayOnCalendarPopup);
        return LocalDate.of(
                Integer.parseInt(getCurrentMonthAndYear()[1]),
                Month.valueOf(getCurrentMonthAndYear()[0].toUpperCase()),
                Integer.parseInt(selectedDay)
        );
    }

    public void clickOutsideOfCalendarField() {
        sendTextToDateField("" + Keys.TAB);
    }


    private boolean checkIfYearIsInCurrentCentury(String date) {
        var dateToSelectTwoDigits = date.substring(0, 2);
        var currentDateTwoDigits = LocalDate.now().toString().substring(0, 2);

        return dateToSelectTwoDigits.equals(currentDateTwoDigits);
    }

    private boolean checkIfYearIsInCurrentDecade(String date) {
        var dateToSelectThreeDigits = date.substring(0, 3);
        var currentDateThreeDigits = LocalDate.now().toString().substring(0, 3);

        return dateToSelectThreeDigits.equals(currentDateThreeDigits);
    }

    private boolean checkIfYearIsInCurrentYear(String date) {
        var dateToSelectFourDigits = date.substring(0, 4);
        var currentDateFourDigits = LocalDate.now().toString().substring(0, 4);

        return dateToSelectFourDigits.equals(currentDateFourDigits);
    }

    private boolean checkIfYearIsInCurrentMillennium(String date) {
        var dateToSelectFirstDigits = date.substring(0, 1);
        var currentDateFirstDigit = LocalDate.now().toString().substring(0, 1);

        return dateToSelectFirstDigits.equals(currentDateFirstDigit);
    }
}
