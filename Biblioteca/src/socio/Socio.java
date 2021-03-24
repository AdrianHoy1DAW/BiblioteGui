package socio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;

import entrada.Entrada;
import libro.Ejemplar;


public class Socio implements Comparable<Socio>, Serializable{

	private String nombre;
	private String apellidos;
	private String DNI;
	private ArrayList<Ejemplar> prestados;
	private static int cantidadMaxima = 3;
	
	public static final Comparator COMPARE_BY_PRESTADOS = new Comparator<Socio>() {
		
		@Override
		public int compare(Socio s0, Socio s1) {
			
			return s0.prestados.size() - s1.prestados.size();
			
		}
		
	};
	
	public static final Comparator COMPARE_BY_NOMBRE = new Comparator<Socio>() {
		
		@Override
		public int compare(Socio s0, Socio s1) {
			
			return s0.nombre.compareTo(s1.nombre);
			
		}
		
	};
	
	public Socio(String nombre, String apellidos, String DNI) {
		
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.DNI = DNI;
		prestados = new ArrayList<Ejemplar>();
		
	}
	
	public void lend(Ejemplar libro) throws Exception {
		
		if(prestados.size() >= cantidadMaxima) {
			throw new Exception("No puedes alquilar mas de tres libros");
		} else {
			prestados.add(libro);
		}
		
	}
	
	public void giveBack() {
		if(prestados.isEmpty()) {
			Entrada.Mensaje("No tienes libros prestados");	
		} else {
			Entrada.Mensaje("Que libro quieres devolver: " + prestados);
			int numero = Entrada.pedirInt();
			if(numero > prestados.size()) {
				Entrada.Mensaje("No tienes tantos libros");
				
			} else {
				prestados.get(numero -1).giveBack();
				prestados.remove(numero -1);
				
			}

			
		}

		
	}
	

	
	
	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getDNI() {
		return DNI;
	}

	public ArrayList<Ejemplar> getPrestados() {
		return prestados;
	}

	@Override
	public int compareTo(Socio p) {
		return DNI.compareTo(p.DNI);
	}

	@Override
	public String toString() {
		return nombre;
	}
	
	
	
}
