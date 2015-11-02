public class Test14 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		if (gas.length == 0 || cost.length == 0 || gas.length != cost.length ) {
			return -1 ; 
		}
		
		int sum = 0 ; 
		int total = 0;
		int begin = 0 ;
		int[] diff = new int[gas.length];
		for(int i = 0 ; i<gas.length ; i++){
			total += (gas[i]-cost[i]);
			if (sum < 0) {
				sum = 0 ;
				begin = i ;
			}else{
				total += sum ;
			
			}
		}
		return total ;
	}
}
