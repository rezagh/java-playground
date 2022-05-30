package lambda;

import java.util.List;

public class LambdaTest {
	
	/*
	 * goal is to search members of a roster list
	 */
	
//----------------------------------------- method 1 - 
	public static void printPersonsOlderThan(List<Person> roster, int age) {
	    for (Person p : roster) {
	        if (p.getAge() >= age) {
	            p.printPerson();
	        }
	    }
	}
//------------------------------------------- method 2
	// Specify Search Criteria Code in a Class

	void printPersons( List<Person> roster, CheckPerson tester) {
	    for (Person p : roster) {
	        if (tester.test(p)) {
	            p.printPerson();
	        }
	    }
	}

	class CheckPersonEligibleForSelectiveService implements CheckPerson {
	    public boolean test(Person p) {
	        return p.gender == Person.Sex.MALE &&
	            p.getAge() >= 18 &&
	            p.getAge() <= 25;
	    }
	}

	public void test1(){
		List<Person> roster = null;
		printPersons(roster , new CheckPersonEligibleForSelectiveService());

	}
	

//-------------------------------------------- method 3
	// anonymous class

	public void test2(){
		List<Person> roster = null;
		// implementing existing CheckPerson interface while usign/passing it on to printPersons method.
		printPersons(roster , new CheckPerson() {
	        public boolean test(Person p) {
	            return p.getGender() == Person.Sex.MALE
	                && p.getAge() >= 18
	                && p.getAge() <= 25;
	        }
	    });
	}
//----------------------------------------------- method 3
	//  lambda
	
	public void test3(){
		List<Person> roster = null;
		
		// below  forms are same. the parameter p on the left had of -> token matches the test() method interface.
		// below are implementation of the functional interface
		// we are passing functionality as lambda to the printPersons method

		printPersons(
			    roster,
			    (Person p) -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 25
			);

		//invocation

		
		printPersons(
			    roster,
			    (p) -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 25
			);
		printPersons(
			    roster,
			    p -> p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 25
			);
	
		printPersons(
			    roster,
			    p -> { return p.getGender() == Person.Sex.MALE
			        && p.getAge() >= 18
			        && p.getAge() <= 25;}
			);
		
	}

	public static void main(String...args){

	}
}