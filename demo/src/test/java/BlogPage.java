import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import java.util.List;
import java.io.IOException;
import com.beust.ah.A;

public class BlogPage {
    WebDriver driver = new ChromeDriver();

    @BeforeTest
    public void setUp() {
        driver.get("https://discord.com");
        driver.manage().window().maximize();
    }

    @AfterTest
    void teardown() {
        driver.close();
        driver.quit();
    }

    @Test
    public void testBlogDropdown() throws InterruptedException, IOException {
        WebElement blogLink = driver.findElement(By.linkText("Blog"));
        blogLink.click();

        WebElement dropdownToggle = driver.findElement(By.xpath("//div[@class='w-dropdown-toggle']"));
        dropdownToggle.click();
        String[] links = {"Community", "Discord HQ", "Engineering & Developers", "How to Discord", "Policy & Safety", "Product & Features"};

        for (String linkText : links) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(link.isDisplayed());
            link.click();
            Thread.sleep(2000);

            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/blog");
            driver.navigate().back();
            dropdownToggle.click();
        }
    }

    @Test
    public void testBlogPosts() throws InterruptedException, IOException {
        WebElement blogLink = driver.findElement(By.linkText("Blog"));
        blogLink.click();
        WebElement featuredLink = driver.findElement(By.cssSelector("a.blog-nav-item:nth-child(2)"));
        featuredLink.click();

        List<WebElement> featuredBlogs = driver.findElements(By.className("blog-featured-title"));
        for (WebElement element : featuredBlogs) {
            element.click();
            Thread.sleep(2000);
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/blog-featured");
            driver.navigate().back();
        }


        List<WebElement> smallBlogs = driver.findElements(By.className("blog-featured-title-small"));
        for (WebElement element : smallBlogs) {
            element.click();
            Thread.sleep(2000);
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/blog-featured");
            driver.navigate().back();
        }

        WebElement nextButton = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div[2]/a/div"));
        nextButton.click();
        Thread.sleep(2000);
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/blog");
        driver.navigate().back();

    }

}