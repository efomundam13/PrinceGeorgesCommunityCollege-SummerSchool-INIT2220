import java.util.*;
import java.lang.*;
import java.io.*;

public class PascalTriangle{
	static int recursivePascal(int row, int col){
		int val_1 = 0; 
		int val_2 = 0; 
		int result = 0;
		if(row == 0 || col == 0 || row == col + 1) {
				return 1;
		}
		val_1 = recursivePascal(row - 1, col - 1);
		val_2 = recursivePascal(row - 1, col);
		return val_1 + val_2;
	}
	
	static void printPascalRecursion(int totalRows) {
		for(int i = 0; i <= totalRows; i++) {
			for(int j = 0; j < i; j++)
				System.out.print(recursivePascal(i, j) + " ");
				System.out.println();
		}
	}
	   
	public static void main(String[] args) throws java.lang.Exception {
		printPascalRecursion(10);
		}
	}