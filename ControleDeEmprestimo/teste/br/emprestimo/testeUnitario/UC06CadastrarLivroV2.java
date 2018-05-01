package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.emprestimo.modelo.Livro;
import br.emprestimo.servico.ServicoEmprestimo;

public class UC06CadastrarLivroV2 {
	public static Livro livro;
	@Before
	public void initialize() {
		livro = new Livro();
	}

}
