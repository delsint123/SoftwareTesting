import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Navbar {

    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://discord.com");
    }

    @AfterTest
    void teardown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testNavbarLinks() {

        // Downloads link
        driver.findElement(By.xpath("//a[normalize-space()='Download']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/download");
        driver.navigate().back();

        // Nitro link
        driver.findElement(By.xpath("//a[normalize-space()='Nitro']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/nitro");
        driver.navigate().back();

        // Discover link
        driver.findElement(By.xpath("//a[normalize-space()='Discover']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/servers");
        driver.navigate().back();

        // Safety link
        driver.findElement(By.xpath("//a[normalize-space()='Safety']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/safety");
        driver.navigate().back();

        // Support link
        driver.findElement(By.xpath("//a[normalize-space()='Support']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://support.discord.com/hc/en-us");
        driver.navigate().back();

        // Blog link
        driver.findElement(By.xpath("//a[normalize-space()='Blog']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/blog");
        driver.navigate().back();

        // Careers link
        driver.findElement(By.xpath("//a[normalize-space()='Careers']")).click();
        Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/careers");
        driver.navigate().back();
    }
}
