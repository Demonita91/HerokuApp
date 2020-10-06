import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FramesTest extends BaseTest {
    @Test
    public void iFrameTest() {
        driver.get("http://the-internet.herokuapp.com/frames");
        driver.findElement(By.linkText("iFrame")).click();
        driver.switchTo().frame(driver.findElement(By.id("mce_0_ifr")));
        Assert.assertEquals(driver.findElement(By.id("tinymce")).getText(), "Your content goes here.");
    }
}

