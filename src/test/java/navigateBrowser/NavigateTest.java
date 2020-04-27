package navigateBrowser;

import base.BaseTest;
import first_level_pages.MultipleWindowsPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class NavigateTest extends BaseTest {
    MultipleWindowsPage multipleWindows;
    private String example1 = "a[href='/dynamic_loading/1']";


    @Test
    public void testWindowManagerMethodsRandomFlow() {
        homePage.goToDynamicLoadingPage().goToExample1Page();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goToUrl("http://google.com");
        getWindowManager().goBack();
        getWindowManager().goBack();

        getWindowManager().closeAllAddedTabs();
    }

    @Test
    public void testSwitchBetweenMultipleOpenedTabsByTheirTitle() {
        multipleWindows = homePage.goToMultipleWindowsPage();
        //String initialTab = multipleWindows.getTabHandle();
        multipleWindows.openNewWindow();
        getWindowManager().switchToTabByTitle("The Internet");
        multipleWindows.openNewWindow();
        getWindowManager().switchToTabByTitle("The Internet");
        multipleWindows.openNewWindow();
        getWindowManager().switchToTabByTitle("The Internet");

        assertEquals(getWindowManager().getNumberOfOpenTabs(), 4, "The number of tabs is not 4.");
        getWindowManager().closeAllAddedTabs();
    }

    @Test
    public void testOpenNewTabBySendingKeysAndVerifyButtonPresence() {
        var example1Page = homePage.goToDynamicLoadingPage().openExampleWithSendingKeys(example1);
        getWindowManager().switchToTheFirstOpenedTab();

        assertTrue(example1Page.findOkButton().isDisplayed(), "The button is not displayed on the page.");
        getWindowManager().closeAllAddedTabs();
    }

    @Test
    public void testOpenNewTabBySendingKeysAndReturnToInitialTabByWindowHandle() {
        var dynamicLoading = homePage.goToDynamicLoadingPage();
        String initialTab = dynamicLoading.getTabHandle();
        dynamicLoading.openExampleWithSendingKeys(example1);

        getWindowManager().switchToTheFirstOpenedTab();
        getWindowManager().switchToTabByHandle(initialTab);

        assertTrue(dynamicLoading.findLinkForOpeningANewPage(example1).isDisplayed(), "The link is not displayed on the landed page.");
        getWindowManager().closeAllAddedTabs();
    }

    @Test
    public void testOpenMultipleTabsBySendingKeysAndNavigateAmongThemByTheirIndex() {
        String example2 = "a[href='/dynamic_loading/2']";
        var dynamicLoading = homePage.goToDynamicLoadingPage();
        String initialTab = dynamicLoading.getTabHandle();

        var example1Page = dynamicLoading.openExampleWithSendingKeys(example1);
        var example2Page = dynamicLoading.openExampleWithSendingKeys(example2);
        var example1Page1 = dynamicLoading.openExampleWithSendingKeys(example1);
        var example2Page1 = dynamicLoading.openExampleWithSendingKeys(example2);

        getWindowManager().switchToTabByIndex(1);
        String h4_example2 = example2Page.getH4Title();
        getWindowManager().switchToTabByIndex(2);
        String h4_example1 = example1Page.getH4Title();
        getWindowManager().switchToTabByHandle(initialTab);
        getWindowManager().switchToTheFirstOpenedTab();

        assertEquals(h4_example1, "Example 1: Element on page that is hidden");
        assertEquals(h4_example2, "Example 2: Element rendered after the fact");
        getWindowManager().closeAllAddedTabs();
    }

}
