//431A
//BlackSquare

import java.util.*;

public class BlackSquare
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int one = sc.nextInt();
        int two = sc.nextInt();
        int thr = sc.nextInt();
        int fou = sc.nextInt();
        char[] arr = sc.next().toCharArray();

        long ans = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(arr[i] == '1') ans += one;
            else if(arr[i] == '2') ans += two;
            else if(arr[i] == '3') ans += thr;
            else ans += fou;
        }
        System.out.println(ans);
    }
}