import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NetflixHomePage extends BasePage {


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

}
