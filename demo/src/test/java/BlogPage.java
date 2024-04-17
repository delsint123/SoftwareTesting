import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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

    @Test(priority = 2)
    public void testBlogDropdown() throws InterruptedException, IOException {
        // Test blog page
        WebElement blogLink = driver.findElement(By.linkText("Blog"));
        blogLink.click();

        WebElement dropdownToggle = driver.findElement(By.xpath("//div[@class='w-dropdown-toggle']"));
        dropdownToggle.click();
        String[] links = {"Community", "Discord HQ", "Engineering & Developers", "How to Discord", "Policy & Safety", "Product & Features"};

        for (String linkText : links) {
            // Find the link element inside the dropdown by its text
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(link.isDisplayed());
            link.click();
            Thread.sleep(2000);

            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/blog");
            driver.navigate().back();
            dropdownToggle.click();
        }
    }

    @Test(priority = 1)
    public void testBlogPosts() throws InterruptedException, IOException {


        WebElement blogLink = driver.findElement(By.linkText("Blog"));
        blogLink.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement featuredLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.blog-nav-item:nth-child(2)")));
        featuredLink.click();

        List<WebElement> featuredBlogs = driver.findElements(By.className("blog-featured-title"));
        for (int i = 0; i < featuredBlogs.size(); i++) {
            List<WebElement> refreshedBlogs = driver.findElements(By.className("blog-featured-title"));
            WebElement element = refreshedBlogs.get(i);
            element.click();
            Thread.sleep(2000);
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/blog-featured");
            driver.navigate().back(); // Navigate back to the previous page
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