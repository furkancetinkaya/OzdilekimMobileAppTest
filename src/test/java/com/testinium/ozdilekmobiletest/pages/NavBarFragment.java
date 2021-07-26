package com.testinium.ozdilekmobiletest.pages;

import com.testinium.ozdilekmobiletest.operations.Operations;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class NavBarFragment extends GenericPageOperations {
    public NavBarFragment(AndroidDriver<MobileElement> appiumDriver, Operations operations) {
        super(appiumDriver, operations);
    }

    @Override
    public void validate_page_loaded() {

    }

    private final String HOME_PAGE_MENU = "page_navbar_homepage";
    private final String CATEGORIES_MENU = "page_navbar_categories";
    private final String CAMPAIGNS_MENU = "page_navbar_campaigns";
    private final String ACCOUNT_MENU = "page_navbar_account";
    private final String CART_MENU = "page_navbar_cart";

    public enum NavbarMenus {
        HOME_PAGE, CATEGORIES, CAMPAIGNS, ACCOUNT, CART
    }

    public void navigate_to_navbar_menu(NavbarMenus navbarMenu){
        switch (navbarMenu){
            case HOME_PAGE:
                operations.click_on_element(HOME_PAGE_MENU);
                break;
            case CATEGORIES:
                operations.click_on_element(CATEGORIES_MENU);
                break;
            case CAMPAIGNS:
                operations.click_on_element(CAMPAIGNS_MENU);
                break;
            case ACCOUNT:
                operations.click_on_element(ACCOUNT_MENU);
                break;
            case CART:
                operations.click_on_element(CART_MENU);
                break;
        }
    }
}
