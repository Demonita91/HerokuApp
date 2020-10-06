import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicControls extends BaseTest {

    public boolean isCheckboxPresent(){
        int number = driver.findElements(By.id("checkbox")).size();
        return number == 0;
    }

    @Test
    public void elementsTest(){
        driver.get("http://the-internet.herokuapp.com/dynamic_controls");
        driver.findElement(By.xpath("//input[@type = 'checkbox']")).click();
        driver.findElement(By.xpath("//button[@onclick = 'swapCheckbox()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's gone!");
        Assert.assertTrue(isCheckboxPresent());

        Assert.assertFalse(driver.findElement(By.cssSelector("input[type='text']")).isEnabled());
        driver.findElement(By.xpath("//button[@onclick='swapInput()']")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        Assert.assertEquals(driver.findElement(By.id("message")).getText(), "It's enabled!");
        Assert.assertTrue(driver.findElement(By.cssSelector("input[type='text']")).isEnabled());
    }
}
