import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FileUpload extends BaseTest {
    @Test
    public void uploadTest() {
        driver.get("http://the-internet.herokuapp.com/upload");
        String workingDir = System.getProperty("user.dir");
        String filePath = workingDir + "/src/test/resourses/list.png";

        driver.findElement(By.cssSelector("input[id='file-upload']")).sendKeys(filePath);
        driver.findElement(By.cssSelector("input[id='file-submit]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("uploaded-files")));
        Assert.assertEquals(driver.findElement(By.id("uploaded-files")).getText(), "list.png");
    }
}
