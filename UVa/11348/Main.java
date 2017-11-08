
import java.io.*;
import java.util.*;
import java.text.DecimalFormat;
public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    for(int i = 1 ; i <= n ; i++)
    {
      TreeMap <Integer , Integer> map = new TreeMap<>();
      boolean[] found = new boolean[10001];
      int people = Integer.parseInt(br.readLine());
      for(int j = 1 ; j <= people ; j++)
      {
        StringTokenizer st = new StringTokenizer(br.readLine());
        st.nextToken();
        while(st.hasMoreTokens())
        {
          int stamp = Integer.parseInt(st.nextToken());
          if(map.containsKey(stamp) && map.get(stamp) != j)
            map.remove(stamp);
          else if(!found[stamp])
          {
            map.put(stamp , j);
            found[stamp] = true;
          }
        }
      }

      double[] peopleStamps = new double[people + 1];
      int stamps = map.size();
      sb.append("Case "+ i +":");
      while(!map.isEmpty())
        peopleStamps[map.remove(map.firstKey())]++;

      for(int j = 1 ; j < people + 1 && stamps > 0; j++)
      {
        DecimalFormat df = new DecimalFormat("#0.000000");
        sb.append(" " + df.format((peopleStamps[j] / stamps) * 100) + "%");
      }
      sb.append("\n");
    }
    System.out.print(sb);

  }
}
