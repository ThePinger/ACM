//12482
//Short Story Competition

import java.io.*;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        
        while(br.ready())
        {
            String[] s = br.readLine().split(" ");
            int words  = Integer.parseInt(s[0]);
            int lines  = Integer.parseInt(s[1]);
            int chars  = Integer.parseInt(s[2]);
            s = br.readLine().split(" ");

            int curPage = 0;
            int curChar = 0;
            int pages   = 0;
            for(int i = 0; i < s.length; i++)
            {
                if(curChar + s[i].length() == chars)
                {
                    curPage++;
                    curChar = 0;
                }
                else if(curChar + s[i].length() > chars)
                {
                    if(s[i].length() == chars)
                        curChar = s[i].length();
                    else
                        curChar = s[i].length() + 1;
                    
                    curPage++;
                }
                else
                    curChar += s[i].length() + 1;

                if(curPage == lines)
                {
                    pages++;
                    curPage = 0;
                }
            }

            if(curChar > 0 || curPage > 0)
                pages++;
            
            sb.append(pages + "\n");
        }
        System.out.print(sb);
    }
}