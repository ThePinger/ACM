//219A
//k-String

import java.util.Scanner;

public class KString
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        
        if(k == 1) System.out.println(s);
        else
        {
            int[] freq = new int[26];
            for(int i = 0; i < s.length(); i++)
                freq[s.charAt(i) - 'a']++;

            boolean flag = true;
            for(int i = 0; i < 26; i++)
                if(freq[i] % k != 0)
                    flag = false;
                else freq[i] /= k;
            
            if(!flag) System.out.println(-1);
            else
            {
                String ans = "";
                for(int j = 0; j < k; j++)
                    for(int i = 0; i < 26; i++)
                        for(int c = 0; c < freq[i]; c++)
                            ans += (char) (i + 'a');

                System.out.println(ans);
            }
        }
    }
}