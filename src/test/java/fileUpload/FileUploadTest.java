package fileUpload;

import base.BaseTest;
import first_level_pages.FileUpload;
import first_level_pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FileUploadTest extends BaseTest {
    FileUpload fileUpload;


    @Test
    public void testFileUpload(){
        fileUpload = homePage.goToFileUploadPage();
        fileUpload.uploadFile("C:\\Users\\Nena\\Desktop\\Leina cestitka.pdf");

        assertEquals(fileUpload.getUploadedFileName(), "Leina cestitka.pdf", "The file name does not match the expected.");


    }
}