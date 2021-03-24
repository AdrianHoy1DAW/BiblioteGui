package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import biblioteca.Biblioteca;
import entrada.Entrada;
import guardado.Guardado;
import libro.Ejemplar;
import libro.Libro;
import socio.Socio;
import vista.VistaAnyadir;
import vista.VistaBiblioteca;
import vista.VistaDevolver;
import vista.VistaLibro;
import vista.VistaPrestar;
import vista.VistaSocio;
import vista.VistaTabla;

public class ControladorBiblioteca implements ActionListener{

	Biblioteca b = new Biblioteca();
	VistaBiblioteca vista;
	VistaLibro vistaLibro;
	VistaTabla vistaTabla;
	VistaAnyadir vistaAnyadir;
	VistaSocio vistaSocio;
	VistaPrestar vistaPrestar;
	VistaDevolver vistaDevolver;
	Guardado g = new Guardado();
	
	public ControladorBiblioteca(VistaBiblioteca vista) {
	
	
		this.vista = vista;
		
		inicializar();
	
		
		
	}
	
	private void inicializar() {
		
		// Iniciar Botones
		vista.getBtnRegistrarLibro().addActionListener(this);
		vista.getBtnMostrarLibro().addActionListener(this);
		vista.getBtnAnyadir().addActionListener(this);
		vista.getBtnRegistrarSocio().addActionListener(this);
		vista.getBtnMostrarSocios().addActionListener(this);
		vista.getBtnAlquilar().addActionListener(this);
		vista.getBtnDevolver().addActionListener(this);
		
		// Añadir Comandos a los botones
		vista.getBtnRegistrarLibro().setActionCommand("AbrirRegistroLibro");
		vista.getBtnMostrarLibro().setActionCommand("MostrarLibro");
		vista.getBtnAnyadir().setActionCommand("AnyadirEjemplar");
		vista.getBtnRegistrarSocio().setActionCommand("AbrirRegistrarSocio");
		vista.getBtnMostrarSocios().setActionCommand("MostrarSocio");
		vista.getBtnAlquilar().setActionCommand("AbrirPrestarLibro");
		vista.getBtnDevolver().setActionCommand("AbrirDevolucion");
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
			
		} else if(comando.equals("AnyadirEjemplar")) {
			
			AnyadirEjemplar();
			
		} else if(comando.equals("Anyadir")) {
			
			Anyadir();
			
		} else if(comando.equals("AbrirRegistrarSocio")) {
			
			AbrirRegistroSocio();
			
		} else if(comando.equals("RegistrarSocio")) {
			
			RegistroSocio();
			
		} else if(comando.equals("MostrarSocio")) {
			
			MostrarSocio();
			
		} else if(comando.equals("AbrirPrestarLibro")) {
			
			AbrirPrestarLibro();
			
		} else if(comando.equals("Comprobar")) {
			
			Comprobar();
			
		} else if(comando.equals("Prestar")) {
			
			Prestar();
			
		} else if(comando.equals("AbrirDevolucion")) {
			
			AbrirDevolucion();
			
		} else if(comando.equals("ComprobarSocios")) {
			
			ComprobarSocios();
			
		} else if(comando.equals("Devolver")) {
			
			Devolver();
			
		}
		
		
	}



	private void Devolver() {
		
		Socio s = (Socio)vistaDevolver.getComboBoxSocios().getSelectedItem();
		Ejemplar e = (Ejemplar)vistaDevolver.getComboBoxEjemplares().getSelectedItem();
		
		b.giveBackBook(s);
		
	}

	private boolean ComprobarSocios() {
		
		Socio s = (Socio)vistaDevolver.getComboBoxSocios().getSelectedItem();
		
		if(s.getPrestados().isEmpty()) {
			JOptionPane.showMessageDialog(vistaDevolver,"No tienes libros prestados","Informacion", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			vistaDevolver.getDcme().addAll();
			vistaDevolver.getBtnDevolver().setEnabled(true);
			return true;
		}
		
	}

	private void AbrirDevolucion() {
		
		vistaDevolver = new VistaDevolver();
		
		if(b.getLibros().isEmpty()) {
			JOptionPane.showMessageDialog(vista, "No hay libros en la biblioteca", "Error", JOptionPane.ERROR_MESSAGE);
		} else if(b.getSocios().isEmpty()) {
			JOptionPane.showMessageDialog(vista, "No hay socios en la registrados", "Error", JOptionPane.ERROR_MESSAGE); 
		} else {
			
			vistaDevolver.setVisible(true);
			vistaDevolver.getDcms().addAll(b.getSocios());
			vistaDevolver.getDcms().setSelectedItem(b.getSocios().get(0));
			vistaDevolver.getBtnDevolver().setEnabled(false);
			
			vistaDevolver.getBtnComprobar().addActionListener(this);
			vistaDevolver.getBtnDevolver().addActionListener(this);
			
			vistaDevolver.getBtnComprobar().setActionCommand("ComprobarSocios");
			vistaDevolver.getBtnDevolver().setActionCommand("Devolver");
		}
		
	}

	private void Prestar() {
		
		Libro l = (Libro) vistaPrestar.getComboBoxLibro().getSelectedItem();
		Socio s = (Socio) vistaPrestar.getComboBoxSocio().getSelectedItem();
		
		try {
			if(Comprobar() == true)
				b.lendBook(s, l);
				
		} catch (Exception e) {
			
			JOptionPane.showMessageDialog(vistaPrestar, "No puedes alquilar más de tres libros", "Informacion", JOptionPane.INFORMATION_MESSAGE);
		}
		vistaPrestar.getBtnPrestar().setEnabled(false);
		
	}

	private boolean Comprobar() {
		
		
		Libro l = (Libro) vistaPrestar.getComboBoxLibro().getSelectedItem();
		
		if(b.comprobarEjemplares(l) == false) {
			JOptionPane.showMessageDialog(vistaPrestar,"No hay ejemplares de ese libro disponibles","Error", JOptionPane.ERROR_MESSAGE);
			vistaPrestar.getBtnPrestar().setEnabled(false);
			return false;
		} else {
			vistaPrestar.getBtnPrestar().setEnabled(true);
			return true;
		}
		
	}

	private void AbrirPrestarLibro() {
		
		vistaPrestar = new VistaPrestar();
		
		if(b.getLibros().isEmpty()) {
			JOptionPane.showMessageDialog(vista, "No hay libros en la biblioteca", "Error", JOptionPane.ERROR_MESSAGE);
		} else if(b.getSocios().isEmpty()) {
			JOptionPane.showMessageDialog(vista, "No hay socios en la registrados", "Error", JOptionPane.ERROR_MESSAGE);
		} else {
			vistaPrestar.setVisible(true);
			vistaPrestar.getDcml().addAll(b.getLibros());
			vistaPrestar.getDcms().addAll(b.getSocios());
			vistaPrestar.getDcml().setSelectedItem(b.getLibros().get(0));
			vistaPrestar.getDcms().setSelectedItem(b.getSocios().get(0));
			vistaPrestar.getBtnPrestar().setEnabled(false);
			
			vistaPrestar.getBtnComprobar().addActionListener(this);
			vistaPrestar.getBtnPrestar().addActionListener(this);
			
			vistaPrestar.getBtnComprobar().setActionCommand("Comprobar");
			vistaPrestar.getBtnPrestar().setActionCommand("Prestar");
		}
		
	}

	private void MostrarSocio() {
		
		vistaTabla = new VistaTabla();
		
		
		if(b.getSocios().isEmpty()) {
			JOptionPane.showMessageDialog(vistaTabla, "No hay socios","Error",JOptionPane.ERROR_MESSAGE);
		} else {
			vistaTabla.setVisible(true);
			vistaTabla.getDtm().addColumn("Nombre");
			vistaTabla.getDtm().addColumn("Apellidos");
			vistaTabla.getDtm().addColumn("DNI");
			for(Socio s : b.getSocios()) {
	
				vistaTabla.getDtm().addRow(new String[] {s.getNombre(),s.getApellidos(),s.getDNI()});
			}
		}
		
	}

	private void RegistroSocio() {
		
		boolean rellenado = true;
		for(Component c : vistaSocio.getPanel().getComponents()) {
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
				b.createAccount(vistaSocio.getTxtNombre().getText(), vistaSocio.getTxtApellidos().getText(), vistaSocio.getTxtDni().getText());
				JOptionPane.showMessageDialog(vistaLibro, "Cuenta creada con éxito", "Información", JOptionPane.INFORMATION_MESSAGE);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(vistaLibro, "Ese DNI ya esta registrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		limpiarPanel(vistaSocio.getPanel());
		
	}

	private void AbrirRegistroSocio() {
		
		vistaSocio = new VistaSocio();
		vistaSocio.setVisible(true);
		vistaSocio.getBtnRegistrar().addActionListener(this);
		vistaSocio.getBtnRegistrar().setActionCommand("RegistrarSocio");

		
	}

	private void Anyadir() {
		
		
		b.reciveEjemplares((int)vistaAnyadir.getSpinner().getValue(), b.buscarLibro(((Libro) vistaAnyadir.getComboBox().getSelectedItem()).getISBN()));
		JOptionPane.showMessageDialog(vistaAnyadir, "Se han recibido ejemplares correctamente","Informacion", JOptionPane.INFORMATION_MESSAGE);
		
	}

	private void AnyadirEjemplar() {
		
		if(b.getLibros().isEmpty()) {
			JOptionPane.showMessageDialog(vistaTabla, "No hay libros","Error",JOptionPane.ERROR_MESSAGE);
		} else {
			vistaAnyadir = new VistaAnyadir();
			vistaAnyadir.getDcm().addAll(b.getLibros());
			vistaAnyadir.setVisible(true);
			vistaAnyadir.getDcm().setSelectedItem(b.getLibros().get(0));
			vistaAnyadir.getBtnAadir().addActionListener(this);
			vistaAnyadir.getBtnAadir().setActionCommand("Anyadir");
		}

		
		
		
	}

	private void MostrarLibro() {
		
		vistaTabla = new VistaTabla();
		
		
		if(b.getLibros().isEmpty()) {
			JOptionPane.showMessageDialog(vistaTabla, "No hay libros","Error",JOptionPane.ERROR_MESSAGE);
		} else {
			vistaTabla.setVisible(true);
			vistaTabla.getDtm().addColumn("Titulo");
			vistaTabla.getDtm().addColumn("Autor");
			vistaTabla.getDtm().addColumn("ISBN");
			vistaTabla.getDtm().addColumn("Ejemplares");
			for(Libro l : b.getLibros()) {

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
