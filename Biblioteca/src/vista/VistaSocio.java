package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class VistaSocio extends JFrame {

	private JPanel contentPane;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JButton btnRegistrar;
	private JPanel panel;



	/**
	 * Create the frame.
	 */
	public VistaSocio() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 416, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		btnRegistrar = new JButton("Registrar");
		panel_1.add(btnRegistrar);
		panel.setLayout(new MigLayout("", "[248.00]", "[][][][][][]"));
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(lblDni, "cell 0 0");
		
		txtDni = new JTextField();
		panel.add(txtDni, "cell 0 1");
		txtDni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(lblNombre, "cell 0 2");
		
		txtNombre = new JTextField();
		panel.add(txtNombre, "cell 0 3,growx");
		txtNombre.setColumns(10);
		
		JLabel lblApellidos = new JLabel("Apellidos");
		lblApellidos.setFont(new Font("Dialog", Font.BOLD, 20));
		panel.add(lblApellidos, "cell 0 4");
		
		txtApellidos = new JTextField();
		panel.add(txtApellidos, "cell 0 5,growx");
		txtApellidos.setColumns(10);
		contentPane.setLayout(gl_contentPane);
		setTitle("Adrihosan Biblioteca - Registrar Socio");
	}



	public JPanel getContentPane() {
		return contentPane;
	}



	public JTextField getTxtDni() {
		return txtDni;
	}



	public JTextField getTxtNombre() {
		return txtNombre;
	}



	public JTextField getTxtApellidos() {
		return txtApellidos;
	}



	public JButton getBtnRegistrar() {
		return btnRegistrar;
	}



	public JPanel getPanel() {
		return panel;
	}
	
	
}
