# PacSin



## Integrantes del grupo

* Aaron Saban
* Fernando Gabriel Juares Coria
* Micaela Sabrina Cardoso

## Decisiones de Diseño

Nuestra primera decisión fue definir como íbamos a administrar las clases para el sistema de provisiones y minas, así que planteamos usar el patrón de diseño Composite que nos permitió resolver ese problema.


Se nos ocurrió crear una clase ArmadorDeTablaro, que nos sirvió para tomar los datos del tablero de salida que tenia coordenadas del tipo Indice, al estilo de fila y columna que se nos hacía más sencillo manejar luego.


Para la interfaz del PacSim decidimos utilizar una interfaz hecha en consola.


Luego finalmente para administrar la lógica principal del juego, decidimos crear la clase Pacsim que se comunica que las demás clases para encapsular la aplicación y asilarla de la interfaz gráfica, para poder reemplazarla más fácilmente en un futuro.