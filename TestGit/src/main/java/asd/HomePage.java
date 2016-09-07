package asd;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By lockupCodeword = By.id("lockup_codeword");
    // private WebElement registerButton = driver.findElement(By.cssSelector("a[class='button button--register']"));
    // private By registerButton = By.xpath("//a[@class='button button--register']");
    private By registerButton = By.linkText("Register");

    public HomePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
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
        wait.until(ExpectedConditions.elementToBeClickable(registerButton));
        Thread.sleep(1000);
        driver.findElement(registerButton).click();
    }
}
