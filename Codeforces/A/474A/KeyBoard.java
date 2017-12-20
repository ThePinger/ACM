//474A
//KeyBoard

import java.util.*;

public class KeyBoard
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        char direction = sc.next().charAt(0);
        String s = sc.next();
        String keyboard = "qwertyuiopasdfghjkl;zxcvbnm,./";

        for(int i = 0; i < s.length(); i++)
            if(direction == 'R')
                sb.append(keyboard.charAt(keyboard.indexOf(s.charAt(i)) - 1));
            else
                sb.append(keyboard.charAt(keyboard.indexOf(s.charAt(i)) + 1));
        
        System.out.println(sb);
    }
}