import java.util.ArrayList;
import java.util.List;

public class Test18 {
	public List<String> letterCombinations(String digits) {  
        List<String> result = new ArrayList<String>();  
        if (digits.length() == 0 || digits=="") {
			return result ;
		}
        String[] map = new String[10];  
        map[0] = "";  
        map[1] = "";  
        map[2] = "abc";  
        map[3] = "def";  
        map[4] = "ghi";  
        map[5] = "jkl";  
        map[6] = "mno";  
        map[7] = "pqrs";  
        map[8] = "tuv";  
        map[9] = "wxyz";  
        char[]  middleTemp = new char[digits.length()];  
        dfsGetStr(digits, 0, middleTemp, map, result);   
        return result;  
    }  
      

	
	private void dfsGetStr(String digits , int index , char[] middleTemp , String[]map ,List<String> result) {
		if (index == digits.length()) {
			result.add(new String(middleTemp));
			return ;
		}
		
		char strChar = digits.charAt(index);
		for (int i = 0; i < map[strChar-'0'].length(); i++) {
			middleTemp[index] =map[strChar-'0'].charAt(i);
			dfsGetStr(digits, index+1, middleTemp, map, result);
		}
	}
	
	public static void main(String[] args) {
		Test18 test = new Test18();
		System.out.println(test.letterCombinations("23"));
	}
}
