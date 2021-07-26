package com.testinium.ozdilekmobiletest.operations;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Operations {
    private final AndroidDriver<MobileElement> appiumDriver;
    private static JSONOperations jsonOperations;
    private static final Logger logger = LogManager.getLogger(Operations.class);

    public Operations(AndroidDriver<MobileElement> appiumDriver, List<String> pageDB){
        jsonOperations = new JSONOperations(pageDB);
        this.appiumDriver = appiumDriver;
    }

    private By get_by_from_locator_element(LocatorElement element) {
        switch (element.getBy()) {
            case ID:
                return By.id(element.getValue());
            case NAME:
                return By.name(element.getValue());
            case CSS_SELECTOR:
                return By.cssSelector(element.getValue());
            case XPATH:
                return By.xpath(element.getValue());
            case CLASS_NAME:
                return By.className(element.getValue());
            case TAG_NAME:
                return By.tagName(element.getValue());
            case LINK_TEXT:
                return By.linkText(element.getValue());
            case PARTIAL_LINK_TEXT:
                return By.partialLinkText(element.getValue());
            default:
                return null;
        }
    }

    public void wait_until_element_visible(long timeout, String key){
        logger.info("Waiting until element " + key + " is visible.");
        WebDriverWait wait = new WebDriverWait(appiumDriver, timeout);
        LocatorElement locatorElement = jsonOperations.findElementByKey(key);
        wait.until(ExpectedConditions.visibilityOfElementLocated(get_by_from_locator_element(locatorElement)));
    }

    public void click_on_element(String key){
        logger.info("Clicking on the element " + key);
        wait_until_element_visible(10, key);
        LocatorElement locatorElement = jsonOperations.findElementByKey(key);
        MobileElement element = appiumDriver.findElement(get_by_from_locator_element(locatorElement));
        element.click();
    }

    public void check_if_element_displayed(String key){
        logger.info("Checking if element " + key + " is displayed");
        wait_until_element_visible(20, key);
        LocatorElement locatorElement = jsonOperations.findElementByKey(key);
        MobileElement element = appiumDriver.findElement(get_by_from_locator_element(locatorElement));
        Assert.assertTrue(element.isDisplayed());
    }

    public void click_inner_element(String keyBase, String keyInner){
        logger.info("Clicking inner element which base: " + keyBase + ", inner: " + keyInner);
        wait_until_element_visible(20, keyBase);
        LocatorElement locatorElement1 = jsonOperations.findElementByKey(keyBase);
        LocatorElement locatorElement2 = jsonOperations.findElementByKey(keyInner);
        // Caution: Above operation may cause By type conflict. Use with only XPATH locators
        locatorElement1.setValue(locatorElement1.getValue() + locatorElement2.getValue());
        MobileElement element = appiumDriver.findElement(get_by_from_locator_element(locatorElement1));
        element.click();
    }

    public void swipeScreen(Direction dir) throws InterruptedException {
        logger.info("swipeScreen(): dir: '" + dir + "'");

        final int ANIMATION_TIME = 3000; // ms
        final int PRESS_TIME = 0; // ms
        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;
        Dimension dims = appiumDriver.manage().window().getSize();
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        TouchAction<?> action = new TouchAction<>(appiumDriver);
        action
                .press(pointOptionStart)
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                .moveTo(pointOptionEnd)
                .release().perform();
        Thread.sleep(ANIMATION_TIME);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }

}
