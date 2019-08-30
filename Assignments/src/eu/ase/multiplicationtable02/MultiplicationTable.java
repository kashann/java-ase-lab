package eu.ase.multiplicationtable02;

import java.util.Scanner;

public class MultiplicationTable {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter multiplication table size: ");
		int size = input.nextInt();
		
		System.out.print("X\t");
		for(int i = 0; i < size; i++){
			System.out.print(i+1 + "\t");
		}
		System.out.println();
		
		for(int i = 0; i < size; i++){
			System.out.print(i+1 + "\t");
			for(int j = 0; j < size; j++){
				int x = (j+1)*(i+1);
				System.out.print(x + "\t");
			}
			System.out.println();
		}
	}
}
