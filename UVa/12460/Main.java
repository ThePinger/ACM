//12460
//CarefulTeacher

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int idx = 0;
        TreeMap<String, Integer> map = new TreeMap<>();
        while(true)
        {
            String line = sc.next();
            if(line.equals("--")) break;
            map.put(line, idx++);
        }

        while(sc.hasNext())
        {
            String line1 = sc.next();
            String line2 = sc.next();
            boolean flag = true;
            for(int i = 0; i < line1.length(); i++)
            {
                line1 = line1.replaceFirst(line1.substring(0, i + 1), line2.substring(0, i + 1));
                if(!map.containsKey(line1)) flag = false;
            }

            if(flag) pw.println("Yes");
            else pw.println("No");
        }

        pw.flush();
        pw.close();
    }
}