package biblioteca;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;

import entrada.Entrada;
import libro.Ejemplar;
import libro.Libro;
import socio.Socio;

public class Biblioteca implements Serializable {

	private ArrayList<Libro> libros;
	private ArrayList<Socio> socios;
	
	public Biblioteca() {
		
		libros = new ArrayList<Libro>();
		socios = new ArrayList<Socio>();
		
		
	}

	public ArrayList<Libro> getLibros() {
		return libros;
	}

	public ArrayList<Socio> getSocios() {
		return socios;
	}
	
	public void lendBook(Socio socio, Libro libro) {
		
		if(socios.contains(socio) && libros.contains(libro)) {
			if(libro.hayEjemplares() == true) {
				if(libro.prestarEjemplar() != null) {
					Ejemplar e = libro.prestarEjemplar();
					socio.lend(e);
					e.lend(socio);
				} else {
					Entrada.Mensaje("No hay ejemplares disponibles en este momento");
				}
			} else {
				Entrada.Mensaje("No disponemos de ejemplares de ese libro en ese momento");
			}
		} else if(!socios.contains(socio)) {
			Entrada.Mensaje("Para pedir prestado un libro necesitas estar registrado");
		} else {
			Entrada.Mensaje("No disponimos de ese libro");
		}
		
	}
	
	public void giveBackBook(Socio socio) {
		
		socio.giveBack();
		
	}

	public void createAccount() {
		String nombre ;
		String apellidos;
		String DNI;
		
		Entrada.Mensaje("Introduce tu nombre de usuario");
		nombre = Entrada.pedirString();
		Entrada.Mensaje("Introduce tus apellidos");
		apellidos = Entrada.pedirString();
		Entrada.Mensaje("Introduce tu DNI");
		DNI = Entrada.pedirString();
		while(comprobarDNI(DNI) == false) {
			Entrada.Mensaje("Ese DNI ya esta en la base de datos");
			DNI = Entrada.pedirString();
		}
		socios.add(new Socio(nombre , apellidos, DNI));
		
	}
	
	public void logIn(Socio socio) {
		
		socios.add(socio);
		
	}
	
	public void addBook(Libro libro) {
		libros.add(libro);
	}
	
	public void registerBook(String titulo,String autor,String ISBN,int ejemplos) throws Exception {
		
		
		if(buscarLibro(ISBN) != null) {
			throw new Exception("Ese libro ya se encuentra");
		} else {
			libros.add(new Libro(titulo, autor, ISBN));
			reciveEjemplares(ejemplos,buscarLibro(ISBN));
		}
		
	
	}
	
	
	
	public void reciveEjemplares(int cantidad, Libro libro) {
		
		if(libros.contains(libro)) {
			libro.añadirEjemplares(cantidad);
		}
		
	}
	
	public boolean comprobarISBN(String ISBN) {
		
		int i = 0;
		if(libros.isEmpty()) {
			return true;
		} else  {
			while(i < libros.size()) {
				if(libros.get(i).getISBN() == ISBN) {
					return false;
				}
				i ++;
			}
		}
		
		return true;
		
	}
	
	public boolean comprobarDNI(String DNI) {
		
		int i = 0;
		if(socios.isEmpty()) {
			return true;
		} else  {
			while(i < socios.size()) {
				if(socios.get(i).getDNI() == DNI) {
					return false;
				}
				i ++;
			}
		}
		
		return true;
		
	}

	
	public Libro buscarLibro(String busqueda) {
		Libro l = null;
		if(libros.isEmpty()) {
			
			return null;
		} else {
			for(int i = 0; i < libros.size() ; i++) {
				if(libros.get(i).getISBN().compareTo(busqueda) == 0) {
					l = libros.get(i);
					
				}
			}
		}

		return l;
		
	}
	
	public Socio buscarSocio(String busqueda) {
		
		Socio s = null;
		if(socios.isEmpty()) {
			Entrada.Mensaje("Esa cuenta no esta creada");
			return null;
		} else {
			for(int i = 0; i < socios.size() ; i++) {
				if(socios.get(i).getDNI().compareTo(busqueda) == 0) {
					s = socios.get(i);
					
				}
			}
		}
		if(s == null ) {
			Entrada.Mensaje("Ese usuario no existe");
		}
		return s;
		
	}
	

	@Override
	public String toString() {
		return "Biblioteca [libros=" + libros + "\n" + ", socios=" + socios + "]";
	}
	
	
	
}
