import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ProductNum {
	public static void main(String[] args) {
		String patternString = "[a-z|A-Z{5}][0-9]";
		String input = "dfadfsfasdf09123";
		Pattern pattern = Pattern.compile(patternString);
	    Matcher match = pattern.matcher(input);
	    if(match.find()){
	    	System.out.println("yes");
	    	String output = match.replaceAll("*");
	    	//System.out.println(match.group());
	    	System.out.println(output);
	    }
	}
}
