import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class gestionFichero {
	String nombre_fichero;

	public gestionFichero(String nombre_fichero) {
		super();
		this.nombre_fichero = nombre_fichero;
	}
	public ArrayList<String> leer() {//genera una arraylist de palabras a raiz del txt
		ArrayList<String> aux =new ArrayList<>();
		String linea="";
		// FileReader fr;
		BufferedReader br;
		try {
			// fr=new FileReader(nombre_fichero);
			br= new BufferedReader(new InputStreamReader(new FileInputStream(nombre_fichero), StandardCharsets.UTF_8));
			while (linea!=null) {
				linea=br.readLine();
				if (linea!=null) {
					aux.add(linea);
				}
			}
			br.close();
			// fr.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return aux;//las palabras almacenadas
	}
	public void printar(ArrayList<String>printar) {
		for (String s : printar) {
			JOptionPane.showMessageDialog(null, s);
		}
	}
	public String generar_palabra(ArrayList<String>deleer) {//arraylist aux ya rellenada anterior metodo
		int tamanio=deleer.size();
		Random num= new Random();
		int numero_palabra=num.nextInt(tamanio);//tamanio=tama�o de la arraylist num. limt de random
		String palabra=deleer.get(numero_palabra);//generamos la palabra de esa posicion.
		System.out.println(palabra);
		return palabra;
		
	}
	public void palabraencontrada() {
		String palabra;
		boolean encontrado=false;
		do {
			
			palabra=JOptionPane.showInputDialog("escribe la palabra que quieres comprobar: ").toLowerCase();
			if (palabra.length()==5) {
				for (String recorrdic : this.leer()) {
					if (recorrdic.equals(palabra)) {
						encontrado=true;
					}
				}
				if (encontrado) {
					JOptionPane.showMessageDialog(null, "la palabra esta en el diccionario");
				}else {
					JOptionPane.showMessageDialog(null, "la palabra no esta en el diccionario");
				}
			}else {
				JOptionPane.showMessageDialog(null, "la palabra tiene que tener 5 caracteres");
			}
		} while (palabra.length()!=5);
		
		
			
		}
	// public void escribir(jugador j) {
	// 	FileWriter fw;
	// 	BufferedWriter bw;
	// 	try {
	// 		fw=new FileWriter(nombre_fichero,true);
	// 		bw=new BufferedWriter(fw);
	// 		String linea=j.getNombre()+","+j.getPuntuacion();
	// 		bw.write(linea+"\n");
	// 		bw.close();
	// 		fw.close();
	// 	} catch (Exception e) {
	// 		// TODO: handle exception
	// 	}
	// }
	// public void name() {
		
	// }
	}

