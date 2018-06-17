
import java.util.*;

public class A 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		char[] a = sc.next().toCharArray();
		char[] b = sc.next().toCharArray();
		
		if(a.length != b.length)
			System.out.println("NO");
		else
		{
			int zeroesA = 0;
			int zeroesB = 0;
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] == '0') zeroesA++;
				if(b[i] == '0') zeroesB++;
			}
			
			
			if((zeroesA != a.length && zeroesB != b.length) || (zeroesA == zeroesB))
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}

}
