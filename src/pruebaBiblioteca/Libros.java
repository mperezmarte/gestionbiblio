package pruebaBiblioteca;

public class Libros {
	

	private int isbn;
	private String autor;
	private String titulo;
	private int stock;
	
	Libros(){
		isbn=0;
		autor = " ";
		titulo= " ";
		stock=0;
	}
	
	Libros( int isbn, String autor, String titulo, int stock){
		isbn=0;
		autor = " ";
		titulo= " ";
		stock=0;
	}
	
	Libros(String[] listaLibros){
		this.isbn= Integer.parseInt(listaLibros[0]);
		this.autor=listaLibros[2];
		this.titulo=listaLibros[1];
		this.stock=Integer.parseInt(listaLibros[3]);
	}


	public int getIsbn() {
		return isbn;
	}

	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public String toString() {
		return 
			"Titulo:" + getTitulo() +  " escrito por " + getAutor() 
			+"\nISBN: " +   getIsbn() 
			+ "\nStock " + getStock() +"\n";
	}

}
