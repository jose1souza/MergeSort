package model;

import java.util.Comparator;

public class InsertionSort<T> extends ObservableSort<T>{
	
	private void insert(T[] array, int i, Comparator<T> comparator) {
		T eleito = array[i];
		int indexComparison = i - 1;
		
		while(indexComparison >= 0 && comparator.compare(eleito, array[indexComparison]) < 0) {
			notificationComparison(i,indexComparison);
			array[indexComparison+1] = array[indexComparison];
			notificationExchanges(i, indexComparison);
			indexComparison--;
		}
		array[indexComparison + 1] = eleito;
	}
	
	public T[] sort(T[] array, Comparator<T> comparator) {
		for(int i = 1;i < array.length;i++) {
			insert(array,i,comparator);
		}
		//notificationEnd();
		return array;
	}
	
	public T[] sort(T[] array) { 
		return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
	}
	
}
