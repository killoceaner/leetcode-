import java.util.HashSet;

public class Test16 {
	public int lengthOfLongestSubstring(String s) {
		HashSet<Character> sets = new HashSet<Character>() ;
		int max = 0 ;
		int runner = 0 ; 
		int walker = 0 ;
		
		while(runner < s.length()){
			if (sets.contains(s.charAt(runner))) {
				while (walker != runner ) {
					if (s.charAt(walker)!=s.charAt(runner)) {
						walker ++ ;
						sets.remove(s.charAt(walker));
					}else{
						 walker ++ ;
						 
						 break ;
					}
				}
			}
			else {
				runner ++ ;
				sets.add(s.charAt(runner));
				if (max < runner - walker) {
					max = runner -walker;
				}
			}
		}
		return max ;
	}
	
	public static void main(String[] args) {
		Test16 test = new Test16();
		String s = "abcabcaas";
		System.out.println(test.lengthOfLongestSubstring(s));
	}
}
