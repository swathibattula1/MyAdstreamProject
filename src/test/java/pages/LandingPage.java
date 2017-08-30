package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import LIB.CommonClass;


public class LandingPage extends AbstractPage {
    //CommonClass e;
    public LandingPage(WebDriver driver) {
        super(driver);
    }

    public void maximiseBrowser() {
        driver.manage().window().maximize();
    }

    WebElement txtusername=webElementId("id","Username");
    //WebElement txtusername=driver.findElement(By.id("Username"));

    WebElement txtpassword=webElementId("name","Password");
   // WebElement txtpassword=driver.findElement(By.name("Password"));


    WebElement btnLogin=webElementId("xpath",".//*[@id='loginbtn']");

    //WebElement btnLogin=driver.findElement(By.xpath(".//*[@id='loginbtn']"));


   /* @FindBy(how = How.CSS, using = "#Username")
    public WebElement txtusername;*/




    //WebElement txtusername=driver.findElement(By.id("Username"));


  /*  @FindBy(how = How.NAME, using = "Password")
    public WebElement txtpassword;


    @FindBy(how = How.XPATH, using = ".//*[@id='loginbtn']")
    public WebElement btnLogin;*/


    public void Login(String username, String password) {


        txtusername.sendKeys(username);
        txtpassword.sendKeys(password);
    }



    public MyAdstreamHomePage ClickLogin(){
       //btnLogin.click();

        click("xpath",".//*[@id='loginbtn']");
        return  new MyAdstreamHomePage(driver);
    }

}
