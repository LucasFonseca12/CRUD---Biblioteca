package model;

public class Livro {
	
	private int id;
	private String titulo;
	private String autor;
	private String genero;
	private String idioma;
	private int quantidade;
	private int preco;
	
	public Livro() {
	}
	

	public Livro(String titulo, String autor, String genero, String idioma, int quantidade, int preco) {
		
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	public Livro(int id, String titulo, String autor, String genero, String idioma, int quantidade, int preco) {
		
		this.id = id;
		this.titulo = titulo;
		this.autor = autor;
		this.genero = genero;
		this.idioma = idioma;
		this.quantidade = quantidade;
		this.preco = preco;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getIdioma() {
		return idioma;
	}
	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getPreco() {
		return preco;
	}
	public void setPreco(int preco) {
		this.preco = preco;
	}
}