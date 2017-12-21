//599A
//Patrick and Shopping
import java.util.*;

public class ShopPath
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int pa = sc.nextInt();

        long path1 = (s1 * 2) + (s2 * 2);
        long path2 = (s1 * 2) + (pa * 2);
        long path3 = (s2 * 2) + (pa * 2);
        long path4 = s1 + s2 + pa;
        System.out.println(Math.min(Math.min(path1, path2), Math.min(path3, path4)));
    }
}