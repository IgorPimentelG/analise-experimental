package br.com.ads.aa.ordering;

import java.io.PrintWriter;

public abstract class SelectionSort {

	public static void sort(Integer[] vetor, PrintWriter recorderFile) {

		long comparacoesChaves = 0;
		long movimentacoesRegistros = 0;
		long tempoProcessamento = 0;

		long tempoInicial = System.nanoTime();								// Tempo inicial da execução
		for(int i = 0; i < vetor.length; i++) {
			
			Integer indiceMenor = i;
			
			/*
			* Buscar um índice de um elemento menor que o elemento 
			* da posição indiceMenor
			*/
			for(Integer j = i + 1; j < vetor.length; j++) {

				comparacoesChaves += 1;

				if(vetor[j] < vetor[indiceMenor]) {
					indiceMenor = j;
				}
			}
			
			// Trocar os elementos
			int aux = vetor[i];
			vetor[i] = vetor[indiceMenor];
			vetor[indiceMenor] = aux;

			movimentacoesRegistros += 3;
		}
		long tempoFinal = System.nanoTime();								// Tempo final da execução
	
		tempoProcessamento = tempoFinal - tempoInicial;

		recorderFile.println("========================================");
		recorderFile.println("TOTAL COMPARAÇÕES DE CHAVES: " + comparacoesChaves);
		recorderFile.println("TOTAL MOVIMENTAÇÕES DE REGISTROS: " + movimentacoesRegistros);
		recorderFile.println("TEMPO DE PROCESSAMENTO: " + tempoProcessamento);
		recorderFile.println("========================================");
	}
	
}
