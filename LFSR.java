import java.util.Arrays;


public class LFSR 
{
	public static void main(String[] args)
	{
		int[] r = {0,0,0,1,0,1};
		
		//System.out.println("0" + Arrays.toString(r));
		
		for(int i = 0; i < 40; i++)
		{
			int t = r[0];
			
			r[0] = (r[2] + r[4]) % 2;
			
			r[5] = r[4];
			r[4] = r[3];
			r[3] = r[2];
			r[2] = r[1];
			r[1] = t;
						
			System.out.print(r[0]);
		}
	}
}
