import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class HoverTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src/test/resourses/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        //       driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void errorPage() {
        WebElement errorPage = driver.findElement(By.xpath("/html/body/h1"));
        assertEquals(errorPage.getText(), "Not Found");
        driver.navigate().back();

    }

    @Test
    public void elementsTest() {
        driver.get("http://the-internet.herokuapp.com/hovers");
        Actions actions = new Actions(driver);
        WebElement userAvatar1 = driver.findElement(By.xpath("//div[@id=\"content\"]/div/div[1]"));
        actions.moveToElement(userAvatar1).build().perform();
        WebElement actualUserProfile1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/h5"));
        assertEquals(actualUserProfile1.getAttribute("innerText"), "name: user1");
        WebElement div = driver.findElement(By.partialLinkText("View profile"));
        div.click();
        errorPage();

        WebElement userAvatar2 = driver.findElement(By.xpath("//div[@id=\"content\"]/div/div[2]"));
        actions.moveToElement(userAvatar2).build().perform();
        WebElement actualUserProfile2 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
        assertEquals(actualUserProfile2.getAttribute("innerText"), "name: user2");
        WebElement div2 = driver.findElement(By.partialLinkText("View profile"));
        div2.click();
        errorPage();

        WebElement userAvatar3 = driver.findElement(By.xpath("//div[@id=\"content\"]/div/div[3]"));
        actions.moveToElement(userAvatar3).build().perform();
        WebElement actualUserProfile3 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
        assertEquals(actualUserProfile3.getAttribute("innerText"), "name: user3");
        WebElement div3 = driver.findElement(By.partialLinkText("View profile"));
        div3.click();
        errorPage();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
