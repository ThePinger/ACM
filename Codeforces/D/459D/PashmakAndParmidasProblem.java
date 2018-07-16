//459D
//PashmakAndParmidasProblem

import java.io.*;
import java.util.*;

public class PashmakAndParmidasProblem
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] left = new int[n];
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++)
        {
            int tmp = arr[i];
            if(map.containsKey(tmp))
            {
                left[i] = map.get(tmp) + 1;
                map.put(tmp, map.get(tmp) + 1);
            }
            else 
            {
                left[i] = 1;
                map.put(tmp, 1);
            }
        } 

        int[] right = new int[n];
        map = new HashMap<>();
        for(int i = n - 1; i > -1; i--)
        {
            int tmp = arr[i];
            if(map.containsKey(tmp))
            {
                right[i] = map.get(tmp) + 1;
                map.put(tmp, map.get(tmp) + 1);
            }
            else 
            {
                right[i] = 1;
                map.put(tmp, 1);
            }
        } 
        
        long count = 0;
        FenwickTree ft = new FenwickTree(n + 1);
        for(int i = n - 1; i > -1; i--)
        {
            count += ft.query(0, left[i] - 1);
            ft.update(1, right[i]);
        }

        System.out.println(count);
    }

    static class FenwickTree
    {
        int[] arr, fenTree;

        public FenwickTree(int n)
        {
            this.fenTree = new int[n];
        }

        public void build()
        {
            for(int i = 0; i < this.arr.length; i++)
                this.update(this.arr[i], i + 1);
        }

        public void update(int val, int idx)
        {
            while(idx < this.fenTree.length)
            {
                this.fenTree[idx] += val;
                idx += idx & -idx;
            }
        }

        public int query(int start, int end)
        {
            return query(end) - query(start);
        }

        public int query(int idx)
        {
            int sum = 0;
            while(idx > 0)
            {
                sum += this.fenTree[idx];
                idx -= idx & -idx;
            }
            return sum;
        }
    }

    static class Scanner 
    {
        StringTokenizer st;
        BufferedReader br;

        public Scanner(InputStream s){	br = new BufferedReader(new InputStreamReader(s));}

        public String next() throws IOException 
        {
            while (st == null || !st.hasMoreTokens()) 
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        public int nextInt() throws IOException {return Integer.parseInt(next());}
        
        public long nextLong() throws IOException {return Long.parseLong(next());}

        public String nextLine() throws IOException {return br.readLine();}
        
        public double nextDouble() throws IOException
        {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if(x.charAt(0) == '-')
            {
                neg = true;
                start++;
            }
            for(int i = start; i < x.length(); i++)
                if(x.charAt(i) == '.')
                {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                }
                else
                {
                    sb.append(x.charAt(i));
                    if(dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg?-1:1);
        }
        
        public boolean ready() throws IOException {return br.ready();}


    }
}