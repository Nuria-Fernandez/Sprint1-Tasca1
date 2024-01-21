package n3exercici1;

public class Tennis extends Noticia {
    private String competicion;
    private String jugador;
    public Tennis(String titular, String competicion, String jugador){
        super(titular);
        this.competicion = competicion;
        this.jugador = jugador;
    }
    public String getCompeticion(){
        return competicion;
    }
    public String getJugador(){
        return jugador;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
    public String toString(){
        return super.toString() + "El jugador " + jugador + "Juega en la competición " + competicion;
    }

    @Override
    public int calcularPuntuacion() {
        int puntuacion = 4;
        if(jugador.equalsIgnoreCase("Federer") || (jugador.equalsIgnoreCase("Nadal") || (jugador.equalsIgnoreCase("Djokovic")))){
            puntuacion += 3;
        }
        return puntuacion;
    }

    @Override
    public int calcularPrecio() {
        int precio = 150;
        if(jugador.equalsIgnoreCase("Federer") || (jugador.equalsIgnoreCase("Nadal") || jugador.equalsIgnoreCase("Djokovic"))){
            precio = precio + 100;
        }
        return precio;
    }
}
