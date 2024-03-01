package Database;

import oracle.jdbc.pool.OracleDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionsPool {

    private static String SERVER = "jdbc:oracle:thin:@//localhost:1523"; //Ruta del SGBD
    private static String BD = "objrel"; //Nombre de la base de datos
    private static String USER = "root"; //Usuario
    private static String PASW = "admin"; //Contraseña

    static DataSource poolConexiones() { //Creamos el pool de conexiones como un DataSource que utilizará el resto de código
        String URL = SERVER + "/" + BD;
        //en este caso usamos un OracleDataSource, pero también sería posible usar un BasicDataSource por ejemplo de Apache
        OracleDataSource oracleDataSource = null;
        try {
            oracleDataSource = new OracleDataSource();
            oracleDataSource.setURL(URL);
            oracleDataSource.setUser(USER);
            oracleDataSource.setPassword(PASW);
            oracleDataSource.setConnectionProperty("maxpoolsize", "10");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        //pasamos el data source a quien pide la conexión
        return oracleDataSource;
    }

    //Método para realizar la conexión.
    public static Connection conectar() throws SQLException { //Creamos la conexión
        return poolConexiones().getConnection(); //cogemos una conexión del DataSource que nos devuelve el pool
    }

}
