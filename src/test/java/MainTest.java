
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;


import java.util.concurrent.TimeUnit;

public class MainTest {

    @Disabled
    @Test
    @Timeout(value = 22, unit = TimeUnit.SECONDS)
    void twentySecondForMainTest() throws Exception {
        Main.main(null);
    }


}
