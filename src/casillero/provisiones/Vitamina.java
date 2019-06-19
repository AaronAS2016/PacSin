package casillero.provisiones;

import casillero.jugador.Pac;

public class Vitamina implements Provision {

    private boolean activa;

    public Vitamina(){
        activa = true;
    }

    @Override
    public void aplicarEfecto(Pac pac) {
         if (estaActiva()){
            this.activa = false;
            pac.modificarVida(1);
        }
    }

    @Override
    public boolean estaActiva() {
        return activa;
    }
}
