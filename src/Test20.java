import java.util.HashMap;
import java.util.Map;
import java.util.Stack;



public class Test20 {
	public boolean isValid(String s) {
		if (s.length()==1) {
			return false;
		}
		Map<Character, Character> map = new HashMap<Character, Character>();
		map.put('(', ')');
		map.put('[', ']');
		map.put('{', '}');
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (map.containsKey(c)||stack.isEmpty()&&map.containsKey(c)) {
				stack.push(c);
			}else if(map.containsValue(c)){
				if (!stack.isEmpty()&&map.get(stack.peek())==c) {
					stack.pop();
				}else{
					return false ;
				}
			}
		}
		
		if (stack.isEmpty()) {
			return true;
		}else{
			return false;
		}
	}
	public static void main(String[] args) {
		Test20 t = new Test20();
		
		System.out.println(t.isValid(")}{({))[{{[}"));
	}
}
