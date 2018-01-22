//556A
//Case of Zeros and Ones

import java.util.*;

public class CaseOfZerosOnes
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] bin = sc.next().toCharArray();
        int ones  = 0;
        int zeros = 0;
        
        for(int i = 0; i < n; i++)
            if(bin[i] == '1')
                ones++;
            else
                zeros++;
        
        System.out.println(n - (2 * Math.min(ones, zeros)));
    }
}