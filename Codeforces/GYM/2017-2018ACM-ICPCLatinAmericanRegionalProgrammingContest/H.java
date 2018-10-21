

import java.util.*;

public class H 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		int ca = sc.nextInt();
		int ba = sc.nextInt();
		int pa = sc.nextInt();
		
		int ans = Math.max(0, sc.nextInt() - ca);
		ans += Math.max(0, sc.nextInt() - ba);
		ans += Math.max(0, sc.nextInt() - pa);
		
		System.out.println(ans);
		
	}

}
