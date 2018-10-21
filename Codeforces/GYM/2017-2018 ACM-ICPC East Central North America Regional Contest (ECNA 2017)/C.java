import java.util.Scanner;

public class C 
{
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		char[] s = sc.next().toCharArray();
		
		int sumHalf1 = 0;
		int sumHalf2 = 0;
		
		for(int i = 0; i < s.length / 2; i++)
			sumHalf1 += (s[i] - 'A');
			
		for(int i = s.length / 2; i < s.length; i++)
			sumHalf2 += (s[i] - 'A');
		
		for(int i = 0; i < s.length / 2; i++)
			s[i] = (char) (((s[i] - 'A') + sumHalf1 % 26) + 'A');
		
		for(int i = s.length / 2; i < s.length; i++)
			s[i] = (char) (((s[i] - 'A') + sumHalf2 % 26) + 'A');
		
		String ans = "";
		for(int i = 0; i < s.length / 2; i++)
			ans += (char) ((((s[i] - 'A') + (s[i + s.length / 2] - 'A')) % 26) + 'A');
		
		System.out.println(ans);
 	}
}
