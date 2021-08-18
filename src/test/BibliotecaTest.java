package test;
import static org.junit.Assert.*;
import java.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import biblioteca.Biblioteca;
import biblioteca.Genero;
import biblioteca.Libro;
public class BibliotecaTest {
	Biblioteca b;
	Libro l0;
	Libro l1;
	Libro l2;
	Libro l3;
	
	@Before
	public void setup() {
		b = new Biblioteca(4);
		l0 = new Libro("Pepe", "Titulo1", 250, 2018, Genero.AUTOAYUDA);
		l1 = new Libro("Alfonsina", "AA", 200, 2015, Genero.DIVULGACION);
		l2 = new Libro("Jose", "ZZ", 50, 2020, Genero.INFANTIL);
		l3 = new Libro("Camila", "Taaa", 350, 2008, Genero.FICCION);
	}
	
	@Test
	public void creacion() {
		assertNotNull(b);
		assertEquals(4, b.getLibros().length);
	}
	
	@Test
	public void agregarLibros() {
		b.agregarLibro(l0);
		b.agregarLibro(l1);
		assertNotNull(b.getLibros()[0]);
		assertNotNull(b.getLibros()[1]);
		assertNull(b.getLibros()[2]);
	}
	
	@Test
	public void ordenarPorPagina() {
		b.agregarLibro(l0);
		b.agregarLibro(l1);
		b.agregarLibro(l2);
		b.agregarLibro(l3);
		
		Libro[] esperado = {l3, l0, l1, l2};
		b.ordenarPorPagina();
		assertArrayEquals(esperado, b.getLibros());
	}

	@Test
	public void ordenarPorTitulo() {
		b.agregarLibro(l0);
		b.agregarLibro(l1);
		b.agregarLibro(l2);
		b.agregarLibro(l3);
		
		Libro[] esperado = {l1, l3, l0, l2};
		b.ordenarPorTitulo();
		System.out.println(Arrays.toString(b.getLibros()));
		assertArrayEquals(esperado, b.getLibros());
	}
}