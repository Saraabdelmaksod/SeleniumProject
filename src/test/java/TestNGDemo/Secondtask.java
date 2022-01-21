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


public class Secondtask {
    ChromeDriver driver;
    @BeforeTest
    public void OpenUrl()
    {
        String chromepath= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver=new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/checkboxes");
    }
    @Test
    public void checkbox()
    {
      //  WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"checkboxes\"]/input[1]")));
        WebElement check1= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        check1.click();
        WebElement check2= driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[2]"));
        Assert.assertTrue(check1.isSelected());
        Assert.assertTrue(check2.isSelected());
        System.out.println("check1 and check2 is selected");
    }
    @AfterTest
    public void close()
    {

        driver.quit();
    }
}
