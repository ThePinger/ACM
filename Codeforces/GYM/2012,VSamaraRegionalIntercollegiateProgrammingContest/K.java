import java.io.*;
import java.util.*;

public class K 
{

	static final int INF = (int) 1e7;
	static int[][] memo;
	static ArrayList<Pair> pairs;
	
	public static int dp(int idx, int weight)
	{
		if(idx >= pairs.size()) return 0;
		if(memo[idx][weight] != -1) return memo[idx][weight];
		
		int ones = pairs.get(idx).weight + weight + dp(idx + 2, 0);
		int thrs = pairs.get(idx + 1).weight + dp(idx + 2, weight + pairs.get(idx).weight);
		
		return memo[idx][weight] = Math.min(ones, thrs);
	}
	
	
	public static void main(String[] args) throws IOException
	{
//		Scanner sc = new Scanner(System.in);
//		PrintWriter pw = new PrintWriter(System.out);
		Scanner sc = new Scanner(new FileReader("input.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));	
		
		String s = sc.next();
		
		char c = s.charAt(0);
		int count = 1;
		pairs = new ArrayList<>();
		for(int i = 1; i < s.length(); i++)
		{
			if(c == s.charAt(i))
				count++;
			else 
			{
				pairs.add(new Pair(c, count));
				c = s.charAt(i);
				count = 1;
			}
		}
		pairs.add(new Pair(c, count));
		
		if(pairs.get(0).type == '3')
			pairs.remove(0);
		if(!pairs.isEmpty() && pairs.get(pairs.size() - 1).type == '1')
			pairs.remove(pairs.size() - 1);
			
		
		memo = new int[pairs.size()][1001];
		for(int[] x : memo)
			Arrays.fill(x, -1);
		
		int ans = dp(0, 0);
		pw.println(ans);
		pw.flush();
		pw.close();
	}
	
	static class Pair
	{
		char type;
		int weight;
		
		public Pair(char type, int weight)
		{
			this.type = type;
			this.weight = weight;
		}
		
		public String toString()
		{
			return this.type + " " + this.weight;
		}
	}

}
