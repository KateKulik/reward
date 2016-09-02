package asd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;


public class RegisterPage {

    private WebDriver driver;

    private By nameField = By.id("auth__name");
    private By emailField = By.id("auth__email");
    private By passwordField = By.id("auth__password");
    private By confirmPasswordField = By.id("auth__password_confirmation");
    //private By termsCheckBox = By.partialLinkText("agree");
    private By termsCheckBox = By.id("auth__terms_of_service");
    private By registerNow = By.linkText("Register now");

    private Random random = new Random();
    private int number = random.nextInt(1000);
    private String randoms = String.format("%03d", number);

    private String randomEmail = "test"+randoms+"@test.test";


    public void enterName(){
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
        Thread.sleep(3000);
        driver.findElement(termsCheckBox).click();
        Thread.sleep(3000);
    }

    public void clickRegisterNow() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(registerNow).click();
    }

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public String findText() {
        String notNowButtonText = driver.findElement(By.className("wallet__secondary-btn wallet__choice-btn")).getText();
        return notNowButtonText;
    }

    public void closeBrowser(){
        driver.close();
    }

}
