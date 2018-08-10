//12347
//Binary Search Tree

import java.io.*;
import java.util.*;

public class Main
{
    static PrintWriter pw = new PrintWriter(System.out);
    
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Node root = new Node(n);        
        while(sc.hasNext())
        {
            int val = sc.nextInt();
            add(root, val);
        }

        print(root);
        pw.flush();
        pw.close();
    }

    public static void print(Node cur)
    {
        if(cur == null) return;
        print(cur.left);
        print(cur.right);
        pw.println(cur.val);
    }

    public static void add(Node cur, int val)
    {
        if(val < cur.val) 
        {
            if(cur.left == null) 
                cur.left = new Node(val);
            else
                add(cur.left, val);
        }
        else 
        {
            if(cur.right == null)
                cur.right = new Node(val);
            else
                add(cur.right, val);
        }
    }

    static class Node
    {
        int val;
        Node left, right;

        public Node(int val)
        {
            this.val = val;
        }
    }
}