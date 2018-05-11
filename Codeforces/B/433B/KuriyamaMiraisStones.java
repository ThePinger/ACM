//433B
//Kuriyama Mirai's Stones

import java.util.*;

public class KuriyamaMiraisStones
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Long> normal = new ArrayList<>();
        ArrayList<Long> sorted = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            normal.add(tmp * 1l);
            sorted.add(tmp * 1l);
        }

        Collections.shuffle(sorted);
        Collections.sort(sorted);

        for(int i = 1; i < n; i++)
        {
            normal.set(i, normal.get(i) + normal.get(i - 1));
            sorted.set(i, sorted.get(i) + sorted.get(i - 1));
        }

        int queries = sc.nextInt();
        while(queries-->0)
        {
            if(sc.nextInt() == 1)
            {
                int start = sc.nextInt() - 1;
                int end = sc.nextInt() - 1;
                if(start != 0)
                    System.out.println(normal.get(end) - normal.get(start - 1));
                else
                    System.out.println(normal.get(end));
            }
            else
            {
                int start = sc.nextInt() - 1;
                int end = sc.nextInt() - 1;
                if(start != 0)
                    System.out.println(sorted.get(end) - sorted.get(start - 1));
                else
                    System.out.println(sorted.get(end));
            }
        }
    }
}