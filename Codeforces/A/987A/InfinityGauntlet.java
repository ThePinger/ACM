//987A
//InfinityGauntlet

import java.util.*;

public class InfinityGauntlet
{
    public static void main(String[] args) 
    {
        ArrayList<String> arr = new ArrayList<>();
        arr.add("Power");
        arr.add("Time");
        arr.add("Space");
        arr.add("Soul");
        arr.add("Reality");
        arr.add("Mind");

        TreeMap<String, Integer> colorTonInt = new TreeMap<>();
        colorTonInt.put("purple", 0);
        colorTonInt.put("green", 1);
        colorTonInt.put("blue", 2);
        colorTonInt.put("orange", 3);
        colorTonInt.put("red", 4);
        colorTonInt.put("yellow", 5);

        boolean[] taken = new boolean[6];

        Scanner sc = new Scanner(System.in);

        int stones = sc.nextInt();
        System.out.println(6 - stones);
        while(stones-->0)
            taken[colorTonInt.get(sc.next())] = true;
    
        for(int i = 0; i < 6; i++)
            if(!taken[i])
                System.out.println(arr.get(i));
    }
}