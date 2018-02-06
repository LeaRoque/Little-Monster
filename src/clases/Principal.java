package clases;
/**
 * Created by leandraroque on 2/2/18.
 */

import formularios.frmLogin;

public class Principal {
    public static void main (String args []){

        frmLogin miLogin = new frmLogin ();
        miLogin.setLocationRelativeTo(null);
        miLogin.setVisible(true);
    }
}
