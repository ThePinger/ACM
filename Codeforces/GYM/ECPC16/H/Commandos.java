//Commandos
//dp

import java.io.*;
import java.util.*;

public class Commandos
{
  static int[][][] saved;
  static int[][][] hotel;
  static int t;
  static int max;
  public static int maxSaved(int f , int y , int x)
  {
    //if(index == t)
    //  return 0;
    if(x == 10 && y == 10 && f == 1)
      return saved[f][y][x] = hotel[f][y][x];
    if(saved[f][y][x] >= 0)
      return saved[f][y][x];
    int sum = 0;
    //if(hotel[f][y][x] > 0)
    //  index++;
    if(y < 10)
      sum = Math.max(hotel[f][y][x]+maxSaved(f,y+1,x) , sum);
    if(x < 10)
      sum = Math.max(hotel[f][y][x]+maxSaved(f,y,x+1) , sum);
    if(f > 1)
      sum = Math.max(hotel[f][y][x]+maxSaved(f-1,y,x) , sum);
    return saved[f][y][x] = sum;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new FileReader(new File("commandos.in")));
    int n = Integer.parseInt(br.readLine());
    for(int i = 0 ; i < n ; i++)
    {
      t = Integer.parseInt(br.readLine());
      hotel = new int[11][11][11];
      for(int j = 0 ; j < t ;  j++)
      {
        String[] s = br.readLine().split(" ");
        int f = Integer.parseInt(s[0]);
        int y = Integer.parseInt(s[1]);
        int x = Integer.parseInt(s[2]);
        int hostages = Integer.parseInt(s[3]);
        hotel[f][y][x] = hostages;
      }
      saved = new int[11][11][11];
      for(int [][] xx : saved)
        for(int [] yy : xx)
        Arrays.fill(yy,-1);
      System.out.println(maxSaved(10,1,1));
    }

  }
}
