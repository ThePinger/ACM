
import java.util.*;

public class B
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        int[] freq = new int[100001];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int max = 0;

        for(int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
            freq[nums[i]]++;
            if(pq.isEmpty() || freq[nums[i]] == 1)
                pq.add(nums[i]); 
            max = Math.max(max, nums[i]);
        }


        if(freq[max] % 2 != 0)
            System.out.println("Conan");
        else
        {
            while(!pq.isEmpty())
                if(freq[pq.poll()] % 2 != 0)
                {
                    System.out.println("Conan");
                    return;
                }
            System.out.println("Agasa");
        }
        
    }
}