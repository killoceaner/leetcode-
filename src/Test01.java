import java.io.BufferedInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Scanner;


public class Test01 {
	private static Hashtable<String , String > map = new Hashtable<String, String>();
	
	public static void main(String[] args) {
		MyThread myThread1 = new Test01().new MyThread("ss");
		MyThread myThread2 = new Test01().new MyThread("dd");
		myThread1.start();
		myThread2.start();
		
		
		System.out.println(map.get("1019"));
		
	}
	class MyThread extends Thread {
		private String value ;
		
		public MyThread(String value ) {
			// TODO Auto-generated constructor stub
			this.value = value ;
		}
		public void run() {
			// TODO Auto-generated method stub
			map.put("1019", value);
		}
		
	}
}

