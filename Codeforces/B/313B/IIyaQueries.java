//313B

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class IIyaQueries
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        char[] s = sc.next().toCharArray();
        int[] freq = new int[s.length];

        for(int i = 0; i < s.length - 1; i++)
            if(s[i] == s[i + 1])
                freq[i]++;

        for(int i = 1; i < s.length; i++)
            freq[i] += freq[i - 1];

        int q = sc.nextInt();

        while(q-->0)
        {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;

            if(l - 1 >= 0)
                pw.println(freq[r - 1] - freq[l - 1]);
            else
                pw.println(freq[r - 1]);
        }
        pw.flush();
        pw.close();
    }
}