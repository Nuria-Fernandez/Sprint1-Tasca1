package n3exercici1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList <Redactor> listaRedactores = new ArrayList<Redactor>();
        eligeMenu(listaRedactores);
    }


    static int pedirDato(String mensaje) {
        Scanner input = new Scanner(System.in);
        System.out.println(mensaje);
        int opcion = input.nextInt();
        return opcion;
    }

    static String pedirNombre(String mensaje) {
        Scanner input = new Scanner(System.in);
        System.out.println(mensaje);
        String nombre = input.nextLine();
        return nombre;
    }
    static void eligeMenu(ArrayList <Redactor> listaRedactores) {
        boolean seguirBucle;
        do {
            seguirBucle = menu(pedirDato("Indica el número de la opción que deseas realizar:\n" + "0.Salir del menú\n"
                    + "1.Introduce un redactor\n"
                    + "2.Elimina un redactor\n"
                    + "3.Introduce una noticia\n"
                    + "4.Elimina una noticia\n"
                    + "5.Muestra todas las noticias por redactor\n"
                    + "6.Calcula la puntuación de la noticia\n"
                    + "7.Calcula el precio de la noticia"), listaRedactores);
        }while(seguirBucle);
    }
    static boolean menu(int opcion, ArrayList <Redactor> listaRedactores) {
        boolean seguirBucle = true;
        switch (opcion){
            case 0:
                seguirBucle = false;
                System.out.println("Has salido del menú");
                break;
            case 1:
                introducirRedactor(listaRedactores, pedirNombre("Introduce tu nombre para verificar que aún no constas en la redacción"));
                break;
            case 2:
                eliminarRedactor(listaRedactores, pedirNombre("Introduce el nombre que quieres eliminar"));
                break;
            case 3:
                introducirNoticiaRedactor(listaRedactores, pedirNombre("Introduce el nombre del redactor al que quieres introducirle la noticia"));
                break;
            case 4:
                eliminarNoticia(listaRedactores, pedirNombre("Introduce el nombre del redactor"), pedirNombre("Introduce el titular"));
                break;
            case 5:
                mostrarNoticias(listaRedactores, pedirNombre("Introduce el nombre del redactor"));
                break;
            case 6:
                calcularPuntuacion(listaRedactores, pedirNombre("Introduce el redactor"));
                break;
            case 7:
                calcularPrecio(listaRedactores, pedirNombre("Introduce el redactor"));
                break;
            default:
                System.out.println("El valor introducido no es correcto ");



        }
        return seguirBucle;

    }
    static ArrayList <Redactor> introducirRedactor(ArrayList <Redactor> listaRedactores, String nombreRedactor) {
        int indice = buscarNombreRedactor(listaRedactores, nombreRedactor);
        if (indice > -1 && nombreRedactor.equalsIgnoreCase(listaRedactores.get(indice).getNombre())) {
            System.out.println("Ya existes en nuestra redacción.");
        } else if (indice == -1) {
            System.out.println("Aún no constas en nuestra redacción. Empezemos con el alta");
            Redactor nuevoRedactor = new Redactor(pedirNombre("Nombre:"), pedirNombre("DNI: "));
            listaRedactores.add(nuevoRedactor);
            System.out.println("Acabas de darte de alta en la redacción.");
        }
        return listaRedactores;
    }
    static ArrayList <Redactor> eliminarRedactor(ArrayList <Redactor> listaRedactores, String nombreRedactor){
        String nombre = "";
        int indice = buscarNombreRedactor(listaRedactores, nombreRedactor);
        if(indice > -1 && nombreRedactor.equalsIgnoreCase(listaRedactores.get(indice).getNombre())){
            nombre = listaRedactores.get(indice).getNombre();
            listaRedactores.remove(indice);
            System.out.println("Se ha eliminado a " + nombre );
        } else if(indice == -1) {
            System.out.println("Este nombre no consta en nuestra base de datos.");
        }

       return listaRedactores;
    }
    static void introducirNoticiaRedactor(ArrayList<Redactor>listaRedactores, String nombreRedactor){
        int indice = buscarNombreRedactor(listaRedactores, nombreRedactor);
        if(indice > -1 && nombreRedactor.equalsIgnoreCase(listaRedactores.get(indice).getNombre())){
            String titular = pedirNombre("Introduce el titular que vas a añadir para comprobar que no existe aún");
            int i = listaRedactores.get(indice).buscarNoticia(titular);
            if(i > -1 && titular.equalsIgnoreCase(listaRedactores.get(indice).getListaNoticias().get(i).getTitular())) {
                System.out.println("Ya existe esa noticia.");
            }else if(i == -1) {
                int opcion = pedirDato("¿Qué tipo de noticia quieres introducir? Pon el número correspondiente:\n"
                                                + "1.Noticia de Fútbol\n"
                                                + "2.Noticia de Básquet\n"
                                                + "3.Noticia de Tennis\n"
                                                + "4.Noticia de Fórmula 1\n"
                                                + "5.Noticia de Motociclismo\n");
                switch (opcion){
                    case 1:
                        Futbol noticiaFutbol = new Futbol(pedirNombre("Pon el titular"), pedirNombre("Di la competición. Escribe <Liga de Campeones> si la noticia tiene lugar en esa competición"), pedirNombre("Di el club. Escribe <Barça> o <Madrid> si tiene que ver con estos clubs"), pedirNombre("Di el jugador. Ecribe <Ferran Torres> o <Benzema> si tiene que ver con ellos."));
                        listaRedactores.get(indice).anyadirNoticia(noticiaFutbol);
                        System.out.println("Has introducido tu noticia de fútbol al redactor " + listaRedactores.get(indice).getNombre());
                        break;
                    case 2:
                        Basquet noticiaBasquet = new Basquet(pedirNombre("Pon el titular"), pedirNombre("Di la competición. Escribe <Euroliga> si ha tenido lugar en esa competición"), pedirNombre("Di el club. Escribe <Barça> o <Madrid> si tiene que ver con estos clubs"));
                        listaRedactores.get(indice).anyadirNoticia(noticiaBasquet);
                        System.out.println("Has introducido tu noticia de básquet al redactor " + listaRedactores.get(indice).getNombre());
                        break;
                    case 3:
                        Tennis noticiaTennis = new Tennis(pedirNombre("Pon el titular"), pedirNombre("Di la competición"), pedirNombre("Di el jugador. Ecribe <Federer>, <Nadal> o <Djokovic> si tiene que ver con ellos."));
                        listaRedactores.get(indice).anyadirNoticia(noticiaTennis);
                        System.out.println("Has introducido tu noticia de tenis al redactor " + listaRedactores.get(indice).getNombre());
                        break;
                    case 4:
                        F1 noticiaF1 = new F1(pedirNombre("Pon el titular"), pedirNombre("Di la escudería. Escribe <Ferrari> o <Mercedes> si es una de estas dos escuderías"));
                        listaRedactores.get(indice).anyadirNoticia(noticiaF1);
                        System.out.println("Has introducido tu noticia de fórmula1 al redactor " + listaRedactores.get(indice).getNombre());
                        break;
                    case 5:
                        Motociclismo noticiaMoto = new Motociclismo(pedirNombre("Pon el titular"), pedirNombre("Di el equipo. Escribe <Honda> o <Yamaha> si tiene que ver con alguno de estos equipos."));
                        listaRedactores.get(indice).anyadirNoticia(noticiaMoto);
                        System.out.println("Has introducido tu noticia de motociclismo al redactor " + listaRedactores.get(indice).getNombre());
                        break;
                    default:
                        System.out.println("El valor introducido no es correcto");
                }
            }

        }else if (indice == -1) {
            System.out.println("No estás en la base de datos. Tienes que darte de alta como redactor");
        }
    }
    static void eliminarNoticia(ArrayList <Redactor> listaRedactores, String nombreRedactor, String titular){
        int indice = buscarNombreRedactor(listaRedactores, nombreRedactor);

        if(indice > -1 && nombreRedactor.equalsIgnoreCase(listaRedactores.get(indice).getNombre())){
            int i = listaRedactores.get(indice).buscarNoticia(titular);//me da un indice. n3exercici1.Noticia es un indice
            if(i > -1 && titular.equalsIgnoreCase(listaRedactores.get(indice).getListaNoticias().get(i).getTitular())) {
               Noticia noticiaBorrada = listaRedactores.get(indice).getListaNoticias().remove(i);
                System.out.println("Se ha borrado " + noticiaBorrada.getTitular());
            }else {
                System.out.println("El titular no existe");
            }
        }else{
            System.out.println("El nombre introducido no es válido");
        }
    }

    static void mostrarNoticias(ArrayList <Redactor> listaRedactores, String nombreRedactor){
        int indice = buscarNombreRedactor(listaRedactores, nombreRedactor);
        if(nombreRedactor.equalsIgnoreCase(listaRedactores.get(indice).getNombre())){
            for(int i = 0; i < listaRedactores.get(indice).getListaNoticias().size(); i++){
                System.out.println(listaRedactores.get(indice).getListaNoticias().get(i).toString());
            }
        }else{
            System.out.println("El nombre no existe");
        }
    }
    static void calcularPuntuacion(ArrayList <Redactor> listaRedactores, String nombreRedactor){
        int indice = buscarNombreRedactor(listaRedactores, nombreRedactor);
        if(nombreRedactor.equalsIgnoreCase(listaRedactores.get(indice).getNombre())){
           int i = listaRedactores.get(indice).buscarNoticia(pedirNombre("Introduce el titular de la noticia que quieres puntuar"));
           int puntuacion = listaRedactores.get(indice).getListaNoticias().get(i).calcularPuntuacion();
            System.out.println("La puntuacion de tu noticia es de " + puntuacion);
        }
    }
    static void calcularPrecio(ArrayList <Redactor> listaRedactores, String nombreRedactor){
        int indice = buscarNombreRedactor(listaRedactores, nombreRedactor);
        if(nombreRedactor.equalsIgnoreCase(listaRedactores.get(indice).getNombre())){
            int i = listaRedactores.get(indice).buscarNoticia(pedirNombre("Introduce el titular de la noticia que quieres puntuar"));
            int puntuacion = listaRedactores.get(indice).getListaNoticias().get(i).calcularPrecio();
            System.out.println("El precio de tu noticia es de " + puntuacion);
        }
    }

    static int buscarNombreRedactor(ArrayList <Redactor> listaRedactores, String nombreRedactor){
        int indice = -1;
        int i = 0;
        boolean seguirBucle = true;

        while(i < listaRedactores.size() && seguirBucle) {

            if(nombreRedactor.equalsIgnoreCase(listaRedactores.get(i).getNombre())) {
                indice = i;
                seguirBucle = false;
            }
            i++;
        }
        return indice;
    }
}