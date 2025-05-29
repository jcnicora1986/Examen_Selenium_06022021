import io.github.bonigarcia.wdm.WebDriverManager; // Add this import
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;

import java.util.concurrent.TimeUnit;

public class BasePage {

    WebDriver driver;
    WebDriverWait wait;

    @BeforeTest
    public void setup() {
        WebDriverManager.chromedriver().setup(); // Replace System.setProperty
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

}
