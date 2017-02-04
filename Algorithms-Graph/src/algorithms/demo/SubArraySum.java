package algorithms.demo;

import java.util.*;
import java.io.*;
import java.lang.*;

public class SubArraySum {
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the number of Testcases");
		int numOfTestcases = scan.nextInt();
		System.out.println("Number of test cases is:" + numOfTestcases);
		
		for(int i=0; i< numOfTestcases; i++) {
			//Get the array size and sum
			int size = scan.nextInt();
			int sum = scan.nextInt();
			
			System.out.println("size and sum are " + size + " " + sum);
			
			int[] array = new int[size+1];
			array[0] =0;
			for(int j=1; j<=size; j++){
				array[j] = scan.nextInt();
			}
			
			for(int j=1; j<=size; j++){
				System.out.println(array[j]);
			}
			
			int calculatedSum = 0;
			
			for (int startIndx = 1; startIndx <= size; startIndx++) {
				for (int j = startIndx; j <= size; j++) {
					calculatedSum += array[j];
					if (calculatedSum == sum) {

						System.out.println(startIndx + " " + j);
						break;
					}

				}
			}
			
			System.out.println("-1");
		}
		
		scan.close();
			
		
		
	}

}
