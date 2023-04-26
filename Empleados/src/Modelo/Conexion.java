package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {
    private final String base="empresa";
    private final String user="root";
    private final String password="Giltirspark343";
    private final String url="jdbc:mysql://localhost:3306/"+base;
    private Connection con=null;
    
    public Connection getConexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con =(Connection) DriverManager.getConnection(this.url,this. user,this.password);
        }catch(SQLException e){
            System.err.print(e);
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
        return con;
    }
}

