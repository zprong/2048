
public class Down {
	public static void shift_down(int[][]matrix, int numElems, int colNum, int numRows) { // shifts all nonzero elems down (inside a column)  
		int shiftCounter = 0;
		int queueNum = 3;
		for(int i = numRows-1; i >= 0 ; --i) {
			if(shiftCounter == numElems)
				return;
			if(matrix[i][colNum] != 0) {
				matrix[queueNum][colNum] = matrix[i][colNum];
				matrix[i][colNum] = 0;
				--queueNum;
			}
		}
	}
		
	public static void merge_down(int[][]matrix, int colNum, int numRows) { // merges the first match of numbers (top to bottom)
		for(int i = 0; i < numRows-2; i++) {
			if(matrix[i][colNum] == matrix[i+1][colNum]) {
				matrix[i+1][colNum] += matrix[i][colNum];
				matrix[i][colNum] = 0;
				shift_down(matrix, 4-i, colNum, i);
				return;
			}
		}
	}
}
