package br.com.ns.q3;

import java.util.logging.Logger;

import org.junit.Test;

import br.com.ns.stream.test.Stream;
import br.com.ns.stream.test.StreamApp;
import br.com.ns.stream.test.StringStream;
import br.com.ns.stream.test.UniqueCharNotFoundException;
import junit.framework.Assert;

/**
 * Teste unitário para a implementação do algoritmo
 * 
 * @author almeida.fernando
 */
public class Q3TestCase {

	/**
	 * Logger.
	 */
	private static final Logger LOGGER = Logger.getLogger(Q3TestCase.class.getCanonicalName());

	/**
	 * Método genérico para auxílio aos testes.
	 */
	private char testFirstChar(Stream stream) throws UniqueCharNotFoundException {

		long time = System.currentTimeMillis();

		char c = StreamApp.firstFound(stream);

		LOGGER.info(String.format("Identificado primeiro caracter único '%s' com tempo de %d ms de execução.", c,
				(System.currentTimeMillis() - time)));

		return c;
	}

	/**
	 * Buscar caracter do exemplo.
	 */
	@Test
	public void buscarCaracter() {

		try {

			char c = testFirstChar(new StringStream("aAbBABacafe"));

			Assert.assertEquals('x', c);

		} catch (UniqueCharNotFoundException e) {
			Assert.fail(e.getLocalizedMessage());
		}

	}

}
