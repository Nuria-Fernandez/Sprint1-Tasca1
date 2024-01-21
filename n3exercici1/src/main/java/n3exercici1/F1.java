package n3exercici1;

public class F1 extends Noticia {
    private String escuderia;
    public F1(String titular, String escuderia){
        super(titular);
        this.escuderia = escuderia;
    }
    public String getEscuderia(){
        return escuderia;
    }

    public void setEscuderia(String escuderia) {
        this.escuderia = escuderia;
    }
    public String toString(){
        return super.toString() + "Corre con la escudería " + escuderia;
    }

    @Override
    public int calcularPuntuacion() {
        int puntuacion = 4;
        if(escuderia.equalsIgnoreCase("Ferrari") || (escuderia.equalsIgnoreCase("Mercedes"))){
            puntuacion += 2;
        }
        return puntuacion;
    }

    @Override
    public int calcularPrecio() {
        int precio = 100;
        if(escuderia.equalsIgnoreCase("Ferrari") || (escuderia.equalsIgnoreCase("Mercedes"))){
            precio = precio + 50;
        }
        return precio;
    }
}
