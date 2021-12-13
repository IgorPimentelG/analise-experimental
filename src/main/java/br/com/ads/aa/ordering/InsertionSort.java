package br.com.ads.aa.ordering;

import java.io.PrintWriter;

public abstract class InsertionSort {
		
	public static void sort(Integer vetor[], PrintWriter recorderFile) {

		long comparacoesChaves = 0;
		long movimentacoesRegistros = 0;
		long tempoProcessamento = 0;
		
		long tempoInicial = System.nanoTime();								// Tempo inicial da execução

		/*
		* Considerar que o primeiro índice do vetor é a subsequência 
		* ordenada do vetor
		*/
		for(int i = 1; i < vetor.length - 1; i++) {							
			
			int j = i;
		
			/*
			* Percorrer a parte ordenada do vetor
			*/
			comparacoesChaves += 1;
			while(j > 0 && vetor[j] < vetor[j - 1]) {				
				int aux = vetor[j];
				vetor[j] = vetor[j - 1];
				vetor[j - 1] = aux;
				j--;

				comparacoesChaves += 1;
				movimentacoesRegistros += 3;
			}

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
