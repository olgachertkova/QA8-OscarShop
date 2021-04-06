package tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePageHelper;
import pages.LoginPageHelper;
import pages.ProductPageHelper;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class LoginPageTests extends TestBase {
    HomePageHelper homePageHelper;
    LoginPageHelper loginPageHelper;
    String emailValid = "olga4" + "@yandex.ru";
    String emailInvalid = "olga4" + "@yandex.ru";

    String passwordValid = "qwe123123";

    @BeforeMethod
    public void initPage(){
        homePageHelper = PageFactory.initElements(driver, HomePageHelper.class);
        loginPageHelper = PageFactory.initElements(driver, LoginPageHelper.class);
    }

    @Test
    public void registerTestPositive(){
        homePageHelper.clickOnLoginOrRegisterButton();
        loginPageHelper.waitUntilLoginPageIsLoaded();
        System.out.println(emailValid);
        loginPageHelper.inputEmail(emailValid);
        loginPageHelper.inputPassword(passwordValid);
        loginPageHelper.confirmPassword(passwordValid);
        loginPageHelper.clickOnRegisterButton();
        homePageHelper.waitUntilHomePageIsLoaded();
        Assert.assertTrue(homePageHelper.successRegistrationMessageIsDisplayed());

    }

    @Test
    public void registerTestNegativeSameEmail(){
        homePageHelper.clickOnLoginOrRegisterButton();
        loginPageHelper.waitUntilLoginPageIsLoaded();
        loginPageHelper.inputEmail(emailInvalid);
        loginPageHelper.inputPassword(passwordValid);
        loginPageHelper.confirmPassword(passwordValid);
        loginPageHelper.clickOnRegisterButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertTrue(loginPageHelper.errorMessageIsDisplayed());

    }
}
