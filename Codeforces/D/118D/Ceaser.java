//118D
//DP
//Ceaser Legion

import java.io.*;
import java.util.*;

public class Ceaser
{
  static int[][][][] memo;
  static int maxFoot;
  static int maxHorse;
  static int horse;
  static int foot;
  public static int dp(int footU , int horseU , int sucFoot , int sucHorse)
  {
    if(footU > foot) return 0;
    if(horseU > horse) return 0;
    if(sucFoot > maxFoot) return 0;
    if(sucHorse > maxHorse) return 0;
    if(footU == foot && horseU == horse) return 1;
    if(memo[footU][horseU][sucFoot][sucHorse] != -1)
      return memo[footU][horseU][sucFoot][sucHorse];
    int pH = 0;
    pH += dp(footU , horseU + 1 , 0, sucHorse + 1);
    pH += dp(footU + 1 , horseU , sucFoot + 1 , 0);
    return memo[footU][horseU][sucFoot][sucHorse] = pH % 100000000;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    foot = sc.nextInt();
    horse = sc.nextInt();
    maxFoot = sc.nextInt();
    maxHorse = sc.nextInt();
    memo = new int[101][101][11][11];
    for(int[][][] xx : memo)
      for(int[][] yy : xx)
        for(int[] zz : yy)
           Arrays.fill(zz , -1);
   System.out.println(dp(0,0,0,0));
  }
}
