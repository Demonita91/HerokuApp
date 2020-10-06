import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SortableDataTablesTest {
    WebDriver driver;

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/tables#delete");
        WebElement value1 = driver.findElement(By.xpath("//table[1]//tr[1]//td[1]"));
        assertEquals(value1.getText(), "Smith");

        WebElement value2 = driver.findElement(By.xpath("//table[2]//tr[2]//td[2]"));
        assertEquals(value2.getText(), "Frank");

        WebElement value3 = driver.findElement(By.xpath("//table[1]//tr[4]//td[5]"));
        assertEquals(value3.getText(), "http://www.timconway.com");

        WebElement value4 = driver.findElement(By.xpath("//table[2]//tr[2]//td[4]"));
        assertEquals(value4.getText(), "$51.00");

        WebElement value5 = driver.findElement(By.xpath("//table[1]//tr[4]//td[3]"));
        assertEquals(value5.getText(), "tconway@earthlink.net");

    }
}
//Проверить содержимое нескольких (3-5) ячеек таблицы.
// Использовать xpath типа //table//tr[1]//td[1] - получение первой ячейки из первого ряда первой таблицы и так далее