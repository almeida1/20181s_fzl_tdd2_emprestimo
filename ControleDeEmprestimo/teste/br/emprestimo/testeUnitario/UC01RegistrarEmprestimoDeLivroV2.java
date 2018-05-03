package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

import br.emprestimo.modelo.Emprestimo;
import br.emprestimo.modelo.Livro;
import br.emprestimo.modelo.Usuario;
import br.emprestimo.servico.ServicoEmprestimo;

@RunWith(Parameterized.class)
public class UC01RegistrarEmprestimoDeLivroV2 {
	private ServicoEmprestimo servico;
	private Livro livro;
	private Usuario usuario;
	private String resultadoEsperado;

	@Before
	public void initialize() {
		servico = new ServicoEmprestimo();
	}
	

	public UC01RegistrarEmprestimoDeLivroV2(Livro umLivro, Usuario umUsuario, String resultadoEsperado) {
		this.livro = umLivro;
		this.usuario = umUsuario;
		this.resultadoEsperado = resultadoEsperado;
	}

	@Parameterized.Parameters
	public static Collection primeNumbers() throws RuntimeException {
		return Arrays.asList(new Object[][] { 
			{ObtemLivro.comDadosValidos(), ObtemUsuario.comDadosValidos(), "valido" },
			{null , ObtemUsuario.comDadosValidos(), "invalido" },
			{ObtemLivro.comDadosValidos(), null, "invalido" }
		});
	}

	
	@Test
	public void CT01UC01ValidaComportamentoDoRegistroDeEmprestimo() {
		System.out.println("Caso de teste executado : " + resultadoEsperado);
		try {
			Emprestimo resultadoObtido = servico.empresta(livro, usuario);
			assertTrue(resultadoObtido.equals(ObtemEmprestimo.comDadosValidos()));
		}catch(Exception e) {
			assertTrue(resultadoEsperado.equals("invalido"));
		}
	}
}
