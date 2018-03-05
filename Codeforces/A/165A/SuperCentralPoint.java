//165A
//SuperCentral Point

import java.util.*;

public class SuperCentralPoint
{

    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] exists = new boolean[2001][2001];

    public static boolean isValid(int x, int y)
    {
        return x > -1 && y > -1 && x < 2001 && y < 2001;
    }

    public static boolean isSuperCentral(int x, int y)
    {
        for(int i = 0; i < 4; i++)
        {
            boolean flag = false;
            if(dx[i] == 0)
            {
                if(dy[i] == 1)
                {
                    for(int c = y + dy[i]; isValid(x, c); c++)
                        if(exists[x][c])
                        {
                            flag = true;
                            break;
                        }
                }
                else
                {
                    for(int c = y + dy[i]; isValid(x, c); c--)
                        if(exists[x][c])
                        {
                            flag = true;
                            break;
                        } 
                }
            }
            else
            {
                if(dx[i] == 1)
                {
                    for(int c = x + dx[i]; isValid(c, y); c++)
                        if(exists[c][y])
                        {
                            flag = true;
                            break;
                        }
                }
                else
                {
                    for(int c = x + dx[i]; isValid(c, y); c--)
                        if(exists[c][y])
                        {
                            flag = true;
                            break;
                        }
                }
            }
            
            if(!flag) return false;
        }
        return true;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        int n = sc.nextInt();
        Pair[] pairs = new Pair[n];

        for(int i = 0; i < n; i++)
        {
            pairs[i] = new Pair(sc.nextInt() + 1000, sc.nextInt() + 1000);
            exists[pairs[i].x][pairs[i].y] = true;
        }

        int superPoints = 0;
        for(int i = 0; i < n; i++)
        {
            if(isSuperCentral(pairs[i].x, pairs[i].y))
                superPoints++;
        }
        System.out.println(superPoints);
    }

    static class Pair
    {
        int x, y;
        Pair(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
}