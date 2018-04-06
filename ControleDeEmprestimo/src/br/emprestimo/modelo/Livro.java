package br.emprestimo.modelo;


public class Livro {
	private String isbn;
	private String titulo;
	private String autor;
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		if (isbn == "" | isbn == null){
			throw new RuntimeException("ISBN invalido");
		}
		this.isbn = isbn;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		if (titulo == "" | titulo == null){
			throw new RuntimeException("Titulo invalido");
		}
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}

}
