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

//id_userLoginId
//id_password
//bxid_rememberMe_true
//button[@class='btn login-button btn-submit btn-small']


    }

    public WebElement getMsgInvalidEmail(){

        List<WebElement> textoInvalidEmail = driver.findElements(By.className("inputError"));
        WebElement texto = textoInvalidEmail.get(0);
        return texto;
    }








    /*
    public void fillingInvalidEmailSignIn(){

        Faker faker_data = new Faker();
        //no utilizo un email para generar error
        String email = faker_data.name().firstName();
        System.out.println("---> utilizo el siguiente alias para dar error: " + email);
        driver.findElement(By.id("username")).sendKeys(email);

    }

    public void fillingValidEmailSignIn(){

        Faker faker_data = new Faker();
        //no utilizo un email para generar error
        String email = faker_data.internet().emailAddress();
        System.out.println("---> utilizo el siguiente email: " + email);
        driver.findElement(By.id("username")).sendKeys(email);

    }

    public void webElementemail(String email){

        driver.findElement(By.id("username")).sendKeys(email);


    }

    public String getTextEmail(){

        String email = driver.findElement(By.id("username")).getAttribute("value");

        return email;
    }

    public void fillingEmailExist(){

      driver.findElement(By.id("username")).sendKeys("test@test.com");

    }

    public void clickOnContinueEmail(){
        driver.findElement(By.xpath("//span[@class='bui-button__text'][contains(text(), 'Continue with email')]")).click();
    }

    public String getTextIngresoEmailVacio(){

        String textError=driver.findElement(By.id("username-description")).getText();
        return textError;

    }


    public WebElement getErrorMsgEmailInvalid(){
        List<WebElement> errorMessageListEmail = driver.findElements(By.className("bui-form__error"));
        WebElement errMsg = errorMessageListEmail.get(0);
        return errMsg;
    }

    public void InvalidPassCreateAccount(){

        Faker faker_data = new Faker();
        //no utilizo un email para generar error
        String pass1 = faker_data.internet().password();
        String pass2 = faker_data.internet().password();
        System.out.println("--->  " + pass1 + ">---" + pass2 );
        driver.findElement(By.id("new_password")).sendKeys(pass1);
        driver.findElement(By.id("confirmed_password")).sendKeys(pass2);

    }

    public WebElement getErrorPassDiferentes(){
        List<WebElement> errorMsgPassDiferentes = driver.findElements(By.id("confirmed_password-description"));
        WebElement errMsg = errorMsgPassDiferentes.get(0);
        return errMsg;
    }

    public void clickCreateAccount(){
        driver.findElement(By.xpath("//span[@class='bui-button__text'][contains(text(), 'Create account')]")).click();
    }

    public WebElement getMsgEnterPassAccountExist(){

        List<WebElement> msgEnterPassAccountExist = driver.findElements(By.xpath("//p[@class='nw-step-description'][contains(text(), 'Enter your Booking.com password for ')]"));
        WebElement msgAccountExist = msgEnterPassAccountExist.get(0);
        return msgAccountExist;
    }
*/

}
