package bin;

import java.lang.reflect.Field;
import java.lang.reflect.Method;



public class ClassLoaderTest {
	public static void main(String[] args) throws Throwable {
		ClassLoader  loader = Thread.currentThread().getContextClassLoader();
		Class claz = loader.loadClass("bin.CarClassTest");
		CarClassTest t = (CarClassTest)claz.newInstance();
		
		Field colorid = claz.getDeclaredField("colour");
		colorid.setAccessible(true);
		colorid.set(t, "red");
		
		Method mth = claz.getDeclaredMethod("drive",(Class[])null);
		mth.setAccessible(true);
		
		mth.invoke(t, (Class[])null);
		
		
		
		System.out.println(loader.getParent());
		System.out.println();
		
		char tmp = ' ';
		//tmp=' ';
		System.out.println((int)tmp);
		
		String srt1 =" dfdfd";
		
		System.out.println(srt1.trim());
		String srt = " fdsfsfs";
		if(srt.contains(" "));
		{
			srt=srt.replace(" ", " ");
			System.out.println(srt.trim());
		}
//      System.out.println(srt.trim());
//		if(srt.contains(" ")){
//			srt.replace(" ", "");
//		}
			
//		if(srt.contains(" ")){
//			srt.replace(" ", " ");
//		}
//		srt = srt.trim();
//		System.out.println(srt);
	}
}
