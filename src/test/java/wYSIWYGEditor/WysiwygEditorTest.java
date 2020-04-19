package wYSIWYGEditor;

import base.BaseTest;
import first_level_pages.WysiwygEditorPage;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class WysiwygEditorTest extends BaseTest {
    WysiwygEditorPage editor;

    @Test
    public void testIndentLineBetweenSendingKeysToTextArea(){
        editor = homePage.goToWysiwygEditorPage();
        editor.clearTextArea();
        editor.sendKeysToTextArea("Hello ");
        editor.indentLine();
        editor.sendKeysToTextArea("world!");

        assertEquals(editor.getTextFromEditArea(), "Hello world!", "The edit area text does not match the expected.");
    }


}
