import java.util.ArrayList;
import java.util.List;


public class Test19 {
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
        int index = 0 ;
        
        int len = map[digits.charAt(index)-'0'].length() ;
        int k = 0 ;
        while(k<len){
        	middleTemp[k] = map[digits.charAt(index)-'0'].charAt(k);
        	if (index<digits.length()) {
				index++;
				int len2 = map[digits.charAt(index)-'0'].length() ;
				int l = 0
				
			}
        	while(index<digits.length()){
        		
        	}
        	
        }
        return result;  
    }  
      
}
