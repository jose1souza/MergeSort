package model;

import java.util.*;

public class MergeSort<T> extends ObservableSort{
	
	public T[] mergeSort(T[] inputArray, Comparator<T> comparator) {
		int inputLength = inputArray.length;
		
		if (inputLength < 2) {
			return inputArray;
		}

		int midIndex = inputLength / 2;
		T[] leftHalf = (T[]) new Object[midIndex];
		T[] rightHalf = (T[]) new Object[inputLength - midIndex];

		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = inputArray[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = inputArray[i];
		}

		mergeSort(leftHalf,comparator);
		mergeSort(rightHalf,comparator);

		merge(inputArray, leftHalf, rightHalf,comparator);
		
		return inputArray;
	}

	private void merge(T[] inputArray, T[] leftHalf, T[] rightHalf,Comparator<T> comparator) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;

		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			notificationComparison(i, j);
			
			if (comparator.compare(leftHalf[i], rightHalf[j]) >= 0) {
				inputArray[k] = leftHalf[i];
				i++;
			} else {
				inputArray[k] = rightHalf[j];
				j++;
			}
			k++;
		}

		while (i < leftSize) {
			inputArray[k] = leftHalf[i];
			i++;
			k++;
		}

		while (j < rightSize) {
			inputArray[k] = rightHalf[j];
			j++;
			k++;
		}

	}
	
	public T[] sort(T[] array) { 
		return mergeSort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
	}

}