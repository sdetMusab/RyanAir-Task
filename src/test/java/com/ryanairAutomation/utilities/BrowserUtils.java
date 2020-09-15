package com.ryanairAutomation.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {

    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.get());
        actions.moveToElement(element).perform();
    }

    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].click();", element);
    }

    public static void scrollWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.get()).executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public static void waitTillClickable(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.get(),15);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void scrollDown() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,1000)");

    }

    public static void scrollUp() {

        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("window.scrollBy(0,-500)");

    }

}
