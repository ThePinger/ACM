//978A
//RemoveDuplicates

import java.util.*;

public class RemoveDuplicates
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] freq = new int[1001];

        for(int i = 0; i < n; i++)
        {
            arr[i] = sc.nextInt();
            freq[arr[i]]++;
        }

        Stack<Integer> st = new Stack<>();
        for(int i = n - 1; i > -1; i--)
            if(freq[arr[i]] > 0)
            {
                st.push(arr[i]);
                freq[arr[i]] = 0;
            }

        System.out.println(st.size());
        while(!st.isEmpty())
            System.out.print(st.pop() + " ");
        System.out.println();
    }
}