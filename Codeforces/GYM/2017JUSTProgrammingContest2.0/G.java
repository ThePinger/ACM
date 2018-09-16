
import java.util.*;

public class G 
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		System.out.println(m % n == 0 ? "YES" : "NO");
	}
}
