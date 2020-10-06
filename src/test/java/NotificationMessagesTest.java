import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NotificationMessagesTest extends BaseTest {

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/notification_message_rendered");
        WebElement button = driver.findElement(By.linkText("Click here"));
        button.click();
        WebElement field = driver.findElement(By.id("flash"));
        assertEquals(field.getText(), "Action successful\n" + "×");
    }
}
