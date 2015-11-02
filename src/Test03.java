import java.util.*;


public class Test03 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] array = new int[n][n];
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				array[i][j]=in.nextInt();
			}
		}
	
		List<Integer>list = null ;
		Map<Integer,List<Integer>> map = new HashMap<Integer,List<Integer>>();
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				int sum = i+j;
				if(map.containsKey(sum)){
					list = map.get(sum);
					if(sum%2==0){
						list.add(0, array[i][j]);
					}else{
						list.add(array[i][j]);
					}
				}else{
					list = new ArrayList<Integer>();
					list.add(array[i][j]);
					map.put(sum, list);
				}
			}
		}
		
		for(int i = 0 ; i<=2*(n-1);i++){
			list = map.get(i);
			for(int e : list){
				System.out.print(e+" ");
			}
		}
	}		
}
