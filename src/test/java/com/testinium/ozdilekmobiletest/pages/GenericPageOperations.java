package com.testinium.ozdilekmobiletest.pages;

import com.testinium.ozdilekmobiletest.operations.Operations;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public abstract class GenericPageOperations {
    protected final AndroidDriver<MobileElement> appiumDriver;
    protected final Operations operations;

    public GenericPageOperations(AndroidDriver<MobileElement> appiumDriver, Operations operations){
        this.appiumDriver = appiumDriver;
        this.operations = operations;
    }

    public void click_on_element(String key){
        operations.click_on_element(key);
    }

    public void navigate_to_element(String key){

    }

    public void click_inner_element(String baseKey, String innerKey){
        operations.click_inner_element(baseKey, innerKey);
    }

    public abstract void validate_page_loaded();
}
