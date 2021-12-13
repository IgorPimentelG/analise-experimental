package br.com.ads.aa.arrangements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import br.com.ads.aa.ordering.MergeSort;

public abstract class VetorQuaseOrdenado {

    
    public static Integer[] getSequencia(Integer tamanho) {
        return generator(tamanho);
    }


    private static Integer[] generator(Integer tamanho) {
		
		Random random = new Random();

		Set<Integer> aux = new HashSet<Integer>();

		while(aux.size() != tamanho) {
			int numero = random.nextInt();
			aux.add(numero);
		}

		Integer[] vetor = aux.toArray(new Integer[tamanho]);
	
        // Ordenar 30% do vetor
        Integer partOrdenada[] = Arrays.copyOfRange(vetor, 0, ((vetor.length * 30) / 100));
        MergeSort.mergeSort(partOrdenada, 0, (partOrdenada.length - 1));

        // Reoganizar o vetor com a parte ordenada
        for(int i = 0; i < partOrdenada.length; i++) {
            vetor[i] = partOrdenada[i];
        }

        return vetor;
	}

}
