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
        System.out.println("Total de H1 encontrados>---" + h1Title.size());

        boolean h1TitleFound = false;
        String textoTituloh1 = ""; // Variable to store the found H1 text
        for (WebElement h1Element : h1Title) { // Renamed loop variable for clarity
            String currentH1Text = h1Element.getText();
            System.out.println(">-- " + currentH1Text); // Log each H1 text found
            if (currentH1Text.equals("Inicia sesión") || currentH1Text.equals("Sign In")) {
                textoTituloh1 = currentH1Text; // Store the matched text
                h1TitleFound = true;
                // Optional: if only the first match is needed, uncomment the next line
                // break; 
            }
        }

        // Assertions and logging should be outside the loop
        Assert.assertTrue(h1TitleFound, "Expected H1 title 'Inicia sesión' or 'Sign In' was not found.");

        if (h1TitleFound) {
            System.out.println("El titulo del h1 encontrado: " + textoTituloh1);
        } else {
            // This else block will not be reached if the assertion above fails.
            // However, it's good for logical completeness if the assertion were softer.
            System.out.println("No se encontró el título H1 esperado ('Inicia sesión' o 'Sign In').");
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



        String currentUrl = driver.getCurrentUrl();

        System.out.println("Current URL after clicking 'Comienza Ya': " + currentUrl);
        Assert.assertTrue(currentUrl.contains("signup"), "Expected URL to contain 'signup' but was: " + currentUrl);
    }

    @Test (dataProvider = "emails", dataProviderClass = DataProviderNetflix.class)
    public void dataProviderEmailTest(String anEmail, String status){ // status parameter is kept to match provider
        NetflixHomePage netflixHomePage = new NetflixHomePage(driver);
        System.out.println("Testing with email: " + anEmail + " (status from DP: " + status + ")"); // Log the status for info
        netflixHomePage.fillingEmailComenzarYa(anEmail);
        netflixHomePage.clickBtnComienzaYa();
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signup"),
            "Expected URL to contain 'signup' for email '" + anEmail + "', but was: " + currentUrl);
    }

   @AfterTest
    public void tearDown(){
        System.out.println("Se ha terminado de ejecutar un test...");
        driver.close();
    }
}
