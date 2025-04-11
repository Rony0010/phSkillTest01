package phSkillTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class AddToCart {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().window().maximize();
    }

    @Test
    public void clickFirstAddToCartButton() throws InterruptedException {
        driver.get("https://www.applegadgetsbd.com/category/phones-tablets");
        
        Thread.sleep(5000);

        List<WebElement> addToCartButtons = driver.findElements(By.xpath("//button[contains(text(), 'Add to Cart')]"));

        if (!addToCartButtons.isEmpty()) {
            WebElement firstAddToCart = addToCartButtons.get(0);
            wait.until(ExpectedConditions.elementToBeClickable(firstAddToCart));
            firstAddToCart.click();
            System.out.println("\n---------------------------------------------");
            System.out.println("First Add To Cart button clicked successfully.");
            System.out.println("---------------------------------------------\n");

        } else {
            System.out.println("\n---------------------------------------------");
            System.out.println("No 'Add To Cart' button found !!!!");
            System.out.println("---------------------------------------------\n");
            
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
