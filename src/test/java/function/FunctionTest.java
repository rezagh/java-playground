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

    /*
    Function<T, R>
     * @param <T> the type of the input to the function
     * @param <R> the type of the result of the function

     */
    @Test
    public void test(){
        Function<String,Integer> func= x->x.length();
        Assertions.assertTrue(func.apply("xxx") == 3);

        //this doesnt run until used
        Supplier<Person> func1= () -> new Person().makePerson(Person.Sex.MALE) ;

        Assertions.assertTrue(func1.get().getGender() == Person.Sex.MALE);

    }

    @Test
    public void composeFunction(){
        Function<Integer,Integer> doubleIt= x->x *2;
        Function<Integer,Integer> absIt = (value) -> Math.abs(value);

        //composites
        Function result = doubleIt.andThen(absIt);
        Function result2 = doubleIt.compose(absIt);

        System.out.print(result.apply(1));




    }



}
