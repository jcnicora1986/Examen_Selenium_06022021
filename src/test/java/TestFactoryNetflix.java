import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class TestFactoryNetflix {

    @Factory
    public Object[] facebookFactoryTest(){
        return new Object[]{
                new prueba_netflix(),
                new prueba_netflix(),
        };
    }
}
