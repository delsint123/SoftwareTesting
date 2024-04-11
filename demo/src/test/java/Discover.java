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

public class Discover {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://discord.com");
        Thread.sleep(2000);
    }

    @AfterTest
    void teardown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testDiscoverLinks() {

        // Servers link
        driver.findElement(By.xpath("//a[normalize-space()='Discover']")).click();

        Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/servers");
        driver.navigate().back();

        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Explore communities']"));
        searchField.sendKeys("Valorant");
        WebElement searchButton = driver.findElement(By.cssSelector("button.searchButton-2-uL9p"));
        searchButton.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<WebElement> tabs = driver.findElements(By.xpath("//div[contains(@class, 'categoryListItemContainer-')]"));

        for (WebElement tab : tabs) {
            tab.click();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
