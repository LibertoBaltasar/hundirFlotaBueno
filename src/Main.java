import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        final int dimensionesTablero=11;

        //Puedo seleccionar la dificultad haciendo que se elija la cantidad de barcos
        int turno=30;
        boolean victoria;
        Barco.contadorLancha = 2;
        Barco.contadorBuque = 2 ;
        Barco.contadorAcorazado = 1 ;
        Barco.contadorPortavion = 1;
        int[] arrayContadores = new int[] {Barco.contadorTotal,Barco.contadorLancha,Barco.contadorBuque,Barco.contadorAcorazado,Barco.contadorPortavion};
        String[][] tablero= new String[dimensionesTablero][dimensionesTablero];
        rellenarTablero(dimensionesTablero, tablero);
        /*
        el 1 es la cantidad de barcos del tipo que sea
        el 2 es la longitud del barco
        el 3 son las coordenadas
        el 4 es el estado

        int[][][][] arrayLanchas= new int[Barco.contadorLancha][1][2][2];
        int[][][][] arrayBuques= new int[Barco.contadorLancha][3][2][2];
        int[][][][] arrayAcorazados= new int[Barco.contadorLancha][4][2][2];
        int[][][][] arrayPortaviones= new int[Barco.contadorLancha][5][2][2];
        */
        //int dimensionesTablero= introducirDimensiones();

        elegirBarco(arrayContadores, tablero,1, dimensionesTablero);
        elegirBarco(arrayContadores, tablero,2, dimensionesTablero);
        elegirBarco(arrayContadores, tablero,3, dimensionesTablero);
        elegirBarco(arrayContadores, tablero,4, dimensionesTablero);
        visualizarTablero(tablero);
        visualizarTableroAcertado(tablero);


        victoria=disparar(tablero, Barco.contadorTotal,turno);
        mensajeFinal(victoria);


    }
    //Genera números aleatorios
    public static int generarNumeroAleatorio(int minimo, int maximo){
        return (int) (Math.floor(Math.random()*(minimo-maximo+1)+maximo));
    }
    /*En caso de querer modificar las dimensiones del tablero
    public static int introducirDimensiones() {
        Scanner teclado =new Scanner(System.in);
        System.out.println("Introduzca las dimensiones del tablero");
        int dimensiones= teclado.nextInt();
        dimensiones++;
        teclado.close();
        return dimensiones;
    }
    */
    //Me lo rellena con a minusculas porque tanto barcos como la a minuscula cuando se visualizan se muestran como "-"
    public static void rellenarTablero(int dimensionesTablero, String[][] tablero) {
        int numeroColumna=1;

        for (int i = 0; i < dimensionesTablero; i++) {
            for (int j = 0; j < dimensionesTablero; j++) {
                if (i != 0 && j != 0) {
                    tablero[i][j] = "a";
                } else if (i == 0 && j == 0) {
                    tablero[i][j] = " ";
                } else if (i == 0) {
                    tablero[i][j] = "" + (j-1);
                } else {
                    tablero[i][j] = cambioNumerosALetras(numeroColumna);
                    numeroColumna++;
                }
            }
        }
    }
    //Muestra el estado real de la partida(Tablero de la CPU)
    public static void visualizarTablero(String[][]tablero){
        for (int i =0; i<tablero[0].length;i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if(!tablero[i][j].equals("a")){
                    System.out.print(tablero[i][j]+" ");
                }else{
                    System.out.print("- ");
                }

            }
            System.out.println();
        }
    }
    //Muestra  al jugador el tablero marcando en qué casillas ha disparado y su resultado
    public static void visualizarTableroAcertado(String[][]tablero){
        for (int i =0; i<tablero[0].length;i++) {
            for (int j = 0; j < tablero[0].length; j++) {
                if (i!=0&&j!=0&&!tablero[i][j].equals("X")&&!tablero[i][j].equals("A")) {
                    System.out.print("- ");
                }else{
                    System.out.print(tablero[i][j] +" ");
                }
            }
            System.out.println();
        }
    }
    //Cambia de numero(int) a letra(String)
    public static String cambioNumerosALetras(int numeroLetra){
        String letra= "";
        switch (numeroLetra) {
            case (1):
                letra=letra+"A";
                break;
            case (2):
                letra=letra+"B";
                break;
            case (3):
                letra=letra+"C";
                break;
            case (4):
                letra=letra+"D";
                break;
            case (5):
                letra=letra+"E";
                break;
            case (6):
                letra=letra+"F";
                break;
            case (7):
                letra=letra+"G";
                break;
            case (8):
                letra=letra+"H";
                break;
            case (9):
                letra=letra+"I";
                break;
            case (10):
                letra=letra+"J";
                break;
        }
        return letra;
    }
    //Cambia de letra(String) a numero(int)
    public static int cambioLetrasANumeros(String letraString){
        int numero;
        letraString=letraString.toUpperCase();
        char letraChar= letraString.charAt(0);
        switch (letraChar) {
            case ('A'):
                numero=1;
                break;
            case ('B'):
                numero=2;
                break;
            case ('C'):
                numero=3;
                break;
            case ('D'):
                numero=4;
                break;
            case ('E'):
                numero=5;
                break;
            case ('F'):
                numero=6;
                break;
            case ('G'):
                numero=7;
                break;
            case ('H'):
                numero=8;
                break;
            case ('I'):
                numero=9;
                break;
            case ('J'):
                numero=10;
                break;
            default:
                numero=-1;
                break;
        }
        return numero;
    }
    //Cambia de numero(char) a numero(int)
    public static int cambioNumerosANumeros(char numeroChar){
        int numero;
        switch (numeroChar) {
            case ('0'):
                numero=1;
                break;
            case ('1'):
                numero=2;
                break;
            case ('2'):
                numero=3;
                break;
            case ('3'):
                numero=4;
                break;
            case ('4'):
                numero=5;
                break;
            case ('5'):
                numero=6;
                break;
            case ('6'):
                numero=7;
                break;
            case ('7'):
                numero=8;
                break;
            case ('8'):
                numero=9;
                break;
            case ('9'):
                numero=10;
                break;
            default:
                numero=-1;
                break;
        }
        return numero;
    }
    // Prepara para mandar cada barco a colocar y lleva el conteo de la cantidad de barcos que se ponen de cada tipo
    public static  void elegirBarco(int[]arrayContadores, String[][] tablero, int tipoBarco, int dimensionesTablero) {
        boolean orientacion;//orientacionn true---->horizontal
        do {
            //tipoBarco = generarNumeroAleatorio(1,4);
            if(tipoBarco==4){
                orientacion=false;
            }else {
                orientacion=true;
            }
            colocarBarco(tipoBarco,tablero,arrayContadores,orientacion, dimensionesTablero);
        //}while(arrayContadores[1]>0||arrayContadores[2]>0||arrayContadores[3]>0||arrayContadores[4]>0);
        }while(arrayContadores[tipoBarco]>0);
    }
    //GESTIONA LA COLOCACIÓN DEL BARCO --->LLAMA A COMPROBAR PARA SABER QUE SE PUEDE PONER Y SI SE PUEDE LLAMA A MODIFICAR TABLERO PARA AÑADIRLO AL MAPA
    //Genera coordenadas aleatorias las valida llamando a comprobarTableroLibre() y si son validadas se las pasa a modificarTablero() para que las use
    public static void colocarBarco(int tipoBarco, String[][] tablero, int[] arrayContadores, boolean orientacion, int dimensionesTablero){
        int vertical;
        int horizontal;
        int comprobacion;
        int longitud = tipoBarco;
        if (tipoBarco != 1) {
            longitud++;
        }
        do {
            do {
                vertical = generarNumeroAleatorio(0,dimensionesTablero);
                horizontal = generarNumeroAleatorio(0,dimensionesTablero);
            } while ((longitud + horizontal > 10 && orientacion)||(longitud+vertical>10&&!orientacion));
            comprobacion = comprobarTableroLibre(horizontal, vertical, tablero, tipoBarco, longitud);
            if (comprobacion==0){
                modificarTablero(horizontal, vertical, tablero, tipoBarco, longitud);
                arrayContadores[tipoBarco]--;
            }
        } while (comprobacion==1);
    }
    //Recorre las posiciones que ocupa el barco para verificar que están libres
    /*0=agua
    1=tocado
     */
    public static int comprobarTableroLibre(int horizontal, int vertical, String[][] tablero, int tipoBarco, int longitud) {
        int comprobacion = 0;
        int longitudAux = 0;

        if (tipoBarco != 4) {
            do {
                if (!tablero[vertical][horizontal + longitudAux].equals("a")) {
                    comprobacion = 1;
                }
                longitudAux++;
            } while (longitud > longitudAux && comprobacion == 0);
        } else {
            do {
                if (!tablero[vertical + longitudAux][horizontal].equals("a")) {
                    comprobacion = 1;
                }
                longitudAux++;
            } while (longitud > longitudAux && comprobacion == 0);
        }

        return comprobacion;
    }
    //Sustituye las casillas de a por las correspondientes del barco, el agua disparada(A) o el tocado(X)
    public static void modificarTablero(int horizontal, int vertical, String[][]tablero, int tipoBarco, int longitud){
        String letraBarco="a";
        switch(tipoBarco){
            case (1):
                letraBarco="L";
                break;
            case (2):
                letraBarco="B";
                break;
            case (3):
                letraBarco="Z";
                break;
            case (4):
                letraBarco="P";
                break;
            case(5):
                letraBarco="tocado";

        }
        if (tipoBarco==5){
            if(tablero[vertical][horizontal].equals("a")) {
                tablero[vertical][horizontal] = "A";
            }else {
                tablero[vertical][horizontal] = "X";
            }
        }else if(tipoBarco==4){
            for(int i =0; i<longitud;i++){
                tablero[vertical + i][horizontal] = letraBarco;
            }
        }else{
            for (int i=0; i<longitud; i++) {
                tablero[vertical][horizontal + i] = letraBarco;
            }
        }
    }
    /*Gestiona los turnos(disparos) que realiza el jugador. llama a pedircoordenadas() para obtener coordenadas válidas y se las pasa comprobarDisparo()
    Luego procesa el disparo en bucle hasta que se aciertan todos los barcos o se acaban los turnos.
    */
    public static boolean disparar( String[][] tablero, int contadorTotal, int turno){
        int vertical;
        int horizontal;
        int longitud=1;
        int comprobacion;
        int tipoBarco=5;
        boolean victoria;
        int[] coordenadas= new int [2];
        vertical=coordenadas[0];
        horizontal=coordenadas[1];
        do {
            pedirCoordenadas(coordenadas);
            //vertical = generarNumeroAleatorio(0,11);
            //horizontal = generarNumeroAleatorio(0,11);
            vertical=coordenadas[0];
            horizontal=coordenadas[1];
            comprobacion = comprobarDisparo(tablero, vertical, horizontal);
            switch(comprobacion){
                case (0):
                    modificarTablero(horizontal, vertical, tablero, tipoBarco,longitud);
                    System.out.println("Agua");
                    break;
                case (1):
                    modificarTablero(horizontal, vertical, tablero, tipoBarco, longitud);
                    contadorTotal--;
                    System.out.println("Tocado");
                    break;
                case (2):
                    System.out.println("Ya has disparado en esta casilla");
                    //en caso de no querer dar un turno extra por repetir coordenadas comentar la siguiente línea
                    turno++;
                    break;
            }
            turno--;
            System.out.println("Te queda(n): "+turno+"turno(s)");
            System.out.println("Casillas por acertar: " + contadorTotal);
            visualizarTablero(tablero);
            System.out.println("-------------------------------------------------------------------------");
            visualizarTableroAcertado(tablero);

        }while(contadorTotal>0&&turno>0);
        if (contadorTotal==0){
            victoria=true;
        }else{
            victoria=false;
        }
        return victoria;
    }
    /*devuelve un int con el resultado del disparo
    0=agua
    1=tocado
    2=ya disparado
     */
    public static int comprobarDisparo(String[][]tablero, int vertical,int horizontal) {
        int comprobacion;
        if (tablero[vertical][horizontal].equals("a")) {
            comprobacion = 0;
        } else if (!tablero[vertical][horizontal].equals("A") && !tablero[vertical][horizontal].equals("X")) {
            comprobacion = 1;
        } else {
            comprobacion = 2;
        }
        return comprobacion;
    }
    //Pide las coordenadas al usuario y se asegura de que son validas
    public static void pedirCoordenadas(int[] coordenadas){
        Scanner teclado= new Scanner(System.in);
        String coordenadasString;
        do {
            do {
                System.out.println("Por favor introduce las coordenadas.");
                System.out.println("Las coordenadas se escriben sin espacios. Primero la letra de la A  y después el número del 0  al 9");
                coordenadasString = teclado.nextLine();
            }while(coordenadasString.length()!=2);
            coordenadas[0] = cambioLetrasANumeros(coordenadasString);
            coordenadas[1] = cambioNumerosANumeros(coordenadasString.charAt(1));
            if(0>coordenadas[0] || coordenadas[0]>11 ||0>coordenadas[1] || coordenadas[1]>11){
                System.out.println("Introduce unas coordenadas válidas");
            }
        }while((0>coordenadas[0]) || (0>coordenadas[1]));
    }
    //Gestiona el mensaje final de derrota o victoria
    public static void mensajeFinal(boolean victoria){
        if (victoria){
            System.out.println("Felicidades has ganado");
        }else{
            System.out.println("Más suerte la próxima vez");
        }
    }
}