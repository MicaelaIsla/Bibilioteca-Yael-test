package biblioteca;

import java.util.Arrays;

public class Biblioteca {
	private Libro[] libros;
	private int cantLibros = 0;
	
	public Biblioteca(int tam) {
		this.libros = new Libro[tam];
	}

	public void agregarLibro(Libro nuevo) {
		if(cantLibros >= this.libros.length)
			throw new Error("La biblioteca esta llena");
		this.libros[cantLibros] = nuevo;
		cantLibros++;
	}
	
	public Libro[] getLibros() {
		return this.libros;
	}
	
	public void ordenarPorPagina() {
		Arrays.sort(this.libros);
	}

	public void ordenarPorTitulo() {
		Arrays.sort(this.libros, new OrdenadorPorTitulo());
	}
}