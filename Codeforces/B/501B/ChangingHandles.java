//501B
//Misha and Changing Handles

import java.util.*;

public class ChangingHandles
{
    static int idx;
    static int[] parent;
    static ArrayList<Integer> olds;
    static ArrayList<String> usernames;

    public static void initializeSets(int size)
    {
        parent = new int[size + 1];
        usernames = new ArrayList<>();
        olds = new ArrayList<>();

        for(int i = 0; i < size + 1; i++) 
            parent[i] = i;
    }

    public static int findSet(int i)
    {
        if(parent[i] == i) return i;
        return findSet(parent[i]);
    }

    public static boolean isSameSet(int i, int j)
    {
        return findSet(i) == findSet(j);
    }

    public static void union(int old, int neww)
    {
        int ii = findSet(old);
        parent[ii] = neww;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        idx = 1;
        initializeSets(2002);
        
        while(q-->0)
        {
            String old  = sc.next();
            String neww = sc.next();
            
            if(usernames.contains(old))
                usernames.add(neww);
            else
            {
                olds.add(idx++);
                usernames.add(old);
                usernames.add(neww);
            }

            union(usernames.indexOf(old) + 1, idx);            
            idx++;
        }

        System.out.println(olds.size());
        for(int i = 0; i < olds.size(); i++)
        {
            int start = olds.get(i);
            String neww  = usernames.get(findSet(start) - 1);
            String olds  = usernames.get(start - 1);

            System.out.println(olds + " " + neww);
        }
    }
}