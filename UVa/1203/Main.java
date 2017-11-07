//1203
//Argus

import java.io.*;
import java.util.*;

public class Main
{
  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    PriorityQueue <Pair> pq = new PriorityQueue<>();
    TreeMap <Integer,Integer> map = new TreeMap<>();
    while(true)
    {
      String[] line = br.readLine().split(" ");
      if(line.length == 1) break;
      int id = Integer.parseInt(line[1]);
      int period = Integer.parseInt(line[2]);
      map.put(id , period);
      pq.add(new Pair(id , period));
    }

    int loops = Integer.parseInt(br.readLine());
    while(loops-->0)
    {
      Pair tmp = pq.remove();
      sb.append(tmp.id + "\n");
      tmp.period = tmp.period + map.get(tmp.id);
      pq.add(tmp);
    }
    System.out.print(sb);
  }

  static class Pair implements Comparable<Pair>
  {
    int id;
    int period;
    Pair(int i , int per)
    {
      id = i;
      period = per;
    }

    public int compareTo(Pair x)
    {
      if(period != x.period)
			  return period - x.period;
		  return id - x.id;
    }
  }
}
