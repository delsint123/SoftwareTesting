import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import com.beust.ah.A;
import java.io.File;
import java.io.IOException;
import java.util.Set;

public class FooterPage  {
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

    @Test(priority = 6)
    public void testFooterSocialMediaLinks() throws InterruptedException, IOException {

        String originalWindow = driver.getWindowHandle();
        String[] socialMediaLinks = {"a.link-s:nth-child(1)", "a.link-s:nth-child(2)", "a.link-s:nth-child(3)", "a.link-s:nth-child(4)", "a.link-s:nth-child(5)"};
        for (String linkText : socialMediaLinks) {
            WebElement link = driver.findElement(By.cssSelector(linkText));
            Assert.assertTrue(link.isDisplayed());
            link.click();
            Thread.sleep(2000);

            }
    }

    @Test(priority = 1)
    public void testProductLinks() throws InterruptedException, IOException {
        String[] Links = {"Download", "Nitro", "Status", "App Directory", "New Mobile Experience"};
        for (String linkText : Links) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(link.isDisplayed());
            link.click();
            Thread.sleep(2000);
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/");
            driver.navigate().back(); 
        }
    }

    @Test(priority = 2)
    public void testCompanyLinks() throws InterruptedException, IOException {
        String[] Links = {"About", "Jobs", "Brand", "Newsroom"};
        for (String linkText : Links) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(link.isDisplayed());
            link.click();
            Thread.sleep(2000);
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/");
            driver.navigate().back(); 
        }
    }

    @Test(priority = 3)
    public void testResourceLinks() throws InterruptedException, IOException {
        String[] Links = {"College", "Support", "Safety", "Blog", "Feedback", "StreamKit", "Creators", "Community", "Developers", "Gaming", "Quests", "Official 3rd Party Merch"};
        for (String linkText : Links) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(link.isDisplayed());
            link.click();
            Thread.sleep(2000);
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/");
            driver.navigate().back(); 
        }
    }


    @Test(priority = 4)
    public void testPoliciesLinks() throws InterruptedException {
        String[] links = {"Terms", "Privacy", "Cookie Settings", "Guidelines", "Acknowledgements", "Licenses", "Company Information"};
        for (String linkText : links) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(link.isDisplayed());
            link.click();
            Thread.sleep(2000);
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/");
            if (isElementPresent(By.xpath("//*[@id='close-pc-btn-handler']"))) {
                WebElement closeButton = driver.findElement(By.xpath("//*[@id='close-pc-btn-handler']"));
                closeButton.click();
                if (!driver.getCurrentUrl().equals("https://discord.com/")) {
                    driver.navigate().back();
                }
            }
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }


    @Test(priority = 5)
    public void testFooterSignUpLink() throws InterruptedException, IOException {
        String[] Links = {"Sign up"};
        for (String linkText : Links) {
            WebElement link = driver.findElement(By.linkText(linkText));
            Assert.assertTrue(link.isDisplayed());
            link.click();
            Thread.sleep(2000);
            Assert.assertNotEquals(driver.getCurrentUrl(), "https://discord.com/");
            driver.navigate().back(); 
        }
    }
}





