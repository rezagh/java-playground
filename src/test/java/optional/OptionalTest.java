package optional;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertFalse;

/*
Optional: A container object which may or may not contain a non-null value.
If a value is present, isPresent() will return true and get() will return the value.


https://www.baeldung.com/java-optional

 */
public class OptionalTest {

    @Test
    public void test(){
        Optional<String> empty = Optional.empty();
        assertFalse(empty.isPresent());

        String myStr = "abc"; // This might be null too hence no need to do null check
        Optional<String> opt = Optional.of("baeldung");
        opt.ifPresent(name -> System.out.println(name.length()));

        String name = Optional.ofNullable(myStr).orElseGet(() -> "ss");

    }


}
