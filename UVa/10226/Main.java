//10226
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.text.DecimalFormat;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    br.readLine();
    for(int i = 0 ; i < n ; i++)
    {
      if(i > 0)
        System.out.println("");
      TreeMap <String , Integer> tm = new TreeMap<String ,Integer>();
      String s ;
      double total = 0;
      while((s = br.readLine())!=null)
      {
        if(s.equals(""))
          break;
        if(tm.containsKey(s))
          tm.put(s , (Integer) tm.get(s) + 1);
        else
          tm.put(s , 1);
        total++;
      }
      DecimalFormat dc = new DecimalFormat("#0.0000");
      Entry<String,Integer> m ;
      while(tm.size() > 0)
      {
        m = tm.pollFirstEntry();
        System.out.println(m.getKey() + " " + dc.format((m.getValue()*100)/total));
      }
    }
  }
}
