package casillero.provisiones;

public class Escudo implements Provision {

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
