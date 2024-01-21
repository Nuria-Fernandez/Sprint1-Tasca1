package n3exercici1;

import java.util.ArrayList;
public class Redactor {

    private String nombre;
    private final String DNI;
    private int sueldo;
    private ArrayList <Noticia> listaNoticias;

    public Redactor(String nombre, String DNI){
        this.nombre = nombre;
        this.DNI = DNI;
        this.sueldo = 1500;
        listaNoticias = new ArrayList <Noticia>();
    }

    public String getNombre(){
        return nombre;
    }
    public String getDNI(){
        return DNI;
    }
    public int getSueldo(){
        return sueldo;
    }
    public ArrayList <Noticia> getListaNoticias() {
        return listaNoticias;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String toString(){
        return "El redactor de llama " + nombre + ", tiene el DNI " + DNI + " y cobra " + sueldo + " euros";
    }

    //incremento de sueldo en un futuro
    public int subidaSueldo(int dineroAnyadido){
        sueldo = sueldo + dineroAnyadido;
        return sueldo;
    }

    public void anyadirNoticia(Noticia noticia) {
        listaNoticias.add(noticia);
    }
    public int buscarNoticia(String titular){
        int indice = -1;
        int i = 0;
        boolean seguirBucle = true;

        while(i < listaNoticias.size() && seguirBucle) {

            if(listaNoticias.get(i).getTitular().equalsIgnoreCase(titular)) {
                indice = i;
                seguirBucle = false;
            }
            i++;
        }
        return indice;
    }

}
