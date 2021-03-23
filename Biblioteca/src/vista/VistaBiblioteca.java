package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.border.EtchedBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;

public class VistaBiblioteca extends JFrame {

	private JPanel contentPane;
	private JButton btnMostrarLibro;
	private JButton btnAnyadir;
	private JButton btnDevolver;
	private JButton btnAlquilar;
	private JButton btnRegistrarLibro;
	private JButton btnRegistrarSocio;
	private JButton btnMostrarSocios;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;



	/**
	 * Create the frame.
	 */
	public VistaBiblioteca() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 649);
		setTitle("Adrihosan Biblioteca");
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmOpen = new JMenuItem("Open");
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		JMenuBar menuBar_1 = new JMenuBar();
		mnFile.add(menuBar_1);
		contentPane = new JPanel();
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(null);
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 371, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(200, Short.MAX_VALUE))
		);
		panel_2.setLayout(new MigLayout("", "[grow,fill]", "[][][][]"));
		
		JLabel lblSocio = new JLabel("Socio");
		panel_2.add(lblSocio, "cell 0 0");
		
		btnRegistrarSocio = new JButton("Registrar Socio");
		panel_2.add(btnRegistrarSocio, "cell 0 1");
		
		btnMostrarSocios = new JButton("Mostrar Socios");
		panel_2.add(btnMostrarSocios, "cell 0 2");
		panel_1.setLayout(new MigLayout("", "[]", "[][][]"));
		
		JLabel lblBiblioteca = new JLabel("Biblioteca");
		lblBiblioteca.setFont(new Font("Dialog", Font.BOLD, 30));
		panel_1.add(lblBiblioteca, "cell 0 0");
		
		JLabel lblAdrihosan = new JLabel("Adrihosan");
		lblAdrihosan.setFont(new Font("FreeMono", Font.BOLD, 20));
		panel_1.add(lblAdrihosan, "cell 0 1");
		panel.setLayout(new MigLayout("", "[grow]", "[][][][][][]"));
		
		JLabel lblLibros = new JLabel("Libros");
		panel.add(lblLibros, "cell 0 0");
		
		btnRegistrarLibro = new JButton("Registrar Libro");
		panel.add(btnRegistrarLibro, "cell 0 1,growx");
		
		btnAlquilar = new JButton("Alquilar Libro");
		panel.add(btnAlquilar, "cell 0 2,growx");
		
		btnDevolver = new JButton("Devolver Libro");
		panel.add(btnDevolver, "cell 0 3,growx");
		
		btnMostrarLibro = new JButton("Mostrar Libros");
		panel.add(btnMostrarLibro, "cell 0 4,growx");
		
		btnAnyadir = new JButton("Añadir Ejemplares");
		panel.add(btnAnyadir, "cell 0 5,growx");
		contentPane.setLayout(gl_contentPane);
	}

	public JButton getBtnMostrarLibro() {
		return btnMostrarLibro;
	}

	public JButton getBtnAnyadir() {
		return btnAnyadir;
	}

	public JButton getBtnDevolver() {
		return btnDevolver;
	}

	public JButton getBtnAlquilar() {
		return btnAlquilar;
	}

	public JButton getBtnRegistrarLibro() {
		return btnRegistrarLibro;
	}

	public JButton getBtnRegistrarSocio() {
		return btnRegistrarSocio;
	}

	public JButton getBtnMostrarSocios() {
		return btnMostrarSocios;
	}

	public JMenuItem getMntmOpen() {
		return mntmOpen;
	}

	public JMenuItem getMntmSave() {
		return mntmSave;
	}
	
	
}
