package casillero.minas;

import casillero.Ficha;

public class Mina implements Ficha {

    private boolean activa;

    public Mina(){
        activa = true;
    }

    @Override
    public void aplicarEfecto(Pac pac) {
        if(estaActiva()){
            this.activa = false;
            if (pac.tieneEscudo){
                pac.modificarEscudo(-1);
            } else {
                pac.modificarVida(-1);
            }
        }
    }

    @Override
    public boolean estaActiva() {
        return activa;
    }
}
