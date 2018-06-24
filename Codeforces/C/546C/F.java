//Soldier and Cards
import java.util.*;

public class F 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Queue<Integer> p1 = new LinkedList<>();
		Queue<Integer> p2 = new LinkedList<>();
		
		int a = sc.nextInt();
		while(a-->0)
			p1.add(sc.nextInt());
		
		int b = sc.nextInt();
		while(b-->0)
			p2.add(sc.nextInt());
		
		int fights = 0;
		int winner = 0;
		TreeSet<String> set = new TreeSet<>();
		while(true)
		{
			a = p1.poll();
			b = p2.poll();
			if(a > b)
			{
				p1.add(b);
				p1.add(a);
			}
			else
			{
				p2.add(a);
				p2.add(b);
			}
			
			String s = p1.toString() + p2.toString();
			if(set.contains(s))
			{
				fights = -1;
				break;
			}
			
			set.add(s);
			fights++;
			
			if(p1.isEmpty())
			{
				winner = 2;
				break;
			}
			else if(p2.isEmpty())
			{
				winner = 1;
				break;
			}
		}
		
		
		System.out.println(fights > -1 ? fights + " " + winner : fights);
	}
}
