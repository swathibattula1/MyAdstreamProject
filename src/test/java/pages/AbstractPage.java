package pages;

import Base.BaseUtil;
import LIB.CommonClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class AbstractPage extends CommonClass{

   /* protected WebDriver driver=getDriver();;

    public AbstractPage(WebDriver driver) {

        this.driver = driver;
        //System.setProperty("webdriver.gecko.driver", "C:\\My Data\\SeleniumDump\\geckodriver.exe");
        //this.driver=new FirefoxDriver();
    }*/



   // protected static WebDriver driver;
    public AbstractPage(WebDriver driver) {

        this.driver = driver;
    }

 /*   protected WebDriver getDriver(){
        if(driver==null){
            System.setProperty("webdriver.gecko.driver", "C:\\My Data\\SeleniumDump\\geckodriver.exe");
            driver= new FirefoxDriver();


        }
        return driver;
    }
*/


    public LandingPage NavigateToWebApp() throws InterruptedException {
        driver.navigate().to("https://my.adstream.com");
        Thread.sleep(2000);
        return new LandingPage(driver);
    }
    public void closeDriver(){
        driver.quit();
    }
}
