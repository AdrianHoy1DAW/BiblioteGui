package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.Biblioteca;
import entrada.Entrada;
import guardado.Guardado;
import libro.Libro;
import vista.VistaBiblioteca;
import vista.VistaLibro;
import vista.VistaTabla;

public class ControladorBiblioteca implements ActionListener{

	Biblioteca b = new Biblioteca();
	VistaBiblioteca vista;
	VistaLibro vistaLibro;
	VistaTabla vistaTabla;
	Guardado g = new Guardado();
	
	public ControladorBiblioteca(VistaBiblioteca vista) {
	
	
		this.vista = vista;
		
		inicializar();
	
		
		
	}
	
	private void inicializar() {
		
		// Iniciar Botones
		vista.getBtnRegistrarLibro().addActionListener(this);
		vista.getBtnMostrarLibro().addActionListener(this);
		
		// Añadir Comandos a los botones
		vista.getBtnRegistrarLibro().setActionCommand("AbrirRegistroLibro");
		vista.getBtnMostrarLibro().setActionCommand("MostrarLibro");
		
	}
	
	
	public  void go() {
		vista.setVisible(true);
//		vista.setVisible(true);
//		int eleccion = 0;
//		int eleccionOrdenacion = 0;
//		while(eleccion != 8) {
//			 eleccion = Entrada.Menu();
//			 switch(eleccion) {
//			 case 1:
//				 b.registerBook();
//				break;
//			 case 2:
//				 b.createAccount();
//				 break;
//			 case 3:
//				 Entrada.Mensaje(b.getLibros() + "Introduce el ISBN del libro que quieras alquilar");
//				 String ISBN = Entrada.pedirString();
//				 Entrada.Mensaje("Introduce tu DNI");
//				 String DNI = Entrada.pedirString();
//				 b.lendBook(b.buscarSocio(DNI), b.buscarLibro(ISBN));
//				 break;
//			 case 4:
//				 Entrada.Mensaje("Introduce tu DNI");
//				 DNI = Entrada.pedirString();
//				 b.giveBackBook(b.buscarSocio(DNI));
//				 break;
//			 case 5:
//				 if(b.getLibros().isEmpty()) {
//					 Entrada.Mensaje("No hay libros en esta biblioteca");
//				 } else {
//					 eleccionOrdenacion = Entrada.MenuLibro();
//					 if(eleccionOrdenacion == 1) {
//						b.getLibros().sort(b.getLibros().get(0).COMPARE_BY_EJEMPLARES);
//						Entrada.Mensaje("Estos son los libros que tenemos ordenados por número de ejemplares: " + b.getLibros());
//					 } else if(eleccionOrdenacion == 2) {
//						 b.getLibros().sort(b.getLibros().get(0).COMPARE_BY_TITULO);
//						 Entrada.Mensaje("Estos son los libros que tenemos ordenados por título: " + b.getLibros());
//					 } else if(eleccionOrdenacion == 3) {
//						 b.getLibros().sort(b.getLibros().get(0).COMPARE_BY_AUTOR);
//						 Entrada.Mensaje("Estos son los libros que tenemos ordenados por autor: " + b.getLibros());
//					 } else {
//						 Entrada.Mensaje("Estos son los libros que tenemos ordenados por defecto: " + b.getLibros());
//					 }
//				 }
//				 break;
//			 case 6:
//				 if(b.getSocios().isEmpty()) {
//					 Entrada.Mensaje("No hay socios registrados");
//				 } else {
//					 
//					 eleccionOrdenacion = Entrada.MenuSocio();
//					 if(eleccionOrdenacion == 1) {
//						 b.getSocios().sort(b.getSocios().get(0).COMPARE_BY_PRESTADOS);
//						 Entrada.Mensaje("Estos son los socios que tenemos ordenados por número de libros prestados: " + b.getSocios());
//					 } else if(eleccionOrdenacion == 2) {
//						 b.getSocios().sort(b.getSocios().get(0).COMPARE_BY_NOMBRE);
//						 Entrada.Mensaje("Estos son los socios ordenados por nombre: " + b.getSocios());
//					 } else {
//						 Entrada.Mensaje("Estos son los socios registrados ordenados por defecto: " + b.getSocios());
//					 }
//			 	}
//				 break;
//			 case 7:
//				 Entrada.Mensaje(b.getLibros() + "De que libro quieres añadir ejemplares?");
//				 ISBN = Entrada.pedirString();
//				 Entrada.Mensaje("Cuantos ejemplares recibimos");
//				 b.reciveEjemplares(Entrada.pedirInt(), b.buscarLibro(ISBN));
//				 break;
//		
//			 }
//			 
//		}
//		g.store(b);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		String comando = arg0.getActionCommand();
		
		if(comando.equals("AbrirRegistroLibro")) {
			
			AbrirRegistroLibro();
			
		} else if(comando.equals("RegistrarLibro")) {
			
			RegistrarLibro();
			
		} else if(comando.equals("MostrarLibro")) {
			
			MostrarLibro();
			
		} 
		
		
	}

	private void MostrarLibro() {
		
		vistaTabla = new VistaTabla();
		
		
		if(b.getLibros().isEmpty()) {
			JOptionPane.showMessageDialog(vistaTabla, "No hay libros","Error",JOptionPane.ERROR_MESSAGE);
		} else {
			
			for(Libro l : b.getLibros()) {
				vistaTabla.setVisible(true);
				vistaTabla.getDtm().addRow(new String[] {l.getTitulo(),l.getAutor(),l.getISBN(),String.valueOf(l.getEjemplares().size())});
			}
		}
		
	}

	private void RegistrarLibro() {
		
		
		boolean rellenado = true;
		for(Component c : vistaLibro.getPanel().getComponents()) {
			if(c instanceof JTextField) {
				if(((JTextField)c).getText().equals("")){
					rellenado = false;
				}
				
			}	
		}
		
		if(rellenado == false) {
			JOptionPane.showMessageDialog(vistaLibro, "Error rellena todos los campos", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			try {
				b.registerBook(vistaLibro.getTxtTitulo().getText(), vistaLibro.getTxtAutor().getText(), vistaLibro.getTxtIsbn().getText(), (Integer)vistaLibro.getSpinner().getValue());
				JOptionPane.showMessageDialog(vistaLibro, "Libro guardado correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
				
			} catch (Exception e) {
			
				JOptionPane.showMessageDialog(vistaLibro, "Ese libro ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
				
			}
			
			limpiarPanel(vistaLibro.getPanel());

		}
		
	}

	private void limpiarPanel(JPanel panel) {
		
		for(Component c : panel.getComponents()) {
			if(c instanceof JTextField) {
		
				((JTextField) c).setText("");
				
			}	
		}
		
	}

	private void AbrirRegistroLibro() {
		
		vistaLibro = new VistaLibro();
		vistaLibro.setVisible(true);
		
		vistaLibro.getBtnAnyadirLibro().addActionListener(this);
		
		
		vistaLibro.getBtnAnyadirLibro().setActionCommand("RegistrarLibro");
		
		
	}
	

	
}
