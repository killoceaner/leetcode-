public class Test12 {
	public String convert(String s, int numRows) {
		int len = s.length();
		
		StringBuilder sb = new StringBuilder();
		if (numRows >= len || numRows == 1) {
			return s;
		}

		// 第一行
		for (int i = 0; i < len; i += 2 * numRows - 2){
			sb.append(s.charAt(i));
		}
				
		// 中间行
		for (int i = 1; i < numRows-1; i++) {
			
			for (int j = i;j < len;j+=2*(numRows-1)){
				sb.append(s.charAt(j));
				if(j+2*(numRows-i-1)<len){
					sb.append(s.charAt(j+2*(numRows-i-1)));
				}				
			}
		}

		// 最后一行
		for (int i = numRows - 1; i < len; i += 2 * numRows - 2) {
			sb.append(s.charAt(i));
		}

		return sb.toString();
	}
	
	public static void main(String[] args) {
		Test12 test = new Test12();
		System.out.println(test.convert("PAYPALISHIRING", 4));
	}
}
