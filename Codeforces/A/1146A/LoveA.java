//1146A
//Love A

import java.util.*;

public class LoveA
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] line = sc.next().toCharArray();
        
        int a = 0;
        for(int i = 0; i < line.length; i++)
            if(line[i] == 'a')
                a++;

        int length = line.length;
        while(a <= length / 2) length--;

        System.out.println(length);
    }
}