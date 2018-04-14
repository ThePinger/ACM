//254A
//Cards With Numbers

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class CardsWithNumbers
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(new File("input.txt"));
        PrintWriter pw = new PrintWriter(new File("output.txt"));
        StringBuilder sb = new StringBuilder();
        int[] lastIdx = new int[5001];
        int n = 2 * sc.nextInt();
        boolean flag = true;

        for(int i = 1; i <= n; i++)
        {
            int tmp = sc.nextInt();
            if(lastIdx[tmp] == 0)
                lastIdx[tmp] = i;
            else
            {
                sb.append(lastIdx[tmp] + " " + i + "\n");
                lastIdx[tmp] = 0;
            }
        }

        for(int i = 0; i < lastIdx.length; i++)
            if(lastIdx[i] != 0)
                flag = false;

        if(!flag) pw.println(-1);
        else pw.print(sb);

        pw.flush();
        pw.close();
    }
}