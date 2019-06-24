
# PacSin


## DESCRIPCIÓN DE CLASES

    #Pac:
        Es el personaje del usuario, almacena las vidas y escudos, las modifica, y se asegura que tenga los recursos para seguir jugando.

    #Ficha:
        Interfaz para manejar los efectos que se pueden producir en el Pac.

    #Mina:
        Le quita una vida al Pac. Solo se aplica una única vez.

    #Provicion:
        Interfaz para manejar los efectos positivos que se aplican al Pac.

    #Escudo:
        Le agrega un escudo al Pac. Solo se aplica una única vez.

    #Vitamina:
        Le agrega una vida al Pac. Solo se aplica una única vez.

    #ProvicionCompuesta:
        Almacena una lista de las provisiones que puede contener un único casillero. Los efectos de estos solo se aplica una única vez. Implementa de "Provicero" y utiliza objetos del mismo tipo.

    #Tablero:
        Arma un arreglo de casilleros y devolver lo que cada uno posee.

    #LectorDeTablero:
        Lee la información que se encuentra en el archivo "Tablero.txt".

    #ArmadorDeTablero:
        En base a lo que recibe el lector de tablero, este adapta la información en una manera que, como se maneja el lenguaje, sea mas fácil usarla.

    #PacSim:
        Se encarga de la lógica de todo el juego: leer el tablero, posicionar los objetos en el mismo (paredes, provisiones, minas, al jugador, entrada y salida), y  en base al estado del jugador, verificar si se puede seguir jugando o cortar el 



## Integrantes del grupo

* Aaron Saban
* Fernando Gabriel Juares Coria
* Sabrina Micaela Cardoso

## Decisiones de Diseño

Nuestra primera decisión fue definir como íbamos a administrar las clases para el sistema de provisiones y minas, así que planteamos usar el patrón de diseño Composite que nos permitió resolver ese problema.


Se nos ocurrió crear una clase ArmadorDeTablaro, que nos sirvió para tomar los datos del tablero de salida que tenia coordenadas del tipo Indice, al estilo de fila y columna que se nos hacía más sencillo manejar luego.


Para la interfaz del PacSim decidimos utilizar una interfaz hecha en consola.


Luego finalmente para administrar la lógica principal del juego, decidimos crear la clase Pacsim que se comunica que las demás clases para encapsular la aplicación y asilarla de la interfaz gráfica, para poder reemplazarla más fácilmente en un futuro.
