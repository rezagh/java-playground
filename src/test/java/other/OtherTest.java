package other;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class OtherTest {
    @Test
    public void test(){
    System.out.println(key(new Integer(1), new String("444"), new Long(55)));
    }

    private String key(Object... keys) {
        return Arrays.stream(keys).filter(Objects::nonNull).map(Object::toString).collect(Collectors.joining(":"));
    }

}
