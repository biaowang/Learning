import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SimpleTest {

    @BeforeClass
    public void setUp() {

    }

    @Test
    public void aTest() {
        System.out.println("run a test by testNG");
    }

}
