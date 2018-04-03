import java.util.Scanner;

public class C {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		if(n < 6) System.out.println(-1);
		else
		{
			for(int i = 2; i <= 4; i++)
				System.out.println(1 + " " + i);
			
			for(int i = 5; i <= n; i++)
				System.out.println(2 + " " + i);
		}
		
		for(int i = 2; i <= n; i++)
			System.out.println(1 + " " + i);
	}

}
