package casillero.provisiones;

import java.util.ArrayList;
import java.util.List;

import casillero.jugador.Pac;

public class ProvisionCompuesta implements Provision {

    private List<Provision> provisiones;
    private boolean activa;

    public ProvisionCompuesta(){
        provisiones = new ArrayList<>();
        activa = true;
    }


    public void agregarProvision(Provision provision){
        this.provisiones.add(provision);
    }

    @Override
    public void aplicarEfecto(Pac pac) {
         for (Provision lista: provisiones) {
             lista.aplicarEfecto(pac);
         }
    }

    @Override
    public boolean estaActiva() {
        return activa;
    }
}
