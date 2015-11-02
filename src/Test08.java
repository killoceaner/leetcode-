import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test08 {

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> threeSum(int[] nums) {
		if (nums == null || nums.length < 3) {
			return res;
		}
		
		Arrays.sort(nums);
		
		for (int i = 0; i < nums.length-2; i++) {
			if (nums[i]>0) {
				break ;
			}
			if ( i>0 && nums[i-1]==nums[i]) {
				continue;
			}
			
			find(nums, i+1 , nums.length-1, nums[i]);
		}
		return res;
	}
	
	private void find(int[] nums , int i , int j , int target) {
		//List<Integer> list = new ArrayList<Integer>();
		int begin = i ;
		int end = j ;
		while(begin < end){
			if(nums[begin]+nums[end]+target==0){
				List<Integer> list = new ArrayList<Integer>();
				list.add(target);
				list.add(nums[begin]);
				list.add(nums[end]);
				res.add(list);
				while (begin < end && nums[begin] == nums[begin+1] ) {
					begin ++ ;
				}
				while(end > begin && nums[end]==nums[end--]){
					end -- ;
				}
				
				begin ++ ;
				end -- ;
				
			}else if(nums[begin]+ nums[end]< target){
				begin ++ ;
			}else {
				end -- ;
			}
		}
	}
	
	public static void main(String[] args) {
		Test08 test = new Test08();
		int[] nums = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
		int count = 0 ;
		for(int i = 0 ; i<nums.length ; i++){
			if (nums[i]==0) {
				count ++ ;
			}
		}
		System.out.println(count );
		System.out.println(test.threeSum(nums));
	}
}
