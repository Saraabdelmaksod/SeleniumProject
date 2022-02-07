package TestNGDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckAllBrockenLinks {
    ChromeDriver driver;
    @BeforeTest
    public void OpenUrl()
    {
        String chromepath= System.getProperty("user.dir")+"\\src\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver",chromepath);
        driver=new ChromeDriver();
        driver.navigate().to("https://the-internet.herokuapp.com/");
    }
    @Test
    public void testBrockenList()
    {
        java.util.List<WebElement> links= driver.findElements(By.tagName("a"));
        System.out.println("the total links" + links.size());
        for(int i=0 ; i< links.size();i++)
        {
            WebElement elemets= links.get(i);
            String url=elemets.getAttribute("href");
            verifylink(url);
        }
    }

    public static void verifylink(String urlLink) {

        try {
            URL link= new URL(urlLink);
            //create connection using url object
            try {
                HttpURLConnection httpconnect= (HttpURLConnection) link.openConnection();
                httpconnect.setConnectTimeout(2000);
                httpconnect.connect();
                //user GetResponseCode() to get response code
                if( httpconnect.getResponseCode()==200)
                {
                    System.out.println(urlLink +" _ "+httpconnect.getResponseCode());
                }
                if( httpconnect.getResponseCode()==404)
                {
                    System.out.println(urlLink +" _ "+httpconnect.getResponseCode());
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }



}
