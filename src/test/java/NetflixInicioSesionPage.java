import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class NetflixInicioSesionPage extends BasePage {


    public NetflixInicioSesionPage(WebDriver remoteDriver){
        driver = remoteDriver;
    }

    public String validarTituloNetflixInicioSesion(){
        return driver.getTitle();
    }
    public List<WebElement> getH1s(){
        return driver.findElements(By.tagName("h1"));
    }

    public WebElement getTextoFacebook(){

        List<WebElement> textoFace = driver.findElements(By.className("fbBtnText"));
        WebElement textoFacebook = textoFace.get(0);
        return textoFacebook;
    }

    public void fillingSignIn(){

        driver.findElement(By.id("id_userLoginId")).sendKeys("XXX");
        driver.findElement(By.id("id_password")).sendKeys("holamundo");
        driver.findElement(By.className("login-remember-me-label-text")).click();
        driver.findElement(By.className("login-button"));

    }

    public WebElement getMsgInvalidEmail(){

        List<WebElement> textoInvalidEmail = driver.findElements(By.className("inputError"));
        WebElement texto = textoInvalidEmail.get(0);
        return texto;
    }



}
