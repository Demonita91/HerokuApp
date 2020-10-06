import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class CheckboxesTest extends BaseTest {

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/checkboxes");
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        assertFalse(checkboxes.get(0).isSelected(), "первый чекбокс не должен быть выбран");
        checkboxes.get(0).click();
        assertTrue(checkboxes.get(0).isSelected(), "первый чекбокс должен быть выбран");
        assertTrue(checkboxes.get(1).isSelected(), "второй чекбокс должен быть выбран");
        checkboxes.get(1).click();
        assertFalse(checkboxes.get(1).isSelected(), "второй чекбокс не должен быть выбран");
    }
}