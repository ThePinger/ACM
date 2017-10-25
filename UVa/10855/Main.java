//10855
//Rotated Squares

import java.util.*;
import java.io.*;

public class Main
{
  static int sizeL ;
  static int sizeS ;
  static char[][] deg90;
  static char[][] deg180;
  static char[][] deg270;
  static char[][] big;
  static char[][] small2;
  public static void create90()
  {
    deg90 = new char[sizeS][sizeS];
     for(int i = 0 ; i < sizeS ; i++)
        for(int j = 0 ; j < sizeS ; j++)
           deg90[j][sizeS - i - 1] = small2[i][j];
  }

  public static void create180()
  {
     deg180 = new char[sizeS][sizeS];
     for(int i = 0 ; i < sizeS ; i++)
        for(int j = 0 ; j < sizeS ; j++)
           deg180[sizeS - i - 1][sizeS - j - 1] = small2[i][j];
  }

  public static void create270()
  {
     deg270 = new char[sizeS][sizeS];
     for(int i = 0 ; i < sizeS ; i++)
        for(int j = 0 ; j < sizeS ; j++)
           deg270[sizeS - j - 1][i] = small2[i][j];
  }

  public static boolean isDeg(int i , int j , int type)
  {
      char[][] temp = new char[sizeS][sizeS];
      switch(type)
      {
        case 0 : temp = small2; break;
        case 1 : temp = deg90 ; break;
        case 2 : temp = deg180; break;
        default: temp = deg270; break;
      }
      for(int ii =0 ; ii < sizeS ; ii++)
         for(int jj = 0 ; jj < sizeS ;jj++)
            if(i+ii >= sizeL || j + jj >= sizeL || temp[ii][jj] != big[i+ii][j+jj])
              return false;
      return true;
  }

  public static void main(String[] args)throws IOException
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    while(true)
    {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int large = Integer.parseInt(st.nextToken());
      int small = Integer.parseInt(st.nextToken());
      if(large == 0)
        break;
      sizeL = large;
      sizeS = small;
      big = new char[large][large];
      small2 = new char[small][small];
      for(int i = 0 ; i < large ; i++)
         big[i] = br.readLine().toCharArray();
      for(int i = 0 ; i < small ; i++)
         small2[i] = br.readLine().toCharArray();
      create90();
      create180();
      create270();
      //for(int i = 0 ;  i < sizeS ; i++)
      //   System.out.println(Arrays.toString(deg270[i]));
      int norm = 0;
      int d90  = 0;
      int d180 = 0;
      int d270 = 0;
      for(int i = 0 ; i < large ; i++)
         for(int j = 0 ; j < large ; j++)
         {
            if(big[i][j] == deg90[0][0]  && isDeg(i, j ,1))
                d90++;
            if(big[i][j] == deg180[0][0] && isDeg(i, j ,2))
                d180++;
            if(big[i][j] == deg270[0][0] && isDeg(i, j ,3))
                d270++;
            if(big[i][j] == small2[0][0] && isDeg(i, j ,0))
                norm++;
         }
      sb.append(norm + " " + d90 + " " + d180 + " " + d270 + "\n" );
    }
    System.out.print(sb.toString());
  }
}
