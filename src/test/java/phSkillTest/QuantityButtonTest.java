package phSkillTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;


public class QuantityButtonTest {

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
    public void testPlusButtonClick() throws InterruptedException {
        
        driver.get("https://www.applegadgetsbd.com/product/galaxy-a06");
        Thread.sleep(5000); 

        try {
           
            WebElement plusButton = driver.findElement(By.xpath("//button[contains(text(), '+')]"));

            plusButton.click();


            System.out.println("\n---------------------------------------------");
            System.out.println("+ Button Working");
            System.out.println("---------------------------------------------\n");
            
        } catch (Exception e) {

            System.out.println("\n---------------------------------------------");
            System.out.println("+ Button not Working");
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
