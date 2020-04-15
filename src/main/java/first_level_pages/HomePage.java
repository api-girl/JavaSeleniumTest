package first_level_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePage {
    private WebDriver driver;
    private String expectedPageTitle = "The Internet";
    private String linkTextShiftingContent = "Shifting Content";
    private By linkDropdownXpath = By.xpath("//ul/li[11]/a");
    private String linkFormAuth = "Form Authentication";
    private By linkForgotPasswordXpath = By.xpath("//ul/li[20]/a");


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void getPageTitle(){
        String actualPageTitle = driver.getTitle();
        System.out.println(actualPageTitle);

    }

    private void clickByLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public ShiftingContentPage goToShiftingContentPage(){
        clickByLinkText(linkTextShiftingContent);
        return new ShiftingContentPage(driver);
    }

    public FormAuthPage goToFormAuthPage(){
        clickByLinkText(linkFormAuth);
        return new FormAuthPage(driver);
    }

    public DropdownPage goToDropdownPage(){   // the test was failing when a clickByLinkText or clickByXPath methods would be called in from this method
        WebElement element = driver.findElement(linkDropdownXpath);
        element.click();
        return new DropdownPage(driver);
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        WebElement element = driver.findElement(By.linkText("Forgot Password"));
        element.click();
        return new ForgotPasswordPage(driver);
    }

    public HoverPage goToHoverPage(){
        clickByLinkText("Hover");
        return new HoverPage(driver);
    }
}
