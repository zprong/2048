
public class Up {
	public static void shift_up(int[][]matrix, int numElems, int colNum, int numRows) { // shifts all nonzero elems up (inside a column)  
		int shiftCounter = 0;
		int queueNum = 0;
		for(int i = 0; i < numRows ; ++i) {
			if(shiftCounter == numElems)
				return;
			if(matrix[i][colNum] != 0) {
				matrix[queueNum][colNum] = matrix[i][colNum];
				matrix[i][colNum] = 0;
				++queueNum;
			}
		}
	}
		
	public static void merge_up(int[][]matrix, int colNum, int numRows) { // merges the first match of numbers (bottom to top)
		for(int i = numRows - 1; i >= 1; i++) {
			if(matrix[i][colNum] == matrix[i-1][colNum]) {
				matrix[i-1][colNum] += matrix[i][colNum];
				matrix[i][colNum] = 0;
				shift_up(matrix, 4-i, colNum, i);
				return;
			}
		}
	}
}
