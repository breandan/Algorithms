//Breandan Considine

public class Knapsack 
{
	public static void pack(int items[], int weights[], int capacity)
	{	
		if(items.length != weights.length)
			System.err.println("Weights are mismatched.");
		
		int[][] c = new int[weights.length+1][capacity+1];
		
		for(int row = 1; row <= weights.length; row++)
			for(int col = 1; col <= capacity; col++)
				if((weights[row-1] <= col) && (c[row-1][col] < items[row-1] + c[row-1][col - weights[row-1]]))
					c[row][col] = items[row-1] + c[row-1][col - weights[row-1]];
				else
					c[row][col] = c[row-1][col];
		
		System.out.println("Optimal packing (item, weight):");
		
		for(int i = weights.length, j = capacity; i > 0; i--)
			if(c[i][j] != c[i-1][j])
				System.out.println("(" + items[i-1] + "," + (j - (j -= weights[i-1])) + ")");
	}
}