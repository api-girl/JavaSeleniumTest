package first_level_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import page.Page;


public class HorizontalSliderPage extends Page {
    private By sliderStart = By.cssSelector("input[type='range']");
    private By numOfArrows = By.id("range");

    public WebElement getSlider() {
        return driver.findElement(sliderStart);
    }

    public void sendArrows(String text, String times) {
        WebElement element = driver.findElement(sliderStart);
        while (!getNumberOfArrows().equals(times))
            element.sendKeys(text);
    }

    public WebElement getValueElement() {
        return driver.findElement(numOfArrows);
    }

    public String getNumberOfArrows() {
        return getValueElement().getText();
    }

    public Actions moveSliderToStartPosition(){
        WebElement slider = driver.findElement(sliderStart);
        int startOffset = slider.getRect().getPoint().getX();
        Actions moveMouseToStartOffset = new Actions(driver);

        return moveMouseToStartOffset.moveToElement(getSlider(), startOffset, 0);
    }

    public void moveSliderToSpecificPosition(String input) {
        int numberOfMoves = 12;
        int offsetOneMove = getSlider().getSize().width / numberOfMoves;
        int oneMove = offsetOneMove;
        Actions mouseOverSlider = moveSliderToStartPosition();
        while (!getValueElement().getText().equals(input)) {
            //actions.dragAndDropBy(getSlider(), offsetOneMove, 0).perform();

            mouseOverSlider.clickAndHold().moveByOffset(oneMove, 0).release().build().perform();
            oneMove +=offsetOneMove ;
        }
    }

//
//


}


