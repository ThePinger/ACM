//451B
//SortArray

import java.util.*;

public class SortArray
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> sorted = new ArrayList<>();
        
        for(int i = 0; i < n; i++)
        {
            int tmp = sc.nextInt();
            arr.add(tmp);
            sorted.add(tmp);
        }

        Collections.shuffle(sorted);
        Collections.sort(sorted);

        int num1 = -1;
        int num2 = -1;
        for(int i = 0; i < n; i++)
        {
            int tmpCur = arr.get(i);
            int tmpSor = sorted.get(i);
            if(tmpCur != tmpSor)
            {
                num1 = tmpSor;
                num2 = tmpCur;
                break;
            }
        } 

        ArrayList<Integer> newArr = new ArrayList<>();
        if(num1 != -1 && num2 != -1)
        {
            int idx1 = arr.indexOf(num1);
            int idx2 = arr.indexOf(num2);
            num1 = Math.min(idx1, idx2);
            num2 = Math.max(idx1, idx2);
            for(int i = 0; i < num1; i++)
                newArr.add(arr.get(i));

            for(int i = num2; i >= num1; i--)
                newArr.add(arr.get(i));

            for(int i = num2 + 1; i < n; i++)
                newArr.add(arr.get(i));

            num1++;
            num2++;
        }
        else
        {
            num1 = 1;
            num2 = 1;
            newArr = (ArrayList) arr.clone();
        }

        boolean isSorted = true;
        for(int i = 0; i < n; i++)
        {
            int tmpCur = newArr.get(i);
            int tmpSor = sorted.get(i);
            if(tmpCur != tmpSor)
                isSorted = false;
        }

        if(isSorted) System.out.print("yes\n" + num1 + " " + num2 + "\n");
        else System.out.println("no");

    }
}