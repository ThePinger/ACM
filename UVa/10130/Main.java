//10130
//SuperSale
//DP
import java.io.*;
import java.util.ArrayList;
import java.awt.Point;
import java.util.Arrays;
public class Main
{
  static ArrayList <Point> pw;
  static int[][] memo;
  public static int maxValue(int i , int weightRem)
  {
    if(i == pw.size())
      return 0;
    if(weightRem == 0)
      return 0;
    if(memo[i][weightRem] != -1)
      return memo[i][weightRem];
    int take = 0;
    int leave = 0;
    if(weightRem - pw.get(i).y >= 0)
      take = pw.get(i).x + maxValue(i+1, weightRem - pw.get(i).y);
    leave = maxValue(i+1 , weightRem);
    return memo[i][weightRem] = Math.max(take,leave);
  }

  public static void main(String[] args)throws IOException
  {
     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
     int t = Integer.parseInt(br.readLine());
     for(int i = 0 ; i < t ; i++)
     {
       int objects = Integer.parseInt(br.readLine());
       pw = new ArrayList<Point>();
       for(int j = 0 ; j < objects ; j++)
       {
         String[] s = br.readLine().split(" ");
         int a = Integer.parseInt(s[0]);
         int b = Integer.parseInt(s[1]);
         pw.add(new Point(a,b));
       }
       memo = new int[objects][31];
       for(int[] xx : memo)
          Arrays.fill(xx,-1);
       int people = Integer.parseInt(br.readLine());
       int sum = 0 ;
       for(int c = 0 ; c < people ; c++)
         sum += maxValue(0,Integer.parseInt(br.readLine()));
       System.out.println(sum);
     }
  }
}
