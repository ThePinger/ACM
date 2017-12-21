//1251
//Repeated Substitution with Sed
//BruteForce

import java.util.*;
import java.io.*;

public class Main
{
    static String[] alpha, beta;
    static String newString;

    public static int getSteps(String s)
    {        
        if(s.equals(newString)) return 0;
        if(s.length() > newString.length()) return (int) 1e9;

        int ans = (int) 1e9;
        for(int i = 0; i < alpha.length; i++)
        {
            String tmp = s.replaceAll(alpha[i], beta[i]);
            if(tmp.equals(s))
                continue;
            else
                ans = Math.min(ans, 1 + getSteps(tmp));
        }
        return ans;
    }

    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        while(true)
        {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break;

            alpha = new String[n];
            beta = new String[n];
            for(int i = 0; i < n; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                alpha[i] = st.nextToken();
                beta[i]  = st.nextToken();
            }

            String original = br.readLine();
            newString = br.readLine();
            int steps = getSteps(original);
            if(steps < (int) 1e9) sb.append(steps + "\n");
            else sb.append("-1\n");
        }
        System.out.print(sb);    
    }
}