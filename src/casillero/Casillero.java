package casillero;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Casillero {

        private boolean estaLibre;
        private List<Ficha> fichasDelCasillero;

        public Casillero(){
            estaLibre = false;
            fichasDelCasillero = new ArrayList<>();
        }

        public Casillero(Ficha ficha ){
            estaLibre = false;
            fichasDelCasillero = new ArrayList<>();
            fichasDelCasillero.add(ficha);
        }

        public void agregarFichas(Ficha ficha){
            this.fichasDelCasillero.add(ficha);
        }
        public boolean estaLibre(){
            return this.estaLibre;
        }
       public List verCasilleros(){
            return this.fichasDelCasillero;
       }

       public void usarFicha(){
           Iterator<Ficha> iteradorDeFichas = fichasDelCasillero.iterator();
           while (iteradorDeFichas.hasNext()){
               Ficha ficha = iteradorDeFichas.next();
               ficha.aplicarEfecto();
           }
       }
}
