import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import org.testng.Assert;
import java.util.List;
import java.io.IOException;

public class CareersPage  {
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

    @Test (priority = 1)
    public void testCareerFilters() throws InterruptedException, IOException {
        Thread.sleep(1000);
        WebElement careerLink = driver.findElement(By.linkText("Careers"));
        careerLink.click();
        Thread.sleep(2000); 

        WebElement filterDiv = driver.findElement(By.id("careers-filters"));
        List<WebElement> filterButtons = filterDiv.findElements(By.className("department-filter-item"));
        for (WebElement filterButton : filterButtons) {
            filterButton.click();
            Thread.sleep(2000);
            Assert.assertEquals(driver.getCurrentUrl(), "https://discord.com/careers");
        }
    }

    @Test (priority = 2)
    public void testJobPostings() throws InterruptedException, IOException {
        Thread.sleep(1000);
        WebElement careerLink = driver.findElement(By.linkText("Careers"));
        careerLink.click();
        Thread.sleep(2000);

        // Find all job postings
        List<WebElement> jobPostings = driver.findElements(By.className("card-job"));

        for (int i = 0; i < 3; i++) {
            jobPostings = driver.findElements(By.className("card-job"));
            WebElement jobPosting = jobPostings.get(i);

            jobPosting.click(); 
            Thread.sleep(2000); 

        }
    }

    @Test(priority = 3)
    public void testApplyNowButton() throws InterruptedException, IOException {
        Thread.sleep(1000);
        WebElement careerLink = driver.findElement(By.linkText("Careers"));
        careerLink.click();
        Thread.sleep(2000);

        String originalWindow = driver.getWindowHandle();

        WebElement specificJobPosting = driver.findElement(By.xpath("//a[contains(@href,'/jobs/')]"));
        specificJobPosting.click();
        Thread.sleep(2000); 

        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.equals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

        WebElement applyContainer = driver.findElement(By.className("ctaContainer-3FbgNU"));
        WebElement applyNowButton = applyContainer.findElement(By.xpath(".//button[contains(text(),'Apply Now')]"));
        applyNowButton.click();
        Thread.sleep(2000); 

        WebElement formSection = driver.findElement(By.className("formSection-333K0P"));

        List<WebElement> inputFields = formSection.findElements(By.cssSelector("input[type='text']"));
        for (WebElement inputField : inputFields) {
            String placeholder = inputField.getAttribute("placeholder");
            if (placeholder != null && !placeholder.isEmpty()) {
                inputField.sendKeys("Test"); 
            }
        }

        WebElement additionalInputField = formSection.findElement(By.cssSelector("div.formRow-3_3vWA:nth-child(3) > div:nth-child(1) > div:nth-child(2) > input:nth-child(1)"));
        additionalInputField.sendKeys("Estero");

        WebElement resumeInput = formSection.findElement(By.xpath(".//input[@accept='.doc,.docx,.pdf,.txt']"));
        resumeInput.sendKeys("");
        Thread.sleep(3000);

    }

}





