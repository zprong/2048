
public class Right extends Ctrl {
	public int[][] shift(int[][]matrix, int numElems, int rowNum, int numCols) { // shifts all nonzero elems to the right
		int shiftCounter = 0;
		int queueNum = 3;
		for(int j = numCols-1; j >= 0 ; --j) {
			if(shiftCounter == numElems)
				return matrix;
			if(matrix[rowNum][j] != 0) {
				matrix[rowNum][queueNum] = matrix[rowNum][j];
				if(j != queueNum) {
					matrix[rowNum][j] = 0;
				}
				--queueNum;
				++shiftCounter;
			}
		}
		return matrix;
	}

	public static int[][] merge(int[][]matrix, int rowNum, int numCols) { // merges the first match of numbers (left to right)
		for(int j = numCols-1; j >= 1; j--) {
			if(matrix[rowNum][j] == matrix[rowNum][j-1]
			&& matrix[rowNum][j] != 0 && matrix[rowNum][j-1] != 0) {
				matrix[rowNum][j] += matrix[rowNum][j-1];
				matrix[rowNum][j-1] = 0;
				matrix = shift(matrix, numHorizElems(matrix, rowNum), rowNum, numCols); 
				return matrix;
			}
		}
		return matrix;
	}
}