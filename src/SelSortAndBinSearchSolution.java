 
import java.util.Random;
import java.text.DecimalFormat;

public class SelSortAndBinSearchSolution {
	 static int SIZE = 100; // size of array to be searched
	 int[] values = new int[SIZE]; // values to be sorted

	 void initValues()
	// Initializes the values array with random integers from 0 to SIZE.
	{
		Random rand = new Random();
		for (int index = 0; index < SIZE; index++)
			values[index] = Math.abs(rand.nextInt()) % SIZE;
	}

	 public boolean isSorted()
	// Returns true if the array values are sorted and false otherwise.
	{
		boolean sorted = true;
		for (int index = 0; index < (SIZE - 1); index++)
			if (values[index] > values[index + 1])
				sorted = false;
		return sorted;
	}

	 public void swap(int index1, int index2)
	// Precondition: index1 and index2 are >= 0 and < SIZE.
	//
	// Swaps the integers at locations index1 and index2 of the values array.
	{
		int temp = values[index1];
		values[index1] = values[index2];
		values[index2] = temp;
	}

	 public void printValues()
	// Prints all the values integers.
	{
		int value;
		DecimalFormat fmt = new DecimalFormat("000");
		System.out.println("The values array is:");
		for (int index = 0; index < SIZE; index++) {
			value = values[index];
			if (((index + 1) % 10) == 0)
				System.out.println(fmt.format(value));
			else
				System.out.print(fmt.format(value) + " ");
		}
		System.out.println();
	}

	/////////////////////////////////////////////////////////////////
	//
	// Selection Sort
 

	 /*
	  * the statements in the inner loop execute a total of N * M times. 
	  * Thus, the complexity is O(N * M). 
	  * the total complexity for the two loops is O(N2).
	  * slow!
	  * 
	  */
	 
	 void selectionSort()
	// Sorts the values array using the selection sort algorithm.
	{
		int endIndex = SIZE - 1;
		for (int current = 0; current < endIndex; current++) {
			// find the index of the smallest value in values[startIndex]..values[endIndex].
			int indexOfMin = current;
			for (int index = current + 1; index <= endIndex; index++)
				if (values[index] < values[indexOfMin])
					indexOfMin = index;
			
			swap(current, indexOfMin);
	//		printValues();	
		}
	}

	//
	// Selection Sort End
	/////////////////////////////////////////////////////////////////

	 
	 //O(log2N) - Logarithmic tims ~ cut the amount of data to be processed in half. 

	 
	 boolean binarySearch(int target, int first, int last)
	// Preconditions: first and last are legal indices of values
	// first + last <= Integer.MAX_Value
	//
	// If target is contained in values[first,last] return true
	// otherwise return false
	{
		int iterations = 0;
		int midpoint;
		while (first <= last) {
			iterations++;
			midpoint = (first + last) / 2;
			if (target == values[midpoint]) {
				System.out.println("It took " + iterations + " iterations to find this # ");
				return true;
			}
			else if (target > values[midpoint]) // target too high
				first = midpoint + 1;
			else // target too low
				last = midpoint - 1;
		}

		System.out.println("It took " + iterations + " iterations & we came up empty");
		return false;
	}

	
}
 
