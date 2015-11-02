import java.io.FileNotFoundException;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.Scanner;


public class Test02 {
	public static void main(String[] args) throws FileNotFoundException {
		String url = "C:/Users/houxiang/Desktop/sourcedata.txt";
		FileReader fin = new FileReader(url);
		Scanner in = new Scanner(fin);
		
		while(in.hasNextInt()){
			int a = in.nextInt();
		    int num = in.nextInt();
		    BigInteger ab = new BigInteger(String.format("%d", a));
		    BigInteger tmp = new BigInteger(String.format("%d", num));
		}
		
	   		
   }
}
