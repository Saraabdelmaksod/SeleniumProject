package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Fourthtask {
    ChromeDriver driver;
    @BeforeTest
    public void OpenUrl()
    {
        String chromepath= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver=new ChromeDriver();
        driver.navigate().to("http://the-internet.herokuapp.com/upload");
    }
    @Test
    public void uploadimage()
    {
        String imagename= "jpeg.jpg";
        String imagepath=System.getProperty("user.dir")+"/uploads/" +imagename;
        WebElement fileuploader=driver.findElement(By.id("file-upload"));
        fileuploader.sendKeys(imagepath);
        WebElement uploadbutton=driver.findElement(By.id("file-submit"));
        uploadbutton.click();
        WebElement uploadedfile =driver.findElement(By.id("uploaded-files"));
        System.out.println(uploadedfile.getText());
       // Thread.sleep(2000);
        Assert.assertEquals(imagename,uploadedfile.getText());
    }
    @AfterTest
    public void close()
    {
        driver.quit();
    }
}
