import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Safety {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() throws InterruptedException {
        driver.get("https://discord.com");
        Thread.sleep(2000);
        driver.manage().window().maximize();
    }

    @AfterTest
    void teardown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testSafetyPageLinks() throws InterruptedException {

        driver.findElement(By.xpath("//a[normalize-space()='Safety']")).click();
        Thread.sleep(2000);

        String[] expectedUrls = {
                "https://discord.com/safety-library",
                "https://discord.com/safety-privacy",
                "https://discord.com/safety-parents",
                "https://discord.com/safety-transparency",
                "https://discord.com/safety-news",
                "https://discord.com/safety-policies"
        };

        List<WebElement> safetyLinks = driver.findElements(By.cssSelector("div.safety-secondary-menu a"));

        for (int i = 0; i < safetyLinks.size(); i++) {
            WebElement link = safetyLinks.get(i);
            link.click();
            Thread.sleep(2000);

            // Assert the current URL
            Assert.assertEquals(driver.getCurrentUrl(), expectedUrls[i], "URL Mismatch for link index: " + i);

            driver.navigate().back();
            Thread.sleep(2000);
            safetyLinks = driver.findElements(By.cssSelector("div.safety-secondary-menu a"));
        }
    }
}