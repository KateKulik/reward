package asd;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;
    private By lockupCodeword = By.id("lockup_codeword");
    // private WebElement registerButton = driver.findElement(By.cssSelector("a[class='button button--register']"));
    // private By registerButton = By.xpath("//a[@class='button button--register']");
    private By registerButton = By.linkText("Register");

    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get("https://stage.rewardexpert.com");
    }

    public void enterCodeword(){
        driver.findElement(lockupCodeword).click();
        driver.findElement(lockupCodeword).sendKeys("r3ward");
        driver.findElement(lockupCodeword).sendKeys(Keys.RETURN);
    }

    public void clickRegister() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(registerButton).click();
    }
}
