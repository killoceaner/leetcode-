public class Test09 {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		int i = 0 ; 
		int j = matrix[0].length -1 ;
		while(i<=matrix.length -1 && j >=0 ){
			int x = matrix[i][j];
			if (x == target) {
				return true;
			}
			if (target > x  ) {
				i++ ; 
			}else{
				j-- ;
			}
		}
		return false ; 
	}
	
	public static void main(String[] args) {
		Test09 test = new Test09();
		int[][]matrix = {
		                 {1,   4,  7, 11, 15},
		                 {2,   5,  8, 12, 19},
		                 {3,   6,  9, 16, 22},
		                 {10, 13, 14, 17, 24},
		                 {18, 21, 23, 26, 30}	 
		                };
		
		
		int[][]matrix2 ={{1,3,5}};
		
		int[][]matrix3 = {{-5}};
		System.out.println(test.searchMatrix(matrix3, -5));
		
	}
}
