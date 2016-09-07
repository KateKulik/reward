package asd;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;


public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private JavascriptExecutor jse;

    private By nameField = By.id("auth__name");
    private By emailField = By.id("auth__email");
    private By passwordField = By.id("auth__password");
    private By confirmPasswordField = By.id("auth__password_confirmation");
    //private By termsCheckBox = By.partialLinkText("agree");
    private By termsCheckBox = By.cssSelector(".auth__form-checkbox-label--agree");
    private By registerNow = By.cssSelector("[type=\"submit\"]");

    private Random random = new Random();
    private int number = random.nextInt(1000);
    private String randoms = String.format("%03d", number);

    private String randomEmail = "test"+randoms+"@test.test";


    public void enterName() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(nameField));
        Thread.sleep(500);
        driver.findElement(nameField).click();
        driver.findElement(nameField).sendKeys(randomEmail);
    }

    public void enterEmail(){
        driver.findElement(emailField).click();
        driver.findElement(emailField).sendKeys(randomEmail);
    }

    public void enterPassword(){
        driver.findElement(passwordField).click();
        driver.findElement(passwordField).sendKeys(randomEmail);
    }

    public void confirmPassword(){
        driver.findElement(confirmPasswordField).click();
        driver.findElement(confirmPasswordField).sendKeys(randomEmail);
    }

    public void checkTermsBox() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(termsCheckBox));
        Thread.sleep(1000);
        jse.executeScript("document.getElementById('auth__terms_of_service').click()");
        Thread.sleep(1000);
    }

    public void clickRegisterNow() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(registerNow).click();
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.jse = (JavascriptExecutor) driver;
    }

    public String findText() {
        String notNowButtonText = driver.findElement(By.className("wallet__secondary-btn wallet__choice-btn")).getText();
        return notNowButtonText;
    }

    public void closeBrowser(){
        driver.close();
    }

}
