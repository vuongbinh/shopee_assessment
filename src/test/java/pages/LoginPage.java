package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

    By loginButtonTXT = By.xpath("//a[.='Register/Login']");
    By usernameTXT = By.id("loginEmail");
    By passwordTXT = By.xpath("//input[@placeholder='Enter Password']");
    By loginTXT = By.xpath("//button[contains(text(),'Login')]");
    By logoutTXT = By.xpath("//a[.='Logout']");
    By captchaTXT = By.xpath("//div[@class='recaptcha-checkbox-border'][1]");


    public LoginPage (WebDriver driver){
        super(driver);
    }

    @Override
    public void open(){
        driver.get("https://anotepad.com/");
    }

    public void login(String user, String pwd){
        driver.findElement(loginButtonTXT).click();
        driver.findElement(usernameTXT).sendKeys(user);
        driver.findElement(passwordTXT).sendKeys(pwd);
        try {
            new WebDriverWait(driver, 10).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
            new WebDriverWait(driver, 20).until(ExpectedConditions.elementToBeClickable(captchaTXT)).click();
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
