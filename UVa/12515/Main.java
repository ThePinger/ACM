//12515
//MoviePolice

import java.util.*;
import java.io.*;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        StringTokenizer s = new StringTokenizer(br.readLine());
        int dbSize = Integer.parseInt(s.nextToken());
        int clips  = Integer.parseInt(s.nextToken());
        String[] db = new String[dbSize];
        for(int i = 0; i < dbSize; i++)
            db[i] = br.readLine();
        
        while(clips-->0)
        {
            String clip = br.readLine();
            int minIdx = (int) 1e9;
            int minDif = (int) 1e9;
            for(int i = 0; i < dbSize; i++)
            {
                String tmp = db[i];
                if(clip.length() > tmp.length()) continue;

                for(int j = 0; j <= tmp.length() - clip.length(); j++)
                {
                    int count = 0;
                    for(int c = j, cc = 0; cc < clip.length(); c++, cc++)
                        if(clip.charAt(cc) != tmp.charAt(c)) count++;
                    
                    if(count < minDif)
                    {
                        minDif = count;
                        minIdx = i;
                    }
                }
            }
            sb.append((minIdx + 1) + "\n");
        }

        System.out.print(sb);
    }
}
