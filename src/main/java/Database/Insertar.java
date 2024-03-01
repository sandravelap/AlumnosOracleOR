package Database;

import java.sql.Connection;

import java.sql.SQLException;
import java.sql.Statement;

public class Insertar {
    public static void insertAlumno(){
        try(Connection miCon = Database.ConnectionsPool.conectar()){
            System.out.println("ok");
            //preparamos la consulta
            String consulta = "INSERT INTO ALUMNOS2 (ALUM) VALUES(\n" +
                    " PERSONA(2, 'Maria Perez', DIRECCION ('C/Mayor 12', \n" +
                    "                    'Utebo', 50180),'18/12/1999'))\n";
            Statement stmt = miCon.createStatement();
            int registros = stmt.executeUpdate(consulta);
            System.out.println("Registros cambiados: " + registros);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
