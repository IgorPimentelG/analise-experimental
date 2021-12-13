package br.com.ads.aa.arrangements;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public abstract class VetorAleatorio {
	
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
		return vetor;
	}
	
}
