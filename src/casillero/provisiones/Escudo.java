package casillero.provisiones;

public class Escudo implements Provision {

    private boolean activa;
    private Pac pac;

    public Escudo(){
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
            pac.modificaEscudo(obtenerCantidadDeProvision());
        }
    }

    @Override
    public boolean estaActiva() {
        return activa;
    }
}
