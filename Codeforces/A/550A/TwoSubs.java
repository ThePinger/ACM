//550A
//Two Substrings

import java.util.Scanner;

public class TwoSubs
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();


        if(s.indexOf("AB") == -1 || s.indexOf("BA") == -1)
            System.out.println("NO");
        else if(s.indexOf("BA", s.indexOf("AB") + 2) != -1 || s.indexOf("AB", s.indexOf("BA") + 2) != -1)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}