package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.time.Duration;
import java.util.List;

public class loginTask {
    ChromeDriver driver;
    @BeforeTest
    public void OpenUrl()
    {
        String chromepath= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver=new ChromeDriver();
        driver.navigate().to("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }
    @Test
    public void uploadimage() throws InterruptedException {
        waitmethod(60,By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button"));
        WebElement cstLoginBotton= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button"));
        cstLoginBotton.click();
        waitmethod(60,By.id("userSelect"));
        WebElement options= driver.findElement(By.id("userSelect"));
        Select optionlist= new Select(options);
        optionlist.selectByVisibleText("Albus Dumbledore");
        WebElement loginbutton= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/form/button"));
        loginbutton.click();
        waitmethod(60,By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));
        WebElement depositButton= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[2]"));
        depositButton.click();
        waitmethod(60,By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
        WebElement enterbox= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
        enterbox.sendKeys("1000");
        WebElement deposit2button= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
        deposit2button.click();
        WebElement withdrawelButton= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[3]"));
        withdrawelButton.click();
        waitmethod(60,By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
        WebElement withdrawlbox= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/div/input"));
        withdrawlbox.sendKeys("400");
        Thread.sleep(5000);
        waitmethod(60,By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
        WebElement withdrawl2button= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[4]/div/form/button"));
        Thread.sleep(5000);
        withdrawl2button.click();
        Thread.sleep(5000);
        WebElement balance= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/strong[2]"));
        String balance1= balance.getText();
        System.out.println("balance" + balance1);
        Thread.sleep(2000);
        Assert.assertEquals(balance1,600);
        WebElement transation= driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[3]/button[1]"));
        transation.click();
        waitmethod(60,By.xpath("/html/body/div/div/div[2]/div/div[2]/table"));
        WebElement table = driver.findElement(By.xpath("/html/body/div/div/div[2]/div/div[2]/table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
    }
    public void waitmethod(int x, By locate)
      {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(x));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locate));
      }
}
