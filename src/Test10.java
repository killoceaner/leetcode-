
public class Test10 {
	
	private int findSeq(int[] nums ){
		int len = nums.length;
		int res = 1 ;
		int[] d = new int[len];
		for(int i = 0 ; i<len ;i++){
			d[i] = 1 ;
			for (int j = 0; j < i; j++) {
				if (nums[j]<nums[i] && d[j]+1 > d[i]) {
					d[i] = d[j]+1 ;
				}
				if (len < d[i]) {
					len = d[i];
				}
			}
		}
		return len ;
	}
	
	public static void main(String[] args) {
		
	}
}
