package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import libro.Libro;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import socio.Socio;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class VistaPrestar extends JFrame {

	private JPanel contentPane;
	private JComboBox<Libro> comboBoxLibro;
	private JButton btnComprobar;
	private JButton btnPrestar;
	private JComboBox<Socio> comboBoxSocio;
	private DefaultComboBoxModel<Libro> dcml = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Socio> dcms = new DefaultComboBoxModel<>();


	/**
	 * Create the frame.
	 */
	public VistaPrestar() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[321.00,grow][]", "[][][][][][]"));
		
		JLabel lblLibroQueQuieres = new JLabel("Libro que quieres prestar");
		lblLibroQueQuieres.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblLibroQueQuieres, "cell 0 0");
		
		comboBoxLibro = new JComboBox<Libro>();
		comboBoxLibro.setModel(dcml);
		contentPane.add(comboBoxLibro, "cell 0 1,growx");
		
		btnComprobar = new JButton("Comprobar");
		contentPane.add(btnComprobar, "cell 1 1");
		
		JLabel lblQuienVaA = new JLabel("Quien va a adquirir este libro");
		lblQuienVaA.setFont(new Font("Dialog", Font.BOLD, 18));
		contentPane.add(lblQuienVaA, "cell 0 2");
		
		comboBoxSocio = new JComboBox<Socio>();
		comboBoxSocio.setModel(dcms);
		contentPane.add(comboBoxSocio, "cell 0 3,growx");
		
		btnPrestar = new JButton("Prestar");
		contentPane.add(btnPrestar, "cell 0 5");
		setTitle("Adrihosan Biblioteca - Prestar Libro");
	}


	public JPanel getContentPane() {
		return contentPane;
	}


	public JComboBox<Libro> getComboBoxLibro() {
		return comboBoxLibro;
	}


	public JButton getBtnComprobar() {
		return btnComprobar;
	}


	public JButton getBtnPrestar() {
		return btnPrestar;
	}


	public JComboBox<Socio> getComboBoxSocio() {
		return comboBoxSocio;
	}


	public DefaultComboBoxModel<Libro> getDcml() {
		return dcml;
	}


	public DefaultComboBoxModel<Socio> getDcms() {
		return dcms;
	}
	
	
	
	

}
