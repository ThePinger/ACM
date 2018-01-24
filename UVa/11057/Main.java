//11057
//Exact Sum

import java.util.Arrays;
import java.util.StringTokenizer;
import java.awt.Point;
import java.util.Scanner;
import java.io.*;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        while(sc.hasNext())
        {
            int n = sc.nextInt();
            int[] books = new int[n];
            for(int i = 0; i < n; i++)
                books[i] = sc.nextInt();

            Arrays.sort(books);

            int money = sc.nextInt();
            Point ans = new Point(-1, -1);
            for(int i = 0; i < n; i++)
            {
                int lo = 0;
                int hi = n - 1;
                while(lo <= hi)
                {
                    int mid = (lo + hi) / 2;
                    if(books[i] + books[mid] == money && i != mid)
                    {
                        if(ans.x == - 1 || (Math.abs(books[i] - books[mid]) < Math.abs(ans.x - ans.y)))
                        {
                            ans.x = books[i];
                            ans.y = books[mid];
                        }
                        hi = mid - 1;
                    }
                    else if(books[i] + books[mid] > money)
                        hi = mid - 1;
                    else
                        lo = mid + 1;
                }
            }
            pw.println("Peter should buy books whose prices are " + Math.min(ans.x, ans.y) + " and " + Math.max(ans.x, ans.y) + ".");
            pw.println();
        }
        pw.flush();
        pw.close();
    }
}