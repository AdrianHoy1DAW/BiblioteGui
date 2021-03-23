package test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

import biblioteca.Biblioteca;
import libro.Ejemplar;
import libro.Libro;
import socio.Socio;

public class Test {

	public static void main(String[] args) {
		
		Biblioteca b = new Biblioteca();
		Socio socio = new Socio("Adrian","Hoyos","1");
		Libro libro = new Libro("Hola","Hola","2");
		Libro libro1 = new Libro("Adios","Manolo","2");
		Libro libro2 = new Libro("Mellizos","Juan","2");
		Libro libro3 = new Libro("Surima","Carlos","2");
		Libro libro4 = new Libro("Thiago","Hoyos","2");
		ArrayList<Libro> libros = b.getLibros();
		
		

		
		
		
		System.out.println(b);
		
		
		
	}

}
