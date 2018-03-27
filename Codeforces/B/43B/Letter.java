//43B
//Letter

import java.util.Scanner;

public class Letter
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        int[] freq = new int[59];

        for(int i = 0; i < s.length; i++)
            if(s[i] != ' ')
                freq[s[i] - 'A']++;

        boolean flag = true;
        s = sc.nextLine().toCharArray();
        for(int i = 0; i < s.length; i++)
            if(s[i] != ' ' && freq[s[i] - 'A']-- == 0)
            {
                flag = false;
                break;
            }

        if(flag) System.out.println("YES");
        else System.out.println("NO");
    }
}