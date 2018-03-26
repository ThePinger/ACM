//431B
//Shower Line

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ShowerLine
{
 
    static int[][] matrix;
    static ArrayList<String> sequence = new ArrayList<>();
    
    public static void generateSequence(String s, int mask)
    {
        if(s.length() == 5)
            sequence.add(s);

        for(int i = 1; i < 6; i++)
            if((mask & (1 << i)) == 0)
                generateSequence(s + i, mask | (1 << i));
    }

    public static int simulate(int i)
    {
        String s = sequence.get(i);
        int[] q = new int[5];
        for(int c = 0; c < s.length(); c++)
            q[c] = Character.getNumericValue(s.charAt(c));

        int max = 0;
        for(int c = 0; c < 5; c++)
            for(int j = c; j < 4; j+=2)
                max += matrix[q[j]][q[j + 1]] + matrix[q[j + 1]][q[j]];

        return max;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        matrix = new int[6][6];
        for(int i = 1; i < 6; i++)
            for(int j = 1; j < 6; j++)
                matrix[i][j] = sc.nextInt();

        generateSequence("", 0);
        
        int max = 0;
        for(int i = 0; i < sequence.size(); i++)
            max = Math.max(max, simulate(i));

        System.out.println(max);
    }
}