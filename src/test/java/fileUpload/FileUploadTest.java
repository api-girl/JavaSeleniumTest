package fileUpload;

import base.BaseTest;
import first_level_pages.FileUpload;
import first_level_pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FileUploadTest extends BaseTest {
    FileUpload fileUpload;


    @Test
    public void testFileUpload(){
        fileUpload = homePage.goToFileUploadPage();
    }
}