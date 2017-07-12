package defaultfunction;

public interface SomeInterface {
	void test();
	
	
	/*
	 * Default methods enable you to add new functionality to the interfaces of your libraries and 
	 * ensure binary compatibility with code written for older versions of those interfaces.
	 */
	default int add(int a){
		return a;
	}
}
