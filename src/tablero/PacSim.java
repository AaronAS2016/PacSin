package tablero;

public class PacSim {

    private ArmadorDeTablero armadorDeTablero;

    private int[] ubicacionDeLaEntrada;

    public PacSim(){
        this.armadorDeTablero =  new ArmadorDeTablero();
        armadorDeTablero.obtenerTablero();
    }
}
