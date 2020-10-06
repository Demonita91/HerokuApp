import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class AddRemoveElementsTest extends BaseTest {

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement buttonAdd = driver.findElement(By.xpath("//button[text()='Add Element']"));
        buttonAdd.click();
        buttonAdd.click();
        List<WebElement> buttonsDelete = driver.findElements(By.xpath("//button[text()='Delete']"));
        buttonsDelete.get(0).click();
        assertTrue(buttonsDelete.get(1).isDisplayed());
    }
}
