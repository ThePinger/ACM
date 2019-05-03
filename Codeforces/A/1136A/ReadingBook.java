//1136A
//Natsya Reading a Book

import java.util.*;

public class ReadingBook
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int chapters = sc.nextInt();
        int[] book = new int[chapters * 100 + 1];
        
        for(int i = 0; i < chapters; i++)
        {
            if(i == 0)
                sc.nextInt();
            else
                book[sc.nextInt()]++;
            sc.nextInt();
        }

        for(int i = 1; i < book.length; i++)
            book[i] += book[i - 1];

        System.out.println(chapters - book[sc.nextInt()]);
    }
}