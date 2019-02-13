// COUNTING SORT


public class CountingSort 
{
    // COUNTING SORT ALGORITHM
    // TIME COMPLEXITY = O(N)
    public static void countingSort(int[] arr)
    {
        // GET THE MAXIMUM VALUE IN THE ARRAY WE WANT TO SORT
        int max = 0;
        for(int i = 0; i < arr.length; i++)
            max = Math.max(max, arr[i]);

        // CREATE A FREQUENCY ARRAY OF SIZE =  MAXIMUMVALUE + 1
        int[] frequencyArray = new int[max + 1];
        // LOOP ON THE ARRAY WE WANT TO SORT AND INCREMENT THE FREQUENCY OF EACH VALUE
        for(int i = 0; i < arr.length; i++)
            frequencyArray[arr[i]]++;

        // LOOP ON THE FREQUENCY ARRAY
        for(int i = 0, j = 0; i < frequencyArray.length; i++)
        {
            int tmpFreq = frequencyArray[i];
            // ADD i TO THE ORIGINAL ARRAY tmpFreq TIMES
            while(tmpFreq > 0)
            {
                arr[j++] = i;
                tmpFreq--;
            }
        }
    }   
}