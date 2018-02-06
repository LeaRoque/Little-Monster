package formularios;

import clases.DesktopConFondo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by leandraroque on 2/2/18.
 */
  public class frmPrincipal extends JFrame {


      private JMenuBar mnbFaturacion;
      private JMenu mnuArchivo;
      private JMenu mnuMovimientos;
      private JMenu mnuAyuda;
      private JMenuItem mnuArchivoClientes;
      private JMenuItem mnuArchivoProductos;
      private JMenuItem mnuArchivoUsuarios;
      private JSeparator mnuArchivoSeparador1;
      private JMenuItem mnuArchivoCambioClave;
      private JMenuItem mnuArchivoCambioUsuario;
      private JSeparator mnuArchivoSeparador2;
      private JMenuItem mnuArchivoSalir;
      private JMenuItem mnuMovimientosNuevaFactura;
      private JMenuItem mnuMovimientosReporteFacturas;
      private JMenuItem mnuAyudaAcercaDe;
      private JMenuItem mnuAyudaAyuda;
      private JDesktopPane dpnEscritorio;

      public frmPrincipal (){

          setTitle("Sistema de Facturación");
          setResizable(true);
          setSize(700, 500);
          setLayout(null);
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          //creacion de objetos

          mnbFaturacion= new JMenuBar ();
          mnuArchivo = new JMenu("Archivo");
          mnuMovimientos = new JMenu("Movimientos");
          mnuAyuda = new JMenu("Ayuda");
          mnuArchivoClientes = new JMenuItem("Clientes");
          mnuArchivoProductos = new JMenuItem("Productos");
          mnuArchivoUsuarios = new JMenuItem("Usuarios");
          mnuArchivoSeparador1 = new JSeparator();
          mnuArchivoCambioClave = new JMenuItem("Cambio Clave");
          mnuArchivoCambioUsuario = new JMenuItem("Cambio de Usuario");
          mnuArchivoSeparador2 = new JSeparator();
          mnuArchivoSalir = new JMenuItem("Salir");
          mnuMovimientosNuevaFactura = new JMenuItem("Nueva Factura");
          mnuMovimientosReporteFacturas = new JMenuItem("Reporte Facturas");
          mnuAyudaAcercaDe = new JMenuItem("Acerca de");
          mnuAyudaAyuda= new JMenuItem("Ayuda");
          dpnEscritorio =new DesktopConFondo();

          //Imagen de fondo

          ((DesktopConFondo) dpnEscritorio).setImagen("/images/negro.jpg");


          //Haciendo menus

          mnuArchivo.add(mnuArchivoClientes);
          mnuArchivo.add(mnuArchivoProductos);
          mnuArchivo.add(mnuArchivoUsuarios);
          mnuArchivo.add(mnuArchivoSeparador1);
          mnuArchivo.add(mnuArchivoCambioClave);
          mnuArchivo.add(mnuArchivoCambioUsuario);
          mnuArchivo.add(mnuArchivoSeparador2);
          mnuArchivo.add(mnuArchivoSalir);
          mnbFaturacion.add(mnuArchivo);

          mnuMovimientos.add(mnuMovimientosNuevaFactura);
          mnuMovimientos.add(mnuMovimientosReporteFacturas);
          mnbFaturacion.add(mnuMovimientos);

          mnuAyuda.add(mnuAyudaAcercaDe);
          mnuAyuda.add(mnuAyudaAyuda);
          mnbFaturacion.add(mnuAyuda);

          //Mas propiedades de los formularios
          setJMenuBar(mnbFaturacion);
          setContentPane(dpnEscritorio);

          //Eventos
          mnuArchivoClientes.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuArchivoClientesActionPerformed (e);

              }
          });

          mnuArchivoProductos.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuArchivoProductosActionPerformed (e);

              }
          });

          mnuArchivoUsuarios.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuArchivoUsuariosActionPerformed (e);

              }
          });

          mnuArchivoCambioClave.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuArchivoCambioClaveActionPerformed (e);

              }
          });

          mnuArchivoCambioUsuario.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuArchivoCambioUsuarioActionPerformed (e);

              }
          });

          mnuArchivoSalir.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuArchivoSalirActionPerformed (e);

              }
          });

          mnuMovimientosNuevaFactura.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuMovimientosNuevaFacturaActionPerformed (e);

              }
          });

          mnuMovimientosReporteFacturas.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuMovimientosReporteFacturasActionPerformed (e);

              }
          });
          mnuAyudaAcercaDe.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuAyudaAcercaDeActionPerformed (e);

              }
          });

          mnuAyudaAyuda.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  mnuAyudaAyudaActionPerformed (e);

              }
          });
    }
    private void mnuArchivoClientesActionPerformed (ActionEvent e){
        frmClientes misClientes = new frmClientes();
        dpnEscritorio.add(misClientes);
        misClientes.show();
    }
    private void mnuArchivoProductosActionPerformed (ActionEvent e){
            frmProductos misProductos = new frmProductos();
            dpnEscritorio.add(misProductos);
            misProductos.show();

    }
    private void mnuArchivoUsuariosActionPerformed (ActionEvent e){
            frmUsuarios misUsuarios = new frmUsuarios();
            dpnEscritorio.add(misUsuarios);
            misUsuarios.show();
    }
    private void mnuArchivoCambioClaveActionPerformed (ActionEvent e){

    }
    private void mnuArchivoCambioUsuarioActionPerformed (ActionEvent e){

    }
    private void mnuArchivoSalirActionPerformed (ActionEvent e){
                System.exit(0);
    }
    private void mnuMovimientosNuevaFacturaActionPerformed (ActionEvent e){

    }
    private void mnuMovimientosReporteFacturasActionPerformed (ActionEvent e){

    }

    private void mnuAyudaAcercaDeActionPerformed (ActionEvent e){

    }
    private void mnuAyudaAyudaActionPerformed (ActionEvent e){

    }


}
