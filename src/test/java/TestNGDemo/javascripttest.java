package TestNGDemo;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class javascripttest {
    ChromeDriver driver;
    @BeforeTest
    public void OpenUrl()
    {
        String chromepath= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver=new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
    }
    @Test
    public void search() throws InterruptedException {
        JavascriptExecutor ja= (JavascriptExecutor) driver;
    ja.executeScript("scrollBy(0,4000)");
        Thread.sleep(3000);

    }
}
