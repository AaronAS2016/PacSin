package tablero;

import casillero.jugador.Pac;

public class PacSim {

    private ArmadorDeTablero armadorDeTablero;

    private int[] ubicacionDelJugador;
    private int[] ubicacionDeLaSalida;
    private Tablero tablero;
    private Pac pac = new Pac();

    private boolean gano;

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

    public boolean obtenerResultado(){
        return this.gano;
    }

    public boolean termino(){
        boolean termino = (!pac.estaVivo() || ubicacionDeLaSalida == ubicacionDelJugador);

        if(termino){
            gano = ubicacionDeLaSalida == ubicacionDelJugador;
        }

        return termino;
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

    public void moverJugadorIzquierda() {
        if(ubicacionDelJugador[1] - 1 > 0 && tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1] - 1 ).estaLibre()){
            ubicacionDelJugador[1]--;
            tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1]).usarFicha();
        }
    }

    public void moverJugadorDerecha() {
        if ((ubicacionDelJugador[1] + 1) < tablero.obtenerCantidadDeColumnas() && tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1] + 1).estaLibre()){
            ubicacionDelJugador[1]++;
            tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1]).usarFicha();
        }
    }

    public void moverJugadorArriba() {
        if ((ubicacionDelJugador[0] - 1) > 0 && tablero.obtenerCasillero(ubicacionDelJugador[0] - 1, ubicacionDelJugador[1]).estaLibre()){
            ubicacionDelJugador[0]--;
            tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1]).usarFicha();
        }
    }

    public void moverJugadorAbajo() {
        if ((ubicacionDelJugador[0] + 1) <= tablero.obtenerCantidadDeFilas() && tablero.obtenerCasillero(ubicacionDelJugador[0] + 1, ubicacionDelJugador[1]).estaLibre()){
            ubicacionDelJugador[0]++;
            tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1]).usarFicha();
        }
    }
}
