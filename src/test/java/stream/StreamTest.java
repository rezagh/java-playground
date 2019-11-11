package stream;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;



/*
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 * http://www.codejava.net/java-core/collections/java-8-stream-terminal-operations-examples 
 * http://www.codejava.net/java-core/collections/java-stream-aggregate-functions-examples-intermediate-operations
 */


public class StreamTest {
	
	@Test
	public void string_contact(){

		String a = Arrays.stream(new String[] {"1", "2", "3"})
	    .map(n -> n + "\n")
	    .collect(Collectors.joining(""));
		System.out.println(a);
	}
	
	@Test
	public void counter(){
	
		long out = Arrays.stream(new int[] {1,2,3,4,5}).count();
		System.out.println(out);
		
		
	}
}
