package br.com.ads.aa.main;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import br.com.ads.aa.arrangements.*;
import br.com.ads.aa.ordering.BubbleSort;

public class ApplicationBubbleSort {
	
	public static void main(String[] args) {

		try {
            System.out.println("INICIANDO A EXECUÇÃO DO BUBBLE SORT");
            run();
            System.out.println("FINALIZANDO A EXECUÇÃO DO BUBBLE SORT");
        } catch(Exception error) {
            System.out.println("ERROR AO CARREGAR ARQUIVO DE SAÍDA DOS RESULTADOS.");
        }
		
	}

	private static void run() throws IOException {

		FileWriter fileResult = new FileWriter("src/data/bubblesort.txt");
    	PrintWriter recorderFile = new PrintWriter(fileResult);

		int tamanho = 10;

		while(true) {
			
			recorderFile.printf("\n INÍCIO DO TAMANHO DA SEQUÊNCIA - %s", tamanho);

			recorderFile.println("\n\n--------| CASE VETOR ORDENADO |--------");
			BubbleSort.sort(VetorOrdenado.getSequencia(tamanho), recorderFile);
							
			recorderFile.println("----| VETOR INVERSAMENTO ORDENADO |----");
			BubbleSort.sort(VetorInversamenteOrdenado.getSequencia(tamanho), recorderFile);
	
			for(int i = 1; i < 6; i++) {
				recorderFile.printf("--| VETOR QUASE ORDENADO: CASE [%s] |-- %n", i);
				BubbleSort.sort(VetorQuaseOrdenado.getSequencia(tamanho), recorderFile);
			}
	
			for(int i = 1; i < 6; i++) {
				recorderFile.printf("-----| VETOR ALEATÓRIO: CASE [%s] |-----%n", i);
				BubbleSort.sort(VetorAleatorio.getSequencia(tamanho), recorderFile);
			}

			recorderFile.printf("TÉRMINO DO TAMANHO DA SEQUÊNCIA - %s", tamanho);

			if(tamanho == 1000000) {
				break;
			} else {
				tamanho *= 10;			// Aumentar tamanhno do vetor
			}
		}
	}
}
