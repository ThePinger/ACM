//Giga Tower
import java.util.*;

public class C 
{

	public static boolean isLucky(String s)
	{
		for(int i = 0; i < s.length(); i++)
			if(s.charAt(i) == '8')
				return true;
		return false;
	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt() + 1;
		int count = 1;
		while(!isLucky(n + ""))
		{
			n++;
			count++;
		}
		
		System.out.println(count);
	}

}
