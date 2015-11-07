import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
/**
 * Implement strStr()
 * @author houxiang
 *
 */
public class Test25 {
	public int strStr(String haystack, String needle) {
		if (haystack==null||needle == null) {
			return 0;
		}
		
		if (needle.length() == 0 ) {
			return 0 ;
		}
		
		for (int i = 0; i < haystack.length(); i++) {
			if (i+needle.length() > haystack.length()) {
				return -1 ;
			}
			int m = i ;
			for (int j = 0; j < needle.length(); j++) {
				if (haystack.charAt(m) == needle.charAt(j)) {
					if (j == needle.length() -1 ) {
						return i ;
					}
					m++;
				}else{
					break;
				}
			}
		}
		return -1 ;
	}
	
	
	public static void main(String[] args) {
		String haystack = "onmyway";
		String needle = "my";
		Test25 t = new Test25();
		System.out.println(t.strStr(haystack, needle));
	}
}
