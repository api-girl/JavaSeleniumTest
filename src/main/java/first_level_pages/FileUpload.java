package first_level_pages;

import org.openqa.selenium.By;
import page.Page;

public class FileUpload extends Page {
    private String browseButton = "file-upload";
    private String submitFileButton = "file-submit";
    private By uploadedFileName = By.id("uploaded-files");

    private void submitFile(){
        clickById(submitFileButton);
    }

    public void uploadFile(String absoluteFilePath){
        driver.findElement(By.id(browseButton)).sendKeys(absoluteFilePath);
        submitFile();
    }

    public String getUploadedFileName(){
        return driver.findElement(uploadedFileName).getText();
    }


}
