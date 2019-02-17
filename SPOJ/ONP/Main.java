// ONP
// Transform the Expression

import java.io.*;
import java.util.*;

public class Main 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(br.readLine());
        while(n-->0)
        {
            char[] line = br.readLine().toCharArray();
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < line.length; i++)
            {
                if(line[i] == ')')
                    pw.print(stack.pop());
                else if(line[i] >= 'a' && line[i] <= 'z')
                    pw.print(line[i]);
                else if(line[i] != '(')
                    stack.push(line[i]);
            }
            pw.println();
        }

        pw.flush();
        pw.close();
    }
}