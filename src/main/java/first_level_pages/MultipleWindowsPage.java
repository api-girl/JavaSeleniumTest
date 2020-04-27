package first_level_pages;

import second_level_pages.NewWindow;
import utilities.Page;

public class MultipleWindowsPage extends Page {
    private String openNewWindowLink = "a[href='/windows/new']";

    public NewWindow openNewWindow(){
        clickByCssSelector(openNewWindowLink);
        return new NewWindow();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

}
