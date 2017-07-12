package lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class LambdaTest2 {
	List<Person> roster = null;
	
	/*
	 * Goal is to use CheckPerson2 interface with 2 parameters
	 * 
	 */

	
	void printPersons( List<Person> roster, CheckPerson2 tester) {
	    for (Person p : roster) {
	        if (tester.test(p, 1)) {
	            p.printPerson();
	        }
	    }
	}

 
	public void test_printPersons(){
		
		
		printPersons(roster,
			    (Person p, int i) -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 25
			        && i > 120
			);
	}
	
	
	//same this using predicate - a functional interface
	void printPersons( List<Person> roster, Predicate<Person> p) {
	    for (Person person : roster) {
	        if (p.test(person)) {
	            person.printPerson();
	        }
	    }
	}

	
	public void test_predicate(){
		printPersons(roster,
			    p -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 25
			);
	}


	//expanding the printPersons method to do more on the person
	//Consumer functional interface represents an operation that accepts a single input argument and returns no result.
	public static void processPersons(List<Person> roster, Predicate<Person> tester, Consumer<Person> block) {
	    for (Person p : roster) {
	        if (tester.test(p)) {
	            block.accept(p);
	        }
	    }
	}
	
	public void test_processPersons(){
		
		processPersons(roster,
			     p -> p.getGender() == Person.Sex.MALE
			         && p.getAge() >= 18
			         && p.getAge() <= 25,
			     q -> q.printPerson()
			);

	}
	


}