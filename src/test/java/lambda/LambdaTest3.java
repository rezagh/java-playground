package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class LambdaTest3 {


    public static void main(String...args){

        Function<Integer,Integer> f = p -> {
            if (p>5) return p;
            else return 0;
        };

        System.out.println(f.apply(4));
        

    }


    
}