package asd;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EmailRegistrationTest {

    private HomePage homePage;
    private RegisterPage registerPage;

    public EmailRegistrationTest() throws IOException {
    }

    @Before
    public void preCondition(){
        System.setProperty("webdriver.gecko.driver","/Users/kate/Documents/Auto/geckodriver");
        WebDriver driver = new FirefoxDriver();
        //WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    public void emailRegistration() throws InterruptedException {

        homePage.open();
        homePage.enterCodeword();
        homePage.clickRegister();
        registerPage.enterName();
        registerPage.enterEmail();
        registerPage.enterPassword();
        registerPage.confirmPassword();
        registerPage.checkTermsBox();
        registerPage.clickRegisterNow();

        Assert.assertTrue(registerPage.findText().contains("Not now. Continue to goal"));
    }

    @After
    public void postCondition(){
        registerPage.closeBrowser();
    }
}
