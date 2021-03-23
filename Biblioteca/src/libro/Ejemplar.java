package libro;


import java.io.Serializable;

import entrada.Entrada;
import socio.Socio;

public class Ejemplar implements Serializable {


	private int codigo;
	private Socio poseedor;
	private Libro l;
	
	
	
	public Ejemplar(int codigo, Libro l) {
		
		
		this.codigo = codigo;
		this.poseedor = null;
		this.l = l;
	
	}
	

	public void lend(Socio poseedor) {
		
		if(poseedor == null) {
			Entrada.Mensaje("Ese libro ya esta prestado");
		} else {
			this.poseedor = poseedor;
		}
	}
	
	public void giveBack() {
		
	
		this.poseedor = null;
		
		
	}
	


	public Socio getPoseedor() {
		return poseedor;
	}


	@Override
	public String toString() {
		return "Ejemplar [codigo=" + codigo + ", poseedor=" + poseedor + "]";
	}


	
	
	
	
	
	
	
}
