public class Punto {
    private int coordenadaX;
    private int coordenadaY;
    private int estado;
    //utilizo el estado para pintar el tipo de barco o el tocado/agua
    Punto(int coordenadaX, int coordenadaY, int tipoBarco){
        this.coordenadaX=coordenadaX;
        this.coordenadaY=coordenadaY;
        switch(tipoBarco){
            case 1:
                this.estado=1;
                break;
            case 2:
                this.estado=2;
                break;
            case 3:
                this.estado=3;
                break;
            case 4:
                this.estado=4;
                break;
            case 5:
                this.estado=5;
                break;
            default:
                this.estado=0;
                break;
        }

    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}