package guardado;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import biblioteca.Biblioteca;

public class Guardado {

	private static String fichero = "biblioteca.txt";
	
	public Guardado() {
		
	}
	
	public  Biblioteca load() {
		
		Biblioteca b = null;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichero))) {
			
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
		
		return b;
		
	}
	
	public  void store(Biblioteca b) {
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fichero))) {
			
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
