package tablero;

public class PacSim {

    private ArmadorDeTablero armadorDeTablero;

    private int[] ubicacionDeLaEntrada;
    private int[] ubicacionDeLaSalida;
    private Tablero tablero;

    public PacSim(){
        iniciarPacsim();
    }

    private void iniciarPacsim() {
        this.armadorDeTablero =  new ArmadorDeTablero();
        this.tablero = armadorDeTablero.obtenerTablero();
        this.ubicacionDeLaEntrada = armadorDeTablero.obtenerCoordenadasDeLaEntrada();
        this.ubicacionDeLaSalida = armadorDeTablero.obtenerCoordenadasDeLaSalida();
    }
}
