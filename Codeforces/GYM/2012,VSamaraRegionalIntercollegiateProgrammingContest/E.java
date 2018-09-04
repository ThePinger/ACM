import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;
public class E {
    
    static Pair dp(int idx, long msk,Pair p)
    {
//      if(p.c>0)
//      {
//          System.out.println(p.c+" "+Long.toBinaryString(p.s));
//      }
        if(idx==n)
        {
            if(Long.bitCount(msk) == m)
            {
//              System.out.println(Long.toBinaryString(p.s));
                return p;
            }
            return new Pair((int)1e9, 0);
        }
        
        long t1 = msk;
        long t2 = msk | a[idx];
        
//      Pair p1=dp(idx+1,t1,new Pair(p.c, new StringBuilder(p.s.toString())));
//      Pair p2=dp(idx+1,t2,new Pair(p.c+1, new StringBuilder(p.s.toString()).append((idx+1)+" ")));
        Pair p1=dp(idx+1,t1,new Pair(p.c, p.s));
        Pair p2=dp(idx+1,t2,new Pair(p.c+1,p.s|(1l << (idx+1))));
        if(p1.c<p2.c)
            return p1;
        return p2;
    }
    static int n,m;
    static long[]a;
    public static void main(String[] args) throws IOException {
//        Scanner sc=new Scanner(System.in);
//        PrintWriter pw=new PrintWriter(System.out);
      Scanner sc = new Scanner(new FileReader("input.txt"));
      PrintWriter pw = new PrintWriter(new FileWriter("output.txt"));   
        n=sc.nextInt();m=sc.nextInt();
        a=new long[n];
        for(int i=0;i<n;i++)
        {
            int k=sc.nextInt();
            while(k-->0)
                a[i] |= 1l << sc.nextInt();
        }
        Pair p=dp(0,0,new Pair(0,0));
        pw.println(p.c);
        int c=1;
        String s=Long.toBinaryString(p.s);
        boolean first=true;
        for(int i=s.length()-2;i>=0;i--)
        {
            if(s.charAt(i)=='1')
            {
                if(first)
                    pw.print(c);
                else
                    pw.print(" "+c);
                first=false;
            }
            c++;
        }
        pw.close();
    }
    static class Pair
    {
        int c;long s;
        public Pair(int c,long s) {
            // TODO Auto-generated constructor stub
            this.c=c;this.s=s;
        }
        public String toString() {
            // TODO Auto-generated method stub
            return c+"\n"+s;
        }
    }
}