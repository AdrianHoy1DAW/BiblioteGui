package libro;




import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import biblioteca.Biblioteca;
import entrada.Entrada;
import socio.Socio;


public class Libro implements Comparable<Libro>, Serializable {


	protected String titulo;
	protected String autor;
	protected String ISBN;
	private ArrayList<Ejemplar> ejemplares = new ArrayList<Ejemplar>();
	
	
	public static final Comparator COMPARE_BY_EJEMPLARES = new Comparator<Libro>() {
		
		@Override
		public int compare(Libro s0, Libro s1) {
			
			return s1.ejemplares.size() - s0.ejemplares.size();
			
		}
		
	};
	
	public static final Comparator COMPARE_BY_AUTOR = new Comparator<Libro>() {
		
		@Override
		public int compare(Libro s0, Libro s1) {
			
			return s0.autor.compareTo(s1.autor);
			
		}
		
	};
	
	public static final Comparator COMPARE_BY_TITULO = new Comparator<Libro>() {
		

		@Override
		public int compare(Libro l0, Libro l1) {
			
			return l0.titulo.compareTo(l1.titulo);
		}
		
	};
	
	
	
	
	public Libro(String titulo, String autor, String ISBN) {
		
		
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		
		
	}
	
	public Ejemplar prestarEjemplar() {
		Ejemplar e = null; 
		
		if(hayEjemplares() == true) {
			for(int i = 0; i<ejemplares.size(); i ++) {
				if(ejemplares.get(i).getPoseedor() == null){
					e = ejemplares.get(i);
				}
			}
		} else {
			return null;
		}

		
		return e;
		
	}
	
	public boolean hayEjemplares() {
		
		if(ejemplares.isEmpty()) {
			return false;
		} else {
			return true;
		}
		
	}

	public void añadirEjemplares(int cantidad) {
		
		for(int i = 0; i< cantidad; i++) {
			
			ejemplares.add(new Ejemplar(ejemplares.size() +1 ,this));
			
		}
		
	}

	public String getTitulo() {
		return titulo;
	}


	public String getAutor() {
		return autor;
	}


	public String getISBN() {
		return ISBN;
	}
	
	
	
	public ArrayList<Ejemplar> getEjemplares() {
		return ejemplares;
	}


	



	@Override
	public String toString() {
		return titulo;
	}

	@Override
	public int compareTo(Libro l) {
		
		return ISBN.compareTo(l.ISBN);
	}

}


	
	
	
	


	

	

