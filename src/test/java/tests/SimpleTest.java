package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class SimpleTest {

    @BeforeClass
    public void setUp() {

    }

    @Test
    public void aTest() {
        System.out.println("run a test by testNG");
        assertThat("1 + 1 = 2", 2, equalTo(1 + 1));
    }

}
