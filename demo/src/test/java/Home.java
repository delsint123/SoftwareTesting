import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.beust.ah.A;

public class Home {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    void setup() {
        driver.get("https://discord.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    void teardown() {
        driver.close();
        driver.quit();
    }

    @Test
    void DownloadButton() {
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/a/img[1]")).click();
    }

    @Test
    //need to be logged in to conduct this test
    void OpenInBrowser() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='landing-cta']/div/button")).click();
        Thread.sleep(1000);

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://discord.com/app");
    }

    @Test
    void DownloadButton2() {
        driver.findElement(By.xpath("//*[@id='about']/div/div[3]/a")).click();
    }

    @Test 
    void DownloadText() {
        String text = driver.findElement(By.xpath("//*[@id='landing-cta']/div/a")).getText();

        Assert.assertEquals(text, "Download for Windows");
    }

    @Test 
    void DownloadText2() {
        driver.findElement(By.xpath("//*[@id='about']/div/div[3]/a")).click();

        String text = driver.findElement(By.xpath("//*[@id='about']/div/div[3]/a")).getText();

        Assert.assertEquals(text, "Download for Windows");
    }
}
