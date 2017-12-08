//577A
//MultiplicationTable

import java.util.*;

public class MultiplicationTable
{
  public static void main(String[] args)
  {
    Scanner sc = new Scanner(System.in);
    int size = sc.nextInt();
    int numb = sc.nextInt();
    int count = 0;

    for(int i = 1 ; i < size + 1; i++)
      if(numb % i == 0 && numb / i <= size) count++;

    System.out.println(count);
  }
}
