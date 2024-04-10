import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Download {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod
    void setup() {
        driver.get("https://discord.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/nav/div[2]/a[1]")).click();
    }

    @AfterTest
    void teardown() {
        driver.close();
        driver.quit();
    }

    @Test
    void MainDownloadButton() throws InterruptedException {
        //Change path depending on your file directory
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();
        
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/a")).click();
        Thread.sleep(2000);

        File[] afterFiles = downloadDir.listFiles();

        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void MainDownloadTextButton() {
        String text = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/a")).getText();

        Assert.assertEquals(text, "Download for Windows");
    }

    @Test
    void iOSDownload() {
        driver.findElement(By.xpath("//*[@id='w-node-a1fd9329-fa33-debf-718b-2568fc683fd1-735ece3e']/a")).click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(currentUrl, "https://discord.com/download");
    }

    @Test
    void AndroidDownload() {
        driver.findElement(By.xpath("//*[@id='w-node-_49fb1c89-f13c-4da7-c28a-8c2824081a9a-735ece3e']/a")).click();

        String currentUrl = driver.getCurrentUrl();

        Assert.assertNotEquals(currentUrl, "https://discord.com/download");
    }

    @Test
    void LinuxDownloadDeb() throws InterruptedException{
        //Change path depending on your file directory
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();
        
        driver.findElement(By.id("w-dropdown-toggle-1")).click();
        driver.findElement(By.linkText("deb")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();

        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void LinuxDownloadTar() throws InterruptedException{
        //Change path depending on your file directory
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();
        
        driver.findElement(By.id("w-dropdown-toggle-1")).click();
        driver.findElement(By.linkText("tar.gz")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();

        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void MacDownload() throws InterruptedException {
        //Change path depending on your file directory
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();
        
        driver.findElement(By.xpath("//*[@id='w-node-_9166b1b0-317d-eb0d-5442-4e710ccfcbcf-735ece3e']/a")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();

        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void ExperimentalDownloadsMac() throws InterruptedException{
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();

        driver.findElement(By.id("w-dropdown-toggle-2")).click();
        driver.findElement(By.linkText("Mac")).click();
        Thread.sleep(1000);


        File[] afterFiles = downloadDir.listFiles();
        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void ExperimentalDownloadsLinuxDeb() throws InterruptedException{
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();

        driver.findElement(By.id("w-dropdown-toggle-2")).click();
        driver.findElement(By.linkText("Linux deb")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();
        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void ExperimentalDownloadsLinuxTar() throws InterruptedException{
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();

        driver.findElement(By.id("w-dropdown-toggle-2")).click();
        driver.findElement(By.linkText("Linux tar.gz")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();
        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void ExperimentalDownloadsWindows32() throws InterruptedException{
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();

        driver.findElement(By.id("w-dropdown-toggle-2")).click();
        driver.findElement(By.linkText("Windows 32-bit")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();
        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void ExperimentalDownloadsWindows64() throws InterruptedException{
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();

        driver.findElement(By.id("w-dropdown-toggle-2")).click();
        driver.findElement(By.linkText("Windows 64-bit")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();
        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test
    void ExperimentalDownloadsWindows64Canary() throws InterruptedException{
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();

        driver.findElement(By.id("w-dropdown-toggle-2")).click();
        driver.findElement(By.linkText("Windows 64-bit (Canary)")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();
        Assert.assertEquals(afterFiles.length, files.length + 1);
    }

    @Test 
    void ArchiveDownload() throws InterruptedException{
        File downloadDir = new File("C:/Users/delsi/Downloads");
        File[] files = downloadDir.listFiles();

        driver.findElement(By.xpath("//*[@id='w-node-b8a70b01-fcca-327e-3efa-26d66c1ad806-735ece3e']/div[2]/a")).click();
        Thread.sleep(1000);

        File[] afterFiles = downloadDir.listFiles();
        Assert.assertEquals(afterFiles.length, files.length + 1);
    }
}
