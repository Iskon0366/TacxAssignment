package com.tacx.utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtils {


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static void waitForInvisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeToWaitInSec);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for provided element to be clickable
     *
     * @param element
     * @param timeout
     * @return
     */
    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.get(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
//
//
//    /**
//     * waits for backgrounds processes on the browser to complete
//     *
//     * @param timeOutInSeconds
//     */
//    public static void waitForPageToLoad(long timeOutInSeconds) {
//        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
//            public Boolean apply(WebDriver driver) {
//                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//            }
//        };
//        try {
//            WebDriverWait wait = new WebDriverWait(Driver.get(), timeOutInSeconds);
//            wait.until(expectation);
//        } catch (Throwable error) {
//            error.printStackTrace();
//        }
//    }
//
//
//    /**
//     * Verifies whether the element is displayed on page
//     *
//     * @param element
//     * @throws AssertionError if the element is not found or not displayed
//     */
//    public static void verifyElementDisplayed(WebElement element) {
//        try {
//            Assert.assertTrue("Element not visible: " + element, element.isDisplayed());
//        } catch (NoSuchElementException e) {
//            e.printStackTrace();
//            Assert.fail("Element not found: " + element);
//
//        }
//    }
//
//    /**
//     *  checks that an element is present on the DOM of a page. This does not
//     *    * necessarily mean that the element is visible.
//     * @param by
//     * @param time
//     */
//    public static void waitForPresenceOfElement(By by, long time) {
//        new WebDriverWait(Driver.get(), time).until(ExpectedConditions.presenceOfElementLocated(by));
//    }
//


}
