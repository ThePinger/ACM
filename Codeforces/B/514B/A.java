//Han Solo and Lazer Gun
import java.util.*;

public class A 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		
		TreeSet<Double> slopes = new TreeSet<>();
		for(int i = 0; i < n; i++)
		{
			int tmpX = sc.nextInt();
			int tmpY = sc.nextInt();
			if(tmpX == x)
				slopes.add(Double.MAX_VALUE);
			else if(tmpY == y)
				slopes.add(0.0);
			else
				slopes.add((y - tmpY) / ((x - tmpX) * 1.0));
		}
		
		System.out.println(slopes.size());
	}

}
