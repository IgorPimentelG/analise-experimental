package br.com.ads.aa.ordering;

import java.io.PrintWriter;

public abstract class QuickSort {

	private static long comparacoesChaves = 0;
	private static long movimentacoesRegistros = 0;
	private static long tempoProcessamento = 0;

	public static void quickSort(Integer vetor[], Integer esquerda, Integer direita) {
		if(esquerda < direita) {
			Integer indexParticionamento = particionar(vetor, esquerda, direita);			// Índice no qual lista será dividida
			quickSort(vetor, esquerda, indexParticionamento);						    	// Ordenar o lado esquerdo do pivo
			quickSort(vetor, indexParticionamento + 1, direita);						    // Ordenar o lado direito do pivo
		}
	}

	private static Integer particionar(Integer vetor[], Integer esquerda, Integer direita) {

		int pivo = vetor[(int) (esquerda + direita) / 2];
		int leftIndex = esquerda;
		int rightIndex = direita;

		while(true) {

			/*
			* Percorrer o lado esquerdo do vetor até encontrar, até encontrar 
			* um elemento maior que o pivo
			*/
			comparacoesChaves += 1;
			while(vetor[leftIndex] < pivo) {
				leftIndex++;

				comparacoesChaves += 1;
			}

			/*
			* Percorrer o lado direito do vetor até encontrar, até encontrar 
			* um elemento menor que o pivo
			*/
			comparacoesChaves += 1;
			while(vetor[rightIndex] > pivo) {
				rightIndex--;

				comparacoesChaves += 1;
			}

			/*
			*  Verificar se as flag que marca o lado esquerdo e direito do vetor
			*  se cruzaram durante o percurso 
			*/
			if(leftIndex >= rightIndex) {
				return rightIndex;
			}

			trocar(vetor, leftIndex, rightIndex);
		}

	}

	private static void trocar(Integer[] vetor, Integer i, Integer j) {
		int aux = vetor[i];
		vetor[i] = vetor[j];
		vetor[j] = aux;

		movimentacoesRegistros += 3;
	}
	
	public static void sort(Integer vetor[], Integer inicio, Integer fim, PrintWriter recorderFile) {

		comparacoesChaves = 0;
		movimentacoesRegistros = 0;
		tempoProcessamento = 0;

		long tempoInicial = System.nanoTime();								// Tempo inicial da execução
		quickSort(vetor, inicio, fim);
		long tempoFinal = System.nanoTime();								// Tempo final da execução

		tempoProcessamento = tempoFinal - tempoInicial;

		recorderFile.println("========================================");
		recorderFile.printf("TOTAL COMPARAÇÕES DE CHAVES: %s %n", comparacoesChaves);
		recorderFile.printf("TOTAL MOVIMENTAÇÕES DE REGISTROS: %s %n", movimentacoesRegistros);
		recorderFile.printf("TEMPO DE PROCESSAMENTO: %s %n", tempoProcessamento);
		recorderFile.println("========================================\n");
	}
}
