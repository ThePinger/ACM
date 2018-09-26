
 import java.util.Arrays;
 import java.util.Scanner;
 
 public class I 
 {
 
     static int n, d , c, a[];
     static long[][] memo;
     
     static long dp(int i, int units)
     {
         if(i == n) return 0;
         if(memo[i][units] != -1) return memo[i][units];
         
         long take = d + dp(i + 1, 0);
         long leave = (i + 1) == n ? (long) 1e12 : (1l * c * (units + 1) * (a[i + 1] - a[i])) + dp(i + 1, units + 1);
         
         return memo[i][units] = Math.min(take, leave);
     }
     
     public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);
         n=sc.nextInt();
         d=sc.nextInt();
         c=sc.nextInt();
         a=new int[n];
         for(int i=0;i<n;i++)
             a[i]=sc.nextInt();
         
         memo = new long[n][n];
         for(long[] x : memo)
             Arrays.fill(x, -1);
         
         System.out.println(dp(0, 0));
     }
 }