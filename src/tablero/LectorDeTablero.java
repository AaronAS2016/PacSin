package tablero;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class LectorDeTablero {



	private int filasDelTablero;
	private int columnasDelTablero;
	private int ubicacionDeSalida;
	private int ubicacionDeLaEntrada;
	private String paredes;
	private String[] ubicacionDeMinas;
	private Map<String, String> provisiones;
	private Map<String, String> ubicacionDeProvisiones;


	private BufferedReader lectorDeTablero;

	public LectorDeTablero(){
		try {
			this.lectorDeTablero = new BufferedReader(new FileReader("resources/tablero.txt"));
		}catch (FileNotFoundException e){
			throw new Error("El aFileNotFoundExceptionrchivo de configuracion del tablero, no fue encontrado");
		}
	}
	

	public void leerTablero() {
		String primeraSeccion = null;
		try {
			primeraSeccion = this.lectorDeTablero.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			analizarSecciones(primeraSeccion);
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		Map<String, String> provisiones = new TreeMap<>();
		String valorDelTablero = this.lectorDeTablero.readLine();
		while(valorDelTablero != null && valorDelTablero.charAt(0) != '[') {
			String[] llaveValor = valorDelTablero.split("=");
			provisiones.put(llaveValor[0], llaveValor[1]);
			valorDelTablero = this.lectorDeTablero.readLine();
		}

		this.ubicacionDeProvisiones = provisiones;
	}

	private void analizarProvisiones() throws IOException {
		Map<String, String> provisiones = new TreeMap<>();
		String valorDelTablero = this.lectorDeTablero.readLine();
		while(valorDelTablero.charAt(0) != '[' && valorDelTablero != null) {
			String[] llaveValor = valorDelTablero.split("=");
			provisiones.put(llaveValor[0], llaveValor[1]);
			valorDelTablero = this.lectorDeTablero.readLine();
		}

		this.provisiones = provisiones;
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
			this.ubicacionDeMinas = ubicacionDeMinas;
		}
		analizarSecciones(this.lectorDeTablero.readLine());
		
	}

	private void analizarTablero() throws IOException {


		/**Valores de fallback*/
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
					columnas= Integer.parseInt(valor);
					break;
				case "N":
					filas= Integer.parseInt(valor);
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

		this.filasDelTablero = filas;
		this.columnasDelTablero = columnas;
		this.ubicacionDeLaEntrada = ubicacionDeLaEntrada;
		this.ubicacionDeSalida = ubicacionDeLaSalida;
		this.paredes = paredes;

		analizarSecciones(valorDelTablero);
	}

	public int obtenerFilasDelTablero() {
		return filasDelTablero;
	}

	public int obtenerColumnasDelTablero() {
		return columnasDelTablero;
	}

	public int obtenerUbicacionDeSalida() {
		return ubicacionDeSalida;
	}

	public int obtenerUbicacionDeLaEntrada() {
		return ubicacionDeLaEntrada;
	}

	public String obtenerParedes() {
		return paredes;
	}

	public String[] obtenerUbicacionDeMinas() {
		return ubicacionDeMinas;
	}

	public Map<String, String> obtenerProvisiones() {
		return provisiones;
	}

	public Map<String, String> obtenerUbicacionDeProvisiones() {
		return ubicacionDeProvisiones;
	}

}
