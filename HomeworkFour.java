//Author: Breandan Considine

import java.util.*;

public class HomeworkFour 
{	
	public static boolean sortedHasSum(int S[], int x)
	{
		System.out.println(Arrays.toString(S));
		if(S.length == 1)
			return false;
		
		int sum = S[0] + S[S.length-1];
		
		if(sum < x)
			return sortedHasSum(Arrays.copyOfRange(S, 1, S.length), x);
		if(sum > x)
			return sortedHasSum(Arrays.copyOfRange(S, 0, S.length-1), x);
		
		return true;
	}
	
	public static boolean hasSum(int S[], int x)
	{
		HashMap<Integer, Integer> diff_map = new HashMap<Integer, Integer>(S.length*4/3);
		
		for(int i = 0; i < S.length; i++)
		{
			if(diff_map.get(x-S[i]) != null)
				return true;
			diff_map.put(S[i], i);
		}
		return false;
	}
	
	public static int[] quicksort(int S[])
	{
		Stack<Integer> idxs = new Stack<Integer>();
		
		//Push right, push left, pop left, pop right.
		//We must remember to push/pop in pairs.
		
		idxs.push(S.length-1);
		idxs.push(0);
		
		while(true)
		{	
			if(idxs.empty())
				return S;
			
			int pivot;
			
			int l_idx = idxs.pop(), r_idx = idxs.pop();
			
			if(l_idx < r_idx)
			{
				pivot = l_idx;
				S[pivot]=(S[r_idx]^=(S[pivot]^=S[r_idx]))^S[pivot];
				pivot = r_idx;
				
				int j = l_idx;
				for(int i = j; i < pivot; i++)
				{
					if(S[i] < S[pivot])
					{
						S[i] = (S[i] == S[j] ? S[i] : (S[j]^=(S[i]^=S[j]))^S[i]); //Swap
						j++;
					}
				}
				
				S[j]= (S[j] == S[pivot] ? S[j] : (S[pivot]^=(S[j]^=S[pivot]))^S[j]); //Finalize
				
				idxs.push(r_idx); //New right index
				idxs.push(j+1); //New left index
				
				idxs.push(j-1); //New right index
				idxs.push(l_idx);//New left index
			}
		}
	}
}
