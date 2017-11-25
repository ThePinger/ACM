//102
//Ecological Bin Packing

import java.io.*;
import java.util.*;

public class Main
{

  public static char getChar(int x)
  {
    switch(x)
    {
      case 0 : return 'B';
      case 1 : return 'G';
      case 2 : return 'C';
    }

    return '_';
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(br.ready())
    {
      int[][] bins = new int[3][3];
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0 ; i < 3 ; i++)
         for(int j = 0 ; j < 3 ; j++)
            bins[i][j] = Integer.parseInt(st.nextToken());

      int minMoves = (int) 1e9;
      TreeSet <String> set = new TreeSet<>();
      for(int i = 0 ; i < 3 ; i++)
      {
         int tmpFirst = 0;
         for(int ii = 1 ; ii < 3 ; ii++)
             tmpFirst += bins[ii][i];

         for(int j = 0 ; j < 3 ; j++)
            if(i != j)
            {
              int tmpSec = 0;
              for(int jj = 0; jj < 3 ; jj++)
                 if(jj != 1)
                  tmpSec += bins[jj][j];

              for(int c = 0 ; c < 3 ; c++)
                 if(c != i && c != j)
                 {
                   int tmpThird = 0;
                   for(int cc = 0; cc < 3 ; cc++)
                      if(cc != 2)
                        tmpThird += bins[cc][c];

                   int tmp = tmpFirst + tmpSec + tmpThird;
                   if(tmp <= minMoves)
                   {
                     if(tmp < minMoves) while(!set.isEmpty()) set.pollFirst();
                     StringBuilder builder = new StringBuilder();
                     builder.append(getChar(i));
                     builder.append(getChar(j));
                     builder.append(getChar(c));
                     set.add(builder.toString());
                     minMoves = tmp;
                   }
                 }
            }
      }

      sb.append(set.pollFirst() + " " + minMoves + "\n");
    }

    System.out.print(sb);
  }
}
