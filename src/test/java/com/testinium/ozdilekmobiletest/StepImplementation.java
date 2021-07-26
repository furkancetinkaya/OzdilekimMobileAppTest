package com.testinium.ozdilekmobiletest;

import com.testinium.ozdilekmobiletest.operations.Operations;
import com.testinium.ozdilekmobiletest.operations.PageNames;
import com.testinium.ozdilekmobiletest.pages.CategoriesPage;
import com.testinium.ozdilekmobiletest.pages.InitialPage;
import com.testinium.ozdilekmobiletest.pages.NavBarFragment;
import com.testinium.ozdilekmobiletest.pages.WomanPage;
import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;

import java.util.concurrent.TimeUnit;

public class StepImplementation extends BaseImplementation {

    public StepImplementation(){
        logger = LogManager.getLogger(StepImplementation.class);
    }

    @Step("Wait for <num> seconds.")
    public void wait(int num) throws InterruptedException {
        logger.info("Waiting for " + num + " seconds");
        TimeUnit.SECONDS.sleep(num);
    }

    @Step("Validate app is open.")
    public void validate_app_opened(){
        logger.info("Validating if the application is opened successfully");
        operations.wait_until_element_visible(20, "initialPage_begin_shopping_button");
    }

    @Step("On <pageName>, click on element <elementKey>.")
    public void click_on_element(PageNames pageName, String key){
        logger.info("Clicking on element " + key + " on page " + pageName.toString());
        switch (pageName){
            case InitialPage:
                initialPage.click_on_element(key);
                break;
            case HomePage:
                homePage.click_on_element(key);
                break;
            case NavBarFragment:
                navBarFragment.click_on_element(key);
                break;
            case CategoriesPage:
                categoriesPage.click_on_element(key);
                break;
            case WomanPage:
                womanPage.click_on_element(key);
                break;
            case ProductPage:
                productPage.click_on_element(key);
                break;
            case LogInPage:
                logInPage.click_on_element(key);
                break;
        }
    }

    @Step("Check if <elementKey> is displayed.")
    public void check_element_displayed(String key){
        logger.info("Checking if element " + key + " is displayed");
        operations.check_if_element_displayed(key);
    }

    @Step("Select category <category>.")
    public void select_category(CategoriesPage.Categories category){
        logger.info("Selecting the category " + category.toString());
        categoriesPage.select_category(category);
    }

    @Step("Navigate to <menuName> navbar menu.")
    public void navigate_to_navbar_menu(NavBarFragment.NavbarMenus menuName){
        logger.info("Navigating to navbar menu " + menuName.toString());
        navBarFragment.navigate_to_navbar_menu(menuName);
    }

    @Step("Select woman item <item>.")
    public void select_woman_item(WomanPage.WomanPageItems item){
        logger.info("Selecting item " + item.toString() + " on WomanPage");
        womanPage.select_item(item);
    }

    @Step("Swipe screen <count> times.")
    public void swipe_screen(int count) throws InterruptedException {
        logger.info("Swiping the screen " + count + " times");
        for (int i=0; i<count; i++)
            operations.swipeScreen(Operations.Direction.UP);
    }

    @Step("On <pageName>, click base - inner element <baseKey> - <innerKey>.")
    public void click_inner_element(PageNames pageName, String baseKey, String innerKey){
        logger.info("Clicking on inner element base: " + baseKey + ", inner: " + innerKey +" on page " + pageName.toString());
        switch (pageName){
            case InitialPage:
                initialPage.click_inner_element(baseKey, innerKey);
                break;
            case HomePage:
                homePage.click_inner_element(baseKey, innerKey);
                break;
            case NavBarFragment:
                navBarFragment.click_inner_element(baseKey, innerKey);
                break;
            case CategoriesPage:
                categoriesPage.click_inner_element(baseKey, innerKey);
                break;
            case WomanPage:
                womanPage.click_inner_element(baseKey, innerKey);
                break;
            case ProductPage:
                productPage.click_inner_element(baseKey, innerKey);
                break;
        }
    }

    @Step("Validate page <pageName> loaded.")
    public void validate_page_load(PageNames pageName){
        switch (pageName){
            case InitialPage:
                initialPage.validate_page_loaded();
                break;
            case HomePage:
                homePage.validate_page_loaded();
                break;
            case NavBarFragment:
                navBarFragment.validate_page_loaded();
                break;
            case CategoriesPage:
                categoriesPage.validate_page_loaded();
                break;
            case WomanPage:
                womanPage.validate_page_loaded();
                break;
            case ProductPage:
                productPage.validate_page_loaded();
                break;
            case LogInPage:
                logInPage.validate_page_loaded();
                break;
        }
    }
}
