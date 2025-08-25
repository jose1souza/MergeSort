package model;
import java.util.Comparator;

public class SelectionSort<T> extends ObservableSort{
	
	private void exchange(T[] array, int i, int j) {
		T temporary = array[i];
		array[i] = array[j];
		array[j] = temporary;
		notificationExchanges(i,j);
	}

	private int indexOfSmallestValueVector(T[] array, int position, Comparator<T> comparator) {
		int smallIndex = position;

		for (int i = position + 1; i < array.length; i++) {
			if (comparator.compare(array[i], array[smallIndex]) < 0) {
				notificationComparison(i,i+1);
				smallIndex = i;
			}
		}
		return smallIndex;
	}
	
	public T[] sort(T[]array,Comparator<T> comparator) {
		for(int i = 0;i < array.length - 1;i++) {
			int smallIndex = indexOfSmallestValueVector(array,i,comparator);
				exchange(array,i,smallIndex);
		}
		notificationEnd();
		return array;
	}
	
	public T[] sort(T[] array) {
		return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
	}
	
	public T[] sortFlag(T[]array,Comparator<T> comparator) {
		for(int i = 0;i < array.length - 1;i++) {
			int smallIndex = indexOfSmallestValueVector(array,i,comparator);
			exchange(array,i,smallIndex);
		}
		return array;
	}

}
