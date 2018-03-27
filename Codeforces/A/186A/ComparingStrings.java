//186A
//Comparing Strings

import java.util.Scanner;

public class ComparingStrings
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] s1 = sc.next().toCharArray();
        char[] s2 = sc.next().toCharArray();
        
        if(s1.length != s2.length)
            System.out.println("NO");
        else
        {
            boolean flag = false;
            for(int i = 0; i < s1.length - 1; i++)
            {
                if(s1[i] != s2[i])
                {
                    int idx = -1;
                    for(int j = 0; j < s1.length; j++)
                        if(s1[j] == s2[i] && s1[j] != s2[j])
                        {
                            idx = j;
                            break;
                        }
                    
                    if(idx != -1)
                    {
                        char[] tmpS = s1;
                        char tmp = tmpS[i];
                        tmpS[i] = tmpS[idx];
                        tmpS[idx] = tmp;
                        
                        String ss1 = new String(tmpS);
                        String ss2 = new String(s2);

                        if(ss1.equals(ss2))
                        {
                            flag = true;
                            break;
                        }
                        else break;
                    }
                    else break;
                }
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}