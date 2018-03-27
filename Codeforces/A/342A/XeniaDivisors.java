//342A
//Xenia and Divisors

import java.util.Scanner;

public class XeniaDivisors
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] freq = new int[8];
        for(int i = 0; i < n; i++)
            freq[sc.nextInt()]++;
        
        boolean flag = true;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n / 3; i++)
        {
            if(freq[1] == 0)
            {
                flag = false;
                break;
            }

            freq[1]--;
            sb.append(1 + " ");
            if(freq[2] == 0 && freq[3] == 0)
            {
                flag = false;
                break;
            }

            if(freq[4] == 0 && freq[6] == 0)
            {
                flag = false;
                break;
            }

            if(freq[2] != 0)
            {
                freq[2]--;
                sb.append(2 + " ");
                if(freq[4] != 0)
                {
                    sb.append(4);
                    freq[4]--;
                }
                else 
                {
                    sb.append(6);
                    freq[6]--;
                }                
            }
            else
            {
                if(freq[6] == 0)
                {
                    flag = false;
                    break;
                }

                freq[3]--;
                freq[6]--;
                sb.append(3 + " " + 6);
            }
            sb.append("\n");
        }

        if(flag) System.out.print(sb);
        else System.out.println(-1);
    }
}