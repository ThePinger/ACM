//276B
//Little Girl and Game

import java.util.Scanner;

public class LittleGirlGame
{

    public static boolean isPalindrome(int[] freq)
    {
        int odd = 0;
        for(int i = 0; i < 26; i++)
            if(freq[i] % 2 != 0)
                odd++;
        
        return odd < 2 ? true : false;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] sss = sc.next().toCharArray();
        int[] freq = new int[26];

        for(int i = 0; i < sss.length; i++)
            freq[sss[i] - 'a']++;
        
        boolean turn = true;
        for(int i = 0; i < sss.length; i++)
        {
            if(isPalindrome(freq)) break;
            else
            {
                boolean flag = false;
                for(int j = 0; j < 26; j++)
                    if(freq[j] % 2 == 0 && freq[j] != 0)
                    {
                        freq[j]--;
                        flag = true;
                        break;
                    }

                if(!flag)
                {
                    for(int j = 0; j < 26; j++)
                        if(freq[j] % 2 != 0)
                        {
                            freq[j]--;
                            break;
                        }
                }
            }

            turn = !turn;
        }

        if(turn) System.out.println("First");
        else System.out.println("Second");
    }
}