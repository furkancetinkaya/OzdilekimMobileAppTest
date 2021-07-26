package com.testinium.ozdilekmobiletest.pages;

import com.testinium.ozdilekmobiletest.operations.Operations;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class WomanPage extends GenericPageOperations {
    public WomanPage(AndroidDriver<MobileElement> appiumDriver, Operations operations) {
        super(appiumDriver, operations);
    }

    @Override
    public void validate_page_loaded() {

    }

    private final String SHIRT_ITEM = "womanPage_shirt_item";
    private final String JACKET_ITEM = "womanPage_jacket_item";
    private final String TROUSER_ITEM = "womanPage_trousers_item";

    // ...

    public enum WomanPageItems {
        TROUSER, SHIRT, JACKET // ....
    }

    public void select_item(WomanPageItems item){
        switch (item){
            case SHIRT:
                operations.click_on_element(SHIRT_ITEM);
                break;
            case TROUSER:
                operations.click_on_element(TROUSER_ITEM);
                break;
            case JACKET:
                operations.click_on_element(JACKET_ITEM);
                break;
        }
    }
}
