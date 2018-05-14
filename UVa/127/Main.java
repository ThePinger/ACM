//127

import java.util.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true)
        {
            String[] line1 = br.readLine().split(" ");
            if(line1.length == 1) break;
            String[] line2 = br.readLine().split(" ");

            ArrayList<Stack<Pair>> arrStack = new ArrayList<>();
            int c = 0;
            for(int i = 0; i < line1.length; i++)
            {
                Stack<Pair> tmp = new Stack<>();
                tmp.push(new Pair(line1[i].charAt(0), line1[i].charAt(1)));
                arrStack.add(tmp);
            }
            for(int i = 0; i < line2.length; i++)
            {
                Stack<Pair> tmp = new Stack<>();
                tmp.push(new Pair(line2[i].charAt(0), line2[i].charAt(1)));
                arrStack.add(tmp);
            }

            for(int i = 1; i < arrStack.size(); i++)
            {
                if(i > 2)
                {
                    Stack<Pair> cur = arrStack.get(i);
                    Stack<Pair> pre = arrStack.get(i - 1);
                    Stack<Pair> pre3 = arrStack.get(i - 3);

                    Pair tmp = cur.peek();
                    Pair before1 = pre.peek();
                    Pair before3 = pre3.peek();

                    if(tmp.x == before3.x || tmp.y == before3.y)
                    {
                        pre3.push(tmp);
                        cur.pop();
                        if(cur.isEmpty())
                            arrStack.remove(i);
                        i = 0;
                    }
                    else if(tmp.x == before1.x || tmp.y == before1.y)
                    {
                        pre.push(tmp);
                        cur.pop(); 
                        if(cur.isEmpty())
                            arrStack.remove(i);    
                        i = 0;                   
                    }
                }
                else
                {
                    Stack<Pair> cur = arrStack.get(i);
                    Stack<Pair> pre = arrStack.get(i - 1);

                    Pair tmp = cur.peek();
                    Pair before1 = pre.peek();
                    if(tmp.x == before1.x || tmp.y == before1.y)
                    {
                        pre.push(tmp);
                        cur.pop(); 
                        if(cur.isEmpty())
                            arrStack.remove(i);      
                        i = 0;                 
                    }
                }
            }
                    
            if(arrStack.size() > 1)
                System.out.print(arrStack.size() + " piles remaining:");
            else
                System.out.print("1 pile remaining:");
                
            for(int i = 0; i < arrStack.size(); i++)
                System.out.print(" " + arrStack.get(i).size());
            System.out.println();
        }
    }

    static class Pair
    {
        char x, y;

        public Pair(char x, char y)
        {
            this.x = x;
            this.y = y;
        }

        public String toString()
        {
            return this.x + " " + this.y;
        }
    }
}