package model;

public abstract class ObservableSort<T> {
	private SortObserver observer;
	private int accountantComparison = 0;
	private int counterExchanges = 0;
	
	public void setObserver(SortObserver observer) {
		this.observer = observer;
	}
	
	public int getAccountantComparison() {
		return this.accountantComparison;
	}
	
	public int getCounterExchanges() {
		return this.counterExchanges;
	}
	
	protected void notificationComparison(int index1, int index2) {
		this.accountantComparison++;
		if(observer != null)
			observer.inComparacion(index1, index2);
	}
	
	protected void notificationExchanges(int index1, int index2) {
		this.counterExchanges++;
		if(observer != null)
			observer.inExchanges(index1, index2);
	}
	
	protected void notificationEnd() {
		if(observer != null)
			observer.uponCompletion(this.accountantComparison,this.accountantComparison);
	}
	
}
