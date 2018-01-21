import java.util.*;

public class D
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int f = 0;
        int min = (int) 1e9;

        for(int i = 0; i < n; i++)
        {
            if(i == 0)
            {
                min = sc.nextInt();
                if(min != sc.nextInt())
                    f = 1;
            }
            else
            {
                int b = sc.nextInt();
                int a = sc.nextInt();

                if(b != a)
                    f = 1;
                else if(b == a && b > min && f != 1)
                    f = -1;
                
                if(b < min)
                    min = b;    
            }
            
        }

        if(f == 1) System.out.println("rated");
        else if(f == 0) System.out.println("maybe");
        else System.out.println("unrated");
        
        
    }
}