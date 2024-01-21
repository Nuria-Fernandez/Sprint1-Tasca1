package n3exercici1;

public abstract class Noticia {
    protected String titular;
    protected String texto;
    protected int puntuacion;
    protected int precio;

    public Noticia(String titular){
        this.titular = titular;
        puntuacion = puntuacion;
        precio = precio;
        //no hace falta inicializar por defecto todas las variables
    }

    public String getTitular(){
        return titular;
    }
    public String getTexto(){
        return texto;
    }
    public int getPuntuacion(){
        return puntuacion;
    }
    public int getPrecio(){
        return precio;
    }
    public void setTitular(){
        this.texto = texto;
    }
    public String toString(){
        return "El titular es " + titular
                + ". La puntuación es " + puntuacion
                + ". El precio es " + precio + " euros. ";
    }
    public abstract int calcularPuntuacion();
    public abstract int calcularPrecio();

}
