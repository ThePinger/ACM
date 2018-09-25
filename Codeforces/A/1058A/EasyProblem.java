//1058A
//In Search of an Easy Problem

import java.util.*;

public class EasyProblem
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean flag = true;
        
        while(n-->0)
            if(sc.nextInt() == 1)
                flag = false;

        System.out.println(flag ? "EASY" : "HARD");
    }
}