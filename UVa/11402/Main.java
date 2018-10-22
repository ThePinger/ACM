//11402
//Ahoy Pirates

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        
        int t = sc.nextInt();
        for(int c = 1; c <= t; c++)
        {
            pw.println("Case " + c + ":");
            int m = sc.nextInt();
            StringBuilder s = new StringBuilder();
            while(m-->0)
            {
                int n = sc.nextInt();
                String tmp = sc.next();
                while(n-->0) s.append(tmp);
            }

            int[] arr = new int[s.length()];
            for(int i = 0; i < arr.length; i++)
                arr[i] = Character.getNumericValue(s.charAt(i));

            SegmentTree st = new SegmentTree(arr);
            int q = sc.nextInt();
            int query = 1;
            while(q-->0)
            {
                String typ = sc.next();
                int start = sc.nextInt();
                int end = sc.nextInt();
                if(typ.equals("F"))
                    st.update(1, 0, arr.length - 1, start, end, 1);
                else if(typ.equals("E"))
                    st.update(1, 0, arr.length - 1, start, end, 2);
                else if(typ.equals("I"))
                    st.update(1, 0, arr.length - 1, start, end, 3);
                else pw.println("Q" + (query++) + ": " + st.query(1, 0, arr.length - 1, start, end));
            }            
        }

        pw.flush();
        pw.close();
    }

    static class SegmentTree
    {
        int[] arr, segTree, lazy;

        public SegmentTree(int[] arr)
        {
            int n = 1;
            while(n < arr.length) n <<= 1;
            n <<= 1;
            this.arr = arr;
            segTree = new int[n];
            lazy = new int[n];
            build(1, 0, arr.length - 1);
        }

        public void build(int node, int l, int r)
        {
            if(l == r)
            {
                segTree[node] = arr[l]; 
                return;
            }

            int mid = (l + r) / 2;
            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);
            segTree[node] = segTree[node << 1] + segTree[node << 1| 1];
        }

        public void propagate(int node, int l, int r)
        {
            int mid = (l + r) / 2;
            if(lazy[node] == 1)
            {
                segTree[node << 1] = mid - l + 1;
                segTree[node << 1 | 1] = r - mid;
                lazy[node << 1] = 1;
                lazy[node << 1 | 1] = 1;
            }
            else if(lazy[node] == 2)
            {
                segTree[node << 1] = 0;
                segTree[node << 1 | 1] = 0;
                lazy[node << 1] = 2;
                lazy[node << 1 | 1] = 2;
            }
            else if(lazy[node] == 3)
            {
                if(lazy[node << 1] == 1)
                    lazy[node << 1] = 2;
                else if(lazy[node << 1] == 2)
                    lazy[node << 1] = 1;
                else if(lazy[node << 1] == 3)
                    lazy[node << 1] = 0;
                else lazy[node << 1] = 3;

                if(lazy[node << 1 | 1] == 1)
                    lazy[node << 1 | 1] = 2;
                else if(lazy[node << 1 | 1] == 2)
                    lazy[node << 1 | 1] = 1;
                else if(lazy[node << 1 | 1] == 3)
                    lazy[node << 1 | 1] = 0;
                else lazy[node << 1 | 1] = 3;

                segTree[node << 1] = (mid - l + 1) - segTree[node << 1];
                segTree[node << 1 | 1] = (r - mid) - segTree[node << 1 | 1];
            }
            lazy[node] = 0;
        }

        public void update(int node, int l, int r, int start, int end, int type)
        {
            if(l > end || r < start) return;
            if(l >= start && r <= end)
            {
                if(type == 1)
                {
                    segTree[node] = r - l + 1;
                    lazy[node] = 1;
                }
                else if(type == 2)
                {
                    segTree[node] = 0;
                    lazy[node] = 2;
                }
                else
                {
                    segTree[node] = (r - l + 1) - segTree[node];
                    if(lazy[node] == 1) lazy[node] = 2;
                    else if(lazy[node] == 2) lazy[node] = 1;
                    else if(lazy[node] == 3) lazy[node] = 0;
                    else lazy[node] = 3;
                }
                return;
            }

            propagate(node, l, r);
            int mid = (l + r) / 2;
            update(node << 1, l, mid, start, end, type);
            update(node << 1 | 1, mid + 1, r, start, end, type);
            segTree[node] = segTree[node << 1] + segTree[node << 1 | 1];
        }

        public int query(int node, int l, int r, int start, int end)
        {
            if(l > end || r < start) return 0;
            if(l >= start && r <= end)
                return segTree[node];

            propagate(node, l, r);
            int mid = (l + r) / 2;
            int q1 = query(node << 1, l, mid, start, end);
            int q2 = query(node << 1 | 1, mid + 1, r, start, end);
            return q1 + q2;
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