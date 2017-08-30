package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class ResourceBookingPage extends AbstractPage {
    public ResourceBookingPage(WebDriver driver) {
        super(driver);
    }

    public void verifyResourceScreen() throws InterruptedException {


        driver.switchTo().frame("body_FRAME_27Module");
        String t=driver.findElement(By.xpath("//form[@id='frmBookingHome']/div/header/h1")).getText();
        Assert.assertEquals(t,"Resource Booking");
       /* verifyTitle("MyAdstream");
        Thread.sleep(2000);*/
    }
    public MakeBookingPage NavigateToMakeBooking(){
        String t=driver.findElement(By.xpath(".//*[@id='RRB']/header/h1")).getText();
        Assert.assertEquals(t,"Make Booking");
        return new MakeBookingPage(driver);
    }

}
