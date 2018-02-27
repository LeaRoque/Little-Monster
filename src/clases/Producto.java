/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

/**
 *
 * @author leandraroque
 */
public class Producto {
    private String idProducto;
    private String descripcion;
    private int precio;

    private String notas;

    public Producto(String idProducto,
                    String descripcion, int precio, String notas) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.precio = precio;

        this.notas = notas;
    }

    public Producto(String idProducto, String descripcion, int precio, String notas, int idIgic) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }


    public String getNotas() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas = notas;
    }



}
