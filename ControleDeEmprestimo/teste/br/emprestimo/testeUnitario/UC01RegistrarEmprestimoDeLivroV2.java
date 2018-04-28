package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

@RunWith(Parameterized.class)
public class UC01RegistrarEmprestimoDeLivroV2 {
	private ServicoEmprestimo servico;
	private Livro livro;
	private Usuario usuario;
	private boolean resultadoEsperado;

	@Before
	public void initialize() {
		servico = new ServicoEmprestimo();
	}
	// Each parameter should be placed as an argument here
	// Every time runner triggers, it will pass the arguments
	// from parameters we defined in primeNumbers() method

	public UC01RegistrarEmprestimoDeLivroV2(Livro umLivro, Usuario umUsuario, boolean resultadoEsperado) {
		this.livro = umLivro;
		this.usuario = umUsuario;
		this.resultadoEsperado = resultadoEsperado;
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() throws RuntimeException {
		return Arrays.asList(new Object[][] { 
			{ObtemLivro.comDadosValidos(), ObtemUsuario.comDadosValidos(), true },
			{ObtemLivro.comISBNInvalido_branco() , ObtemUsuario.comDadosValidos(), false }
		});
	}

	// This test will run 4 times since we have 5 parameters defined
	@Test
	public void CT01UC01RegistrarEmprestimo() {
		System.out.println("Parameterized Number is : ");
		assertEquals(resultadoEsperado, servico.empresta(livro, usuario).equals(null));
	}
}
