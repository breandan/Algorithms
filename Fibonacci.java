//Author: Breandan Considine

import java.util.Calendar;
import java.math.*;

public class Fibonacci 
{
	public static double phi = (1 + Math.sqrt(5))/2;
	public static double psi = (1 - Math.sqrt(5))/2;
	
	public static void main(String args[])
	{
		long t;
		double d = 0, f;
		
		System.out.println(fibber(6));
		
		/*for(int i = 0; d < 5; i++)
		{
			t = Calendar.getInstance().getTimeInMillis();
			fib(i);
			d = ((double)(Calendar.getInstance().getTimeInMillis() - t))/1000;
			System.out.print("fib(" + i + ") = " + d + "\t s \t");
			
			t = Calendar.getInstance().getTimeInMillis();
			fibIt(i, 0, 1);
			f = ((double)(Calendar.getInstance().getTimeInMillis() - t))/1000;
			System.out.println("fibIt(" + i + ") = " + f + "s");
		}*/
	}
	
	//3. (Project) fib(n) appears to run slowly for n~40
	
	public static int fib(int i)
	{
		return i <= 1 ? i : fib(i-1) + fib(i-2);
	}
	
	//5. (Project) fibIt(n) does not appear to run slowly for any n whatsoever.
	
	public static long fibIt(int n, long a, long b)
	{
		return n <= 1 ? (n == 1 ? b : a) : fibIt(n-1, b, a + b);
	}
	
	public static int fibber(int i)
	{
		return (int) ((Math.pow(phi, i) - Math.pow(psi, i))/(phi-psi));
	}
	
	public static int fibPow(int pow, int a, int b)
	{
		return a+b;
	}
}
