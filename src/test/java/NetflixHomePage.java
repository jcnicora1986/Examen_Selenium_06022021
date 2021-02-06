import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NetflixHomePage extends BasePage {
/*
    public NetflixHomePage selectLanguage(){
        driver.findElement(By.xpath("//img[@class='bui-avatar__image']")).click();
        driver.findElement(By.xpath("//div[@lang='en-us']")).click();
        NetflixHomePage nextPage= new NetflixHomePage(driver);
        return nextPage;
    }*/

    public NetflixHomePage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public String validarTituloNetflix(){
        return driver.getTitle();
    }

    public NetflixHomePage clickBtnIniciarSesion(){
        driver.findElement(By.className("redButton")).click();
        NetflixHomePage nextPage= new NetflixHomePage(driver);
        return nextPage;
    }

    public void clickBtnComienzaYa(){

        driver.findElement(By.className("cta-btn-txt")).click();

    }

    public void fillingEmailComenzarYa(String email){

        driver.findElement(By.id("id_email_hero_fuji")).sendKeys(email);


    }

    public void fillingFakerEmailComenzarYa(){

        Faker faker_data = new Faker();
        //no utilizo un email para generar error
        String email = faker_data.internet().emailAddress();
        System.out.println("---> utilizo el siguiente email: " + email);
        driver.findElement(By.id("id_email_hero_fuji")).sendKeys(email);


    }


//redButton

    /*

    public List<WebElement> getLink(){
        return driver.findElements(By.tagName("a"));
    }

    public List<WebElement> getH1s(){
        return driver.findElements(By.tagName("h1"));
    }
    public List<WebElement> getH2s(){
        return driver.findElements(By.tagName("h2"));
    }



    public NetflixHomePage clickBtnRegister(){
        driver.findElement(By.xpath("//span[@class='bui-button__text'][contains(text(), 'Register')]")).click();
        NetflixHomePage nextPage= new NetflixHomePage(driver);
        return nextPage;
    }


*/

}
