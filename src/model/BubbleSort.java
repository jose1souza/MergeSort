package model;

import java.util.*;

public class BubbleSort<T> extends ObservableSort {

	private void troca(T[] array, int i, int j) {
		T temporaria = array[i]; // armazena temporariamente
		array[i] = array[j]; // substitui os valores de i e j
		array[j] = temporaria;
		notificationExchanges(i, j);
	} // fim do metódo troca

	public T[] sort(T[] array, Comparator<T> comparator) {
		int numberOfElements = array.length; // este é o n
		for (int fase = 1; fase < numberOfElements; fase++) {
			for (int comparacoes = 0; comparacoes < numberOfElements - fase; comparacoes++) { // percorre até o ultimo
																								// que não está
				// organizado
				notificationComparison(comparacoes, comparacoes + 1);
				if (comparator.compare(array[comparacoes], array[comparacoes + 1]) > 0) { // compara se o primeiro valor
																							// é maior que o próximo
					troca(array, comparacoes, comparacoes + 1); // troca se for maior
				} // fim do if
			} // fim do for de comparacoes
		} // fim do for da fase
		notificationEnd();
		return array;
	} // fim do metódo sort

	public T[] sort(T[] array, Comparator<T> comparator, boolean verbose) { // metódo para caso o queira que detalhe as
																			// fases
		Scanner leia = new Scanner(System.in);
		if (verbose == true) {
			int numberOfElements = array.length; // este é o n
			for (int fase = 1; fase < numberOfElements; fase++) {
				System.out.println("Fase: " + fase); // mostrando a cada fase
				System.out.println(Arrays.toString(array));// como o vetor está durante a fase
				leia.nextLine(); // pause
				for (int comparacoes = 0; comparacoes < numberOfElements - fase; comparacoes++) { // percorre até o
																									// ultimo que não
																									// está
					// organizado
					if (comparator.compare(array[comparacoes], array[comparacoes + 1]) > 0) { // compara se o primeiro
																								// valor é maior que o
																								// próximo
						troca(array, comparacoes, comparacoes + 1); // troca se for maior
					} // fim do if
				} // fim do for de comparacoes
			} // fim do for da fase
		} // fim do if de verbose
		return array;
	} // fim do metódo sort

	public T[] sortFlag(T[] array, Comparator<T> comparator) {
		Scanner leia = new Scanner(System.in);
		int exchanges = 0, numberComparations = 0;

		// if (verbose == true) {
		int numberOfElements = array.length;
		for (int fase = 1; fase < numberOfElements; fase++) {
			boolean exchange = false;
			// System.out.println("Fase: " + fase); // mostrando a cada fase
			// System.out.println(Arrays.toString(array));// como o vetor está durante a
			// fase
			// leia.nextLine(); // pause
			for (int comparacoes = 0; comparacoes < numberOfElements - fase; comparacoes++) {
				numberComparations = numberComparations + 1;
				if (comparator.compare(array[comparacoes], array[comparacoes + 1]) > 0) {
					troca(array, comparacoes, comparacoes + 1);
					exchange = true;
					exchanges = exchanges + 1;
				}
			}
			if (!exchange) {
				System.out.println("Este vetor já está ordenado!");
				break;
			}
		}
		// }
		System.out.println("Comparations: " + numberComparations);
		System.out.println("Exchanges: " + exchanges);
		return array;
	}

	public T[] sort(T[] array) { // Este vai pegar o comparator e passar para o sort independente de seu tipo
		return sort(array, (a, b) -> ((Comparable<T>) a).compareTo(b));
	}
} // fim da classe

/*
 * Comparator retorna 0 quando iguais -1 para menores e 1 para maiores
 */
