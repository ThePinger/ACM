// MERGE SORT

public class MergeSort 
{
    // MERGE SORT ALGORITHM
    // TIME COMPLEXITY = O(NlogN)
    public static void mergeSort(int[] arr, int start, int end)
	{
		// IF WE HAVE AN ARRAY OF SIZE = 1 RETURN
		if(start == end) return;
		
		// GET MID INDEX OF ARRAY (END OF FIRST SUB-ARRAY)
		int mid = (start + end) / 2;
		// GO TO FIRST SUB-ARRAY FROM INDEX START ---> MID
		mergeSort(arr, start, mid);
		// GO TO SECOND SUB-ARRAY FROM INDEX MID + 1 ----> END
		mergeSort(arr, mid + 1, end);
		// MERGE STEP OF FIRST & SECOND SUB-ARRAYS
		merge(arr, start, mid, end);
	}
	
	public static void merge(int[] arr, int start, int mid, int end)
	{
		// START OF FIRST SUB-ARRAY
		int counterFirstSubArray = start;
		// END OF FIRST SUB-ARRAY
		int endFirstSubArray = mid;
		// START OF SECOND SUB-ARRAY
		int counterSecondSubArray = mid + 1;
		// END OF SECOND SUB-ARRAY
		int endSecondSubArray = end;
		
		// TEMPORARY ARRAY TO SAVE SORTED LIST FROM START ---> END
		int[] tmpArr = new int[end - start + 1];
		// TEMPORARY ARRAY CURRENT INDEX
		int idxTmpArr = 0;
		
		while(counterFirstSubArray <= endFirstSubArray || counterSecondSubArray <= endSecondSubArray)
		{
			// IF WE ADDED ALL ELEMENTS IN FIRST SUB-ARRAY
			if(counterFirstSubArray > endFirstSubArray)
				tmpArr[idxTmpArr++] = arr[counterSecondSubArray++];
			// IF WE ADDED ALL ELEMENTS IN SECOND SUB-ARRAY
			else if(counterSecondSubArray > endSecondSubArray)
				tmpArr[idxTmpArr++] = arr[counterFirstSubArray++];
			// IF CURRENT ELEMENT IN FIRST SUB-ARRAY < CURRENT ELEMENT IN SECOND SUB-ARRAY
			else if(arr[counterFirstSubArray] < arr[counterSecondSubArray])
				tmpArr[idxTmpArr++] = arr[counterFirstSubArray++];
			else 
				tmpArr[idxTmpArr++] = arr[counterSecondSubArray++];
		}
		
		// COPY SORTED TEMPORARY ARRAY TO OUR ORIGINAL ARRAY
		for(int i = 0; i < tmpArr.length; i++)
			arr[start++] = tmpArr[i];
	}   
}