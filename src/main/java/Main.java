import static Database.Insertar.insertAlumno;
import static Database.Listar.notasMediasAlumnos;
import static Database.Llamadas.funVerCiudad;
import static libs.Leer.pedirCadena;

public class Main {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion = "";
        do {
            System.out.println("0. Salir \n" +
                    "1. Leer notas medias de alumnos \n" +
                    "2. Insertar alumnos \n"+
                    "3. Ver ciudad de un alumno");

            opcion = pedirCadena("Introduce una opción");
            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> notasMediasAlumnos();
                case "2" -> insertAlumno();
                case "3" -> funVerCiudad();
                default -> System.out.println("Opción incorrecta");
            }
        } while (!salir);
    }


}
