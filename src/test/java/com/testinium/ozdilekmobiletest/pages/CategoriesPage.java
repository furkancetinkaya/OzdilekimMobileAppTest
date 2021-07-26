package com.testinium.ozdilekmobiletest.pages;

import com.testinium.ozdilekmobiletest.operations.Operations;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CategoriesPage extends GenericPageOperations {
    public CategoriesPage(AndroidDriver<MobileElement> appiumDriver, Operations operations) {
        super(appiumDriver, operations);
    }

    @Override
    public void validate_page_loaded() {
        operations.check_if_element_displayed("categoriesPage_validation_text");
    }

    private final Logger logger = LogManager.getLogger(CategoriesPage.class);

    private final String HOME_TEXTILE_CATEGORY = "categoriesPage_home_textile_category";
    private final String WOMAN_CATEGORY = "categoriesPage_woman_category";
    private final String MAN_CATEGORY = "categoriesPage_man_category";
    private final String SHOE_CATEGORY = "categoriesPage_shoe_category";
    private final String CHILD_CATEGORY = "categoriesPage_child_category";
    private final String SPORTS_OUTDOOR_CATEGORY = "categoriesPage_sports_and_outdoor_category";
    private final String HOME_LIFESTYLE_CATEGORY = "categoriesPage_home_and_lifestyle_category";
    private final String PERFUME_COSMETICS_CATEGORY = "categoriesPage_perfume_and_cosmetics_category";
    private final String WATCH_GLASSES_CATEGORY = "categoriesPage_watch_and_glasses_category";
    private final String TV_PROMOTIONAL_CATEGORY = "categoriesPage_tv_promotional_category";
    private final String CLEARANCE_CATEGORY = "categoriesPage_clearance_category";
    private final String ALL_CAMPAIGNS_CATEGORY = "categoriesPage_all_campaigns_category";

    public enum Categories {
        HOME_TEXTILE, WOMAN, MAN, SHOE, CHILD, SPORTS_OUTDOOR, HOME_LIFESTYLE,
        PERFUME_COSMETICS, WATCH_GLASSES, TV_PROMOTIONAL, CLEARANCE, ALL_CAMPAIGNS
    }

    public void select_category(Categories category){
        switch (category){
            case HOME_TEXTILE:
                operations.click_on_element(HOME_TEXTILE_CATEGORY);
                break;
            case WOMAN:
                operations.click_on_element(WOMAN_CATEGORY);
                break;
            case MAN:
                operations.click_on_element(MAN_CATEGORY);
                break;
            case SHOE:
                operations.click_on_element(SHOE_CATEGORY);
                break;
            case CHILD:
                operations.click_on_element(CHILD_CATEGORY);
                break;
            case SPORTS_OUTDOOR:
                operations.click_on_element(SPORTS_OUTDOOR_CATEGORY);
                break;
            case HOME_LIFESTYLE:
                operations.click_on_element(HOME_LIFESTYLE_CATEGORY);
                break;
            case PERFUME_COSMETICS:
                operations.click_on_element(PERFUME_COSMETICS_CATEGORY);
                break;
            case WATCH_GLASSES:
                operations.click_on_element(WATCH_GLASSES_CATEGORY);
                break;
            case TV_PROMOTIONAL:
                operations.click_on_element(TV_PROMOTIONAL_CATEGORY);
                break;
            case CLEARANCE:
                operations.click_on_element(CLEARANCE_CATEGORY);
                break;
            case ALL_CAMPAIGNS:
                operations.click_on_element(ALL_CAMPAIGNS_CATEGORY);
                break;
        }
    }
}
