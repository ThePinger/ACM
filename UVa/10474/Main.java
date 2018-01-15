//10474
//Where is the Marble
//Binary Search

import java.util.*;
import java.io.*;

public class Main 
{
    public static void main(String[] args)throws IOException 
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder  sb = new StringBuilder();
        int t = 1;

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int numbers = Integer.parseInt(st.nextToken());
            int queries = Integer.parseInt(st.nextToken());
            if(numbers == 0) break;
            ArrayList<Integer> nums = new ArrayList<>();

            while(numbers-->0)
                nums.add(Integer.parseInt(br.readLine()));
            
            Collections.sort(nums);
            sb.append("CASE# " + t++ + ":\n");            
            while(queries-->0)
            {
                int n = Integer.parseInt(br.readLine());
                int lo = 0;
                int hi = nums.size() - 1;
                int ans = -1;

                while(lo <= hi)
                {
                    int mid = (lo + hi) / 2;
                    if(nums.get(mid) < n)
                        lo = mid;
                    else if(nums.get(mid) == n)
                    {
                        ans = mid;
                        hi = mid;
                    }
                    else
                        hi = mid; 

                    if(hi - lo  == 1)
                    {
                        if(nums.get(lo) == n)
                            ans = lo;
                        else if(nums.get(hi) == n)
                            ans = hi;
                        break;
                    }
                }
                
                if(ans > -1)
                    sb.append(n + " found at " + (ans + 1) + "\n");
                else
                    sb.append(n + " not found\n");

            }
        }
        System.out.print(sb);
    }
}