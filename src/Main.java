import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String tmp = in.next();
		char[] tmp_char = tmp.toCharArray();
		int count = 0;
		int i = 0;
		for (; i < tmp_char.length; i++) {
			count += tmp_char[i] - '0';
		}
		System.out.println(count_num(count).trim());
	}

	private static String count_num(int count) {
		String ans = "";
		while (count % 10 > 0) {
			int tmp = count % 10;
			String str = num_change(tmp);
			ans = " " + str + ans;
			count /= 10;
		}
		return ans;
	}

	private static String num_change(int num) {
		switch (num) {
		case 0: {
			return "lin";
		}
		case 1: {
			return "yi";
		}
		case 2: {
			return "er";
		}
		case 3: {
			return "san";
		}
		case 4: {
			return "si";
		}
		case 5: {
			return "wu";
		}
		case 6: {
			return "liu";
		}
		case 7: {
			return "qi";
		}
		case 8: {
			return "ba";
		}
		case 9: {
			return "jiu";
		}
		}
		return null;
	}

}
