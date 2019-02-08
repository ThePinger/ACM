import java.util.*;

public class E1 
{

    public static void main(String[] args) 
    {
    	Scanner sc = new Scanner(System.in);
    	
    	int n = sc.nextInt();
    	int m = sc.nextInt();
    	
    	int[] arr = new int[n];
    	for(int i = 0; i < n; i++)
    		arr[i] = sc.nextInt();
    	
    	Pair[] range = new Pair[m];
    	for(int i = 0; i < m; i++)
    		range[i] = new Pair(sc.nextInt() - 1, sc.nextInt() - 1);
    	
    	int max = Integer.MIN_VALUE;
    	int min = Integer.MAX_VALUE;
    	for(int i = 0; i < n; i++)
    	{
    		max = Math.max(max, arr[i]);
    		min = Math.min(min, arr[i]);
    	}
    	
    	int ans  = max - min;
    	int used = 0;
    	boolean[] rangeUsed = new boolean[m];
    	
    	for(int i = 0; i < n; i++)
    	{
    		max = Integer.MIN_VALUE;
    		min = Integer.MAX_VALUE;
    		int tmpAns = 0;
    		int tmpUsed = 0;
    		int[] tmpArr = arr.clone();
    		boolean[] tmpRangeUsed = new boolean[m];
    		for(int j = 0; j < m; j++)
    		{
    			if(!range[j].inRange(i))
    			{
    				tmpUsed++;
    				tmpRangeUsed[j] = true;
    				for(int c = range[j].l; c <= range[j].r; c++)
    					tmpArr[c]--;
    			}
    		}
    		
    		for(int j = 0; j < n; j++)
    		{
    			max = Math.max(max, tmpArr[j]);
    			min = Math.min(min, tmpArr[j]);
    		}
    		
    		tmpAns = max - min;
    		if(tmpAns > ans)
    		{
    			ans = tmpAns;
    			used = tmpUsed;
    			rangeUsed = tmpRangeUsed.clone();
    		}	
    	}
    	
    	System.out.println(ans);
    	System.out.println(used);
    	for(int i = 0; i < m; i++)
    		if(rangeUsed[i])
    			System.out.print((i + 1) + " ");
    }
    
    static class Pair
    {
    	int l, r;
    	
    	public Pair(int l, int r)
    	{
    		this.l = l;
    		this.r = r;
    	}
    	
    	public boolean inRange(int idx)
    	{
    		return this.l <= idx && idx <= this.r;
    	}
    }

}