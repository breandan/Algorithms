//Author: Breandan Considine

public class FibPow 
{
	final static double phi = (1 + Math.sqrt(5))/2;
	final static double psi = (1 - Math.sqrt(5))/2;
	
	public static void main(String[] args)
	{
		long m = 1;
		m = ( 32 - m >> 9);
		
		System.out.println(m);
		//System.out.println(fibPow(4, 0, 1)[0]); // It checks out.
	}
	
	//Closed form solution for the Fibonacci sequence.
	//This should speed things up.

	public static long fib(int i)
	{
		return (long) ((Math.pow(phi, i) - Math.pow(psi, i))/(Math.sqrt(5)));
	}
	
	//1. Takes a functional power and two seed values as parameters.
	//2. Notice how the result coefficients of a and b follow a familiar pattern... curious.
	//3. A miracle happens.
	//4. Returns the result of L^n(a, b), where L(a, b) = (b, a+b). 
	
	public static long[] fibPow(int pow, int a, int b)
	{
		pow = pow < 1 ? 1 : pow;
		return new long[] {fib(pow-1)*a+fib(pow)*b,fib(pow)*a + fib(pow+1)*b};
	}
	


}
