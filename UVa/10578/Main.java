//10578
//The Game of 31

import java.io.*;
import java.util.*;

public class Main
{

    static int n;
    static Boolean[][][][][][][] memo;

    public static boolean dp(int a, int one, int two, int thr, int four, int fiv, int six)
    {
        if(memo[a][one][two][thr][four][fiv][six] != null)
            return memo[a][one][two][thr][four][fiv][six];

        boolean result = false;
        if(one > 0 && a + 1 < 32)
            result |= !dp(a + 1, one - 1, two, thr, four, fiv, six);
        if(two > 0 && a + 2 < 32)
            result |= !dp(a + 2, one, two - 1, thr, four, fiv, six);
        if(thr > 0 && a + 3 < 32)
            result |= !dp(a + 3, one, two, thr - 1, four, fiv, six);
        if(four > 0 && a + 4 < 32)
            result |= !dp(a + 4, one, two, thr, four - 1, fiv, six);
        if(fiv > 0 && a + 5 < 32)
            result |= !dp(a + 5, one, two, thr, four, fiv - 1, six);
        if(six > 0 && a + 6 < 32)
            result |= !dp(a + 6, one, two, thr, four, fiv, six - 1);

        return memo[a][one][two][thr][four][fiv][six] = result;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        while(br.ready())
        {
            String s = br.readLine();

            int[] cards = new int[7];
            Arrays.fill(cards, 4);
            
            int a = 0;
            boolean last = false;
            for(int i = 0; i < s.length(); i++)
            {
                cards[Character.getNumericValue(s.charAt(i))]--;
                a += Character.getNumericValue(s.charAt(i));
                if(a < 32) last = !last;
            }

            memo = new Boolean[32][5][5][5][5][5][5];
            if(a < 31)
            {
                boolean result = dp(a, cards[1], cards[2], cards[3], cards[4], cards[5], cards[6]);
                if(last) pw.println(s + " " + (result ? "B" : "A"));
                else pw.println(s + " " + (result ? "A" : "B"));
            }
            else pw.println(s + " " + (last ? "A" : "B"));
        }

        pw.flush();
        pw.close();
    }
}