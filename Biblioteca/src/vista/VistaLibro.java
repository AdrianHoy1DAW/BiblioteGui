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
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class VistaLibro extends JFrame {

	private JPanel contentPane;
	private JTextField txtIsbn;
	private JTextField txtTitulo;
	private JLabel lblAutor;
	private JTextField txtAutor;
	private JLabel lblEjemplares;
	private JPanel panel_1;
	private JButton btnAnyadirLibro;
	private JSpinner spinner;
	private JLabel lblAdrihosanBibliotecas;
	private JPanel panel;



	/**
	 * Create the frame.
	 */
	public VistaLibro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 373);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Registrar Libro Adrihosan Biblioteca");
		
		panel = new JPanel();
		
		panel_1 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 566, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnAnyadirLibro = new JButton("Añadir Libro");
		panel_1.add(btnAnyadirLibro);
		panel.setLayout(new MigLayout("", "[317.00,grow][64.00][75.00]", "[][][][][][][][]"));
		
		lblAdrihosanBibliotecas = new JLabel("Adrihosan Bibliotecas");
		lblAdrihosanBibliotecas.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblAdrihosanBibliotecas, "cell 0 0");
		
		JLabel lblTtulo = new JLabel("ISBN");
		lblTtulo.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblTtulo, "cell 0 1,alignx left");
		
		txtIsbn = new JTextField();
		panel.add(txtIsbn, "cell 0 2");
		txtIsbn.setColumns(10);
		
		JLabel lblTitulo = new JLabel("Titulo");
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblTitulo, "cell 0 3");
		
		txtTitulo = new JTextField();
		panel.add(txtTitulo, "cell 0 4,growx");
		txtTitulo.setColumns(10);
		
		lblAutor = new JLabel("Autor");
		lblAutor.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblAutor, "cell 0 5");
		
		txtAutor = new JTextField();
		panel.add(txtAutor, "cell 0 6,growx");
		txtAutor.setColumns(10);
		
		lblEjemplares = new JLabel("Ejemplares");
		lblEjemplares.setFont(new Font("Dialog", Font.BOLD, 16));
		panel.add(lblEjemplares, "flowx,cell 1 6,alignx right");
		
		spinner = new JSpinner();
		spinner.setFont(new Font("Dialog", Font.BOLD, 12));
		spinner.setModel(new SpinnerNumberModel(0,0,99,1));
		panel.add(spinner, "cell 2 6,growx");
		contentPane.setLayout(gl_contentPane);
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JTextField getTxtIsbn() {
		return txtIsbn;
	}

	public JTextField getTxtTitulo() {
		return txtTitulo;
	}

	public JLabel getLblAutor() {
		return lblAutor;
	}

	public JTextField getTxtAutor() {
		return txtAutor;
	}

	public JLabel getLblEjemplares() {
		return lblEjemplares;
	}

	public JButton getBtnAnyadirLibro() {
		return btnAnyadirLibro;
	}

	public JSpinner getSpinner() {
		return spinner;
	}

	public JLabel getLblAdrihosanBibliotecas() {
		return lblAdrihosanBibliotecas;
	}

	public JPanel getPanel() {
		return panel;
	}


	
	
	
	
}
