package Database;

import libs.Leer;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;


public class Llamadas {
    public static void funVerCiudad(){
        String nombreAlum = Leer.pedirCadena("Introduce el nombre del alumno: ");
        String nombreCiudad;
        try(Connection miCon = ConnectionsPool.conectar()){
            //preparamos la llamada a la función almacenada con call y las llaves
            CallableStatement cs = miCon.prepareCall("{? = call FUN_VER_CIUDAD(?)}");
            //los valores que devuelve la función se definen como OutParameter y hay que asignarles el tipo
            cs.registerOutParameter(1, Types.VARCHAR);
            //los parámetros que necesita la función se pasan con el set correspondiente
            cs.setString(2,nombreAlum);
            cs.execute();
            //recuperamos lo que devuelve la función con el correspondiente get
            nombreCiudad = cs.getString(1);
            System.out.println(nombreCiudad);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
