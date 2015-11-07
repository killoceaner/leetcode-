import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * 4 SUM 
 * @author houxiang
 *
 */
public class T {
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
    	HashSet<List<Integer>> sets = new HashSet<List<Integer>>();
    	if (nums.length==0||nums == null ) {
			return result ;
		}
    	
    	Arrays.sort(nums);
    	for (int i = 0; i <= nums.length-4; i++) {
    		
			for(int j = i+1 ; j<= nums.length-3;j++){
				if (j!=(i+1)&&nums[j]==nums[j-1]) {
					continue ;
				}
				int sum = nums[i]+nums[j];
				int tmp = target - sum ;
				List<List<Integer>>  tmpResult = check(nums, j+1, nums.length-1, target -sum);
				for(List<Integer> list : tmpResult){
					if (list != null && list.size() == 2) {
						list.add(nums[i]);
						list.add(nums[j]);
						Collections.sort(list);
						if (!sets.contains(list)) {
							sets.add(list);
							result.add(list);
						}
						
					}
				}
			}
    	}
    	return result ;
    }
    
    private List<List<Integer>> check(int[] nums , int begin , int end , int target) {
    	List<List<Integer>> result = new ArrayList<List<Integer>>();
 		while(begin < end ) {
			int sum = nums[begin]+ nums[end];
			if (sum<target) {
				begin ++ ;
			}else if(sum > target){
				end-- ;
			}else{
				List<Integer> list = new ArrayList<Integer>();
				list.add(nums[begin]);
				list.add(nums[end]);
				result.add(list);
				begin++;
				end--;
			}
		}
 		return result ;
	}
    
    public static void main(String[] args) {
		T t = new T();
		int i = 3;
		if (++i == 4) {
			System.out.println(i);
		}
		int[] nums = {-1,0,-5,-2,-2,-4,0,1,-2};
		System.out.println(t.fourSum(nums, -9));
	}
}
