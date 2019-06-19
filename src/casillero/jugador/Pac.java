package casillero.jugador;

public class Pac{
    private int vidas;
    private int escudo;

    private final static int CANTIDAD_DE_VIDAS = 10;
    private final static int CANTIDAD_DE_ESCUDO = 0;

    public Pac(){
        this.vidas = CANTIDAD_DE_VIDAS;
        this.escudo = CANTIDAD_DE_ESCUDO;
    }

    public int obtenerVidas() {
        return this.vidas;
    }

    public int obtenerEscudo() {
        return this.escudo;
    }

    public boolean estaVivo() {
        return this.vidas > 0;
    }

    public boolean tieneEscudo() {
        return this.escudo > 0;
    }

    public void modificarEscudo(int diferencia){
        this.escudo = this.escudo + diferencia;
    }

    public void modificarVida(int diferencia){
        this.vidas = this.vidas + diferencia;
    }
}
