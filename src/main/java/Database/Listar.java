package Database;

import Clases.Alumno;

import java.sql.*;

public class Listar {
    public static void notasMediasAlumnos() {
        try(Connection miCon = Database.ConnectionsPool.conectar()){
            System.out.println("ok");
            //preparamos la consulta
            String consulta = "select A.ALUM.NOMBRE, A.MEDIA() from ALUMNOS2 A";
            Statement stmt = miCon.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);
            Alumno alumAux;
            while (rs.next()){
                String alumRs = rs.getString("ALUM.NOMBRE");
                Float alumMedia = rs.getFloat("A.MEDIA()");
                System.out.println(alumRs + ": Nota media: " + alumMedia);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
