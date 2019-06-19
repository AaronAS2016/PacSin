package casillero.provisiones;

public class Vitamina implements Provision {

    private boolean activa;
    private Pac pac;

    public Vitamina(){
        activa = true;
        pac = new Pac();
    }

    @Override
    public void aplicarEfecto(Pac pac) {
         if (estaActiva()){
            this.activa = false;
            pac.modificaVida(1);
        }
    }

    @Override
    public boolean estaActiva() {
        return activa;
    }
}
