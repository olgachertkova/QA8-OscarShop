package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePageHelper;
import pages.ProductPageHelper;

public class HomePageTests extends TestBase {
    HomePageHelper homePageHelper;
    ProductPageHelper productPageHelper;

    @BeforeMethod
    public void initPage(){
        homePageHelper = PageFactory.initElements(driver, HomePageHelper.class);
        productPageHelper = PageFactory.initElements(driver, ProductPageHelper.class);
    }

    @Test
    public void homePageTitleTest(){
        String title = homePageHelper.getHomePageTitle();
        Assert.assertTrue(homePageHelper.pageTitleIsCorrect(title));
    }

    @Test
    public void loginLinkIsDisplayedTest(){
        Assert.assertTrue(homePageHelper.loginLinkIsDisplayed());
    }

    @Test
    public void changeLanguageTest() {
        homePageHelper.selectLanguage("ru");
        homePageHelper.clickOnGoButton();
        Assert.assertTrue(homePageHelper.languageOnPageIsRussian());
    }

    @Test
    public void changeLangWithOutClickOnGoButton(){
        homePageHelper.selectLanguage("ru");
        Assert.assertFalse(homePageHelper.languageOnPageIsRussian());
    }

    @Test
    public void userCanChooseProduct(){
        homePageHelper.selectBooksProductCategory();
        homePageHelper.selectSecondProduct();
        Assert.assertTrue(productPageHelper.productPageIsDisplayed());
    }




}
