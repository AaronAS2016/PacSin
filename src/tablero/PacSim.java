package tablero;

import casillero.jugador.Pac;

import java.util.Arrays;

import excepciones.ExcepcionesPared;

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
        boolean termino = (!pac.estaVivo() || Arrays.equals(ubicacionDeLaSalida, ubicacionDelJugador));

        if(termino){
            gano = pac.estaVivo();
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

    public void moverJugadorIzquierda() throws ExcepcionesPared {
    	
		if(ubicacionDelJugador[1] - 1 <= 0 ){
			throw new ExcepcionesPared ("No se puede salir del tablero");
			
		}else if ( !tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1] - 1 ).estaLibre()){
			throw new ExcepcionesPared("Hay una pared a la izquierda. No es posible avanzar");
			
		}else {
			ubicacionDelJugador[1]--;
			tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1]).usarFicha(pac);    			
		}
	}
    	
    

    public void moverJugadorDerecha()throws ExcepcionesPared  {
       
    	if ((ubicacionDelJugador[1] + 1) > tablero.obtenerCantidadDeColumnas() ) {
        	throw new ExcepcionesPared("No se puede salir del tablero");
        
        }else if( !tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1] + 1).estaLibre()){
            throw new ExcepcionesPared("Hay una pared a la derecha. No es posible avanzar");
            
        }else{
        	ubicacionDelJugador[1]++;
            tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1]).usarFicha(pac);
        }
    }

    public void moverJugadorArriba() throws ExcepcionesPared {
        if ((ubicacionDelJugador[0] - 1) <= 0 ){
        	throw new ExcepcionesPared("No se puede salir del tablero");
        	
        }else if(!tablero.obtenerCasillero(ubicacionDelJugador[0] - 1, ubicacionDelJugador[1]).estaLibre()){
        	throw new ExcepcionesPared ("Hay una pared arriba. No es posible avanzar");
        }else{
            ubicacionDelJugador[0]--;
            tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1]).usarFicha(pac);
        }
    }

    public void moverJugadorAbajo() throws ExcepcionesPared {
        if ((ubicacionDelJugador[0] + 1) > tablero.obtenerCantidadDeFilas() ){
        	throw new ExcepcionesPared("No se puede salir del tablero");
        
        } else if ( !tablero.obtenerCasillero(ubicacionDelJugador[0] + 1, ubicacionDelJugador[1]).estaLibre()){
        	throw new ExcepcionesPared ("Hay una pared abajo. No es posible avanzar");
  
        }else{
            ubicacionDelJugador[0]++;
            tablero.obtenerCasillero(ubicacionDelJugador[0], ubicacionDelJugador[1]).usarFicha(pac);
        }
    }

}
