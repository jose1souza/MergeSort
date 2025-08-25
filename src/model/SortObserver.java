package model;

public class SortObserver {
	public void  inComparacion(int index1, int index2) {
		System.out.println("Comparation index: " + index1 + " and" + index2);
	}
	
	public void  inExchanges(int index1, int index2) {
		System.out.println("Exchanges index: " + index1 + " and" + index2);
	}
	
	public void  uponCompletion(int totalyComparations, int totalyExchanges) {
		System.out.println("Totaly Comparations: " + totalyComparations);
		System.out.println("Totaly Exchanges: " + totalyExchanges);
	}
	
}
