package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageHelper;
import pages.ProductPageHelper;

import java.util.List;

public class ProductPageTest extends TestBase {
    HomePageHelper homePageHelper;
    ProductPageHelper productPageHelper;

    @BeforeMethod
    public void initPage(){
        homePageHelper = PageFactory.initElements(driver, HomePageHelper.class);
        productPageHelper = PageFactory.initElements(driver, ProductPageHelper.class);
    }

    @Test
    public void userCanAddProductToBasketTest(){
        homePageHelper.selectSubMenuBooks();
        homePageHelper.waitUntilProductListIsDisplayed();
        homePageHelper.selectProductInListByNumber(1);
        productPageHelper.clickOnAddToBasketButton();
        Assert.assertTrue(productPageHelper.successMessageIsDisplayed() && productPageHelper.messageContainsSuccessText());

    }

    @Test
    public void productPriceInBasketValidation(){
        homePageHelper.selectSubMenuBooks();
        homePageHelper.waitUntilProductListIsDisplayed();
        homePageHelper.selectProductInListByNumber(1);
        Double price = productPageHelper.getProductPrice();
        productPageHelper.clickOnAddToBasketButton();
        Double basketTotal = productPageHelper.getBasketTotal();
        System.out.println(basketTotal);
        Assert.assertEquals(price, basketTotal);

    }

//    @Test
//    public void nameProductValidation(){
//        WebElement booksSubmenu = driver.findElement(By.className("dropdown-submenu"));
//        booksSubmenu.click();
//        waitUntilElementVisible(driver.findElement(By.className("page-header")), 5);
//
//        List<WebElement> bookImgList = driver.findElements(By.cssSelector(".product_pod .image_container"));
//        WebElement firstBookImg = bookImgList.get(0);
//        firstBookImg.click();
//        waitUntilElementVisible(driver.findElement(By.className("breadcrumb")), 5);
//
//        WebElement bookTitle = driver.findElement(By.cssSelector(".product_main h1"));
//        String bookTitleText = bookTitle.getText();
//        System.out.println(bookTitleText);
//
//        WebElement addToBasketButton = driver.findElement(By.className("btn-add-to-basket"));
//        addToBasketButton.click();
//
//        WebElement alertMessage = driver.findElement(By.className("alert-success"));
//        String alertMessageText = alertMessage.getText();
//        System.out.println(alertMessageText);
//
//        Assert.assertTrue(alertMessageText.contains(bookTitleText));
//
//    }
}
