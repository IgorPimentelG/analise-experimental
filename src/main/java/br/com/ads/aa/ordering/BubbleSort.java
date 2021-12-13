package br.com.ads.aa.ordering;

import java.io.PrintWriter;

public abstract class BubbleSort {

	public static void sort(Integer vetor[], PrintWriter recorderFile) {
		
		long comparacoesChaves = 0;
		long movimentacoesRegistros = 0;
		long tempoProcessamento = 0;
		
		long tempoInicial = System.nanoTime();								// Tempo inicial da execução
		for(int i = 0; i < vetor.length; i++) {
			
			/*
			* Considerar inicialmente o vetor já ordenado, para evitar executar o laço for 
			* varias vezes depois que o vetor já estiver ordenado.
			*/
			boolean ordenado = true;
			
			/*
			* [vetor.length - 1 - i] evita comparações com os últimos números que já 
			* estão ordenados
			*/
			for(int j = 0; j < vetor.length - 1 - i; j++) {

				comparacoesChaves += 1;

				if(vetor[j] > vetor[j + 1]) {
					int aux = vetor[j];
					vetor[j] = vetor[j + 1];
					vetor[j + 1] = aux;
					ordenado = false;										// Considerar que o vetor não está ordenado

					movimentacoesRegistros += 3;
			
				}
			}
			
			if(ordenado) {													// Interrompe a execução quando o vetor está ordenado
				break;
			}
		}
		long tempoFinal = System.nanoTime();								// Tempo final da execução

		tempoProcessamento = tempoFinal - tempoInicial;

		recorderFile.println("========================================");
		recorderFile.printf("TOTAL COMPARAÇÕES DE CHAVES: %s %n", comparacoesChaves);
		recorderFile.printf("TOTAL MOVIMENTAÇÕES DE REGISTROS: %s %n", movimentacoesRegistros);
		recorderFile.printf("TEMPO DE PROCESSAMENTO: %s %n", tempoProcessamento);
		recorderFile.println("========================================\n");
		
	}
	
}
