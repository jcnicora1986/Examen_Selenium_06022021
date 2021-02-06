import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class prueba_netflix extends BasePage {


    @BeforeMethod
    public void ingresarNetflix() {
        driver.get("https://www.netflix.com/uy/");

    }
    @Test (priority = 4)
    public void validarTitulo() {

        NetflixHomePage netflixHomePage = new NetflixHomePage(driver);
        String tituloNetflix = netflixHomePage.validarTituloNetflix();

        System.out.println(">---" + tituloNetflix);

        Assert.assertEquals(tituloNetflix, "Netflix Uruguay: Ve series online, ve películas online");
    }

    @Test (priority = 3)

    public void iniciarSesionPageTest(){

        NetflixHomePage netflixHomePage = new NetflixHomePage(driver);
        String tituloNetflix = netflixHomePage.validarTituloNetflix();

        netflixHomePage.clickBtnIniciarSesion();

        NetflixInicioSesionPage netflixInicioSesionPage = new NetflixInicioSesionPage(driver);
        String tituloInicioSesionNetflix = netflixInicioSesionPage.validarTituloNetflixInicioSesion();

        Assert.assertNotEquals(tituloNetflix,tituloInicioSesionNetflix);

        List<WebElement> h1Title = netflixInicioSesionPage.getH1s();
        System.out.println("Total de H1 encontrados>---"+h1Title.size());

        boolean h1TitleFound = false;
        String textoTituloh1="";
        for (WebElement h1 : h1Title) {
            String tituloh1 = h1.getText();
            System.out.println(">--"+tituloh1);
            if (h1.getText().equals("Inicia sesión")||h1.getText().equals("Sign In")) {
                textoTituloh1 = tituloh1;
                h1TitleFound = true;
        }

            Assert.assertTrue(h1TitleFound);
            System.out.println("El titulo del h1: "+textoTituloh1);


    }

        WebElement etextoFacebook = netflixInicioSesionPage.getTextoFacebook();
        String textoFacebook = etextoFacebook.getText();
        System.out.println("El texto de facebook encontrado: "+textoFacebook);


        Assert.assertEquals(textoFacebook,"Login with Facebook");
    }

    @Test (priority = 2)
    public void loginToNetflixErrorTest(){

        NetflixInicioSesionPage netflixInicioSesionPage = new NetflixInicioSesionPage(driver);
        NetflixHomePage netflixHomePage = new NetflixHomePage(driver);

        netflixHomePage.clickBtnIniciarSesion();
        netflixInicioSesionPage.fillingSignIn();

        WebElement emailInvalid = netflixInicioSesionPage.getMsgInvalidEmail();
        String textoInvalidEmail = emailInvalid.getText();
        System.out.println("El texto de email invalido encontrado: "+textoInvalidEmail);


        Assert.assertEquals(textoInvalidEmail,"Please enter a valid email.");


    }

    @Test (priority = 1)
    public void fakeEmailTest(){

        NetflixHomePage netflixHomePage = new NetflixHomePage(driver);

        netflixHomePage.fillingFakerEmailComenzarYa();

        netflixHomePage.clickBtnComienzaYa();



        String url = driver.getCurrentUrl();

        System.out.println(url);
    }

    @Test (dataProvider = "emails", dataProviderClass = DataProviderNetflix.class)
    public void dataProviderEmailTest(String anEmail, String status){

        NetflixHomePage netflixHomePage = new NetflixHomePage(driver);

        if (status.equals("false")){

            netflixHomePage.fillingEmailComenzarYa(anEmail);
            // localizo el mensaje de existo y agrego un assert!! :)
            System.out.println("El email no valido a utilizar es: "+ anEmail);
        }


        netflixHomePage.clickBtnComienzaYa();



    }

   @AfterTest
    public void tearDown(){
        System.out.println("Se ha terminado de ejecutar un test...");
        driver.close();
    }
}
