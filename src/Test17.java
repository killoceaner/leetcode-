import java.util.Arrays;

public class Test17 {
	private int min = Integer.MAX_VALUE ;
	private int begin = 0 ;
	private int end = 0 ; 
	public int threeSumClosest(int[] nums, int target) {
		int res = 0 ;
		int flag =  Integer.MAX_VALUE ;
		
		if (nums.length == 0||nums==null) {
			return 0 ;
		}
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-2; i++) {
//			if (nums[i]>= target ) {
//				break ;
//			}
			int s = target -nums[i];
			int tmp = check(nums, i, s );
			int sum = nums[i]+tmp;
			if (flag > Math.abs(target - sum )) {
				flag = Math.abs(target - sum );
				res = sum ;
			}
		}
		
		return res ;
	}
	
	public int check(int[]nums ,int begin , int target) {
		int sum = 0 ;
		int i = begin +1 ;
		int j = nums.length -1 ;
		while(j>i) {
			sum = nums[i]+nums[j];
			if (min>Math.abs(target-sum)) {
				min = Math.abs(target - sum);
				begin = i ;
				end =j ;
			}
			if (sum < target) {
				i++ ;
			}else{ 
				j-- ;
			}
		}
		return (nums[begin]+nums[end]) ;
	}
	
	public static void main(String[] args) {
		Test17 test = new Test17() ;
		int[] array = {1,1,-1,-1,3};
		System.out.println(test.threeSumClosest(array, 3));
	}
}
