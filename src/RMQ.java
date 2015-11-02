import java.util.Scanner;


public class RMQ {
	private static int[] tmp = {1,2,5,55,8,44,48,14,8,6,18,1,4,7,5,57,49,14,18,0,18};
	private static int N = tmp.length;
	private static int[][] maxDp = new int[N][20];
	private static int[][] minDp = new int[N][20];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = tmp.length;
		RMQ(21);
		System.out.println("********************************");	
		Scanner in = new Scanner(System.in);
		int i = in.nextInt();
		int j = in.nextInt();
		int k = countK(i,j);
		System.out.println(maxDp[i][k]);
	}
	
	public static int max(int i , int j ){
		return i>j?i:j;
	}
	
	public static int min(int i , int j ){
		return i<j?i:j;
	}
	
	
	//先对数组进行预处理
	public static void RMQ(int num){
		
		for(int i = 0 ; i< num ;i++){
			maxDp[i][0] = tmp[i];
			minDp[i][0] = tmp[i];
		}
		
		int k = countK(0,num);
	     
		for(int j = 1 ; j<=k ; j++){
			for(int i = 0 ; i+(1<<j-1)<num;i++){
				int mid = i+(1<<j-1);
				maxDp[i][j] = max(maxDp[mid][j-1],maxDp[mid+1][j-1]);
				minDp[i][j] = min(minDp[mid][j-1],minDp[mid+1][j-1]);
			}
		}
		
		
//		for(int i = 0 ; i< num ; i++){
//			for(int j =1 ; (1<<j) < num;j++ ){
//			    int tmp_num = 1<<j;
//				maxDp[i][1<<j] = max(maxDp[i][1<<j-1],maxDp[i+1<<j-1][1<<j]);
//				minDp[i][1<<j] = min(minDp[i][1<<j-1],minDp[i+1<<j-1][1<<j]);
//			}
//		}
	}
	
//	public int[] process(int[] m ){
//		int i = 0 ;
//		for(;i<m.length;i++){
//			
//		}
//		return m;
//	}
//	
	public static int countK(int i , int j ){
		int x = 1 ;
		int k = 0 ;
		if(j<i){
			return k ;
		}else{
			int range = j -i + 1 ;
			while(x<range){
				k++;
				x<<=1;
			}
		}
		return k;
	}
}
