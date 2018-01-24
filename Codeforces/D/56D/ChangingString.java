//56D
//Changing a String

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class ChangingString
{
    static int oo = (int) 1e9;
    static char[] s, t;
    static int[][] memo;
    static PrintWriter pw = new PrintWriter(System.out);

    public static void printSol(int idxS, int idxT)
    {
        if(idxS == s.length && idxT == t.length)
            return;


        int ins = oo;
        int del = oo;
        int rep = oo;
        int lev = oo;

        if(idxS < s.length && idxT < t.length)
        {
            if(s[idxS] == t[idxT])
                lev = dp(idxS + 1, idxT + 1);
            else
            {
                ins = 1 + dp(idxS, idxT + 1);
                del = 1 + dp(idxS + 1, idxT);
                rep = 1 + dp(idxS + 1, idxT + 1);
            }
        }
        else if(idxS < s.length)
            del = 1 + dp(idxS + 1, idxT);
        else
            ins = 1 + dp(idxS, idxT + 1);

        if(memo[idxS][idxT] == lev)
            printSol(idxS + 1, idxT + 1);
        else if(memo[idxS][idxT] == ins)
        {
            pw.println("INSERT " + (idxT  + 1) + " " + t[idxT]);
            printSol(idxS, idxT + 1);
        }
        else if(memo[idxS][idxT] == del)
        {
            pw.println("DELETE " +  (idxT + 1));
            printSol(idxS + 1, idxT);
        }
        else
        {
            pw.println("REPLACE " + (idxT + 1) + " " + t[idxT]);
            printSol(idxS + 1, idxT + 1);
        }
    }

    public static int dp(int idxS, int idxT)
    {
        if(idxS == s.length && idxT == t.length)
            return 0;

        if(memo[idxS][idxT] != -1)
            return memo[idxS][idxT];

        int ins = oo;
        int del = oo;
        int rep = oo;
        int lev = oo;

        if(idxS < s.length && idxT < t.length)
        {
            if(s[idxS] == t[idxT])
                lev = dp(idxS + 1, idxT + 1);
            else
            {
                ins = 1 + dp(idxS, idxT + 1);
                del = 1 + dp(idxS + 1, idxT);
                rep = 1 + dp(idxS + 1, idxT + 1);
            }
        }
        else if(idxS < s.length)
            del = 1 + dp(idxS + 1, idxT);
        else
            ins = 1 + dp(idxS, idxT + 1);
            
        return memo[idxS][idxT] = Math.min(Math.min(ins, del), Math.min(rep, lev));
    }

    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        s = sc.next().toCharArray();
        t = sc.next().toCharArray();
        memo = new int[s.length + 1][t.length + 1];
        
        for(int[] ii : memo)
            Arrays.fill(ii, -1);

        pw.println(dp(0,0));
        printSol(0, 0);
        pw.flush();
        pw.close();
    }
}