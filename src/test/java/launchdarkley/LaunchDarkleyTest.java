package launchdarkley;


/*
https://docs.launchdarkly.com/sdk/server-side/java

 */
import com.launchdarkly.sdk.*;
import com.launchdarkly.sdk.server.*;
import org.junit.jupiter.api.Test;

public class LaunchDarkleyTest {
    @Test
    public void test(){
        LDClient ldClient = new LDClient("sdk-2bd89d1a-4ac1-47df-80f4-8ad9485c7669");
        //LDUser user = new LDUser("xyz");
        LDUser user = new LDUser.Builder("aa0ceb")
                .email("reza.ghafari@streamotion.com.au")
                .build()
                ;
        String showFeature = ldClient.stringVariation("test-reza", user, "default val");

            System.out.print(showFeature);


    }
}
