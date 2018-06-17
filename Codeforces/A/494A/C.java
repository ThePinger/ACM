
import java.util.Scanner;

public class C 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		char[] line = sc.next().toCharArray();
		int left = 0;
		int right = 0;
		int hashes = 0;
		int lastHash = 0;
		for(int i = 0; i < line.length; i++)
		{
			if(line[i] == '(') left++;
			else if(line[i] == ')') right++;
			else 
			{
				hashes++;
				lastHash = i;
			}
		}
		
		if(left - right < hashes)
			System.out.println(-1);
		else
		{
			int toBePrinted = left - right;
			int remaining   = toBePrinted;
			left = 0;
			right = 0;
			boolean flag = true;
			for(int i = 0; i < line.length; i++)
			{
				if(line[i] == '#')
				{
					if(lastHash == i)
					{
						while(remaining-->0)
							right++;
					}
					else
					{
						right++;
						remaining--;
					}
				}
				else if(line[i] == ')')
					right++;
				else
					left++;
				
				if(right > left)
					flag = false;
			}
			
			if(!flag) System.out.println(-1);
			else
			{
				while(hashes-->0)
				{
					if(hashes == 0) System.out.println(toBePrinted);
					else System.out.println(1);
					toBePrinted--;
				}
			}
		}
	}

}
