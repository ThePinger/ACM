//462B
//ApplemanAndCardGame

import java.util.Arrays;
import java.util.Scanner;

public class ApplemanAndCardGame
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int cards = sc.nextInt();
        long k = sc.nextLong();
        String letters = sc.next();
        
        long[] freq = new long[26];
        for(int i = 0; i < letters.length(); i++)
            freq[letters.charAt(i) - 'A']++;

        Arrays.sort(freq);

        long sum = 0;
        for(int i = 25; i > -1; i--)
            if(k <= freq[i])
            {
                sum += k * k * 1l;
                break;
            }
            else
            {
                sum += freq[i] * freq[i] * 1l;
                k -= freq[i];
            }

        System.out.println(sum);
    }
}