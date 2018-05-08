//977C
//LessOrEqual

import java.util.*;

public class LessOrEqual
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        //int[] arr = new int[n];
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i < n; i++)
            arr.add(sc.nextInt());

        Collections.shuffle(arr);
        Collections.sort(arr);

        int zeroIDX = arr.get(0);
        if(k == n)
            System.out.println(arr.get(k - 1));
        else if(k == 0 && zeroIDX == 1)
            System.out.println(-1);
        else if(k == 0)
            System.out.println(1);
        else 
        {
            int first = arr.get(k - 1);
            int second = arr.get(k);
            if(first == second)
                System.out.println(-1);
            else
                System.out.println(first);
        }
    }
}