package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
public class Fifth {
    ChromeDriver driver;
    @BeforeTest
    public void OpenUrl()
    {
        String chromepath= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver=new ChromeDriver();
        driver.navigate().to("https://jqueryui.com/resources/demos/droppable/default.html");
    }
    @Test
    public void search()
    {
        WebElement source= driver.findElement(By.id("draggable"));
        WebElement target= driver.findElement(By.id("droppable"));
        Actions builder=new Actions(driver);
        builder.dragAndDrop(source,target).perform();
        Assert.assertEquals(target.getText(),"Dropped!");
    }
    @AfterTest
    public void close()
    {
        driver.quit();
    }
}
