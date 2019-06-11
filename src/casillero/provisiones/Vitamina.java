package casillero.provisiones;

public class Vitamina implements Provision {

    @Override
    public int obtenerCantidadDeProvision() {
        return 0;
    }

    @Override
    public void aplicarEfecto() {

    }

    @Override
    public boolean estaActiva() {
        return false;
    }
}
