package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.Page;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class FormyPage extends Page {
    private By firstNameId = By.id("first-name");
    private By lastNameId = By.id("last-name");
    private By jobTitleId = By.id("job-title");
    private By allRadioButtons = By.cssSelector("input[type='radio']");
    private By allCheckBoxes = By.cssSelector("input[type='checkbox']");
    private By dropDownField = By.id("select-menu");
    private By defaultOption = By.cssSelector("option[value][selected]");
    private String option_FORMAT = "option[value = '%d']";
    private Logger logger;

    private List<WebElement> getAllClickableElements(By locator){
        return driver.findElements(locator);
    }

    private List<Boolean> checkStateOfAllClickableElements(List<WebElement> elements){
        return elements.stream().map(e->e.isSelected()).collect(Collectors.toList());
    }

    private void clickOnAllClickableElements(List<WebElement> allClickableElementsOfAType){
        /*
        by clickable elements it is meant: radio buttons and checkboxes
         */
        for(WebElement clickableElement : allClickableElementsOfAType) {
            clickableElement.click();
        }
    }

    private List<WebElement> getAllRadioButtons(){
        return getAllClickableElements(allRadioButtons);
    }

    private List<WebElement> getAllCheckBoxes(){
        return getAllClickableElements(allCheckBoxes);
    }

    private List<WebElement> getAllOptions(){
        return getDropDownField().getOptions();
    }

    private WebElement getSpecificOption(By locator){
        return driver.findElement(locator);
    }



    public boolean istFirstNameFieldEnabled(){
        //logger.
        return getElement(firstNameId).isEnabled();
    }

    public boolean isLastNameFieldEnabled(){
        return getElement(lastNameId).isEnabled();
    }

    public boolean isJobTitleFieldEnabled(){
        return getElement(jobTitleId).isEnabled();
    }

    public void setFirstName(String name) {
        sendTextToField(firstNameId, name);
    }

    public void setLastName(String lastName) {
        sendTextToField(lastNameId, lastName);
     }

    public void setJobTitle(String jobTitle) {
        sendTextToField(jobTitleId, jobTitle);
    }

    public void clickOnAllRadioButtons(){
        clickOnAllClickableElements(getAllRadioButtons());
    }

    public void clickOnAllCheckBoxes(){
        clickOnAllClickableElements(getAllCheckBoxes());
    }

    public List<Boolean> checkRadioButtonsState(){
        return checkStateOfAllClickableElements(getAllRadioButtons());
    }

    public List<Boolean> checkCheckBoxesStates(){
        return checkStateOfAllClickableElements(getAllCheckBoxes());
    }

    public Select getDropDownField(){
        return new Select(getElement(dropDownField));
    }

    public int getNumberOfOptionsInDropDown(){
        return getAllOptions().size();
    }

    public String getDefaultOptionsText(){
        return getSpecificOption(defaultOption).getText();
    }

    public int getSpecificOptionsIndex(int index){
        return getAllOptions().indexOf(getSpecificOption(By.cssSelector(String.format(option_FORMAT, index)))) + 1;
    }

    public void selectRandomOptionFromDropDown(){
        Random random = new Random();
        int index = random.nextInt(getAllOptions().size());
        getDropDownField().selectByIndex(index);
    }

    public String getSelectedOptionText(){
        selectRandomOptionFromDropDown();
        return getDropDownField().getFirstSelectedOption().getText();
    }








}
