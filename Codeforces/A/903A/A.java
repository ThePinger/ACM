import java.util.*;

public class A
{

  static int[] memo;
  public static int dp(int chunks)
  {
    if(chunks == 0) return 1;
    if(chunks < 0)  return 0;
    if(memo[chunks] != -1) return memo[chunks];

    int ways = dp(chunks - 3);
    ways += dp(chunks - 7);

    return memo[chunks] = ways;
  }
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    StringBuilder sb = new StringBuilder();

    while(n-->0)
    {
      int chunks = sc.nextInt();
      memo = new int[101];
      Arrays.fill(memo, -1);
      int ways = dp(chunks);
      if(ways > 0) sb.append("YES" + "\n");
      else sb.append("NO" + "\n");
    }

    System.out.print(sb);
  }
}
