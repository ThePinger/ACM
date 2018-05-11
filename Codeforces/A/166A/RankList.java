//166A
//RankList

import java.util.*;

public class RankList
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);  
        int n = sc.nextInt();
        int k = sc.nextInt(); 
        Pair[] rank = new Pair[n];
        
        for(int i = 0; i < n; i++)
            rank[i] = new Pair(sc.nextInt(), sc.nextInt());


        Arrays.sort(rank);

        int curRank = 1;
        int same = 1;
        Pair pre = rank[0];
        for(int i = 1; i < n; i++)
        {
            curRank++;
            Pair cur = rank[i];
            if(pre.compareTo(cur) == 0)
                same++;
            else
            {
                if(k < curRank) break;
                pre = cur;
                same = 1;
            }
        }

        System.out.println(same);
    }

    static class Pair implements Comparable<Pair>
    {
        int solved, penalty;

        public Pair(int solved, int penalty)
        {
            this.solved = solved;
            this.penalty = penalty;
        }

        public int compareTo(Pair p)
        {
            if(this.solved == p.solved)
                return this.penalty - p.penalty;
            return p.solved - this.solved;
        }

        public String toString()
        {
            return this.solved + "+" + this.penalty;
        }
    }
}