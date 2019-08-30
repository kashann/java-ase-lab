package eu.ase.matrix04;

public class Matrix {
	int[][] matrix;
	
	public Matrix(int[][] array){
		matrix = new int[array.length][array[0].length];
		for (int i = 0; i < array.length; i++)
	        for (int j = 0; j < array[i].length; j++)
	            matrix[i][j] = array[i][j];
	}
	
	public Matrix(int x, int y)
	{
		matrix = new int[x][y];
	    for (int i = 0; i < x; i++)
	        for (int j = 0; j < y; j++)
	            matrix[i][j] = 0;
	}
	
	public void display(){
		for (int i = 0; i < matrix.length; i++){
	        for (int j = 0; j < matrix[0].length; j++){
	        	System.out.print(matrix[i][j] + "\t");
	        }
	        System.out.println();
		}
	}
	
	public double average(){
		double avg = 0;
		for (int i = 0; i < matrix.length; i++){
	        for (int j = 0; j < matrix[0].length; j++)
	        	avg += matrix[i][j];
		}
		avg = avg / (matrix.length*matrix[0].length);
		return avg;
	}
}
