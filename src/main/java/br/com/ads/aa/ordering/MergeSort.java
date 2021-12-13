package br.com.ads.aa.ordering;

import java.io.PrintWriter;
import java.util.Arrays;

public abstract class MergeSort {

	private static long comparacoesChaves = 0;
	private static long movimentacoesRegistros = 0;
	private static long tempoProcessamento = 0;

	private static void merge(Integer[] vetor, Integer inicio, Integer meio, Integer fim) {

		// Criar vetores auxiliares para o lado esquerdo e direito do vetor
		Integer[] left = Arrays.copyOfRange(vetor, inicio, meio + 1);
        Integer[] right = Arrays.copyOfRange(vetor, meio + 1, fim + 1);

		Integer leftIndex = 0; 					// Índice do elemento que está sendo comparado no lado esquerdo
		Integer rightIndex = 0;					// Índice do elemento que está sendo comparado no lado direito 
		Integer insertIndex = inicio;			// Índice no qual o elemento da esquerda ou direita deve ser inserido no vetor original

		while(leftIndex < left.length && rightIndex < right.length) {

			comparacoesChaves += 1;
			if(left[leftIndex] <= right[rightIndex]) {
				vetor[insertIndex] = left[leftIndex];
				leftIndex++;
			} else {		
				vetor[insertIndex] = right[rightIndex];
				rightIndex++;
			}

			insertIndex++;

			movimentacoesRegistros += 1;
		}

		/*
		* Copiar os elementos restantes
		*/
		while(leftIndex < left.length) {
			vetor[insertIndex] = left[leftIndex];
			leftIndex++;
			insertIndex++;

			movimentacoesRegistros += 1;
		}

		while(rightIndex < right.length) {
			vetor[insertIndex] = right[rightIndex];
			rightIndex++;
			insertIndex++;

			movimentacoesRegistros += 1;
		}
	}

	public static void mergeSort(Integer[] vetor, Integer inicio, Integer fim) {
		if(inicio < fim) {
			Integer meio = ((inicio + fim) / 2);
			mergeSort(vetor, inicio, meio);	
			mergeSort(vetor, meio+1, fim);
			merge(vetor, inicio, meio, fim);
		} 
	}

	public static void sort(Integer[] vetor, Integer inicio, Integer fim, PrintWriter recorderFile) {

		comparacoesChaves = 0;
		movimentacoesRegistros = 0;
		tempoProcessamento = 0;

		long tempoInicial = System.nanoTime();								// Tempo inicial da execução
		mergeSort(vetor, inicio, fim);
		long tempoFinal = System.nanoTime();								// Tempo final da execução

		tempoProcessamento = tempoFinal - tempoInicial;

		recorderFile.println("========================================");
		recorderFile.printf("TOTAL COMPARAÇÕES DE CHAVES: %s %n", comparacoesChaves);
		recorderFile.printf("TOTAL MOVIMENTAÇÕES DE REGISTROS: %s %n", movimentacoesRegistros);
		recorderFile.printf("TEMPO DE PROCESSAMENTO: %s %n", tempoProcessamento);
		recorderFile.println("========================================\n");
	}
	
}
