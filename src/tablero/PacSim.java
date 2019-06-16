package tablero;

import casillero.jugador.Pac;

public class PacSim {

    private ArmadorDeTablero armadorDeTablero;

    private int[] ubicacionDelJugador;
    private int[] ubicacionDeLaSalida;
    private Tablero tablero;
    private Pac pac = new Pac();

    public PacSim(){
        iniciarPacsim();
    }

    private void iniciarPacsim() {
        this.armadorDeTablero =  new ArmadorDeTablero();
        this.tablero = armadorDeTablero.obtenerTablero();
        this.ubicacionDelJugador = armadorDeTablero.obtenerCoordenadasDeLaEntrada();
        this.ubicacionDeLaSalida = armadorDeTablero.obtenerCoordenadasDeLaSalida();
    }

    public int obtenerVidaDelJugador(){
      return pac.obtenerVidas();
    }

    public int obtenerCantidadDeEscudoDelJugador(){
        return pac.obtenerEscudo();
    }

    public boolean termino(){
        return pac.estaVivo();
    }

    public Tablero obtenerTablero(){
        return this.tablero;
    }
    public int[] obtenerPosicionDelJugador(){
        return this.ubicacionDelJugador;
    }

    public int[] obtenerPosicionDeLaSalida(){
        return this.ubicacionDeLaSalida;
    }

}
