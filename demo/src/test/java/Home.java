import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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
    void DownloadButton() throws InterruptedException {
        //Change path depending on your file directory
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();
        
        driver.findElement(By.xpath("//*[@id='landing-cta']/div/a")).click();

        File[] afterFiles = downloadDir.listFiles();

        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    //need to be logged in to conduct this test
    void OpenInBrowser() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id='landing-cta']/div/button")).click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertEquals(currentUrl, "https://discord.com/app");
    }

    @Test
    void DownloadButton2() throws InterruptedException {
        //Change path depending on your file directory
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();

        driver.findElement(By.xpath("//*[@id='about']/div/div[3]/a")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();

        Assert.assertEquals(afterFiles.length, files.length + 1);
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
