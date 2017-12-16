import java.util.*;

public class B
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        boolean f = false;

        for(int x = 0 ; x <= n / a; x++)
        {
            if((n-(x*a)) % b == 0)
            {
                int y = (n-(x*a)) / b;
                int sum = (x*a) + (y*b);
                if(sum == n && y > -1)
                {
                    sb.append("YES\n");
                    sb.append(x + " " + y);
                    f = true;
                    break;
                }
            }
        }
        
        if(!f)
        {
          for(int y = 0 ; y <= n / b ; y++)
            {
                if((n-(y*b)) % a == 0)
                {
                    int x = (n-(y*b)) / a;
                    int sum = (x*a) + (y*b);
                    if(sum == n && x > -1)
                    {
                        sb.append("YES\n");
                        sb.append(x + " " + y);
                        f = true;
                        break;
                    }
                }
            }  
        }

        if(!f) sb.append("NO");
        System.out.println(sb);
    }
}