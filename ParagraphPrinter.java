import java.util.Arrays;

//Author: Breandan Considine
//Adapted from pseudo-code available in CLRS, Selected Solutions.

public class ParagraphPrinter 
{
	public static void main(String args[])
	{
		String s = "Which is a more efficient way to determine the optimal number of multiplications" +
				" in a matrix-chain multiplication problem: enumerating all the ways of parenthesizing " +
				"the product and computing the number of multiplications for each, or running? Justify your answer.";
		//System.out.println(Arrays.toString(s.split("\\s+")));
		
		printParagraph(s.split("\\s+"), 40);
	}
	
	
	public static void printParagraph(String[] S, int M)
	{
		int n = S.length;
		int[][] extras  = new int[n][n];
		int[][] lc = new int[n][n];
		int[] c = new int[n+1];
		
		for(int i = 0; i < n; i++)
		{
			extras[i][i] = M - S[i-1].length();
			for(int j = i + 1; j < n; j++)
				extras[i][j] = extras[i][j-1] - S[j-1].length() - 1;
		}
		
		for(int i = 1; i < n; i++)
			for(int j = i; j < n; j++)
				if(extras[i][j] < 0)
					lc[i][j] = Integer.MAX_VALUE;
				else if((j == n) && (extras[i][j] >= 0))
					lc[i][j] = 0;
				else
					lc[i][j] = (int)Math.pow(extras[i][j], 3);
		
		c[0] = 0;
		int[] p = new int[n+1];
		
		for(int j = 1; j < n; j++)
		{
			c[j] = Integer.MAX_VALUE;
			for(int i = 1; i <= j; i++)
				if(c[i-1] + lc[i-1][j-1] < c[j])
				{
					c[j] = c[i-1] + lc[i-1][j-1];
					p[j] = i;
				}
		}
		
		giveLines(p, n);
	}
	
	public static int giveLines(int[] p, int j)
	{
		int k;
		int i = p[j];
		if(i == 1)
			k = 1;
		else
			k = giveLines(p, i-1) + 1;
		
		System.out.println("Line " + k + " contains words " + i + " through " + j);
		
		return k;
	}
}
