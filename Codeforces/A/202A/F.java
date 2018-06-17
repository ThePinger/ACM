
import java.util.*;

public class F 
{

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		char[] line = sc.next().toCharArray();
		int[] count = new int[26];
		
		for(int i = 0; i < line.length; i++)
			count[line[i] - 'a']++;
		
		char used = '-';
		for(int i = 25; i > -1; i--)
			if(count[i] > 0)
			{
				used = (char) (i + 'a');
				break;
			}
		
		for(int i = 0; i < count[used - 'a']; i++)
			System.out.print(used);
		System.out.println();
	}

}
