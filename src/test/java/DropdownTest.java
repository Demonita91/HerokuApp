import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class DropdownTest extends BaseTest {

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/dropdown");
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByVisibleText("Option 1");
        assertTrue(select.getFirstSelectedOption().isSelected(), "Option 1");
        select.selectByVisibleText("Option 2");
        assertTrue(select.getFirstSelectedOption().isSelected(), "Option 2");

    }
}
