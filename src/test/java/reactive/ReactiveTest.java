package reactive;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/*
  Source https://www.baeldung.com/reactor-core
*/

public class ReactiveTest{
    @Test
    public void test_Basic(){
        List<Integer> elements = new ArrayList<>();

        /*
            Create a Flux that emits the provided elements and then completes.
            it emits immediately
         */

        Flux.just(1, 2, 3, 4)
        .log()
        .subscribe(elements::add);

        System.out.println(elements.size());
    }

    @Test
    public void test_blocking(){
        Flux.range(1,1000000).map(i -> i-1).log().subscribe();
        System.out.println("reza");
    }

    @Test
    public void test_Basic2() {
        Flux books = Flux.just("book1", "book2");
        Flux mapped = books.map(title -> "Book name = " + title);
    }


    @Test
    public void test_Backpressure(){
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
        .log()
        .subscribe(new Subscriber<Integer>() {
          private Subscription s;
          int onNextAmount;
       
          @Override
          public void onSubscribe(Subscription s) {
              this.s = s;
              s.request(2);
          }
       
          @Override
          public void onNext(Integer integer) {
              elements.add(integer);
              onNextAmount++;
              if (onNextAmount % 2 == 0) {
                  s.request(2);
              }
          }
       
          @Override
          public void onError(Throwable t) {}
       
          @Override
          public void onComplete() {}
      });
             
    }

    @Test
    public void test_operations(){
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
        .log()
        //Transform the items emitted by this Flux by applying a synchronous function to each item.
        .map(i -> i * 2)
        .subscribe(elements::add);

        System.out.println(elements.toString());
    }

    //zip = combine
    @Test
    public void test_zip(){
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
        .log()
        .zipWith(Flux.just(1,2,3), (a,b)->a+b)
        .subscribe(elements::add);

        System.out.println(elements.toString());
    }

    @Test
    public void test_flatmap(){
        Flux.just(1, 5, 10)
                .flatMap(num -> Flux.just(num * 10))
                .subscribe(System.out :: println);
    }


    @Test
    public void test_defer(){
        Mono<Long> clock = Mono.just(System.currentTimeMillis());
        clock.subscribe(aLong -> System.out.println(aLong));
        clock.subscribe(aLong -> System.out.println(aLong));
        clock.subscribe(aLong -> System.out.println(aLong));
        clock.subscribe(aLong -> System.out.println(aLong));

    }
}