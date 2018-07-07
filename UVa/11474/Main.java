//11474
//Dying Tree

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Scanner sc = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        int t = sc.nextInt();
        
        while(t-->0)
        {
            int trees = sc.nextInt();
            int doctors = sc.nextInt();
            UnionFindDisjointSets uf = new UnionFindDisjointSets(trees + doctors);
            int treeTree = sc.nextInt();
            int treeDoc = sc.nextInt();
            Point[] docs = new Point[doctors];
            ArrayList<Point>[] branches = new ArrayList[trees];

            for(int i = 0; i < doctors; i++)
                docs[i] = new Point(sc.nextInt(), sc.nextInt());

            for(int i = 0; i < trees; i++)
            {
                int b = sc.nextInt();
                branches[i] = new ArrayList<>();
                for(int j = 0; j < b; j++)
                    branches[i].add(new Point(sc.nextInt(), sc.nextInt()));
            }

            for(int i = 0; i < trees; i++)
            {
                for(int j = i + 1; j < trees; j++)
                    for(Point a : branches[i])
                        for(Point b : branches[j])
                            if(a.dist(b) <= treeTree)
                                uf.union(i, j);

                for(int j = 0; j < doctors; j++)
                    for(Point a : branches[i])
                        if(a.dist(docs[j]) <= treeDoc)
                            uf.union(i, j + trees);
            }

            boolean flag = false;
            for(int i = 0; i < doctors && !flag; i++)
                flag = uf.isSameSet(0, i + trees);
                    
            pw.println(flag || trees == 0 ? "Tree can be saved :)" : "Tree can't be saved :(");
        }

        pw.flush();
        pw.close();
    }

    static class Point
    {
        int x, y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        public double square(double x)
        {
            return x * x;
        }

        public double dist(Point p)
        {
            return Math.sqrt(square(this.x - p.x) + square(this.y - p.y));
        }
    }

    static class UnionFindDisjointSets
    {
        int sets;
        int[] rank, parent, setSize;

        public UnionFindDisjointSets(int size)
        {
            this.sets = size;
            this.rank = new int[size];
            this.parent = new int[size];
            this.setSize = new int[size];
            for(int i = 0; i < size; i++)
            {
                this.parent[i] = i;
                this.setSize[i] = 1;
            }
        }

        public int findSet(int i)
        {
            return i == parent[i] ? i : (parent[i] = this.findSet(parent[i]));
        }

        public boolean isSameSet(int i, int j)
        {
            return this.findSet(i) == this.findSet(j);
        }

        public void union(int i, int j)
        {
            if(this.isSameSet(i, j))
                return;
            
            sets--;
            int ii = this.findSet(i);
            int jj = this.findSet(j);
            if(rank[ii] > rank[jj])
            {
                parent[jj] = ii;
                setSize[ii] += setSize[jj];
            }
            else
            {
                parent[ii] = jj;
                setSize[jj] += setSize[ii];
                if(rank[ii] == rank[jj]) rank[jj]++;
            }
        }

        public int getSets()
        {
            return this.sets;
        }

        public int getSetSize(int i)
        {
            return this.setSize[this.findSet(i)];
        }
    }
}