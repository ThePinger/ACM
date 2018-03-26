//787
//Maximum Sub-sequence Product

import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        BigInteger zero = new BigInteger("0");

        while(sc.hasNext())
        {
            int c = 1;
            BigInteger max = new BigInteger("-999999");
            ArrayList<BigInteger> arr = new ArrayList<>();
            arr.add(new BigInteger("1"));
            while(true)
            {
                BigInteger tmp = new BigInteger(sc.next());
                max = max.max(tmp);
                if(tmp.equals(new BigInteger("-999999"))) break;
                BigInteger pre = arr.get(c - 1);
                if(pre.equals(zero))
                    arr.add(tmp);
                else
                    arr.add(pre.multiply(tmp));
                c++;
            }

            for(int i = 1; i < arr.size(); i++)
                for(int j = i; j < arr.size(); j++)
                {
                    BigInteger x = arr.get(j);
                    BigInteger y = arr.get(i - 1);
                    if(!y.equals(zero) && !x.equals(zero))
                        max = max.max(x.divide(y));
                    else if(y.equals(zero) && !x.equals(zero))
                        max = max.max(x);
                    else break;
                }

            pw.println(max.toString());
        }

        pw.flush();
        pw.close();
    }
}
