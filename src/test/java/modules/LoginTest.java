package modules;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @DataProvider
    Object [][] credentials(){
        return new Object[][]{
                //Positve case
                new Object[]{"binh.vuonghao@gmail.com","123abcd"},
                //Negative cases
                new Object[]{"binh.vuonghao@gmail.com","onebyone"},
                new Object[]{"Wrongpassword","cannotbypas theCaptcha"},
                new Object[]{"Somebody@help.me","How @_31!>?"},
                new Object[]{"ThisTest.cannot@complete.com",""}
        };
    }

    @Test(dataProvider = "credentials")
    void validatedLogin (String username, String pwd){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.login(username,pwd);
        Assert.assertEquals(true,driver.findElement(By.xpath("//a[.='Logout']")).isDisplayed());
    }

}
