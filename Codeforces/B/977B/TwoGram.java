//977B
//TwoGram

import java.util.Scanner;
import java.util.TreeMap;

public class TwoGram
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        TreeMap<String, Integer> map = new TreeMap<>();
        
        int max = 0;
        String maxx = "";
        for(int i = 0; i < n - 1; i++)
        {
            String tmp = s.charAt(i) + "" + s.charAt(i + 1);
            if(map.containsKey(tmp))
                map.put(tmp, map.get(tmp) + 1);
            else 
                map.put(tmp, 1);

            if(map.get(tmp) > max)
            {
                max = map.get(tmp);
                maxx = tmp;
            }
        }

        System.out.println(maxx);
    }
}