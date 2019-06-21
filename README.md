"# PacSin" 


DESCRIPCION DE CLASES

    Pac:
        Es el personaje del usuario, almacena las vidas y escudos, las modifica, y se asegura que tenga los recursos para seguir jugando.

    Ficha:
        Interfaz para manejar los efectos que se pueden producir en el Pac.

    Mina:
        Le quita una vida al Pac. Solo se aplica una única vez.

    Provicion:
        Interfaz para manejar los efectos positivos que se aplican al Pac.

    Escudo:
        Le agrega un escudo al Pac. Solo se aplica una única vez.

    Vitamina:
        Le agrega una vida al Pac. Solo se aplica una única vez.

    ProvicionCompuesta:
        Almacena una lista de las provisiones que puede contener un único casillero. Los efectos de estos solo se aplica una única vez. Implementa de "Provicero" y utiliza objetos del mismo tipo.

    Tablero:
        Arma un arreglo de casilleros y devolver lo que cada uno posee.

    LectorDeTablero:
        Lee la información que se encuentra en el archivo "Tablero.txt".

    ArmadorDeTablero:
        En base a lo que recibe el lector de tablero, este adapta la información en una manera que, como se maneja el lenguaje, sea mas fácil usarla.

    PacSim:
        Se encarga de la lógica de todo el juego: leer el tablero, posicionar los objetos en el mismo (paredes, provisiones, minas, al jugador, entrada y salida), y  en base al estado del jugador, verificar si se puede seguir jugando o cortar el juego.

