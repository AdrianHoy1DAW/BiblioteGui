package controlador;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFileChooser;
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
		vista.getMntmOpen().addActionListener(this);
		vista.getMntmSave().addActionListener(this);
		
		// Añadir Comandos a los botones
		vista.getBtnRegistrarLibro().setActionCommand("AbrirRegistroLibro");
		vista.getBtnMostrarLibro().setActionCommand("MostrarLibro");
		vista.getBtnAnyadir().setActionCommand("AnyadirEjemplar");
		vista.getBtnRegistrarSocio().setActionCommand("AbrirRegistrarSocio");
		vista.getBtnMostrarSocios().setActionCommand("MostrarSocio");
		vista.getBtnAlquilar().setActionCommand("AbrirPrestarLibro");
		vista.getBtnDevolver().setActionCommand("AbrirDevolucion");
		vista.getMntmOpen().setActionCommand("Open");
		vista.getMntmSave().setActionCommand("Save");
	}
	
	
	public  void go() {
		vista.setVisible(true);
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
			
		} else if(comando.equals("Open")) {
			
			open();
			
		} else if(comando.equals("Save")) {
			
			save();
			
		}
		
		
	}



	private void Devolver() {
		
		Socio s = (Socio)vistaDevolver.getComboBoxSocios().getSelectedItem();
		Ejemplar e = (Ejemplar)vistaDevolver.getComboBoxEjemplares().getSelectedItem();
		
		if(ComprobarSocios() == true) {
			b.giveBackBook(s,e);
		}
		
		vistaDevolver.getBtnDevolver().setEnabled(false);
		
	}

	private boolean ComprobarSocios() {
		
		Socio s = (Socio)vistaDevolver.getComboBoxSocios().getSelectedItem();
		
		if(s.getPrestados().isEmpty()) {
			JOptionPane.showMessageDialog(vistaDevolver,"No tienes libros prestados","Informacion", JOptionPane.INFORMATION_MESSAGE);
			return false;
		} else {
			vistaDevolver.getDcme().removeAllElements();
			vistaDevolver.getDcme().addAll(((Socio)vistaDevolver.getComboBoxSocios().getSelectedItem()).getPrestados());
			vistaDevolver.getDcme().setSelectedItem(((Socio)vistaDevolver.getComboBoxSocios().getSelectedItem()).getPrestados().get(0));
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
	
	private void open() {
		
		JFileChooser jfc = new JFileChooser();
		int opcion = jfc.showOpenDialog(vista);
		
		if(opcion == JFileChooser.APPROVE_OPTION) {
			
			try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jfc.getSelectedFile()))) {
				
					
					b = (Biblioteca)ois.readObject();
			
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		

		
	}



	private void save() {
		
		JFileChooser jfc = new JFileChooser();
		int opcion = jfc.showSaveDialog(vista);
		
		if(opcion == JFileChooser.APPROVE_OPTION) {
			
			try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(jfc.getSelectedFile()))) {
				
				oos.writeObject(b);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}	
	}
	

	
}
