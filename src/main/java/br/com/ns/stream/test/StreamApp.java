package br.com.ns.stream.test;

import java.util.Arrays;

public class StreamApp {

	static char[] vogals = { 'a', 'e', 'i', 'o', 'u' };
	static char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v',
			'x', 'w', 'y', 'z' };

	/**
	 * Dada uma stream, encontre o primeiro caractere Vogal, após uma consoante,
	 * onde a mesma é antecessora a uma vogal e que não se repita no resto da
	 * stream.
	 * 
	 * O termino da leitura da stream deve ser garantido através do método
	 * hasNext(), ou seja, retorna falso para o termino da leitura da stream. V
	 * oce tera acesso a leitura da stream através dos métodos de interface
	 * fornecidos.
	 * 
	 * @param input
	 *            Stream a ser analisado.
	 * @return primeiro caracter que se enquadra nas regras propostas
	 * @throws CharNotFoundException
	 *             Exceção indicando que não foi encontrado cenário que
	 *             atendesse o requisito.
	 */
	public static char firstFound(Stream input) throws UniqueCharNotFoundException {

		//init
		char c;
		int size = 5;
		int indexFound, matchIndex = 0;
		
		char previousCharacter = '1';

		// Array dos caracters encontrados que enquadram-se nas regras propostasna stream
		char[] matchChars = new char[size];

		// Array de controle, que indica se a quantidade dos caracteres repetidos
		short[] quantidadeMatchedRepetidos = new short[size];

		
		while (input.hasNext()) {

			//get caracter atual
			c = input.getNext();
			
			if (isVogal(c)) {
				if (isConsonant(previousCharacter)) {
					if (isVogal(input.getPrevious(2))) {
						
						indexFound = indexOf(c, matchChars);

						if(indexFound >= 0){
							quantidadeMatchedRepetidos[indexFound]++;
						}else{
							matchChars[matchIndex] = c;
							quantidadeMatchedRepetidos[matchIndex]++;
							matchIndex++;
						}
					}
				}
			}

			// Redimensionar array quando necessário
			if (matchIndex == matchChars.length) {
				matchChars = Arrays.copyOf(matchChars, matchChars.length + size);
				quantidadeMatchedRepetidos = Arrays.copyOf(quantidadeMatchedRepetidos, matchChars.length + size);
			}
			
			previousCharacter = c;

		}

		return indexOfFirstNotRepeated(quantidadeMatchedRepetidos, matchChars);

	}

	
	private static char indexOfFirstNotRepeated(short[] quantidadeCharsRepetidos, char[] matchChars) throws UniqueCharNotFoundException {
		for (int i = 0; i < quantidadeCharsRepetidos.length; i++) {
			if (quantidadeCharsRepetidos[i] == 1) {
				return matchChars[i];
			}
		}
		throw new UniqueCharNotFoundException();
	}


	/**
	 * Pesquisa do caracter no array.
	 * 
	 * @param c
	 *            Caracter a ser pesquisado.
	 * @param chars
	 *            Array com os caracters.
	 * @return Posição identificada.
	 */
	private static int indexOf(char c, char[] chars) {
		for (int i = 0; i < chars.length; i++) {
			if (c == chars[i]) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Verifica se o caractere atual é uma vogal
	 * 
	 * @param c
	 *            - Caracter a ser pesquisado.
	 * @return se é vogal ou não
	 */
	private static boolean isVogal(char c) {
		for (int i = 0; i < vogals.length; i++) {
			if (Character.toUpperCase(c) == Character.toUpperCase(vogals[i])) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Verifica se o caractere atual é uma consoante
	 * 
	 * @param cpreviousCharacter
	 *            - caractere anterior ao atual da stream
	 * @return se é consoante ou não
	 */
	private static boolean isConsonant(char previousCharacter) {
		for (int i = 0; i < consonants.length; i++) {
			if (Character.toUpperCase(previousCharacter) == Character.toUpperCase(consonants[i])) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		StringStream s = new StringStream("aAbBABacafe");
		try {
			char foundChar = StreamApp.firstFound(s);
			System.out.println("Char encontrado : " + foundChar);
		} catch (UniqueCharNotFoundException e) {
			System.out.println("Char não encontrado");
		}
	}

}
