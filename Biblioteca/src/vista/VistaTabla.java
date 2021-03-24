package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VistaTabla extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel dtm = new DefaultTableModel();



	/**
	 * Create the frame.
	 */
	public VistaTabla() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.X_AXIS));
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);
		
		table = new JTable();

		table.setModel(dtm);
		scrollPane.setViewportView(table);
		setTitle("Biblioteca Adrihosan - Mostrar");
	}



	public DefaultTableModel getDtm() {
		return dtm;
	}
	
	
}
