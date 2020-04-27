package first_level_pages;
import utilities.Page;


public class HomePage extends Page {
    private String expectedPageTitle = "The Internet";
    private String link_TextShiftingContent = "Shifting Content";
    private String link_DropdownXpath = "//ul/li[11]/a";
    private String link_FormAuth = "Form Authentication";
    private String link_ForgotPasswordXpath = "//ul/li[20]/a";
    private String link_Hover = "Hovers";
    private String link_KeyPresses = "Key Presses";
    private String link_HorizontalSlider = "Horizontal Slider";
    private String link_JsAlerts = "JavaScript Alerts";

    public void getPageTitle(){
        String actualPageTitle = driver.getTitle();
        System.out.println(actualPageTitle);

    }

    public ShiftingContentPage goToShiftingContentPage(){
        clickByLinkText(link_TextShiftingContent);
        return new ShiftingContentPage();
    }

    public FormAuthPage goToFormAuthPage(){
        clickByLinkText(link_FormAuth);
        return new FormAuthPage();
    }

    public DropdownPage goToDropdownPage(){   // the test was failing when a clickByLinkText or clickByXPath methods would be called in from this method
        clickByXPath(link_DropdownXpath);
        return new DropdownPage();
    }

    public ForgotPasswordPage goToForgotPasswordPage() {
        clickByXPath(link_ForgotPasswordXpath);
        return new ForgotPasswordPage();
    }

    public HoverPage goToHoverPage(){
        clickByLinkText(link_Hover);
        return new HoverPage();
    }

    public KeyPresses goToKeyPressesPage(){
        clickByLinkText(link_KeyPresses);
        return new KeyPresses();
    }

    public HorizontalSliderPage goToHorizontalSliderPage(){
        clickByLinkText(link_HorizontalSlider);
        return new HorizontalSliderPage();
    }

    public JsAlertPage goToJsAlertPage() {
        clickByLinkText(link_JsAlerts);
        return new JsAlertPage();
    }

    public FileUpload goToFileUploadPage() {
        clickByLinkText("File Upload");
        return new FileUpload();
    }

    public ContextMenu goToContextMenuPage() {
        clickByLinkText("Context Menu");
        return new ContextMenu();
    }

    public EntryAddPage goToEntryAddPage() {
        clickByLinkText("Entry Ad");
        return new EntryAddPage();
    }

    public WysiwygEditorPage goToWysiwygEditorPage() {
        clickByLinkText("WYSIWYG Editor");
        return new WysiwygEditorPage();
    }

    public NestedFramesPage goToNestedFramesPage(){
        clickByLinkText("Nested Frames");
        return new NestedFramesPage();
    }

    public DynamicLoadingExamplesPage goToDynamicLoadingPage() {
        clickByLinkText("Dynamic Loading");
        return new DynamicLoadingExamplesPage();
    }

    public LargeDeepDomPage goToLargeDeepDomPage(){
        clickByLinkText("Large & Deep DOM");
        return new LargeDeepDomPage();
    }

    public InfiniteScroll goToInfiniteScrollPage(){
        clickByLinkText("Infinite Scroll");
        return new InfiniteScroll();
    }

    public MultipleWindowsPage goToMultipleWindowsPage() {
        clickByLinkText("Multiple Windows");
        return new MultipleWindowsPage();
    }
}
