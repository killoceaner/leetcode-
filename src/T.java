import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class T {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	if (nums.length==0||nums == null ) {
			return result ;
		}
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length-4; i++) {
			for(int j = i+1 ; j<nums.length-3;j++){
				int sum = nums[i]+nums[j];
				List<Integer> tmpResult = check(nums, j+1, nums.length-1, target -sum);
				if (tmpResult!=null&&tmpResult.size() == 2) {
					tmpResult.add(nums[i]);
					tmpResult.add(nums[j]);
					Collections.sort(tmpResult);
					result.add(tmpResult);
				}
			}
    	}
    	return result ;
    }
    
    private List<Integer> check(int[] nums , int begin , int end , int target) {
    	List<Integer> result = new ArrayList<Integer>();
 		for (; begin < end ; begin++ , end --) {
			int sum = nums[begin]+ nums[end];
			if (sum<target) {
				begin ++ ;
			}else{
				end-- ;
			}
			if (sum == target) {
				result.add(nums[begin]);
				result.add(nums[end]);
				return result ;
			}
		}
 		return null ;
	}
    
    public static void main(String[] args) {
		T t = new T();
		int[] nums = {1,0,-1,0,-2,2};
		System.out.println(t.fourSum(nums, 0));
	}
}
