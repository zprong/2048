
public class Left {
	public static void shift_left(int[][]matrix, int numElems, int rowNum, int numCols) { // shifts all nonzero elems to the left
		int shiftCounter = 0;
		int queueNum = 0;
		for(int j = 0; j < numCols ; --j) {
			if(shiftCounter == numElems)
				return;
			if(matrix[rowNum][j] != 0) {
				matrix[rowNum][queueNum] = matrix[rowNum][j];
				matrix[rowNum][j] = 0;
				++queueNum;
			}
		}
	}
	
	public static void merge_left(int[][]matrix, int rowNum, int numCols) { // merges the first match of numbers (right to left)
		for(int j = numCols; j >= 1; --j) {
			if(matrix[rowNum][j] == matrix[rowNum][j-1]) {
				matrix[rowNum][j-1] += matrix[rowNum][j];
				matrix[rowNum][j] = 0;
				shift_left(matrix, 4-j, rowNum, j);
				return;
			}
		}
	}
}
