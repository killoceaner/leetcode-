import java.util.*;


public class Test07 {
	
	
	public static void main(String[] args) {
		StrComparator comparator = new StrComparator();
		Set<String> set = new TreeSet(comparator);
		Scanner cin = new Scanner(System.in);
		int num = Integer.parseInt(cin.next());
		for (int i = 0; i < num; i++) {
			set.add(cin.next());
		}
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String ans = (String) itr.next();
			System.out.print(ans);
		}
		System.out.println("\n");
	}
	
}

class StrComparator implements Comparator<String>
{
	public int compare(String o1, String o2) {
		String str1 = o1+o2;
		String str2 = o2+01;
		return str1.compareTo(str2);
	}
	
}
