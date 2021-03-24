package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaDevolver extends JFrame {

	private JPanel contentPane;
	private JComboBox comboBox;
	private JButton btnComprobar;



	/**
	 * Create the frame.
	 */
	public VistaDevolver() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnDevolver = new JButton("Devolver");
		panel_2.add(btnDevolver);
		panel_1.setLayout(new MigLayout("", "[grow]", "[][]"));
		
		JLabel lblEstosSonLos = new JLabel("Estos son los libros a tu disposicion");
		lblEstosSonLos.setFont(new Font("Dialog", Font.BOLD, 15));
		panel_1.add(lblEstosSonLos, "cell 0 0");
		
		JComboBox comboBox_1 = new JComboBox();
		panel_1.add(comboBox_1, "cell 0 1,growx");
		panel.setLayout(new MigLayout("", "[grow][]", "[][]"));
		
		JLabel lblPorFavorSelecciona = new JLabel("Por favor selecciona tu usuario");
		lblPorFavorSelecciona.setFont(new Font("Dialog", Font.BOLD, 15));
		panel.add(lblPorFavorSelecciona, "cell 0 0");
		
		comboBox = new JComboBox();
		panel.add(comboBox, "cell 0 1,growx");
		
		btnComprobar = new JButton("Comprobar");
		panel.add(btnComprobar, "cell 1 1");
		contentPane.setLayout(gl_contentPane);
	}

}
