//Author: Breandan Considine

public class MaxValue 
{
	public static void main(String[] args)
	{
		System.out.println(max(new int[] {5, 4, 3, 2, 1}));
	}
	
	public static int max(int[] a)
	{
		for(int i = 1; i < a.length; i++)
			a[i] -= (((a[i] - a[i-1]) >> 31) & 1) * (a[i] - a[i-1]);
		
		return a[a.length-1];
	}
}
