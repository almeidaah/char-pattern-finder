package br.com.ns.stream.test;

/**
 * Exceção lançada quando não for identificado caracter repetido.
 * 
 * @author almeida.fernando
 */
@SuppressWarnings("serial")
public class UniqueCharNotFoundException extends Exception {

	public UniqueCharNotFoundException() {
    	super("Caractere referente ao padrão não encontrado.");
    }
    
}
