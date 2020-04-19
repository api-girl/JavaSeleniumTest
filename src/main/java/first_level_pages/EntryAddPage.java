package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import page.Page;

public class EntryAddPage extends Page {
    private String closeModalButton = "div.modal-footer p";
    private By modalTitle = By.cssSelector("div.modal-title h3");
    private By modalBody = By.cssSelector("div.modal-body p");
    private By linkUnderModal = By.id("restart-ad");

    public String getModalTitle(){
        waitForElementVisibility(modalTitle);
        return driver.findElement(modalTitle).getText();
    }

    public String getModalBody(){
        waitForElementVisibility(modalBody);
        return driver.findElement(modalBody).getText();

    }

    public void closeModal() {
        waitForElementClickability(By.cssSelector(closeModalButton));
        clickByCssSelector(closeModalButton);
    }

    public WebElement getLinkUnderModal(){
        waitForElementClickability(linkUnderModal);
        return driver.findElement(linkUnderModal);
    }

    public void clickLinkUnderModal(){
        waitForElementVisibility(By.cssSelector(closeModalButton));
        driver.findElement(linkUnderModal).click();
    }
}

