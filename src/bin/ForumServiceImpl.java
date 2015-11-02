package bin;

public class ForumServiceImpl {
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Employee c1 = new Employee("Jack");
		Class c2 = c1.getClass();
		System.out.println(c2.getName());
		c1.print();
		Employee c3 = (Employee)Class.forName("bin.Employee").newInstance();
		c3.setName("Tom");
		c3.print();
	}
}
