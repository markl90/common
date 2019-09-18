package com.netbuilder.test.common.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementHelper {

    @FindBy(xpath ="//*[@id=\"spanAboutCookiesOk\"]/button")
    private WebElement cookiesDialogueOKButton;

    private WebDriver driver;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public void checkElementsFound(WebElement element){
        try {
            WebDriverWait wait = new WebDriverWait(driver, 60);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.isDisplayed();
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("The WebElement "+ element.getClass().getName() + " could not be located");
        }
    }

    public boolean checkElementIsDisplayed(WebElement element){
        try {
            if (element.isDisplayed()) {
                return true;
            } else {
                return false;
            }
        }catch (NoSuchElementException e) {
                throw new NoSuchElementException("The WebElement "+ element.getClass().getName() + " could not be located");
            }
        }

    public void closeCookiesDialogueBox(){

        try{
            if(cookiesDialogueOKButton != null) {
                cookiesDialogueOKButton.click();
            }
        } catch(NoSuchElementException e) {
            StringBuilder s = new StringBuilder(new String());
            throw new NoSuchElementException(s.append("Cookie dialogue accept button could not be located:\n")
                    .append("Probable page load problem\n")
                    .append(((JavascriptExecutor)driver).executeScript("return document.readyState"))
                    .toString());
        }
    }
}

