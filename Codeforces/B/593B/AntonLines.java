//593B
//AntonLines

import java.util.*;

public class AntonLines
{

    static final double EPS = 1e-9;

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double x1 = sc.nextInt() + EPS;
        double x2 = sc.nextInt() - EPS;

        Pair[] yOne = new Pair[n];
        Pair[] yTwo = new Pair[n];
        for(int i = 0; i < n; i++)
        {
            int m = sc.nextInt();
            int c = sc.nextInt();
            yOne[i] = new Pair(i, (x1 * m) + c);
            yTwo[i] = new Pair(i, (x2 * m) + c);
        }

        Arrays.sort(yOne);
        Arrays.sort(yTwo);

        boolean inter = false;
        for(int i = 0; i < n; i++)
            if(yOne[i].n != yTwo[i].n)
                inter = true;

        if(inter) System.out.println("YES");
        else System.out.println("NO");
    }

    static class Pair implements Comparable<Pair>
    {
        int n;
        double y;

        public Pair(int n, double y)
        {
            this.n = n;
            this.y = y;
        }

        public int compareTo(Pair p)
        {
            return Double.compare(this.y, p.y);
        }

        public String toString()
        {
            return this.n + " " + this.y;
        }
    }
}