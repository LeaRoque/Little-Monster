package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leandraroque
 */
public class Datos {
    private Connection cnn;

    public Datos(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String db = "jdbc:mysql://192.168.64.2/lea";
            cnn = DriverManager.getConnection(db,"lea","123");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void cerrarConexion(){
        try {
            cnn.close();
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public boolean validarUsuario(String usuario, String clave){
        String sql = "SELECT 1 FROM Usuario WHERE IDUsuario = '"
                + usuario +"' AND Clave= '" + clave + "'";
        try {
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) return true;
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }
    public Usuario getUsuario (String idUsuario){
        String sql= "SELECT * FROM Usuario WHERE IDUsuario = '" + idUsuario + "' ";
        try {
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Usuario miUsuario = new Usuario(
                        rs.getString("IDUsuario"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Clave"),
                        rs.getInt("IDRol"));
                return miUsuario;
            }else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


    }



}


