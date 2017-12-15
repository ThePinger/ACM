//167
//Sultan Succ.
//Recursive Complete Search

import java.util.*;

public class Main
{
    static int[][] grid;
    static int[] row;
    static int max;

   
    public static boolean isValid(int column, int roww)
    {
        for(int i = 0 ; i < column ; i++)
            if(row[i] == roww || Math.abs(roww - row[i]) == Math.abs(column - i))
            return false;
        
        return true;
    }
  
    public static void getMaxScore(int i)
    {
        if(i == 8)
        {
            int tmp = 0;
            for(int j = 0 ; j < 8 ; j++)
                tmp += grid[row[j]][j];
            max = Math.max(max, tmp);
        }
    
        for(int j = 0 ; j < 8 ; j++)
            if(isValid(i,j))
            {
                row[i] = j;
                getMaxScore(i + 1);
            }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        while(n-->0)
        {
            max = 0;
            grid = new int[8][8];
            row = new int[8];
            for(int i = 0 ; i < 8 ; i++)
                for(int j = 0 ; j < 8 ; j++)
                    grid[i][j] = sc.nextInt();
           
            getMaxScore(0);
            String m = "" + max;
            switch(m.length())
            {
                case 1 : sb.append("    " + max + "\n");break;
                case 2 : sb.append("   " + max + "\n"); break;
                case 3 : sb.append("  " + max + "\n");  break;
                case 4 : sb.append(" " + max + "\n");   break;
                default: sb.append(max + "\n"); break;
            } 
        }
        System.out.print(sb);
    }
}
