//637B
//ChatOrder

import java.io.*;
import java.util.*;

public class ChatOrder 
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        
        int n = Integer.parseInt(br.readLine());
        Stack<String> stack = new Stack<>();
        TreeSet<String> set = new TreeSet<>();

        while(n-->0)
        {
            String tmp = br.readLine();
            set.add(tmp);
            stack.push(tmp);
        }

        while(!set.isEmpty())
        {
            String tmp = stack.pop();
            if(set.contains(tmp))
            {
                set.remove(tmp);
                pw.println(tmp);
            }
        }

        pw.flush();
        pw.close();
    }
    
}