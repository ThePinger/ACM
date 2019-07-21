//152C
//PocketBook

import java.util.*;

public class PocketBook
{

    static int mod = 1000000007;

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String[] words = new String[n];
        for(int i = 0; i < n; i++)
            words[i] = sc.next();

        long ans = 1;
        for(int i = 0; i < m; i++)
        {
            TreeSet<Character> set = new TreeSet<Character>();
            for(int j = 0; j < n; j++)
                set.add(words[j].charAt(i));
            ans = (ans * set.size()) % mod;
        }

        System.out.println(ans);
    }
}