package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Collection;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import br.emprestimo.modelo.Livro;

@RunWith(Parameterized.class)
public class UC06CadastrarLivroV2 {
	Livro umLivro;
	@Parameter
	public String isbn;
	@Parameter(1)
	public String titulo;
	@Parameter(2)
	public String autor;
	@Parameter(3)
	public String resultadoEsperado;

	@Before
	public void setup() {
		umLivro = new Livro();
	}

	@Parameters
	public static Collection<Object[]> dadosDeTeste() {
		return Arrays.asList(new Object[][] { 
			{ "1111", "Introducao ao Teste de Software", "Delamaro", "valido" },
			{ "", "Introducao ao Teste de Software", "Delamaro", "ISBN invalido" },
			{ "1111", "", "Delamaro", "Titulo invalido" }, 
			{ null, "", "Delamaro", "ISBN invalido" } 
		});
	}

	// Este teste sera executado n vezes de acordo com a quantidade de parametros
	// fornecidos
	@Test
	public void CT01UC06ValidaComportamentoDoCadastrarLivro() {
		// System.out.println("Caso de teste executado : " + resultadoEsperado);
		try {
			umLivro.setIsbn(isbn);
			umLivro.setTitulo(titulo);
			umLivro.setAutor(autor);
			assertTrue(resultadoEsperado.equals("valido"));
		} catch (Exception e) {
			assertTrue(resultadoEsperado.equals(e.getMessage()));
		}
	}
}
