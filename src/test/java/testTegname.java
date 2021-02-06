import org.testng.annotations.BeforeMethod;

public class testTegname extends BasePage {

    @BeforeMethod
    public void ingresarNetflix() {
        driver.get("https://www.netflix.com/uy/");
        //NetflixHomePage netflixHomePage = new NetflixHomePage(driver);
        //netflixHomePage.selectLanguage();

    }




}
