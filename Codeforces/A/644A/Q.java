
import java.util.*;

public class Q 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		
		if(a * b < n)
			System.out.println(-1);
		else
		{
			if(b % 2 != 0)
			{
				int count = 1;
				for(int i = 0; i < a; i++)
				{
					for(int j = 0; j < b; j++)
					{
						if(count > n)
							System.out.print(0 + " ");
						else
							System.out.print(count++ + " ");
					}
					System.out.println();
				}
			}
			else
			{
				int count = 1;
				boolean turn = true;
				for(int i = 0; i < a; i++)
				{
					if(turn)
					{
						for(int j = 0; j < b; j++)
						{
							if(count > n)
								System.out.print(0 + " ");
							else
								System.out.print(count++ + " ");
						}
					}
					else
					{
						String s = "";
						for(int j = b - 1; j > -1; j--)
						{
							if(count > n)
								s = 0 + " " + s;
							else
								s = count++ + " " + s;
						}
						System.out.print(s);
					}
					turn = !turn;
					System.out.println();
				}
			}
		}
	}

}
