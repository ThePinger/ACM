//32B
//Borze

import java.util.*;

public class Borze
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char[] code = sc.next().toCharArray();

        for(int i = 0; i < code.length; i++)
            if(code[i] == '.') 
                sb.append(0);
            else
            {
                if(code[i + 1] == '.')
                    sb.append(1);
                else
                    sb.append(2);
                i++;
            }
        System.out.println(sb);

    }
}