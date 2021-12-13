package br.com.ads.aa.arrangements;


public abstract class VetorOrdenado {
	
	public static Integer[] getSequencia(Integer tamanho) {
		Integer[] vetor = new Integer[tamanho];
		generator(vetor);
		return vetor;
	}

	private static void generator(Integer[] vetor) {
		for(int i = 0; i < vetor.length; i++) {
			vetor[i] = i + 1;
		}
	}

	
}
