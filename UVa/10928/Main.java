//10928
//My Dear Neighbours

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine());
        
        while(t-->0)
        {
            int places = Integer.parseInt(br.readLine());
            ArrayList<Integer> minN = new ArrayList<>();
            int min = (int) 1e9;
            
            for(int i = 1; i < places + 1; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int tmpCount = st.countTokens();
                if(tmpCount < min)
                {
                    minN.clear();
                    minN.add(i);
                    min = tmpCount;
                }
                else if(tmpCount == min)
                    minN.add(i);
            }
                
            for(int i = 0; i < minN.size(); i++)
                if(i + 1 == minN.size())
                    pw.println(minN.get(i));
                else
                    pw.print(minN.get(i) + " ");

            if(t > 0) br.readLine();
        }

        pw.flush();
        pw.close();
    }
}