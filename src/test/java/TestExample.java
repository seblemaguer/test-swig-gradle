// Testing
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.IOException;
import cz.adamh.utils.NativeUtils;

// Example interface
import example_package.example;

public class TestExample {

    static {
        try {
            NativeUtils.loadLibraryFromJar("/libexample.so");
        } catch (IOException e) {
            e.printStackTrace(); // This is probably not the best way to handle exception :-)
        }
    }

    // static {
    //     try {
    //         System.loadLibrary("example");
    //     } catch (UnsatisfiedLinkError e) {
    //         System.err.println("Native code library failed to load. See the chapter on Dynamic Linking Problems in the SWIG Java documentation for help.\n" + e);
    //         System.exit(1);
    //     }
    // }


    @Test
    public void testGCD() {
        // Call our gcd() function

        int x = 42;
        int y = 105;
        int g = example.gcd(x,y);
        Assert.assertEquals(g, 21);
    }

    @Test
    public void testFOO() {
        example.setFoo(3.1415926);
        Assert.assertEquals(example.getFoo(), 3.1415926);
    }
}
