public class Test24 {
	public int removeDuplicates(int[] nums) {
		if (nums.length == 0 || nums == null) {
			return 0;
		}
		int count =1 ;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]!=nums[i-1]) {
				nums[count] = nums[i];
				count ++ ;
			}
		}
		return count ;
	}
	public static void main(String[] args) {
		Test24 t = new Test24() ;
		int[] nums ={1,1,1,1,2,2,2,2,2,3,3,3,3,5,5,5,5,};
		System.out.println(t.removeDuplicates(nums));
	}
}
