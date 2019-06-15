package tablero;

import casillero.jugador.Pac;

public class PacSim {

    private ArmadorDeTablero armadorDeTablero;

    private int[] ubicacionDeLaEntrada;
    private int[] ubicacionDeLaSalida;
    private Tablero tablero;
    private Pac pac = new Pac();

    public PacSim(){
        iniciarPacsim();
    }

    private void iniciarPacsim() {
        this.armadorDeTablero =  new ArmadorDeTablero();
        this.tablero = armadorDeTablero.obtenerTablero();
        this.ubicacionDeLaEntrada = armadorDeTablero.obtenerCoordenadasDeLaEntrada();
        this.ubicacionDeLaSalida = armadorDeTablero.obtenerCoordenadasDeLaSalida();
    }

    public int obtenerVidaDelJugador(){
      return pac.obtenerVidas();
    }

    public int obtenerCantidadDeEscudoDelJugador(){
        return pac.obtenerEscudo();
    }
}
