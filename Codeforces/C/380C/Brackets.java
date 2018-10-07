//380C
//Sereja and Brackets

import java.io.*;
import java.util.*;

public class Brackets
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        PrintWriter pw = new PrintWriter(System.out);

        char[] s = sc.next().toCharArray();
        SegmentTree st = new SegmentTree(s);

        int q = sc.nextInt();
        while(q-->0)
        {
            int l = sc.nextInt() - 1;
            int r = sc.nextInt() - 1;
            pw.println(st.query(1, 0, s.length - 1, l, r).seq);
        }

        pw.flush();
        pw.close();
    }

    static class Triple
    {
        int seq, open, closed;

        public Triple(int seq, int open, int closed)
        {
            this.seq = seq;
            this.open = open;
            this.closed = closed;
        }
    }

    static class SegmentTree
    {
        int size;
        char[] brackets;
        Triple[] segTree;

        public SegmentTree(char[] brackets)
        {
            this.size = 1;
            while(this.size < brackets.length) this.size <<= 1;
            this.size <<= 1;
            this.brackets = brackets;
            this.segTree = new Triple[this.size];
            this.build(1, 0, brackets.length - 1);
        }

        public void build(int node, int l, int r)
        {
            if(l == r)
            {
                if(this.brackets[l] == '(')
                    this.segTree[node] = new Triple(0, 1, 0);
                else
                    this.segTree[node] = new Triple(0, 0, 1);
                return;
            }

            int mid = (l + r) / 2;
            build(node << 1, l, mid);
            build(node << 1 | 1, mid + 1, r);

            Triple left = this.segTree[node << 1];
            Triple right = this.segTree[node << 1 | 1];

            int add = Math.min(left.open, right.closed);
            this.segTree[node] = new Triple(left.seq + right.seq + (add * 2), left.open + right.open - add, left.closed + right.closed - add);
        }

        public Triple query(int node, int l, int r, int start, int end)
        {
            if(l > end || r < start) return new Triple(0, 0, 0);
            if(l >= start && r <= end)
                return this.segTree[node];

            int mid = (l + r) / 2;
            Triple left = query(node << 1, l, mid, start, end);
            Triple right = query(node << 1 | 1, mid + 1, r, start, end);

            int add = Math.min(left.open, right.closed);
            return new Triple(left.seq + right.seq + (add * 2), left.open + right.open - add, left.closed + right.closed - add);
        }

    }
}