//1095A
//Cipher

import java.util.*;

public class Cipher
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] line = sc.next().toCharArray();
    
        int i = 0;
        int count = 1;
        while(i < n)
        {
            System.out.print(line[i]);
            i += count;
            count++;
        }
        System.out.println();
    }
}