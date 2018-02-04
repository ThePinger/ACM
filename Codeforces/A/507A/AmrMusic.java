//507A
//Amr and Music

import java.util.*;

public class AmrMusic
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int days = sc.nextInt();
        int[] nums = new int[n];
        ArrayList<Integer>[] numInd = new ArrayList[101];

        for(int i = 0; i < 101; i++)
            numInd[i] = new ArrayList<>();

        for(int i = 0; i < n; i++)
        {
            int x = sc.nextInt();
            numInd[x].add(i);
            nums[i] = x;
        }

        Arrays.sort(nums);

        int sum = 0;
        Queue<Integer> used = new LinkedList<>();
        for(int i = 0; i < n; i++)
        {
            if(sum + nums[i] > days) break;
            sum += nums[i];
            used.add(nums[i]);
        }

        System.out.println(used.size());
        while(!used.isEmpty())
        {
            int x = used.remove();
            System.out.print(numInd[x].get(0) + 1 + " ");
            numInd[x].remove(0);
        }
        System.out.println();   
    }
}