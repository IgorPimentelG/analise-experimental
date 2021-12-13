package br.com.ads.aa.arrangements;

public class VetorInversamenteOrdenado {
	
	public static Integer[] getSequencia(Integer tamanho) {
		Integer[] vetor = new Integer[tamanho];
		generator(vetor);
		return vetor;
	}
	
	private static void generator(Integer[] vetor) {
		Integer index = 0;
		for(int i = vetor.length; i > 0; i--) {
			vetor[index] = i;
			index++;
		}
	}

}
