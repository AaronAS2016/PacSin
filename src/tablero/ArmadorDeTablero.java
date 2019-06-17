package tablero;

import casillero.Casillero;
import casillero.minas.Mina;
import casillero.provisiones.Escudo;
import casillero.provisiones.Provision;
import casillero.provisiones.ProvisionCompuesta;
import casillero.provisiones.Vitamina;
import java.util.Map;

public class ArmadorDeTablero {

    private LectorDeTablero lectorDeTablero;
    private Tablero tablero;
    private int[] ubicacionDeLaSalida;
    private int[] ubicacionDelJugador;

    private Map<String, String> provisiones;
    private Map<String, String> ubicacionDeProvisiones;

    private int columnas;
    private int filas;


    public ArmadorDeTablero(){
        this.lectorDeTablero = new LectorDeTablero();
        this.lectorDeTablero.leerTablero();
        adaptarTablero();
    }


    public Tablero obtenerTablero(){
        return this.tablero;
    }

    public int[] obtenerCoordenadasDeLaEntrada(){
        return this.ubicacionDelJugador;
    }

    public int[] obtenerCoordenadasDeLaSalida(){
        return this.ubicacionDeLaSalida;
    }

    /**
     * ADAPTA LAS COORDENADAS DEL TABLERO BASADAS EN UN INDICE AL TIPO FILA - COLUMNA
     * */

    private void adaptarTablero() {
        filas = this.lectorDeTablero.obtenerFilasDelTablero();
        columnas = this.lectorDeTablero.obtenerColumnasDelTablero();

        String ubicacionDeParedes = this.lectorDeTablero.obtenerParedes();

        this.tablero = new Tablero(filas,columnas);

        this.ubicacionDelJugador = this.obtenerCoordenadasPorIndice(this.lectorDeTablero.obtenerUbicacionDeLaEntrada(), columnas);
        this.ubicacionDeLaSalida = this.obtenerCoordenadasPorIndice(this.lectorDeTablero.obtenerUbicacionDeSalida(), columnas);

        String[] ubicacionDeMinas = this.lectorDeTablero.obtenerUbicacionDeMinas();

        generarParedes(ubicacionDeParedes);
        agregarMinas(ubicacionDeMinas);

        provisiones = this.lectorDeTablero.obtenerProvisiones();

        ubicacionDeProvisiones = this.lectorDeTablero.obtenerUbicacionDeProvisiones();

        agregarProvisiones();
    }

    private void agregarProvisiones() {


        for (String nombreProvision: provisiones.keySet()){
            String llaveProvision = nombreProvision;
            String tipoDeProvisiones = provisiones.get(nombreProvision);
            String[] elementosDeLaProvision = tipoDeProvisiones.split(",");
            Provision provision = null;

            provision = obtenerProvisionPorCantidadDeElementos(elementosDeLaProvision);

            for (String ubicacionProvision : ubicacionDeProvisiones.get(llaveProvision).split(",")){
                int coordenadas[] = this.obtenerCoordenadasPorIndice(Integer.parseInt(ubicacionProvision), columnas);
                this.tablero.agregarFichas(coordenadas[0], coordenadas[1], provision);
            }

        }

    }

    private Provision obtenerProvisionPorTipo(String tipoDeProvision){
        if(tipoDeProvision.equals("E")){
            return new Escudo();
        }else if(tipoDeProvision.equals("V")){
            return new Vitamina();
        }else{

            String[] elementosDeLaProvision = provisiones.get(tipoDeProvision).split(",");
            Provision provision = obtenerProvisionPorCantidadDeElementos(elementosDeLaProvision);
            return provision;

        }
    }

    private Provision obtenerProvisionPorCantidadDeElementos(String[] elementosDeLaProvision){

        Provision provision = null;
        if(elementosDeLaProvision.length >= 1){
            ProvisionCompuesta provisionCompuesta = new ProvisionCompuesta();
            for (String tipoDeProvision : elementosDeLaProvision){
                provisionCompuesta.agregarProvision(obtenerProvisionPorTipo(tipoDeProvision));
            }
            provision = provisionCompuesta;
        }
        else{
            provision = obtenerProvisionPorTipo(elementosDeLaProvision[0]);
        }

        return provision;

    }


    private void agregarMinas(String[] ubicacionDeMinas) {

        for (String mina : ubicacionDeMinas){
            int[] coordenadas = this.obtenerCoordenadasPorIndice(Integer.parseInt(mina), columnas);
            this.tablero.agregarFichas(coordenadas[0], coordenadas[1], new Mina());
        }

    }

    private void generarParedes(String ubicacionDeParedes) {

        int posicion = 1;
        for(char hayPared : ubicacionDeParedes.toCharArray()){
            int[] coordenadas = this.obtenerCoordenadasPorIndice(posicion, columnas);
            if(hayPared == '0'){
                this.tablero.agregarCasillero(coordenadas[0], coordenadas[1], new Casillero(false));

            }else{
                this.tablero.agregarCasillero(coordenadas[0], coordenadas[1], new Casillero(true));
            }
            posicion++;
        }

    }


    private int[] obtenerCoordenadasPorIndice(int posicion, int cantidadDeColumnas) {


        int[] coordenadas = new int[2];

        int ubicacionFila = (int) Math.ceil((double)posicion / (double)cantidadDeColumnas) ;
        int ubicacionColumna = (posicion % cantidadDeColumnas) == 0 ? cantidadDeColumnas : (posicion % cantidadDeColumnas);


        coordenadas[0] = ubicacionFila;
        coordenadas[1] = ubicacionColumna;

        return coordenadas;

    }


}
