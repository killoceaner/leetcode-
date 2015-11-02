/**
 * 01背包问题
 * @author houxiang
 *
 */
public class Test11 {
	private int[][] c = new int[10][100]; 
	private int knapsack(int m , int n , int[]w , int[] p ) {
		 
		 for(int i = 0; i<10 ; i++){
			 for(int j = 0 ; j<100 ; j++){
				 c[i][j] = 0 ;
			 }
		 }
		 
		 for(int i = 1 ; i < n+1 ; i++){
			 for(int j = 1 ; j<m+1 ; j++){
				 if (w[i]<=j) {
					if (p[i]+c[i-1][j-w[i]]>c[i-1][j]) {
							c[i][j] = p[i]+c[i-1][j-w[i]];
					}else{
						c[i][j] = c[i-1][j];
					}
				}else{
					c[i][j] = c[i-1][j];
				}
			 }
		 }
		 return c[n][m];
	}
}
