//11201
//The problem of the crazy linguist
//BruteForce

import java.util.*;
import java.io.*;

public class Main 
{
   
    static int words;
    static double wordsSum;
    static String s;
    static String odd = "bcdfghjklmnpqrstvwxyz";
    static String even = "aeiou";
    static int[] count;
    static double[] probability = {12.53, 1.42, 4.68, 5.86, 13.68, 0.69, 1.01, 0.70, 6.25, 0.44, 0.00, 4.97, 3.15,
                                    6.71, 8.68, 2.51, 0.88, 6.87 , 7.98, 4.63, 3.93, 0.90, 0.02, 0.22, 0.90, 0.52};

    public static void wordsCombination(int i, String cur, double ans)
    {
        if(i == s.length() + 1){ words++; wordsSum += ans; return;}
        if(i % 2 == 0)
        {
            for(int j = 0; j < even.length(); j++)
                if(count[even.charAt(j) - 97] < 2)
                {
                    count[even.charAt(j) - 97]++;
                    wordsCombination(i + 1, cur + even.charAt(j), ans + (probability[even.charAt(j) - 97] * i));
                    count[even.charAt(j) - 97]--;
                }
        }
        else
        {
            for(int j = 0; j < odd.length(); j++)
                if(count[odd.charAt(j) - 97] < 2)
                {
                    count[odd.charAt(j) - 97]++;
                    wordsCombination(i + 1, cur + odd.charAt(j), ans + (probability[odd.charAt(j) - 97] * i));
                    count[odd.charAt(j) - 97]--;
                }
        }
    }
    
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n-->0)
        {
            words = 0;
            wordsSum = 0;
            count = new int[26];
            s = br.readLine();
            wordsCombination(2, s.charAt(0) + "", probability[s.charAt(0) - 97]); 
            double avg = wordsSum / words;
            double inputSBC = 0;
            for(int i = 0; i < s.length(); i++)
                inputSBC += (probability[s.charAt(i) - 97] * (i + 1));

            if(inputSBC < avg) sb.append("below\n");
            else sb.append("above or equal\n");
        } 
        System.out.print(sb);   
    }
}