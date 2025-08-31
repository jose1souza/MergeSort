package view;

import java.util.List;
import java.util.Scanner;

import model.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class App {

	public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
		List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
		Integer[] numeros = new Integer[linhas.size()];
		for (int i = 0; i < linhas.size(); i++) {
			numeros[i] = Integer.parseInt(linhas.get(i).trim());
		}
		return numeros;
	}

	static Scanner read = new Scanner(System.in); // instância do Scanner

	public static void main(String[] args) throws Exception {
		Integer[] arquivoCarregado = carregarArquivo("numeros_aleatorios.txt");
		Integer[] arquivoCarregado2 = carregarArquivo("numeros_aleatorios2.txt");
		Integer[] arquivoCarregado3 = carregarArquivo("numeros_aleatorios3.txt");
		Integer[] arquivoCarregado4 = carregarArquivo("numeros_aleatorios4.txt");

		MergeSort merge = new MergeSort();
		SortObserver observerMerge = new SortObserver();
		merge.setObserver(observerMerge);

		InsertionSort<Integer> insert = new InsertionSort<>();
		SortObserver observerInsert = new SortObserver();
		insert.setObserver(observerInsert);

		SelectionSort<Integer> selectionSort = new SelectionSort<>();
		SortObserver observerSelection = new SortObserver();
		selectionSort.setObserver(observerSelection);

		BubbleSort<Integer> bubbleSort = new BubbleSort<>();
		SortObserver observerBubble = new SortObserver();
		selectionSort.setObserver(observerBubble);

		// Usando Merge Sort

		long tempoInicialM = System.currentTimeMillis();
		arquivoCarregado = merge.sort(arquivoCarregado);
		long tempoFinalM = System.currentTimeMillis();
		double tempoTotalSegM = (tempoFinalM - tempoInicialM) / 1000.00;
		System.out.println("Comparison: " + merge.getAccountantComparison());
		System.out.printf("Time (s) MergeSort: %.3f\n", tempoTotalSegM);

		System.out.println("/--------------------------------------------------/");

		// Usando Insertion Sort
		long tempoInicialS = System.currentTimeMillis();
		arquivoCarregado = insert.sort(arquivoCarregado2);
		long tempoFinalS = System.currentTimeMillis();
		double tempoTotalSegS = (tempoFinalS - tempoInicialS) / 1000.00;
		System.out.println("Comparison: " + insert.getAccountantComparison());
		System.out.printf("Time (s) Insertion: %.3f\n", tempoTotalSegS);

		System.out.println("/--------------------------------------------------/");

		// Usando Selection Sort

		long tempoInicial = System.currentTimeMillis();
		selectionSort.sort(arquivoCarregado3);
		long tempoFinal = System.currentTimeMillis();
		double tempoTotalSeg = (tempoFinal - tempoInicial) / 1000.00;
		System.out.println("Comparison: " + selectionSort.getAccountantComparison());
		System.out.printf("Time (s) Selection Sort: %.3f\n", tempoTotalSeg);

		System.out.println("/--------------------------------------------------/");
		// Usando Bubble Sort

		long tempoInicialB = System.currentTimeMillis();

		// bubbleSort.sort(observer);
		bubbleSort.sort(arquivoCarregado4);
		long tempoFinalB = System.currentTimeMillis();
		double tempoTotalSegB = (tempoFinalB - tempoInicialB) / 1000.00;
		System.out.println("Comparison: " + bubbleSort.getAccountantComparison());
		System.out.printf("Time (s) Bubble Sort: %.3f\n", tempoTotalSegB);

		System.out.println("/--------------------------------------------------/");

	} // fim do main
} // fim da classe App