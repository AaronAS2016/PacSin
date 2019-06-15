package casillero.provisiones;

import java.util.ArrayList;
import java.util.List;

public class ProvisionCompuesta implements Provision {

    private List<Provision> provisiones;

    public ProvisionCompuesta(){
        provisiones = new ArrayList<>();
    }


    public void agregarProvision(Provision provision){
        this.provisiones.add(provision);
    }

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
