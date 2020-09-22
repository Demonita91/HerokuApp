import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TyposTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
         driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/typos");
        WebElement typos = driver.findElement(By.className("example"));

        assertEquals(typos.getAttribute("innerText"), "Typos\n" +
                "\n" +
                "This example demonstrates a typo being introduced. It does it randomly on each page load.\n" +
                "\n" +
                "Sometimes you'll see a typo, other times you won't.");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}