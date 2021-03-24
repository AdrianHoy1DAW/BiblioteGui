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
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JButton;

public class VistaAnyadir extends JFrame {

	private JPanel contentPane;
	private JButton btnAadir;
	private JSpinner spinner;
	private JComboBox<Libro> comboBox;
	private DefaultComboBoxModel<Libro> dcm = new DefaultComboBoxModel<>();


	/**
	 * Create the frame.
	 */
	public VistaAnyadir() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(23, Short.MAX_VALUE))
		);
		panel_1.setLayout(new MigLayout("", "[79.00][85.00]", "[][][][]"));
		
		JLabel lblCuantosDeseasAadir = new JLabel("Cuantos Deseas Añadir");
		panel_1.add(lblCuantosDeseasAadir, "cell 0 0");
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1,1,100,1));
		panel_1.add(spinner, "cell 1 0,growx");
		
		btnAadir = new JButton("Añadir");
		panel_1.add(btnAadir, "cell 0 3");
		panel.setLayout(new MigLayout("", "[grow]", "[][][]"));
		
		JLabel lblDeQueLibro = new JLabel("De que Libro desea Añadir Ejemplares?");
		panel.add(lblDeQueLibro, "cell 0 0");
		
		comboBox = new JComboBox<Libro>();
		comboBox.setModel(dcm);
		panel.add(comboBox, "cell 0 2,growx");
		contentPane.setLayout(gl_contentPane);
		setTitle("Biblioteca Adrihosan-Recibir Ejemplares");
	}



	public JPanel getContentPane() {
		return contentPane;
	}



	public JButton getBtnAadir() {
		return btnAadir;
	}



	public JSpinner getSpinner() {
		return spinner;
	}



	public JComboBox<Libro> getComboBox() {
		return comboBox;
	}



	public DefaultComboBoxModel<Libro> getDcm() {
		return dcm;
	}
	
	
	
}
