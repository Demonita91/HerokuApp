import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class InputTest extends BaseTest {

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/inputs");
        WebElement input = driver.findElement(By.tagName("input"));
        input.sendKeys("5");
        input.sendKeys(Keys.ARROW_UP);
        assertEquals(input.getAttribute("value"), "6");
        input.sendKeys(Keys.ARROW_DOWN);
        assertEquals(input.getAttribute("value"), "5");
    }
}
//Inputs - Проверить на возможность ввести различные цифровые и нецифровые значения,
// используя Keys.ARROW_UP  И Keys.ARROW_DOWN
