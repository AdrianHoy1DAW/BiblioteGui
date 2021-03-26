package aplicacion;

import java.awt.EventQueue;

import controlador.ControladorBiblioteca;
import vista.VistaBiblioteca;

public class APP {
	
	
		
		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						VistaBiblioteca frame = new VistaBiblioteca();
						ControladorBiblioteca cb = new ControladorBiblioteca(frame);
						cb.go();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
}
