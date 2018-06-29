import java.util.Random;
import java.util.Scanner;
//import java.awt.*;
//import java.awt.event.*;
public class Test {

	public static void main(String[] args) {
		final int NUM_COLS = 4;
		final int NUM_ROWS = 4;
//		Right rCtrl = new Right();
//		Up uCtrl = new Up(); 
//		Down dCtrl = new Down();
//		Left lCtrl = new Left();
		char input;
		Scanner inputDevice = new Scanner(System.in);
//		Test myChar = new Test();
		int[][] matrix = new int[4][4];
		int[][] tempMatrix = new int[4][4];
		boolean valid;
//		printMatrix(matrix);
//		System.out.println();
		randGenerator(matrix);
		printMatrix(matrix);
		System.out.println();
		do {
			setMatrix(tempMatrix, matrix, NUM_ROWS, NUM_COLS);
			System.out.print("Enter control: ");
			input = inputDevice.next().charAt(0);
			switch(Character.toLowerCase(input)) {
			  case 'd':
				for(int i = 0; i < 4; ++i) {
//					shift_right(matrix, numHorizElems(matrix, i), i, NUM_COLS);
//					merge_right(matrix, i, NUM_COLS);
//				}
					
					shift_right(matrix, numHorizElems(matrix, i), i, NUM_COLS);
//					System.out.println("Matrix after shifting right: ");
//					printMatrix(matrix);
					merge_right(matrix, i, NUM_COLS);
//					System.out.println("row #" + (i+1) + " count: " + numHorizElems(matrix,i));
				}
				valid = true;
				break;
			  case 'a':
				for(int i = 0; i < 4; ++i) {
					shift_left(matrix, numHorizElems(matrix, i), i, NUM_COLS);
					merge_left(matrix, i, NUM_COLS);
				}
				valid = true;
				break;
			  case 's':
				for(int j = 0; j < 4; ++j) {
					shift_down(matrix, numVertElems(matrix, j), j, NUM_ROWS);
					merge_down(matrix, j, NUM_ROWS);
				}
				valid = true;
				break;
			  case 'w':
				for(int j = 0; j < 4; ++j) {
					shift_up(matrix, numVertElems(matrix, j), j, NUM_ROWS);
					merge_up(matrix, j, NUM_ROWS);
				}
				valid = true;
				break;
			  case 'q':
				System.out.println("Game over! Exiting now...");
				inputDevice.close();
				System.exit(1);
			  default:
				System.out.println("CTRLS: ");
				System.out.println("\'w\': up \t'");
				System.out.println("\'a\': left \t'");
				System.out.println("\'s\': down \t'");
				System.out.println("\'d\': right \t'");
				valid = false;
			} // end of switch
			
			if(valid) {
//				System.out.println("RESULTANT MATRIX: ");
//				printMatrix(matrix);
				if(is_shifted(tempMatrix, matrix, NUM_ROWS, NUM_COLS)) {	
					randGenerator(matrix);
				}
				System.out.println("NEW MATRIX: ");
				printMatrix(matrix);
				System.out.println();
			} 
			inputDevice.nextLine();
		} while(true);
	}
	
/*	int[][] setMatrix(int[][] settingMatrix, int [][] setterMatrix, int numRows, int numCols)
 *  Description: 	This function sets a temp matrix as the same as the original matrix to
 *  				see if the original matrix has changed.
 * 	- settingMatrix	: Passes in an empty temp matrix to be set as 
 *  - setterMatrix	: Passes in updated matrix
 *  - numRows		: Number of rows in matrix
 *  - numCols		: Number of columns in matrix
 *  
 *  Returns: The newly set temp matrix 
 */
	public static void setMatrix(int[][] settingMatrix, int [][] setterMatrix, int numRows, int numCols) {
		for(int i = 0; i < numRows; ++i) 
			for(int j = 0; j < numCols; ++j) 
				settingMatrix[i][j] = setterMatrix[i][j];
	}
	
/*	boolean is_shifted(int[][] ogMatrix, int[][] newMatrix, int numRows, int numCols) 
 *	Description: Checks if the variable made a valid shift
 *	
 *	- ogMatrix	: Matrix before performing shift
 *	- newMatrix : Matrix after performing shift
 *	- numRows	: Number of rows in matrix
 *	- numCols	: Number of columns in matrix
 *
 *	Returns: True if the two matrices aren't the same, false if not.
 */
	public static boolean is_shifted(int[][] ogMatrix, int[][] newMatrix, int numRows, int numCols) {
		for(int i = 0; i < numRows; ++i) 
			for(int j = 0; j < numCols; ++j) 
				if(ogMatrix[i][j] != newMatrix[i][j])
					return true;
		return false;
	}
	
/*	void printMatrix(int[][] matrix) 
 * 	Description: Prints the new matrix
 *	- matrix : Main matrix
 *
 *	Returns: N/A
 */
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
	
/* 	void randGenerator(int[][] matrix) 
 * 	Description: Spawns a 2 in a random, empty slot within the matrix
 * 	- matrix : Main matrix
 * 
 * Returns: N/A
 */
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
/*	int numHorizElems(int[][] matrix, int row) 
 * 	Description: Sees how many elements are in a specified row
 * 
 * 	matrix 	: Main matrix
 * 	row		: Row number being checked
 * 
 * 	Returns: Number of elements in row
 */
	public static int numHorizElems(int[][] matrix, int row) { // number of nonzero elements in a row
		int counter = 0;
		for(int j = 0; j < 4; ++j) 
			if(matrix[row][j] != 0)
				counter++;
		return counter;
	}
/*	int numVertElems(int[][] matrix, int col) 
 * 	Description: Sees how many elements are in a specified column
 * 
 * 	matrix 	: Main matrix
 * 	col		: Column number being checked
 * 
 * 	Returns: Number of elements in column
 */	
	public static int numVertElems(int[][] matrix, int col) {
		int counter = 0;
		for(int i = 0; i < 4; ++i) 
			if(matrix[i][col] != 0)
				counter++;
		return counter;
	}
// ===============================================================================================================================================
	
