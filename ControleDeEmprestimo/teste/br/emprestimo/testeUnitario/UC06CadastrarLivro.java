package br.emprestimo.testeUnitario;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.emprestimo.modelo.Livro;
public class UC06CadastrarLivro {
	public static Livro livro;
   
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		livro = ObtemLivro.comDadosValidos();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test(expected = RuntimeException.class)
	public void CT01UC06CadastrarLivro_com_isbn_invalido_branco() {
		livro.setIsbn("");
	}

	@Test(expected = RuntimeException.class)
	public void CT02UC06CadastrarLivro_com_isbn_invalido_nulo() {
		livro.setIsbn(null);
	}
	

	@Test
	public void CT03UC06CadastrarLivro_com_isbn_valido() {
		assertEquals("121212", livro.getIsbn());
	}
	@Test
	public void CT04UC01CadastrarLivro_com_isbn_invalido(){
		try{
			livro.setIsbn("");
			fail ("deveria lan�ar uma exce��o");
		}catch(RuntimeException e){
			assertEquals("ISBN invalido", e.getMessage());
		}
	}
}





