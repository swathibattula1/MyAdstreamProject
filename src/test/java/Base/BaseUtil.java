package Base;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Swathi.Battula on 13/08/2017.
 */
public class BaseUtil {
    protected static WebDriver driver;

    protected WebDriver getDriver(){
        if(driver==null){
            System.setProperty("webdriver.gecko.driver", "C:\\mydata\\SeleniumDump\\geckodriver.exe");
            driver= new FirefoxDriver();


        }
        return driver;
    }


}
