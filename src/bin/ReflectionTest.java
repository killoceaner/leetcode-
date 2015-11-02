package bin;

import java.util.*;
import java.lang.reflect.*;

public class ReflectionTest {
	public static void main(String[] args) {
		String name;
		if (args.length > 0)
			name = args[0];
		else {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter class name(e.g.java.util.Date):");
			name = in.next();
		}
		Class c1;
		try {
			c1 = Class.forName(name);
			Class superc1 = c1.getSuperclass();
			String modifiers = Modifier.toString(c1.getModifiers());
			if (modifiers.length() > 0)
				System.out.println("modifiers" + modifiers);
			System.out.println("********************");
			printConstructors(c1);
			printMethods(c1);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.exit(0);
	}

	/**
	 * 
	 */
	public static void printConstructors(Class c1) {
		Constructor[] constructors = c1.getDeclaredConstructors();
		for (Constructor c : constructors) {
			String name = c.getName();
			String modifiers = Modifier.toString(c.getModifiers());
			if (modifiers.length() > 0) {
				System.out.println(modifiers + " ");
			}
			System.out.println(name + "(");

			Class[] paramsTypes = c.getParameterTypes();
			for (int i = 0; i < paramsTypes.length; i++) {
				if (i > 0)
					System.out.println(", ");
				System.out.print(paramsTypes[i].getName()+" ");
			}

			System.out.println(")");

		}

	}

	/**
	 * 
	 */
	public static void printMethods(Class c1) {
		Method[] methods = c1.getDeclaredMethods();
		for (Method m : methods) {
			String name = m.getName();
			System.out.println(" ");
			String modifiers = Modifier.toString(m.getModifiers());
			if (modifiers.length() > 0) {
				System.out.println(modifiers + " ");
			}
			System.out.println(name + "(");

			Class[] paramsTypes = m.getParameterTypes();
			for (int i = 0; i < paramsTypes.length; i++) {
				if (i > 0)
					System.out.println(", ");
				System.out.print(paramsTypes[i].getName()+" ");
			}

			System.out.println(")");

		}
	}
}
