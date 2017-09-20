package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import LIB.CommonClass;


public class LandingPage extends AbstractPage {

    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void maximiseBrowser() {
        driver.manage().window().maximize();
    }

    WebElement txtusername = webElementId("id", "Username");
    WebElement txtpassword = webElementId("name", "Password");
    WebElement btnLogin = webElementId("xpath", ".//*[@id='loginbtn']");

    public void Login(String username, String password) {
        txtusername.sendKeys(username);
        txtpassword.sendKeys(password);
    }


    public MyAdstreamHomePage ClickLogin() {
        click("xpath", ".//*[@id='loginbtn']");
        return new MyAdstreamHomePage(driver);
    }

}
