package casillero.provisiones;

public class Vitamina implements Provision {

    private boolean activa;
    private Pac pac;

    public Vitamina(){
        activa = true;
        pac = new Pac();
    }

    @Override
    public int obtenerCantidadDeProvision() {
        return 0;
    }

    @Override
    public void aplicarEfecto() {
         if (estaActiva()){
            this.activa = false;
            pac.modificaVida(obtenerCantidadDeProvision());
        }
    }

    @Override
    public boolean estaActiva() {
        return activa;
    }
}
