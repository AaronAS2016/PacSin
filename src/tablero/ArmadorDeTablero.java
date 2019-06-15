package tablero;

public class ArmadorDeTablero {

    private LectorDeTablero lectorDeTablero;
    private Tablero tablero;
    private int[] ubicacionDeLaEntrada;
    private int[] ubicacionDelJugador;

    public ArmadorDeTablero(){
        this.lectorDeTablero = new LectorDeTablero();
        this.lectorDeTablero.leerTablero();
        adaptarTablero();
    }

    private void adaptarTablero() {
        int filas = this.lectorDeTablero.obtenerFilasDelTablero();
        int columnas = this.lectorDeTablero.obtenerColumnasDelTablero();

        this.tablero = new Tablero(filas,columnas);

        this.ubicacionDeLaEntrada = this.obtenerEntrada(this.lectorDeTablero.obtenerUbicacionDeLaEntrada(), columnas);

    }

    public Tablero obtenerTablero(){


        return null;
    }

    public int[] obtenerEntrada(int posicion, int cantidadDeColumnas) {


        int[] coordenadas = new int[2];

        int ubicacionFila = (int) Math.ceil((double)posicion / (double)cantidadDeColumnas) ;
        int ubicacionColumna = (posicion % cantidadDeColumnas) == 0 ? cantidadDeColumnas : (posicion % cantidadDeColumnas);


        coordenadas[0] = ubicacionFila -1;
        coordenadas[1] = ubicacionColumna -1;

        System.out.println("Cantidad de columnas: " + cantidadDeColumnas);

        System.out.println("Ubicacion en indice de la grilla: " + posicion);
        System.out.println("Ubicacion en fila: " + ubicacionFila);
        System.out.println("Ubicacion en columnas: " + ubicacionColumna);

        return coordenadas;

    }


}
