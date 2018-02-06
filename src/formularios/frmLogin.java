package formularios;
import clases.Datos;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by leandraroque on 2/2/18.
 */
public class frmLogin extends JFrame {
    private JLabel lblUsuario;
    private JLabel lblClave;
    private JTextField txtUsuario;
    private JPasswordField txtClave;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JLabel  lblImagen;

    public frmLogin (){
        setTitle("Ingreso al Sistema");
        setResizable(false);
        setSize(390, 180);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Icon icoImagen = new ImageIcon(getClass().getResource("/images/abeja_white1.png"));

        lblUsuario = new JLabel ("Usuario:");
        txtUsuario = new JTextField (10);
        lblClave = new JLabel ("Clave:");
        txtClave = new JPasswordField (10);
        btnAceptar = new JButton ("Aceptar");
        btnCancelar = new JButton ("Cancelar");
        lblImagen = new JLabel (icoImagen);

        btnAceptar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        btnAceptar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAceptar.setToolTipText("Ingresa al Sistema");

        btnCancelar.setHorizontalTextPosition(SwingConstants.HORIZONTAL);
        btnCancelar.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCancelar.setToolTipText("Cierra la Aplicación");

        add (lblUsuario);
        add (txtUsuario);
        add (lblClave);
        add (txtClave);
        add (btnAceptar);
        add (btnCancelar);
        add (lblImagen);

        lblUsuario.reshape(20 ,20 ,100, 20);
        txtUsuario.reshape(120,20,100,20 );
        lblImagen.reshape(250,20,100,100);
        lblClave.reshape(20,45,100,20);
        txtClave.reshape(120,45,100,20);
        btnAceptar.reshape(20,75,90,60);
        btnCancelar.reshape(130,75,90,60);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 btnAceptarActionPerformed(e);

            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                btnCancelarActionPerformed(e);
            }
        });
    }
        private void btnAceptarActionPerformed (ActionEvent e){
            Datos misDatos = new Datos();
            if(!misDatos.validarUsuario(txtUsuario.getText(), new String(txtClave.getPassword()))){

                JOptionPane.showMessageDialog(null,"Usuario o contraseña no validos");
                txtUsuario.setText("");
                txtClave.setText("");
                txtUsuario.requestFocusInWindow();
                return;
            }
                frmPrincipal miPrincipal = new frmPrincipal();
                setVisible(false);
                miPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
                miPrincipal.setVisible(true);
        }
        private void btnCancelarActionPerformed (ActionEvent e){
                System.exit(0);

        }
}
