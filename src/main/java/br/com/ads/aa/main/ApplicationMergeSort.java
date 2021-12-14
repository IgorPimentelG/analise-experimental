package br.com.ads.aa.main;

import java.io.FileWriter;
import java.io.PrintWriter;

import br.com.ads.aa.arrangements.*;
import br.com.ads.aa.ordering.MergeSort;

public class ApplicationMergeSort {
  
    public static void main(String[] args) {

        try {
            System.out.println("INICIANDO A EXECUÇÃO DO MERGE SORT");
            run();
            System.out.println("FINALIZANDO A EXECUÇÃO DO MERGE SORT");
        } catch(Exception error) {
            System.out.println("ERROR AO CARREGAR ARQUIVO DE SAÍDA DOS RESULTADOS.");
        }
        
    }

    private static void run() throws Exception {

        FileWriter fileResult = new FileWriter("src/data/mergesort.txt");
    	PrintWriter recorderFile = new PrintWriter(fileResult);

        int tamanho = 10;

        while(true) {

            recorderFile.printf("\n INÍCIO DO TAMANHO DA SEQUÊNCIA - %s", tamanho);

            recorderFile.println("\n\n--------| CASE VETOR ORDENADO |--------");
            MergeSort.sort(VetorOrdenado.getSequencia(tamanho),  0, tamanho - 1, recorderFile);
                            
            recorderFile.println("----| VETOR INVERSAMENTO ORDENADO |----");
            MergeSort.sort(VetorInversamenteOrdenado.getSequencia(tamanho), 0, tamanho - 1, recorderFile);
    
            for(int i = 1; i < 6; i++) {
                recorderFile.printf("--| VETOR QUASE ORDENADO: CASE [%s] |-- %n", i);
                MergeSort.sort(VetorQuaseOrdenado.getSequencia(tamanho), 0, tamanho - 1, recorderFile);
            }
    
            for(int i = 1; i < 6; i++) {
                recorderFile.printf("-----| VETOR ALEATÓRIO: CASE [%s] |-----%n", i);
                MergeSort.sort(VetorAleatorio.getSequencia(tamanho), 0, tamanho - 1, recorderFile);
            }

            recorderFile.printf("TÉRMINO DO TAMANHO DA SEQUÊNCIA - %s", tamanho);

            if(tamanho == 1000000) {
                recorderFile.close();
                break;
            } else {
                tamanho *= 10;                     // Aumentar tamanho do vetor
            }
        }
    }

    
}
