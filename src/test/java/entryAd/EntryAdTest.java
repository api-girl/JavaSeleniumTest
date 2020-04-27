package entryAd;

import base.BaseTest;
import first_level_pages.EntryAddPage;
import org.openqa.selenium.ElementClickInterceptedException;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class EntryAdTest extends BaseTest {
    EntryAddPage entryAdd;

    @Test
    public void testIsPageContentEnabled() {
        entryAdd = homePage.goToEntryAddPage();

        assertThrows(ElementClickInterceptedException.class, () -> entryAdd.clickLinkUnderModal());
        entryAdd.deleteCookiesAfterEachTest();
    }

    @Test
    public void testVerifyModalContent() {
        String expectedModalTitle = "This is a modal window";
        String expectedModalBody = "It's commonly used to encourage a user to take an action " +
                "(e.g., give their e-mail address to sign up for " +
                "something or disable their ad blocker).";

        entryAdd = homePage.goToEntryAddPage();
        String actualModalTitle = entryAdd.getModalTitle();
        String actualModalBody = entryAdd.getModalBody();

        assertEquals(actualModalTitle, expectedModalTitle.toUpperCase(), "Actual title doesn't match the expected.");
        assertEquals(actualModalBody, expectedModalBody, "Actual modal body doesn't match the expected.");
        entryAdd.deleteCookiesAfterEachTest();
    }

    @Test
    public void testCloseModal() {
        entryAdd = homePage.goToEntryAddPage();
        entryAdd.closeModal();

        assertTrue(entryAdd.getLinkUnderModal().isEnabled(), "Page content is still not enabled.");
        entryAdd.deleteCookiesAfterEachTest();
    }

}
