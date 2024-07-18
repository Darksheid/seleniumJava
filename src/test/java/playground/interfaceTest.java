package playground;

public interface interfaceTest {
	
	public static void check() {
		System.out.println("Static method implemented in interface");
	}
	
	default void checkAnother() {
		System.out.println("Default method implemented in interface");
	}
	
	public void checkNew();
	
	abstract void check2();

}
