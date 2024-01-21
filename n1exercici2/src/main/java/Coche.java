public class Coche {
    private static final String MARCA = "Audi"; //Por ser constante fija para la clase se inicializa en la declaración
    private static String modelo;
    private final int POTENCIA;

    public Coche(String modelo, int POTENCIA){
        this.modelo = modelo;
        this.POTENCIA = POTENCIA;
    }

    public static final String getMarca(){
        return MARCA;
    }

    public static String getModelo(){
        return modelo;
    }

    public int getPotencia(){
        return POTENCIA;
    }

    public static void setModelo(String modelo){
        Coche.modelo = modelo;
    }

    public String toString(){
        return "El coche es " + MARCA + ", el modelo es " + modelo + " y tiene la potencia de " + POTENCIA + ".";
    }

    public static void frenar(){
        System.out.println("El coche está frenando");
    }

    public void acelerar(){
        System.out.println("El coche está acelerando");
    }


}
