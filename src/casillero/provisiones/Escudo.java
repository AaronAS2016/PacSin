package casillero.provisiones;

public class Escudo implements Provision {

    private boolean activa;

    public Escudo(){
        activa = true;
        pac = new Pac();
    }

    @Override
    public void aplicarEfecto(Pac pac) {
        if (estaActiva()){
            this.activa = false;
            pac.modificaEscudo(1);
        }
    }

    @Override
    public boolean estaActiva() {
        return activa;
    }
}
