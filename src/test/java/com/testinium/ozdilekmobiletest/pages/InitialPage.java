package com.testinium.ozdilekmobiletest.pages;

import com.testinium.ozdilekmobiletest.operations.Operations;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InitialPage extends GenericPageOperations {
    public InitialPage(AndroidDriver<MobileElement> appiumDriver, Operations operations) {
        super(appiumDriver, operations);
    }

    @Override
    public void validate_page_loaded() {

    }
}
