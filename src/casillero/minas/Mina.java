package casillero.minas;

import casillero.Ficha;

public class Mina implements Ficha {

    private boolean activa;
    private Pac pac;

    public Mina(){
        activa = true;
        pac = new Pac();
    }

    @Override
    public void aplicarEfecto() {
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
