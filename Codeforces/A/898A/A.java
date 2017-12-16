
import java.util.*;

public class A
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int removelast = 0;
        String tmpS = n + "";
        if(tmpS.length() > 1)
            removelast = Integer.parseInt(tmpS.substring(0,tmpS.length() - 1));
        
        char[] tmp = tmpS.toCharArray();
        if(Character.getNumericValue(tmp[tmp.length - 1]) < 6)
        {
            tmp[tmp.length - 1] = '0';
            String s = new String(tmp);
            sb.append(s);
        }
        else if(tmp[tmp.length - 1] == '9') sb.append(n + 1);
        else if(Character.getNumericValue(tmp[tmp.length - 1]) > 5 && tmp.length > 1) 
        {
            removelast++;
            String s = removelast + "0";
            sb.append(s);
        }
        else sb.append(10);

        System.out.println(sb);
    }
}