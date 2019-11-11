package reactive;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ReactiveTest{
    
    @Test
    public void test_Basic(){
        
        Flux<String> flux = Flux.just("1", "2", "3");
        Mono<String> mono = Mono.just("foo");

        List<Integer> elements = new ArrayList<>();
 
        Flux.just(1, 2, 3, 4)
        .log()
        .subscribe(elements::add);
        
        //assertThat(elements).containsExactly(1, 2, 3, 4);

    }

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

    public void test_operations(){
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
        .log()
        //Transform the items emitted by this Flux by applying a synchronous function to each item.
        .map(i -> i * 2)
        .subscribe(elements::add);

        System.out.println(elements.toString());
        //assertThat(elements).containsExactly(1, 2, 3, 4);
    }
    public void test_zip(){
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4)
        .log()
        //Transform the items emitted by this Flux by applying a synchronous function to each item.
        .map(i -> i * 2)
        .subscribe(elements::add);

        System.out.println(elements.toString());
        //assertThat(elements).containsExactly(1, 2, 3, 4);
    }


}