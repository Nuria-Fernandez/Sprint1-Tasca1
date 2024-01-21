package n3exercici1;

public class Motociclismo extends Noticia{
    private String equipo;
    public Motociclismo(String titular, String equipo){
        super(titular);
        this.equipo = equipo;
    }
    public String getEquipo(){
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }
    public String toString(){
        return super.toString() + "Juega en el equipo " + equipo;
    }

    @Override
    public int calcularPuntuacion() {
        int puntuacion = 3;
        if((equipo.equalsIgnoreCase("Honda") || equipo.equalsIgnoreCase("Yamaha"))){
            puntuacion += 3;
        }
        return puntuacion;
    }

    @Override
    public int calcularPrecio() {
        int precio = 100;
        if((equipo.equalsIgnoreCase("Honda") || equipo.equalsIgnoreCase("Yamaha"))){
            precio = precio + 50;
        }
        return precio;
    }
}
