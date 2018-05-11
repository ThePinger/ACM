//285C
//BuildingPermutation

import java.util.*;

public class BuildingPermutation
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] isTaken = new boolean[n + 1];
        boolean[] numTaken = new boolean[n + 1];
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            arr.add(tmp);
            if(tmp > 0 && tmp <= n)
            {
                isTaken[tmp] = true;
                numTaken[tmp] = true;
            }
        }

        Collections.shuffle(arr);
        Collections.sort(arr);

        Queue<Integer> turn = new LinkedList<>();
        for(int i = 1; i < n + 1; i++)
            if(!numTaken[i])
                turn.add(i);

        if(!turn.isEmpty())
        {
            int start = turn.poll();
            long ans = 0;
            loop : for(int i = 0; i < n; i++)
            {

                int tmp = arr.get(i);
                if(tmp > 0 && tmp <= n && isTaken[tmp])
                    isTaken[tmp] = false;
                else
                {
                    ans += Math.abs(start - tmp);
                    if(turn.isEmpty()) break loop;
                    start = turn.poll();
                }
            }
            System.out.println(ans);
        }
        else System.out.println(0);
    }
}