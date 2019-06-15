package tablero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class LectorDeTablero {


	private BufferedReader lectorDeTablero;

	public LectorDeTablero(){
		try {
			this.lectorDeTablero = new BufferedReader(new FileReader("resources/tablero.txt"));
		}catch (FileNotFoundException e){
			throw new Error("El aFileNotFoundExceptionrchivo de configuracion del tablero, no fue encontrado");
		}
	}
	

	public Tablero leerTablero() throws IOException {
		String primeraLinea = this.lectorDeTablero.readLine();

		return new Tablero(5,4);
	}


	private void analizarSecciones(String nombreDeSeccion) throws IOException {
		switch (nombreDeSeccion) {
		case "[TABLERO]":
			analizarTablero();
			break;
		case "[MINAS]":
			analizarMinas();
			break;
		case "[PROVISIONES]":
			analizarProvisiones();
			break;
		case "[UBICACION_PROVISIONES]":
			analizarUbicacionProvisiones();
			break;
		default:
			throw new Error("Error en el archivo de configuración");
		}
	}

	private void analizarUbicacionProvisiones() throws IOException {
		System.out.println("UBICAMOS LAS PROVISIONES");
		
	}

	private void analizarProvisiones() throws IOException {
		System.out.println("ARRANCAMOS CON PROVISIONES");
		Map<String, String> provisiones = new TreeMap<>();
		String valorDelTablero = this.lectorDeTablero.readLine();
		while(valorDelTablero.charAt(0) != '[' && valorDelTablero != null) {
			String[] llaveValor = valorDelTablero.split("=");
			provisiones.put(llaveValor[0], llaveValor[1]);
			valorDelTablero = this.lectorDeTablero.readLine();
		}
		System.out.println(Arrays.toString(provisiones.values().toArray()));
		/*TODO : TRABAJAR CON EL ARRAY PARA OBTENER LAS PROVISIONES*/
		analizarSecciones(valorDelTablero);
		
	}

	private void analizarMinas() throws IOException {
		
		String minas = lectorDeTablero.readLine();
		String[] posicionDeMinas = minas.split("=");
		if(posicionDeMinas[0].equals("B")) {
			String[] ubicacionDeMinas =  posicionDeMinas[1].split(",");
			for(String ubicacion : ubicacionDeMinas) {
				System.out.println(ubicacion);
				/*TODO : AGREGAR MINA AL TABLERO*/
			}
		}
		analizarSecciones(this.lectorDeTablero.readLine());
		
	}

	private void analizarTablero() throws IOException {
		int filas = 4;
		int columnas = 4;
		int ubicacionDeLaSalida = 8;
		int ubicacionDeLaEntrada = 1;
		String paredes = "000000000000";

		String valorDelTablero = this.lectorDeTablero.readLine();

		
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
			valorDelTablero = lectorDeTablero.readLine();
		}
		
		System.out.println(filas);
		System.out.println(columnas);
		System.out.println(ubicacionDeLaEntrada);
		System.out.println(ubicacionDeLaSalida);
		System.out.println(paredes);
		System.out.println(valorDelTablero);
		
		Tablero tablero = new Tablero(filas,columnas);
		
		analizarSecciones(valorDelTablero);
	}
	
	
	public void generarParedes(String paredes) {
		
	}
	
	
}
