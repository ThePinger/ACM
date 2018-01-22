//723A
//New Year Friends Meeting

import java.util.*;

public class NewYearMeeting
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int[] n = new int[3];
        n[0] = sc.nextInt();
        n[1] = sc.nextInt();
        n[2] = sc.nextInt();
        
        Arrays.sort(n);

        System.out.println(Math.abs(n[1] - n[0]) + Math.abs(n[1] - n[2]));
    }
}