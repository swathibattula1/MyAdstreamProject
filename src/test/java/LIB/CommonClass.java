package LIB;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.AbstractPage;

import java.util.List;

public class CommonClass {

    Actions action;
    /*public CommonClass(WebDriver driver) {
        super(driver);
    }*/
    protected static WebDriver driver;
    protected WebDriver getDriver(){
        if(driver==null){
           /* System.setProperty("webdriver.gecko.driver", "C:\\mydata\\SeleniumDump\\geckodriver.exe");
            driver= new FirefoxDriver();*/
            System.setProperty("webdriver.chrome.driver", "C:\\mydata\\SeleniumDump\\chromedriver.exe");
            driver= new ChromeDriver();


        }
        return driver;
    }

    //WebElement
    public WebElement webElementId(String identifier,String locator)
    {
        WebElement e=null;
        switch (identifier)
        {
            case "id" :
                e=driver.findElement(By.id(locator));
                break;
            case "className" :
                e=driver.findElement(By.className(locator));
                break;
            case "tagName" :
                e=driver.findElement(By.tagName(locator));
                break;
            case "name" :
                e=driver.findElement(By.name(locator));
                break;
            case "linkText" :
                e=driver.findElement(By.linkText(locator));
                break;
            case "partialLinkText" :
                e=driver.findElement(By.partialLinkText(locator));
                break;
            case "cssSelector" :
                e=driver.findElement(By.cssSelector(locator));
                break;
            case "xpath" :
                e=driver.findElement(By.xpath(locator));
                break;


            default :
                System.out.println("Locator not found");
                e=null;
        }
        return e;
    }



    //Sendkey general method
    public void sendKeys(String identifier,String locator,String content)
    {

        WebElement e=webElementId(identifier, locator);
        e.sendKeys(content);
    }
    //Clear text  field method
    public void ClearTextField(String identifier,String locator)
    {

        WebElement e=webElementId(identifier, locator);
        e.clear();
    }
    //click general method
    public void click(String identifier,String locator)
    {
        WebElement e=webElementId(identifier, locator);
        e.click();
    }
    //verify title of the page
    public void verifyTitle(String title)
    {
        if(driver.getTitle().equals(title))
        {
            System.out.println("");
            System.out.println("Given usercredentials are correct");
            System.out.println(title+" displayed" );
        }
        else
        {
            System.out.println("");
            System.out.println("Given usercredentials are in correct");
            System.out.println("Failed to display "+title );
            return;
        }
    }

    //Wait until the Element is present
    public void waitUntilElementPresent(String elementpath)
    {
        WebElement elementpresent=(new WebDriverWait(driver,10)).
                until(ExpectedConditions.presenceOfElementLocated
                        (By.xpath(elementpath)));
    }

    //Verify Text
    public void verifyText(String identifier,String locator,String text)
    {
        WebElement e=webElementId(identifier, locator);
        if (e.getText().equals(text))
        {
            System.out.println(text+" displayed");
        }
        else
        {
            System.out.println(text+"Did not displayed");
        }
    }
    //verify element present
    public void verifyElementPresent(String identifier,String locator)
    {
        WebElement e=webElementId(identifier, locator);
        if (e.isDisplayed())
        {
            System.out.println("Element present");
        }
        else
        {
            System.out.println("Element is not present");
        }
    }

    //Thread sleep
    public void sleepThread(long sleeptime)
    {
        try
        {
            Thread.sleep(sleeptime);
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    //Wait for page to load
    public void waitForPageToLoad()
    {
        try {
            for(int i=0;i< 50;)
            {
                if (driver.getTitle().length()!=0 )
                {
                    System.out.println("Page loaded");
                    i=51;
                    break;
                }else {
                    Thread.sleep(1000);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //select frame by id
    public void selectFrameById(String locator)
    {
        driver.switchTo().frame(locator);
    }
    //Select frame default method
    public void selectFrameDefault(){
        driver.switchTo().defaultContent();
    }

    //getting data from table and verifying it with the required text
    public void verifyElementInTable(String xpathlocator,String text)
    {
        boolean a=false;
        List<WebElement> tdlist = driver.findElements(By.xpath(xpathlocator));
        for(WebElement el: tdlist)
        {
            if (el.getText().equals(text))
            {
                a=true;
                break;
            }
        }

        if(a==true)
        {
            System.out.println(text+" was identifed");
        }
        else
        {
            System.out.println( text+" was not identifed");
        }
    }
    //Start action
    public void startAction()
    {
        action =new Actions(driver);
    }
    //move to element
    public void MouseOverToElement(String identifier,String locator)
    {
        WebElement e=webElementId(identifier, locator);
        action.moveToElement(e).perform();
    }


}
