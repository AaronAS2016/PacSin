package casillero.provisiones;

import casillero.jugador.Pac;

public class Escudo implements Provision {

    private boolean activa;

    public Escudo(){
        activa = true;
    }

    @Override
    public void aplicarEfecto(Pac pac) {
        if (estaActiva()){
            this.activa = false;
            pac.modificarEscudo(1);
        }
    }

    public boolean estaActiva() {
        return activa;
    }
}
