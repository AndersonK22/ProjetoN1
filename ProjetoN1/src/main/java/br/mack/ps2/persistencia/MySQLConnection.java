package br.mack.ps2.persistencia;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
        String url = "jdbc:mysql://localhost:3306/projeto_n1?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
        String usuario = "root";
        String psw = "";

        public Connection getConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(url, usuario, psw);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                return null;
            }

        }
}
