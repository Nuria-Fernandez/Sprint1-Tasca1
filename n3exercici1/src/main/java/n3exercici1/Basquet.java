package n3exercici1;

public class Basquet extends Noticia {
    private String competicion;
    private String club;

    public Basquet(String titular, String competicion, String club){
        super(titular);
        this.competicion = competicion;
        this.club = club;
    }
    public String getCompeticion(){
        return competicion;
    }
    public String getClub(){
        return club;
    }
    public void setCompeticion(){
        this.competicion = competicion;
    }

    public void setClub(String club) {
        this.club = club;
    }
    public String toString(){
        return super.toString() + "La conmpetición es " + competicion
                + ". El club es " + club;
    }

    public int calcularPuntuacion(){
        int puntuacion = 4;
        if(competicion.equalsIgnoreCase("Euroliga")){
            puntuacion += 3;
        }
        if(competicion.equalsIgnoreCase("ACB")){
            puntuacion += 2;
        }
        if(club.equalsIgnoreCase("Madrid") || (club.equalsIgnoreCase("Barça"))) {
            puntuacion += 1;
        }

        return puntuacion;
    }
    public int calcularPrecio(){
        int precio = 250;
        if(competicion.equalsIgnoreCase("Euroliga")){
            precio = precio + 75;
        }
        if(club.equalsIgnoreCase("Madrid") || (club.equalsIgnoreCase("Barça"))){
            precio = precio + 75;
        }
        return precio;
    }
}
