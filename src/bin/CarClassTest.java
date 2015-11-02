package bin;

public class CarClassTest {
	
	private String colour;
	
	protected void drive(){
		System.out.println("this car'colour is " + colour);
	}
	
	public static void main(String[] args) {
		CarClassTest ss = new CarClassTest();
		System.out.println(ss.getClass().getName());
	}
}
