package first_level_pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import page.Page;


public class HomePage extends Page {
    private String expectedPageTitle = "The Internet";
    private String linkTextShiftingContent = "Shifting Content";
    private By linkDropdownXpath = By.xpath("//ul/li[11]/a");
    private String linkFormAuth = "Form Authentication";
    private By linkForgotPasswordXpath = By.xpath("//ul/li[20]/a");
    private String linkHoverXpath = "//ul/li[25]/a";
    private String linkHover = "Hovers";
    private String linkKeyPresses = "Key Presses";
    private String linkHorizontalSlider = "Horizontal Slider";
    private String linkJsAlerts = "JavaScript Alerts";

    public void getPageTitle(){
        String actualPageTitle = driver.getTitle();
        System.out.println(actualPageTitle);

    }

    private void clickByLinkText(String linkText){
        driver.findElement(By.linkText(linkText)).click();
    }

    public ShiftingContentPage goToShiftingContentPage(){
        clickByLinkText(linkTextShiftingContent);
        return new ShiftingContentPage();
    }

    public FormAuthPage goToFormAuthPage(){
        clickByLinkText(linkFormAuth);
        return new FormAuthPage();
    }

    public DropdownPage goToDropdownPage(){   // the test was failing when a clickByLinkText or clickByXPath methods would be called in from this method
        WebElement element = driver.findElement(linkDropdownXpath);
        element.click();
        return new DropdownPage();
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        WebElement element = driver.findElement(By.linkText("Forgot Password"));
        element.click();
        return new ForgotPasswordPage();
    }

//    private void waitForElementClickability(int seconds, By locator){
//        WebDriverWait wait = new WebDriverWait(driver, seconds);
//        wait.until(ExpectedConditions)
//    }

    public HoverPage goToHoverPage(){
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", element);
        clickByLinkText(linkHover);
        return new HoverPage();
    }

    public KeyPresses goToKeyPressesPage(){
        clickByLinkText(linkKeyPresses);
        return new KeyPresses();
    }

    public HorizontalSliderPage goToHorizontalSliderPage(){
        clickByLinkText(linkHorizontalSlider);
        return new HorizontalSliderPage();
    }

    public JsAlertPage goToJsAlertPage() {
        clickByLinkText(linkJsAlerts);
        return new JsAlertPage();
    }

    public FileUpload goToFileUploadPage() {
        clickByLinkText("File Upload");
        return new FileUpload();
    }
}
