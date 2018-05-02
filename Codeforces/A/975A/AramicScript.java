//975A

import java.util.*;

public class AramicScript
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] words = new String[n];
        for(int i = 0; i < n; i++)
            words[i] = sc.next();

        int groups = 0;
        TreeSet<String> set = new TreeSet<>();
        for(int i = 0; i < n; i++)
        {
            String s = "";
            for(int j = 0; j < 26; j++)
            {
                char c = (char) (j + 'a');
                if(words[i].contains(c + ""))
                    s += c;
            }
            set.add(s);
        }
        System.out.println(set.size());
    }
}