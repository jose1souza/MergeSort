package model;

import java.util.*;

public class MergeSort {
	public static void mergeSort(Integer[] inputArray) {
		int inputLength = inputArray.length;

		if (inputLength < 2) {
			return;
		}

		int midIndex = inputLength / 2;
		Integer[] leftHalf = new Integer[midIndex];
		Integer[] rightHalf = new Integer[inputLength - midIndex];

		for (int i = 0; i < midIndex; i++) {
			leftHalf[i] = inputArray[i];
		}
		for (int i = midIndex; i < inputLength; i++) {
			rightHalf[i - midIndex] = inputArray[i];
		}

		mergeSort(leftHalf);
		mergeSort(rightHalf);

		merge(inputArray, leftHalf, rightHalf);
	}

	private static void merge(Integer[] inputArray, Integer[] leftHalf, Integer[] rightHalf) {
		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;

		int i = 0, j = 0, k = 0;

		while (i < leftSize && j < rightSize) {
			if (leftHalf[i] <= rightHalf[j]) {
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

	private static void printArray(Integer[] numbers) {
		for (int i = 0; i < numbers.length; i++) {
			System.out.println(numbers[i]);
		}
	}
}