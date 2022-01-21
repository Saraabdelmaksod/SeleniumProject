package TestNGDemo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;

public class Firsttask {
    ChromeDriver driver;
    @BeforeTest
    public void OpenUrl()
    {
        String chromepath= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver=new ChromeDriver();
        driver.navigate().to("https://www.google.com/");
    }
    @Test
   public void search()
   {
      // WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      // wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
     //  driver.findElement(By.name("q")).sendKeys("Cucumber IO");
       WebElement searchbox= driver.findElement(By.name("q"));
       searchbox.sendKeys("Cucumber IO");
       searchbox.submit();
       WebElement resultpage2= driver.findElement(By.xpath("//*[@id=\"xjs\"]/table/tbody/tr/td[3]/a"));
       resultpage2.click();
       //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
       //wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("LinkedIn")));
      WebElement linkpath = driver.findElement(By.partialLinkText("LinkedIn"));
      Assert.assertTrue(linkpath.isDisplayed());
      System.out.println(linkpath.getAttribute("href"));
    }
    @AfterTest
    public void close()
    {
        driver.quit();
    }
}
