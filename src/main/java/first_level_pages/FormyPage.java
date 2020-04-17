package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.Normalizer;
import java.util.List;

public class FormyPage {
    WebDriver driver;
    private By firstNameId = By.id("first-name");
    private By lastNameId = By.id("last-name");
    private By jobTitleId = By.id("job-title");
    private By allRadioButtons = By.cssSelector("input[type='radio']");
    private By firstRadioButton = By.id("radio-button-1");
    private By allCheckBoxes = By.cssSelector("input[type='checkbox']");


    public FormyPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String name) {
        WebElement fNField = driver.findElement(By.cssSelector("#first-name"));
        if (fNField.isDisplayed()) {
            fNField.sendKeys(name);
        } else {
            System.out.println("The field is not displayed yet.");
        }
    }

    public void setLastName(String lastName) {
        WebElement lNField = driver.findElement(lastNameId);
        lNField.sendKeys(lastName);

    }

    public void setJobTitle(String jobTitle) {
        driver.findElement(jobTitleId).sendKeys(jobTitle);
    }

    public void clickOnARadioButton(){
        driver.findElement(firstRadioButton).click();
    }

    public Boolean checkRadioButtonState(){
        WebElement element = driver.findElement(By.id("radio-button-1"));
        return element.isSelected();
    }

    public List<Boolean> getRadioButtons(){
        List<WebElement> allRadioButtonElements = driver.findElements(allRadioButtons);
        List<Boolean> areButtonsSelected = null;
        for(WebElement radioButton:allRadioButtonElements){
            boolean buttonState = (radioButton.isSelected());
            areButtonsSelected.add(buttonState);
        }
        return areButtonsSelected;
    }


     public void clickOnAllRadioButtons(List<WebElement> allRadioButtonElements){
         for(WebElement radioButton : allRadioButtonElements) {
             radioButton.click();
         }
     }

     public List<Boolean> getRadioButtonsState(List<WebElement> allRadioButtonElements){
        List<Boolean> areRadioButtonsSelected = null;
        for(WebElement radioButton: allRadioButtonElements){
            boolean isRadioButtonSelected = radioButton.isSelected();
            areRadioButtonsSelected.add(isRadioButtonSelected);
        }
        return areRadioButtonsSelected;
     }


}
