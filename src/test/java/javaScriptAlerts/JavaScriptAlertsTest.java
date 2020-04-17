package javaScriptAlerts;

import base.BaseTest;
import first_level_pages.HomePage;
import first_level_pages.JsAlertPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class JavaScriptAlertsTest extends BaseTest {
    JsAlertPage jsAlert;
    String resultMessage = "You successfuly clicked an alert";
    private By triggerAlertButton = By.cssSelector("button[onclick='jsAlert()']");
    private By triggerConfirmButton = By.cssSelector("button[onclick='jsConfirm()']");
    private By triggerPromptButton = By.cssSelector("button[onclick='jsPrompt()']");
    private String textForSendingToPrompt = "Test@123;";

    @Test
    public void testJsAlert() {
        jsAlert = homePage.goToJsAlertPage();
        jsAlert.activateAlert(triggerAlertButton);
        jsAlert.alert_clickToAccept();

        assertEquals(jsAlert.getResult().getText(), resultMessage, "The actual message doesn't match the expected.");
    }

    @Test
    public void testJsConfirmCancel(){
        jsAlert = homePage.goToJsAlertPage();
        jsAlert.activateAlert(triggerConfirmButton);
        jsAlert.alert_clickToCancel();

        assertEquals(jsAlert.getResult().getText(), "You clicked: Cancel", "The messages do not match.");
    }

    @Test
    public void testJsConfirmOk(){
        jsAlert = homePage.goToJsAlertPage();
        jsAlert.activateAlert(triggerConfirmButton);
        jsAlert.alert_clickToAccept();

        assertEquals(jsAlert.getResult().getText(), "You clicked: Ok", "The messages do not match.");
    }

    @Test
    public void testJsPromptGetPromptText(){
        jsAlert = homePage.goToJsAlertPage();
        jsAlert.activateAlert(triggerPromptButton);
        String alert_text = jsAlert.alert_getText();
        jsAlert.alert_clickToCancel();

        assertEquals(alert_text, "I am a JS prompt", "The messages do not match.");
    }

    @Test
    public void testJsPromptEnterText(){
        jsAlert = homePage.goToJsAlertPage();
        jsAlert.activateAlert(triggerPromptButton);
        jsAlert.sendTextToPrompt(textForSendingToPrompt);
        jsAlert.alert_clickToAccept();

        assertEquals(jsAlert.getResult().getText(), "You entered: "+ textForSendingToPrompt, "Result text doesn't equal to sent text.");
    }


}
