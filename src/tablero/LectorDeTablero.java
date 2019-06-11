package tablero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LectorDeTablero {
	
	
	/*TODO: PASAR OBJETOS COMO ATRIBUTOS EN VEZ DE GENERADOS EN EL MAIN PARA EVITAR PASARLO COMO ATRIBUUTO EN CADA METÓDO*/
	
	
	public static void main(String[] args) throws IOException {
		try {
			BufferedReader br = new BufferedReader(new FileReader("resources/tablero.txt"));
			String line = br.readLine();
			System.out.println(line);
			controlPath(br, line);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Tablero leerTablero() {
		
		return new Tablero(5,4);
	}
	
	private static void controlPath(BufferedReader br, String path) throws IOException {
		switch (path) {
		case "[TABLERO]":
			analizarTablero(br, path);
			break;
		case "[MINAS]":
			analizarMinas(br, path);
			break;
		case "[PROVISIONES]":
			analizarProvisiones(br, path);
			break;
		case "[UBICACION_PROVISIONES]":
			analizarUbicacionProvisiones(br, path);
			break;
		default:
			throw new Error("Error en el archivo de configuración");
		}
	}

	private static void analizarUbicacionProvisiones(BufferedReader br, String path) throws IOException {
		System.out.println("UBICAMOS LAS PROVISIONES");
		
	}

	private static void analizarProvisiones(BufferedReader br, String path) throws IOException {
		System.out.println("ARRANCAMOS CON PROVISIONES");
		Map<String, String> provisiones = new TreeMap<>();
		String valorDelTablero = br.readLine();
		while(valorDelTablero.charAt(0) != '[' && valorDelTablero != null) {
			String[] llaveValor = valorDelTablero.split("=");
			provisiones.put(llaveValor[0], llaveValor[1]);
			valorDelTablero = br.readLine();
		}
		System.out.println(Arrays.toString(provisiones.values().toArray()));
		/*TODO : TRABAJAR CON EL ARRAY PARA OBTENER LAS PROVISIONES*/
		controlPath(br,valorDelTablero);
		
	}

	private static void analizarMinas(BufferedReader br, String path) throws IOException {
		
		String minas = br.readLine();
		String[] posicionDeMinas = minas.split("=");
		if(posicionDeMinas[0].equals("B")) {
			System.out.println("EMPEZAMOS CON MINAS");
			String[] ubicacionDeMinas =  posicionDeMinas[1].split(",");
			for(String ubicacion : ubicacionDeMinas) {
				System.out.println(ubicacion);
				/*TODO : AGREGAR MINA AL TABLERO*/
			}
		}
		controlPath(br, br.readLine());
		
	}

	private static void analizarTablero(BufferedReader br, String path) throws IOException {
		int filas = 4;
		int columnas = 4;
		int ubicacionDeLaSalida = 8;
		int ubicacionDeLaEntrada = 1;
		String paredes = "000000000000";

		String valorDelTablero = br.readLine();

		
		while(valorDelTablero.charAt(0) != '[' && valorDelTablero != null) {
			String[] llaveValor = valorDelTablero.split("=");
			String llave = llaveValor[0];
			String valor = llaveValor[1];
			
			switch (llave) {
				case "M":
					filas= Integer.parseInt(valor);
					break;
				case "N":
					columnas= Integer.parseInt(valor);
					break;
				case "S":
					ubicacionDeLaSalida = Integer.parseInt(valor);
					break;
				case "E":
					ubicacionDeLaEntrada = Integer.parseInt(valor);
					break;
				case "L":
					paredes = valor;
					break;
			}
			valorDelTablero = br.readLine();
		}
		
		System.out.println(filas);
		System.out.println(columnas);
		System.out.println(ubicacionDeLaEntrada);
		System.out.println(ubicacionDeLaSalida);
		System.out.println(paredes);
		System.out.println(valorDelTablero);
		
		Tablero tablero = new Tablero(filas,columnas);
		
		controlPath(br, valorDelTablero);
	}
	
	
	public static void generarParedes(String paredes) {
		
	}
	
	
}
