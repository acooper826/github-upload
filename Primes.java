/* Adrienne Cooper
 * CS 3345.004
 * AKC180007 
 * 
 * 
 * Project 1
 * This project is an implementation of the Sieve of Eratosthenes algorithm 
 * which outputs all prime numbers less than or equal to the specified value. 
 * 
 */

import java.util.Arrays;
import java.util.Scanner;

public class Primes 
{
	public static void main(String[] args)
	{
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a positive integer value.");
		
		// assume user enters integer
		int N = input.nextInt();
		while(N < 1)
		{
			System.out.println("Please enter a valid number.");
			N = input.nextInt();
		}
		
		primes(N);
		input.close();
	}
	
	public static void primes(int N)
	{
		//boolean array of 2 to N
		boolean[] A = new boolean[N+1];
		//set all values to true
		Arrays.fill(A, true);
		//from 2 while i is less than sqrt of N ( i <= sqrtN  => i^2 <= sqrtN^2)
		for(int i = 2; i * i <= N; i++)
		{
			if(A[i])
			{
				//for j = i^2, i^2+i, i^2+2i, i^2+3i... false
				for(int j = (i * i); j <=  N ; j += i)
				{
					A[j] = false;
				}
			}
		}
		//starting at 2 output prime numbers 
		for(int x = 2; x <= N; x++)
			if(A[x])
				System.out.println(x);
	}
}
