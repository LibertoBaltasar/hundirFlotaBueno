public class Barco {
    Punto[] puntos;
    int tipoBarco;
    //utilizo un int por si se me va la flapa e intento meterlos en diagonal. Si solo quisiera vertical horizontal podría usar un boolean
    //La siguiente implemntación serían las diagonales.
    //La última serían oblicuas
    int orientacion;
    int longitud;
    //podría meter aquí los contadores??????
    static int contadorLancha;
    static int contadorBuque;
    static int contadorAcorazado;
     static int contadorPortavion;
    static int contadorTotal = (contadorLancha*1)+(contadorBuque*3)+(contadorAcorazado*4)+(contadorPortavion*5);
    Barco(int tipoBarco, int orientacion){

    }
}
