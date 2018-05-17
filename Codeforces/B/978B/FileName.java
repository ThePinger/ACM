//978B
//FileName

import java.util.Scanner;

public class FileName
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] arr = sc.next().toCharArray();
        
        int cons = 0;
        int remove = 0;
        for(int i = 0; i < n; i++)
        {
            if(arr[i] == 'x' && cons < 2)
                cons++;
            else if(arr[i] == 'x')
                remove++;
            else 
                cons = 0;
        }

        System.out.println(remove);
    }
}