package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
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

    public  void Login(String username, String password) throws InterruptedException {
       // txtusername.sendKeys(username);
        Thread.sleep(2000);
        WebElement username1= driver.findElement(By.id("Username"));
        Actions builder = new Actions(super.driver);
        Action act1=builder.moveToElement(username1).sendKeys(username).build();
        act1.perform();


        txtpassword.sendKeys(password);
        Thread.sleep(4000);
    }


    public MyAdstreamHomePage ClickLogin() {
        click("xpath", ".//*[@id='loginbtn']");
        return new MyAdstreamHomePage(driver);
    }

}
