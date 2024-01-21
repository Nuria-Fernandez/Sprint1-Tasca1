package n3exercici1;

public class Futbol extends Noticia {
    private String competicion;
    private String club;
    private String jugador;

    public Futbol(String titular, String competicion, String club, String jugador){
        super(titular);
        this.competicion = competicion;
        this.club = club;
        this.jugador = jugador;
    }

    public String getCompeticion(){
        return competicion;
    }
    public String getClub(){
        return club;
    }
    public String getJugador(){
        return jugador;
    }

    public void setCompeticion(String competicion) {
        this.competicion = competicion;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }
    public String toString(){
        return super.toString() + "La conmpetición es " + competicion
                + ". El club es " + club +
                " y el jugador es " + jugador;
    }

    public int calcularPuntuacion(){
        int puntuacion = 5;
        if(competicion.equalsIgnoreCase("Liga de Campeones")){
            puntuacion += 3;
        }
        if(competicion.equalsIgnoreCase("Liga")){
            puntuacion += 2;
        }
        if(club.equalsIgnoreCase("Madrid") || (club.equalsIgnoreCase("Barça"))){
            puntuacion += 1;
        }
        if(jugador.equalsIgnoreCase("Ferran Torres") || (jugador.equalsIgnoreCase("Benzema"))){
            puntuacion += 1;
        }
        return puntuacion;
    }
    public int calcularPrecio(){//Si compiten en la Liga de Campeones escribe: Liga de Campeones. Y así con el club y el jugador
        int precio = 300;
        if(competicion.equalsIgnoreCase("Liga de Campeones")){
            precio = precio + 100;
        }
        if(club.equalsIgnoreCase("Madrid") || (club.equalsIgnoreCase("Barça"))){
            precio = precio + 100;
        }
        if(jugador.equalsIgnoreCase("Ferran Torres") || (jugador.equalsIgnoreCase("Benzema"))){
            precio = precio + 50;
        }
        return precio;
    }
    
}
