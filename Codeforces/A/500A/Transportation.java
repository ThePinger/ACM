//500A
//NewYear Transportation

import java.util.*;

public class Transportation
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int target = sc.nextInt();
    int[] cells = new int[n];

    for(int i = 1 ; i < n ; i++)
      cells[i] = sc.nextInt();

    boolean flag = false;
    int curCell = 1;
    while(curCell < n)
    {
      curCell += cells[curCell];
      if(curCell == target){ flag = true; break; }
    }

    if(flag) System.out.println("YES");
    else System.out.println("NO");

  }
}
