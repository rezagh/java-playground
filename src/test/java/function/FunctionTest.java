package function;

import lambda.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Supplier;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class FunctionTest {

    @Test
    public void test(){
        Function<String,Integer> func= x->x.length();
        Assertions.assertTrue(func.apply("xxx") == 3);

        //this doesnt run until used
        Supplier<Person> func1= () -> new Person().makePerson(Person.Sex.MALE) ;

        Assertions.assertTrue(func1.get().getGender() == Person.Sex.MALE);

    }



}
