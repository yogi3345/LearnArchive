package learn.sort.mergeSort;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/* This is Standard Merge sort that focuses on best time complexity for a standard merge sort O(n log n).
 * Though there is probably a way to improve time complexity in best case scenario to n, 
 * maybe more or maybe no.*/
public class StandardMergeSortTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> arr = new Random().ints(10, -100, 100).boxed().collect(Collectors.toList());
		mergeSort(arr, 0, arr.size());
		printArr(arr);
		arr = new Random().ints(11, -100, 100).boxed().collect(Collectors.toList());
		mergeSort(arr, 0, arr.size());
		printArr(arr);
	}

	/*This method Prints the list.*/
	private static void printArr(List<Integer> arr) {
		// TODO Auto-generated method stub
		arr.stream().forEach(x -> System.out.print(x + " "));
		System.out.println("\n");
	}

	/*This method modifies the input list to sort it.*/
	private static void mergeSort(List<Integer> arr, int i, int j) {
		
		if(j-i>1) {
			mergeSort(arr, i, (j+i)/2);
			mergeSort(arr, (j+i)/2, j);
			merge(arr, i, (j+i)/2, j);
		}
	}

	/*Helper to mergeSort Method.*/
	private static void merge(List<Integer> arr, int start, int mid, int end) {
		
		List<Integer> newArr = new ArrayList<Integer>();
		int i=start,j=mid;
		while(i<mid && j<end) {
			if(arr.get(i)>arr.get(j))
				newArr.add(arr.get(j++));
			else
				newArr.add(arr.get(i++));
		}
		while(i<mid)
			newArr.add(arr.get(i++));
		while(j<end)
			newArr.add(arr.get(j++));
		for(i=0, j=start; j<end; i++, j++)
			arr.set(j, newArr.get(i));
	}

}
