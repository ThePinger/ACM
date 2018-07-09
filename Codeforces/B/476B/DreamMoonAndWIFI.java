//476B
//DreamMoonAndWIFI

import java.util.*;

public class DreamMoonAndWIFI
{

    static int correct, count;
    static char[] received;

    public static int backtrack(int idx, int cnt)
    {
        if(idx == received.length)
        {
            count++;
            if(cnt == correct) 
                return 1;
            return 0;
        }

        int ans = 0;
        if(received[idx] == '+') 
            return backtrack(idx + 1, cnt + 1);
        if(received[idx] == '-')
            return backtrack(idx + 1, cnt - 1);
        return backtrack(idx + 1, cnt + 1) + backtrack(idx + 1, cnt - 1);
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        char[] original = sc.next().toCharArray();    
        received = sc.next().toCharArray();
        correct = 0;
        for(int i = 0; i < original.length; i++)
            if(original[i] == '+') correct++;
            else correct--;

        System.out.println(backtrack(0, 0) / (count * 1.0));
    }
}