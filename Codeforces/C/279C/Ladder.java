//279C
//Ladder

import java.io.*;
import java.util.*;

public class Ladder
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);

        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] arr = new int[n];
        for(int i = 0; i < n ;i++)
            arr[i] = sc.nextInt();

        SegmentTree st = new SegmentTree(arr);
        while(m-->0)
        {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            pw.println(st.query(1, 0, n - 1, l, r).isLadder ? "Yes" : "No");
        }
        
        pw.flush();
        pw.close();
    }

    static class SegmentTree
    {
        int[] arr;
        Quadruple[] tree;

        public SegmentTree(int[] arr)
        {
            int n = 1;
            while(n < arr.length) n <<= 1;
            n <<= 1;

            this.arr = arr;
            this.tree = new Quadruple[n];
            this.build(1, 0, this.arr.length - 1);
        }

        public void build(int node, int start, int end)
        {
            if(start == end)
            {
                this.tree[node] = new Quadruple(this.arr[start], this.arr[start], null, true);
                return;
            }

            int mid = (start + end) / 2;
            this.build(node << 1, start, mid);
            this.build(node << 1 | 1, mid + 1, end);

            Quadruple left = this.tree[node << 1];
            Quadruple right = this.tree[node << 1 | 1];

            if(left == null) this.tree[node] = right;
            else if(right == null) this.tree[node] = left;
            else if(!left.isLadder || !right.isLadder) 
                this.tree[node] = new Quadruple(left.first, right.last, null, false);
            else if(left.direction == null && left.isLadder)
            {
                if(right.direction == null && right.isLadder)
                {
                    String direction = left.first < right.first ? "U" : left.first > right.first ? "D" : "E";
                    this.tree[node] = new Quadruple(left.first, right.first, direction, true);
                }
                else if(right.direction.equals("U") && right.isLadder)
                {
                    if(left.first <= right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "U", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, null, false);
                }
                else if(right.direction.equals("D") && right.isLadder)
                {
                    if(left.first >= right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "D", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, "UD", true);
                }
                else if(right.direction.equals("UD") && right.isLadder)
                {
                    if(left.first <= right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "UD", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, null, false);
                }
                else if (right.direction.equals("E") && right.isLadder)
                {
                    if(left.first < right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "U", true);
                    else if (left.first > right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "D", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, "E", true);
                }
                else
                    this.tree[node] = new Quadruple(left.first, right.last, null, false);
            }
            else if(right.direction == null && right.isLadder)
            {
                if(left.direction.equals("U") && left.isLadder)
                {
                    if(left.last <= right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "U", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, "UD", true);
                }
                else if(left.direction.equals("D") && left.isLadder)
                {
                    if(left.last >= right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "D", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, null, false);
                }
                else if(left.direction.equals("UD") && left.isLadder)
                {
                    if(left.last >= right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "UD", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, null, false);
                }
                else if (left.direction.equals("E") && left.isLadder)
                {
                    if(left.last < right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "U", true);
                    else if (left.last > right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "D", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, "E", true);
                }
                else
                    this.tree[node] = new Quadruple(left.first, right.last, null, false);
            }
            else if(left.direction.equals("U") && left.isLadder)
            {
                if(right.direction.equals("U") && right.isLadder && left.last <= right.first)
                    this.tree[node] = new Quadruple(left.first, right.last, "U", true);
                else if(right.direction.equals("D") && right.isLadder)
                    this.tree[node] = new Quadruple(left.first, right.last, "UD", true);
                else if(right.direction.equals("UD") && right.isLadder && left.last <= right.first)
                    this.tree[node] = new Quadruple(left.first, right.last, "UD", true);
                else if(right.direction.equals("E") && right.isLadder)
                {
                    if(left.last <= right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "U", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, "UD", true);
                }
                else 
                    this.tree[node] = new Quadruple(left.first, right.last, null, false);
            }
            else if((left.direction.equals("D") || left.direction.equals("UD"))&& left.isLadder)
            {
                if((right.direction.equals("D") || right.direction.equals("E")) && right.isLadder && left.last >= right.first)
                    this.tree[node] = new Quadruple(left.first, right.last, left.direction, true);
                else 
                    this.tree[node] = new Quadruple(left.first, right.last, null, false);
            }
            else if(left.direction.equals("E") && left.isLadder)
            {
                if(right.direction.equals("D") && right.isLadder && left.last >= right.first)
                    this.tree[node] = new Quadruple(left.first, right.last, "D", true);
                else if((right.direction.equals("U") || right.direction.equals("UD")) && right.isLadder && left.last <= right.first)
                    this.tree[node] = new Quadruple(left.first, right.last, right.direction, true);
                else if (right.direction.equals("E") && right.isLadder)
                {
                    if(left.last < right.first)
                    this.tree[node] = new Quadruple(left.first, right.last, "U", true);
                    else if (left.last > right.first)
                        this.tree[node] = new Quadruple(left.first, right.last, "D", true);
                    else
                        this.tree[node] = new Quadruple(left.first, right.last, "E", true);
                }
                else
                    this.tree[node] = new Quadruple(left.first, right.last, null, false);
            }
            else
                this.tree[node] = new Quadruple(left.first, right.last, null, false);        
        }

        public Quadruple query(int node, int start, int end, int l, int r)
        {
            if(start > r || end < l) return null;
            if(start >= l && end <= r) return this.tree[node];

            int mid = (start + end) / 2;
            Quadruple left = this.query(node << 1, start, mid, l, r);
            Quadruple right = this.query(node << 1 | 1, mid + 1, end, l, r);

            if(left == null) return right;
            if(right == null) return left;
            if(!left.isLadder || !right.isLadder) return new Quadruple(left.first, right.last, null, false);
            if(left.direction == null)
            {
                if(right.direction == null)
                {
                    String direction = left.first < right.first ? "U" : left.first > right.first ? "D" : "E";
                    return new Quadruple(left.first, right.first, direction, true);
                }
                if(right.direction.equals("U"))
                {
                    if(left.first <= right.first)
                        return new Quadruple(left.first, right.last, "U", true);
                    return new Quadruple(left.first, right.last, null, false);
                }
                if(right.direction.equals("D"))
                {
                    if(left.first >= right.first)
                        return new Quadruple(left.first, right.last, "D", true);
                    return new Quadruple(left.first, right.last, "UD", true);
                }
                if(right.direction.equals("UD"))
                {
                    if(left.first <= right.first)
                        return new Quadruple(left.first, right.last, "UD", true);
                    return new Quadruple(left.first, right.last, null, false);
                }
                if (right.direction.equals("E"))
                {
                    if(left.first < right.first)
                        return new Quadruple(left.first, right.last, "U", true);
                    if(left.first > right.first)
                        return new Quadruple(left.first, right.last, "D", true);
                    return new Quadruple(left.first, right.last, "E", true);
                }
                return new Quadruple(left.first, right.last, null, false);
            }
            if(right.direction == null)
            {
                if(left.direction.equals("U"))
                {
                    if(left.last <= right.first)
                        return new Quadruple(left.first, right.last, "U", true);
                    return new Quadruple(left.first, right.last, "UD", true);
                }
                if(left.direction.equals("D"))
                {
                    if(left.last >= right.first)
                        return new Quadruple(left.first, right.last, "D", true);
                    return new Quadruple(left.first, right.last, null, false);
                }
                if(left.direction.equals("UD"))
                {
                    if(left.last >= right.first)
                        return new Quadruple(left.first, right.last, "UD", true);
                    return new Quadruple(left.first, right.last, null, false);
                }
                if (left.direction.equals("E"))
                {
                    if(left.last < right.first)
                        return new Quadruple(left.first, right.last, "U", true);
                    if (left.last > right.first)
                        return new Quadruple(left.first, right.last, "D", true);
                    return new Quadruple(left.first, right.last, "E", true);
                }
                return new Quadruple(left.first, right.last, null, false);
            }
            if(left.direction.equals("U"))
            {
                if(right.direction.equals("U") && left.last <= right.first)
                    return new Quadruple(left.first, right.last, "U", true);
                if(right.direction.equals("D"))
                    return new Quadruple(left.first, right.last, "UD", true);
                if(right.direction.equals("UD") && left.last <= right.first)
                    return new Quadruple(left.first, right.last, "UD", true);
                if(right.direction.equals("E"))
                {
                    if(left.last <= right.first)
                        return new Quadruple(left.first, right.last, "U", true);
                    return new Quadruple(left.first, right.last, "UD", true);
                }
                return new Quadruple(left.first, right.last, null, false);
            }
            if((left.direction.equals("D") || left.direction.equals("UD")))
            {
                if((right.direction.equals("D") || right.direction.equals("E")) && left.last >= right.first)
                    return new Quadruple(left.first, right.last, left.direction, true);
                return new Quadruple(left.first, right.last, null, false);
            }
            if(left.direction.equals("E"))
            {
                if(right.direction.equals("D") && left.last >= right.first)
                    return new Quadruple(left.first, right.last, "D", true);
                if((right.direction.equals("U") || right.direction.equals("UD")) && left.last <= right.first)
                    return new Quadruple(left.first, right.last, right.direction, true);
                if (right.direction.equals("E"))
                {
                    if(left.last < right.first)
                        return new Quadruple(left.first, right.last, "U", true);
                    if (left.last > right.first)
                        return new Quadruple(left.first, right.last, "D", true);
                    return new Quadruple(left.first, right.last, "E", true);
                }
                return new Quadruple(left.first, right.last, null, false);
            }
            return new Quadruple(left.first, right.last, null, false);  
        }
    }

    static class Quadruple
    {
        int first, last;
        String direction;
        boolean isLadder;

        public Quadruple(int first, int last, String direction, boolean isLadder)
        {
            this.first = first;
            this.last = last;
            this.direction = direction;
            this.isLadder = isLadder;
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