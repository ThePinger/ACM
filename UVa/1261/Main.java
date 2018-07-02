//1261
//String Popping

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static boolean flag;
    static TreeSet<String> set;

    public static void backtrack(String s)
    {
        if(s.length() == 0)
        {
            flag = true;
            return;
        }

        if(set.contains(s)) return;
        else set.add(s);

        int count = 1;
        for(int i = 0; i < s.length(); i += count)
        {
            count = 1;
            for(int j = i; j < s.length() - 1; j++)
                if(s.charAt(j) == s.charAt(j + 1))
                    count++;
                else break;

            if(count > 1)
            {
                StringBuilder tmp = new StringBuilder();
                for(int j = 0; j < i; j++)
                    tmp.append(s.charAt(j));
                for(int j = i + count; j < s.length(); j++)
                    tmp.append(s.charAt(j));
                backtrack(tmp.toString());
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            flag = false;
            set = new TreeSet<>();
            String s = sc.next();
            backtrack(s);
            pw.println(flag ? 1 : 0);
        }

        pw.flush();
        pw.close();
    }
}