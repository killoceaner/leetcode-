import java.util.HashMap;
import java.util.Stack;
/**
 * Longest Valid Parentheses
 * @author houxiang
 *
 */
public class Test27 {
	public int longestValidParentheses(String s) {
		Stack<Integer> stack = new Stack<Integer>() ;
		int imatch = 0 ;
		int result = 0 ;
		for(int i = 0 ; i<s.length() ; i++){
			if (s.charAt(i)=='(') {
				stack.add(i);
			}else{
				if (!stack.isEmpty()) {
					stack.pop() ;
					if (!stack.isEmpty()) {
						result = Math.max(result, (i-stack.peek()));
					}else{
						result = Math.max(result, (i-imatch+1));
					}
				}else{
					imatch = i+1 ;
				}
			}
		}
		return result ;
	}
	
	public static void main(String[] args) {
		Test27 t = new Test27() ;
		System.out.println(t.longestValidParentheses("))))))))))()()()()()()"));
	}
}
