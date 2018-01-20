
import java.util.*;

public class A
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt(); 
            
        Arrays.sort(nums);

        for(int i = n - 1; i > -1; i--)
        {
            if(nums[i] >= 0)
            {
                int m = (int) Math.sqrt(nums[i]);
                if(m * m == nums[i])
                    continue;
                System.out.println(nums[i]);
                break;
            }
            else
            {
                System.out.println(nums[i]);
                break;
            }
        }
    }
}