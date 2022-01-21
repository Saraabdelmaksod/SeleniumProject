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
import java.util.List;

public class Thirdtask {
    ChromeDriver driver;
    @BeforeTest
    public void OpenUrl()
    {
        String chromepath= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver=new ChromeDriver();
        driver.navigate().to("https://www.w3schools.com/html/html_tables.asp");
        //*[@id="customers"]/tbody/tr[1]
    }
    @Test
    public void webtable() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"customers\"]")));
        WebElement table = driver.findElement(By.xpath("//*[@id=\"customers\"]"));
       WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(70));
        wait1.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("tr")));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        System.out.println("size is " +rows.size());
        int size=rows.size();
        String before_xpath = "//*[@id=\"customers\"]/tbody/tr[";
        String after_xpath = "]/td[3]";
        for (int i =0 ; i <= size; i++)
        {
           String  reqiredrow= rows.get(i).getText();
           if(reqiredrow.contains("Ernst Handel"))
           {
            System.out.println(reqiredrow);
            System.out.println(i);
          i=i+1;
               String firstNames = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
               //System.out.println(i);
              Assert.assertEquals(firstNames,"Austria");
               //*[@id="customers"]/tbody/tr[4]/td[3]
            break;
           }
        }

    }

}

