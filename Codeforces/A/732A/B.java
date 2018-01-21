import java.util.*;

public class B
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        int min = 0;
        
        for(int i = 1; ; i++)
        {
            int poss = n * i;
            while(poss > 0)
            {
                if(poss - 10 >= 0)
                    poss -= 10;
                else if(poss - r == 0)
                    poss -= r;
                else
                    break;
            }

            if(poss == 0)
            {
                min = i;                
                break;
            }
        }
        System.out.println(min);
    }
}