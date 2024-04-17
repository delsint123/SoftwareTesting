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
    public void testDiscoverLinks() throws InterruptedException {
        driver.findElement(By.xpath("//a[normalize-space()='Discover']")).click();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/servers");
        driver.navigate().back();

        Thread.sleep(2000);

        WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Explore communities']"));
        searchField.sendKeys("Valorant");
        WebElement searchButton = driver.findElement(By.cssSelector("button.searchButton-2-uL9p"));
        searchButton.click();

        Thread.sleep(5000);

        List<WebElement> serverList = driver.findElements(By.cssSelector(".searchListItem-3mtFl3"));

        for (WebElement server : serverList) {
            String serverName = server.findElement(By.cssSelector(".listName-GkVhEs")).getText();

            if ("VALORANT LFG".equalsIgnoreCase(serverName)) {
                server.click();
                Thread.sleep(5000);
                driver.navigate().back();
                Thread.sleep(5000);
                break;
            }
        }

        List<WebElement> tabs = driver.findElements(By.xpath("//div[contains(@class, 'categoryListItemContainer-')]"));

        for (WebElement tab : tabs) {
            tab.click();
            Thread.sleep(5000);
        }
    }

}