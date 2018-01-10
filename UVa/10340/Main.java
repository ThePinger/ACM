//10340
//All in All

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
            String original = s[0];
            String modified = s[1];
            if(original.length() > modified.length())
                sb.append("No\n");
            else
            {
                int j = 0;
                for(int i = 0; i < modified.length(); i++)
                {
                    if(modified.charAt(i) == original.charAt(j))
                        j++;
                    if(j == original.length())
                        break;
                }
                if(j == original.length())
                    sb.append("Yes\n");
                else
                    sb.append("No\n");
            }
        }
        System.out.print(sb);
    }
}