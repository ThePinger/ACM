//12405
//Scarecrow

import java.io.*;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        int tc = 1;
        
        while(t-->0)
        {
            int chars = Integer.parseInt(br.readLine());
            char[] field = br.readLine().toCharArray();
            int scarecrow = 0;

            for(int i = 1; i < chars; i++)
            {
                if(field[i - 1] == '#')
                {
                    if(i + 1 == chars && field[i] == '.')
                        scarecrow++;
                    else
                        continue;

                }
                else
                {
                    scarecrow++;
                    field[i - 1] = '#';
                    field[i] = '#';
                    if(i + 1 < chars) field[i + 1] = '#';
                    i++;
                }
            }

            if(chars == 1 && field[0] == '.')
                scarecrow = 1;

            sb.append("Case " + tc + ": " + scarecrow + "\n");
            tc++;
        }
        System.out.print(sb);
    }
}