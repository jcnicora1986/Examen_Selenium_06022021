import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderNetflix {

    @DataProvider(name="emails")
    public Object[][] email(){
        return new Object[][] {
                {"jcnicora@gmail.com", "false"},
                {"juanperez@yahoo.com", "false"},
                {"jcarlos@hotmail.com", "false"}
        };
    }



}
