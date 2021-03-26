package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import libro.Ejemplar;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import socio.Socio;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaDevolver extends JFrame {

	private JPanel contentPane;
	private JComboBox<Socio> comboBoxSocios;
	private JButton btnComprobar;
	private JComboBox<Ejemplar> comboBoxEjemplares;
	private JButton btnDevolver;
	private DefaultComboBoxModel<Socio> dcms = new DefaultComboBoxModel<>();
	private DefaultComboBoxModel<Ejemplar> dcme = new DefaultComboBoxModel<>();


	/**
	 * Create the frame.
	 */
	public VistaDevolver() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 67, GroupLayout.PREFERRED_SIZE)
					.addGap(35)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(36)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 49, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		btnDevolver = new JButton("Devolver");
		panel_2.add(btnDevolver);
		panel_1.setLayout(new MigLayout("", "[grow]", "[][]"));
		
		JLabel lblEstosSonLos = new JLabel("Estos son los libros a tu disposicion");
		lblEstosSonLos.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_1.add(lblEstosSonLos, "cell 0 0");
		
		comboBoxEjemplares = new JComboBox<>();
		comboBoxEjemplares.setModel(dcme);
		panel_1.add(comboBoxEjemplares, "cell 0 1,growx");
		panel.setLayout(new MigLayout("", "[grow][]", "[][]"));
		
		JLabel lblPorFavorSelecciona = new JLabel("Por favor selecciona tu usuario");
		lblPorFavorSelecciona.setFont(new Font("Dialog", Font.BOLD, 15));
		panel.add(lblPorFavorSelecciona, "cell 0 0");
		
		comboBoxSocios = new JComboBox<>();
		comboBoxSocios.setModel(dcms);
		panel.add(comboBoxSocios, "cell 0 1,growx");
		
		btnComprobar = new JButton("Comprobar");
		panel.add(btnComprobar, "cell 1 1");
		contentPane.setLayout(gl_contentPane);
	}


	public JPanel getContentPane() {
		return contentPane;
	}


	public JComboBox<Socio> getComboBoxSocios() {
		return comboBoxSocios;
	}


	public JButton getBtnComprobar() {
		return btnComprobar;
	}


	public JComboBox<Ejemplar> getComboBoxEjemplares() {
		return comboBoxEjemplares;
	}


	public JButton getBtnDevolver() {
		return btnDevolver;
	}


	public DefaultComboBoxModel<Socio> getDcms() {
		return dcms;
	}


	public DefaultComboBoxModel<Ejemplar> getDcme() {
		return dcme;
	}
	
	
	
	

}
