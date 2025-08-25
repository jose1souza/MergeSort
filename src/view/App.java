package view;
import java.util.*;

import model.BubbleSort;
import model.Pessoa;
import model.SelectionSort;
import model.SortObserver;
import model.MergeSort;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;

public class App {
	public static Pessoa[] vetorDePessoas() {
		return new Pessoa[] { new Pessoa("João", LocalDate.of(1990, 1, 1)), new Pessoa("Ana", LocalDate.of(1992, 2, 2)),
				new Pessoa("Maria", LocalDate.of(1995, 5, 5)), new Pessoa("Pedro", LocalDate.of(1993, 4, 4)),
				new Pessoa("Lucas", LocalDate.of(1991, 6, 6)), new Pessoa("Carlos", LocalDate.of(1988, 3, 3)) };
	}

	public static Integer[] carregarArquivo(String nomeArquivo) throws IOException {
		List<String> linhas = Files.readAllLines(Paths.get(nomeArquivo));
		Integer[] numeros = new Integer[linhas.size()];
		for (int i = 0; i < linhas.size(); i++) {
			numeros[i] = Integer.parseInt(linhas.get(i).trim());
		}
		return numeros;
	}

	static Scanner leia = new Scanner(System.in); // instância do Scanner

	public static void main(String[] args) throws Exception {
		Integer[] arquivoCarregado = carregarArquivo("numeros_aleatorios.txt");
		Integer[] arquivoCarregado2 = carregarArquivo("numeros_aleatorios2.txt");
		Integer[] arquivoCarregado3 = carregarArquivo("numeros_aleatorios3.txt");
		SelectionSort<Integer> selectionSort = new SelectionSort<>();
		BubbleSort<Integer> bubbleSort = new BubbleSort<>();
		MergeSort mergeSort = new MergeSort();
		// SortObserver observer = new SortObserver();
		//selectionSort.setObserver(observer);
		
		// Usando Selection Sort
		
		System.out.println("Vetor antes de ordenar: " + 
					Arrays.toString(arquivoCarregado));
		long tempoInicial = System.currentTimeMillis();
		selectionSort.sort(arquivoCarregado);
		long tempoFinal = System.currentTimeMillis();
		double tempoTotalSeg = (tempoFinal-tempoInicial)/1000.00;
		System.out.println("Pessoas depois de ordenar Usando Selection Sort: " + 
					Arrays.toString(arquivoCarregado));
		System.out.printf("Time (s): %.3f\n", tempoTotalSeg);

		System.out.println("/--------------------------------------------------/");
		// Usando Bubble Sort
		long tempoInicialB = System.currentTimeMillis();
		
		System.out.println("Vetor antes de ordenar: " + 
					Arrays.toString(arquivoCarregado2));
		//bubbleSort.sort(observer);
		bubbleSort.sort(arquivoCarregado2);
		long tempoFinalB = System.currentTimeMillis();
		double tempoTotalSegB = (tempoFinalB-tempoInicialB)/1000.00;
		System.out.println("Pessoas depois de ordenar Usando Bubble Sort: " + 
					Arrays.toString(arquivoCarregado2));
		System.out.printf("Time (s): %.3f\n", tempoTotalSegB);
		System.out.println("/--------------------------------------------------/");
		System.out.println("Vetor antes de ordenar: " + 
				Arrays.toString(arquivoCarregado3));
		long tempoInicialM = System.currentTimeMillis();
		MergeSort.mergeSort(arquivoCarregado3);
		long tempoFinalM = System.currentTimeMillis();
		double tempoTotalSegM = (tempoFinalM-tempoInicialM)/1000.00;
		System.out.println("Pessoas depois de ordenar Usando Merge Sort: " + 
				Arrays.toString(arquivoCarregado3));
		System.out.printf("Time (s): %.3f\n", tempoTotalSegM);

	} // fim do main
} // fim da classe App

/* Número 2 da atividade
  	Fases: 87
  	Comparations: 4872
	Exchanges: 2343
  */