	public static void shift_right(int[][]matrix, int numElems, int rowNum, int numCols) { // shifts all nonzero elems to the right
		int shiftCounter = 0;
		int queueNum = 3;
		for(int j = numCols-1; j >= 0 ; --j) {
			if(shiftCounter == numElems)
				return;
			if(matrix[rowNum][j] != 0) {
				matrix[rowNum][queueNum] = matrix[rowNum][j];
				if(j != queueNum) {
//					System.out.println("column " + j + ": " + matrix[rowNum][j] + " set at column " + queueNum);
					matrix[rowNum][j] = 0;
				}
				--queueNum;
				++shiftCounter;
			}
		}
	}

	public static void merge_right(int[][]matrix, int rowNum, int numCols) { // merges the first match of numbers (left to right)
		for(int j = numCols-1; j >= 1; j--) {
			if(matrix[rowNum][j] == matrix[rowNum][j-1]
			&& matrix[rowNum][j] != 0 && matrix[rowNum][j-1] != 0) {
				matrix[rowNum][j] += matrix[rowNum][j-1];
				matrix[rowNum][j-1] = 0;
//				System.out.println("Matrix after first merge: ");
//				printMatrix(matrix);
				shift_right(matrix, numHorizElems(matrix, rowNum), rowNum, numCols); 
//				if(j == 3)
//					j--;
//				return;
			}
		}
	}
// ===============================================================================================================================================
	
	public static void shift_left(int[][]matrix, int numElems, int rowNum, int numCols) { // shifts all nonzero elems to the left
		int shiftCounter = 0;
		int queueNum = 0;
		for(int j = 0; j < numCols ; ++j) {
			if(shiftCounter == numElems)
				return;
			if(matrix[rowNum][j] != 0 && queueNum < numCols) {
				matrix[rowNum][queueNum] = matrix[rowNum][j];
				if(j != queueNum)
					matrix[rowNum][j] = 0;
				++queueNum; 
				++shiftCounter;
			}
		}
	}
	
	public static void merge_left(int[][]matrix, int rowNum, int numCols) { // merges the first match of numbers (right to left)
		for(int j = 0; j <= numCols-2; ++j) {
			if(matrix[rowNum][j] == matrix[rowNum][j+1]
			&& matrix[rowNum][j] != 0 && matrix[rowNum][j+1] != 0) {
				matrix[rowNum][j] += matrix[rowNum][j+1];
				matrix[rowNum][j+1] = 0;
				shift_left(matrix, numHorizElems(matrix, rowNum), rowNum, numCols);
//				if(j == 0)
//				j++;
//				return;
			}
		}
	}
// ===============================================================================================================================================
	public static void shift_down(int[][]matrix, int numElems, int colNum, int numRows) { // shifts all nonzero elems down (inside a column)  
		int shiftCounter = 0;														
		int queueNum = 3;
		for(int i = numRows-1; i >= 0 ; --i) {					
			if(shiftCounter == numElems)
				return;
			if(matrix[i][colNum] != 0) {
				matrix[queueNum][colNum] = matrix[i][colNum];
				if(i != queueNum)
					matrix[i][colNum] = 0;
				--queueNum;
			}
		}
	}
		
	public static void merge_down(int[][]matrix, int colNum, int numRows) { // merges the first match of numbers (top to bottom)
		for(int i = numRows-1; i >= 1; i--) {
			if(matrix[i][colNum] == matrix[i-1][colNum]
			&& matrix[i][colNum] != 0 && matrix[i-1][colNum] != 0) {
				matrix[i][colNum] += matrix[i-1][colNum];
				matrix[i-1][colNum] = 0;
				shift_down(matrix, numVertElems(matrix, colNum), colNum, numRows);
//				if(i == 3)
//					i--;
//				return;
			}
		}
	}
// ===============================================================================================================================================
	public static void shift_up(int[][]matrix, int numElems, int colNum, int numRows) { // shifts all nonzero elems up (inside a column)  
		int shiftCounter = 0;
		int queueNum = 0;
		for(int i = 0; i < numRows ; ++i) {
			if(shiftCounter == numElems)
				return;
			if(matrix[i][colNum] != 0) {
				matrix[queueNum][colNum] = matrix[i][colNum];
				if(i != queueNum)
					matrix[i][colNum] = 0;
				++queueNum;
				++shiftCounter;
			}
		}
	}
		
	public static void merge_up(int[][]matrix, int colNum, int numRows) { // merges the first match of numbers (bottom to top)
		for(int i = 0; i < numRows - 1; i++) {

			if(matrix[i][colNum] == matrix[i+1][colNum]
			&& matrix[i][colNum] != 0 && matrix[i+1][colNum] != 0) {
				printMatrix(matrix);
				matrix[i][colNum] += matrix[i+1][colNum];
				matrix[i+1][colNum] = 0;
//				printMatrix(matrix);
//				if(i == 0)
//					i++;
				shift_up(matrix, numVertElems(matrix, colNum), colNum, numRows);
//				return;
			}
		}
	}
}

