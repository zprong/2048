import java.util.Random;
public class Ctrl {
	/*
	private char input;
	private int[][] matrix = new int[4][4]; 
	public char getInput() {
		return input;
	}
	public void setInput(char input) {
		this.input = input;
	}
	
	*/

	public static int[][] setMatrix(int[][] settingMatrix, int [][] setterMatrix, int numRows, int numCols) {
		for(int i = 0; i < numRows; ++i) 
			for(int j = 0; j < numCols; ++j) 
				settingMatrix[i][j] = setterMatrix[i][j];
		return settingMatrix;
	}
	public static boolean shifted(int[][] ogMatrix, int[][] newMatrix, int numRows, int numCols) {
		for(int i = 0; i < numRows; ++i) 
			for(int j = 0; j < numCols; ++j) 
				if(ogMatrix[i][j] != newMatrix[i][j])
					return true;
		return false;
	}
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j < 4; j++) {
//				System.out.print(matrix[i][j] + " "); 
				System.out.printf("%-4d ", matrix[i][j]);
			}
			System.out.println();
			System.out.println();
		}
	}
	public static void randGenerator(int[][] matrix) { // generates random number, 
		while(true) {
			Random rand = new Random();
			int randRow = rand.nextInt(4);
			int randCol = rand.nextInt(4);
			if(matrix[randRow][randCol] == 0) { // element is empty 
				matrix[randRow][randCol] = 2;
				break;
			}
		}
	}

/* 	int numHorizElems(int[][] matrix, int row)
 * 		matrix [2D int array] 	-- Passed in main matrix 
 * 		row [int]			 	-- Row number of matrix being checked
 * 	Description: This 
 * 
 * 
 * 
 * 	
 */
	public static int numHorizElems(int[][] matrix, int row) { // number of nonzero elements in a row
		int counter = 0;
		for(int j = 0; j < 4; ++j) 
			if(matrix[row][j] != 0)
				counter++;
		return counter;
	}
	
	public static int numVertElems(int[][] matrix, int col) {
		int counter = 0;
		for(int i = 0; i < 4; ++i) 
			if(matrix[i][col] != 0)
				counter++;
		return counter;
	}
	
	public int[][] shift(int[][]matrix, int numElems, int rowNum, int numCols) {
		return matrix;
	}
}
