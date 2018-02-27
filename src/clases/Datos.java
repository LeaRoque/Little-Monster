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
    public Producto getProducto (String idProducto){
        String sql= "SELECT * FROM Producto WHERE IDProducto = '" + idProducto + "' ";
        try {
            Statement st = cnn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if(rs.next()){
                Producto miProducto = new Producto(
                        rs.getString("IDProducto"),
                        rs.getString("Descripcion"),
                        rs.getInt("Precio"),
                        rs.getString("Notas"));
                return miProducto;
            }else {
                return null;
            }

        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }


    }





    public boolean newUsuario(Usuario miUsuario) {
        String sql ="INSERT INTO Usuario VALUES('"
                + miUsuario.getIdUsuario() + "', '"
                + miUsuario.getNombre() + "', '"
                + miUsuario.getApellidos() + "', '"
                + miUsuario.getClave() + "', " + miUsuario.getIdRol() + ")";
        try {
            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean newProducto(Producto miProducto) {
        String sql ="INSERT INTO Producto VALUES('"
                + miProducto.getIdProducto() + "', '"
                + miProducto.getDescripcion() + "', '"
                + miProducto.getPrecio() + "', '"
                + miProducto.getNotas() + "')";
        try {
            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean updateUsuario(Usuario miUsuario) {
        String sql ="UPDATE Usuario SET "
                + "Nombre = '" + miUsuario.getNombre() + "', "
                + "Apellidos = '" + miUsuario.getApellidos() + "', "
                + "Clave = '" + miUsuario.getClave() + "', "
                + "IDRol = "+ miUsuario.getIdRol() + " "
                + "WHERE IDUsuario = '" + miUsuario.getIdUsuario() + "'";
        try {
            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean updateProducto(Producto miProducto) {
        String sql ="UPDATE Producto SET "
                + "Descripcion = '" + miProducto.getDescripcion()+ "', "
                + "Precio = '" + miProducto.getPrecio()+ "', "
                + "Notas = '" + miProducto.getNotas()+ "', "
                + "WHERE IDProducto = '" + miProducto.getIdProducto() + "'";
        try {
            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public boolean deleteUsuario(Usuario miUsuario) {
        String sql ="DELETE FROM Usuario "
                + "WHERE IDUsuario = '" + miUsuario.getIdUsuario() + "'";
        try {
            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    public boolean deleteProducto(Producto miProducto) {
        String sql ="DELETE FROM Producto "
                + "WHERE IDProducto = '" + miProducto.getIdProducto() + "'";
        try {
            Statement st = cnn.createStatement();
            st.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Datos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }



}


