public class App {

    public static void main(String[] args) {
        Coche nuevoCoche = new Coche("A3", 120);
        nuevoCoche.setModelo("A1"); //A diferencia de los demás atriburos este sí se puede cambiar porque no es final
        nuevoCoche.acelerar();
        nuevoCoche.frenar();

        Coche.frenar();//El método static se puede llamar instanciando o desde la clase
        Coche.setModelo("Seat");

    }
}
