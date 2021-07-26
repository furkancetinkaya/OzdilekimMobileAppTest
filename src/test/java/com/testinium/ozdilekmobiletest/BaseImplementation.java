package com.testinium.ozdilekmobiletest;

import com.testinium.ozdilekmobiletest.operations.Operations;
import com.testinium.ozdilekmobiletest.pages.*;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeScenario;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BaseImplementation {
    private static final String AUTOMATION_NAME = "uiautomator2";
    private static final String DEVICE_NAME = "emulator-5554";
    private static final String APP_PACKAGE = "com.ozdilek.ozdilekteyim";
    private static final String APP_ACTIVITY = "com.ozdilek.ozdilekteyim.MainActivity";
    private static final int NEW_COMMAND_TIMEOUT = 3000;
    private static final String URL_ADDRESS = "http://127.0.0.1:4723/wd/hub";

    protected static Logger logger = LogManager.getLogger(BaseImplementation.class);
    protected static AndroidDriver<MobileElement> appiumDriver;
    protected static Operations operations;

    protected final InitialPage initialPage;
    protected final HomePage homePage;
    protected final CategoriesPage categoriesPage;
    protected final WomanPage womanPage;
    protected final NavBarFragment navBarFragment;
    protected final ProductPage productPage;
    protected final LogInPage logInPage;

    public BaseImplementation(){
        initialPage = new InitialPage(appiumDriver, operations);
        homePage = new HomePage(appiumDriver, operations);
        categoriesPage = new CategoriesPage(appiumDriver, operations);
        womanPage = new WomanPage(appiumDriver, operations);
        navBarFragment = new NavBarFragment(appiumDriver, operations);
        productPage = new ProductPage(appiumDriver, operations);
        logInPage = new LogInPage(appiumDriver, operations);
    }

    @BeforeScenario
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, NEW_COMMAND_TIMEOUT);
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, APP_PACKAGE);
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, APP_ACTIVITY);
        URL url = new URL(URL_ADDRESS);

        appiumDriver = new AndroidDriver<>(Objects.requireNonNull(url), caps);
        logger.info("Android Driver is created.");

        List<String> pageDB = new ArrayList<>();
        pageDB.add("InitialPage.json");
        //pageDB.add("HomePage.json");
        pageDB.add("NavBarFragment.json");
        pageDB.add("CategoriesPage.json");
        pageDB.add("WomanPage.json");
        pageDB.add("ProductPage.json");
        pageDB.add("LogInPage.json");
        operations = new Operations(appiumDriver, pageDB);
        logger.info("Page Database and Operations instance are created");
    }

    @AfterScenario
    public void cleanup(){
        logger.info("Exiting ...");
        if (appiumDriver != null)
            appiumDriver.quit();
    }

}
