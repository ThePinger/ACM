
import java.util.*;

public class D 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int s = sc.nextInt();
		TreeMap<Integer, Integer> buy = new TreeMap<>();
		TreeMap<Integer, Integer> sell = new TreeMap<>();
		for(int i = 0; i < n; i++)
		{
			String line = sc.next();
			int p = sc.nextInt();
			int v = sc.nextInt();
			if(line.equals("B"))
			{
				if(buy.containsKey(p))
					buy.put(p, buy.get(p) + v);
				else
					buy.put(p, v);
			}
			else
			{
				if(sell.containsKey(p))
					sell.put(p, sell.get(p) + v);
				else
					sell.put(p, v);
			}
		}
		
		TreeMap<Integer, Integer> sellFinal = new TreeMap<>();
		for(int i = 0; i < s && !sell.isEmpty(); i++)
		{
			int k = sell.firstKey();
			sellFinal.put(k, sell.get(k));
			sell.pollFirstEntry();
		}
		
		while(!sellFinal.isEmpty())
		{
			int k = sellFinal.lastKey();
			System.out.println("S " + k + " " + sellFinal.get(k));
			sellFinal.pollLastEntry();
		}
		
		for(int i = 0; i < s && !buy.isEmpty(); i++)
		{
			int k = buy.lastKey();
			System.out.println("B " + k + " " + buy.get(k));
			buy.pollLastEntry();
		}
			
	}	

}
