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


public class NotificationMessagesTest {
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
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement button = driver.findElement(By.linkText("Click here"));
        button.click();
        WebElement field = driver.findElement(By.id("flash"));
        if (field.getText().equals("Action successful\n" + "×")) {
            assertEquals(field.getText(), "Action successful\n" + "×");
        } else {
            assertEquals(field.getText(), "Action unsuccesful, please try again\n" + "×");
        }

    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
