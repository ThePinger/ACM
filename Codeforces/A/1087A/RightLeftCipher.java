//1087A
//RightLeftCipher

import java.util.*;

public class RightLeftCipher
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        
        int i = 0;
        int j = s.length() - 1;
        boolean turn = s.length() % 2 == 0;
        StringBuilder sb = new StringBuilder();
        while(i <= j)
        {
            if(turn)
                sb.append(s.charAt(j--));
            else
                sb.append(s.charAt(i++));
            turn = !turn;
        }
        System.out.println(sb.reverse());

    }
}