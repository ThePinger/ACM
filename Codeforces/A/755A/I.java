//PolandBall and Hypothesis
import java.util.*;

public class I 
{
	
	public static boolean isPrime(int m)
	{
		for(int i = m - 1; i > 1; i--)
			if(m % i == 0)
				return false;
		return true;
	}

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i = 1; i < 1001; i++)
		{
			if(!isPrime((n * i) + 1))
			{
				System.out.println(i);
				return;
			}
		}
	}

}
