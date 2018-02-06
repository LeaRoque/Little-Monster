package clases;

/**
 * Created by leandraroque on 3/2/18.
 */

import javax.swing.*;
import java.awt.*;



public class DesktopConFondo extends JDesktopPane {

    private Image imagen;

    public DesktopConFondo() {
    }

    public DesktopConFondo(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(
                    getClass().getResource(nombreImagen)
            ).getImage();
        }
    }

    public DesktopConFondo(Image imagenInicial) {
        if (imagenInicial != null) {
            imagen = imagenInicial;
        }
    }

    public void setImagen(String nombreImagen) {
        if (nombreImagen != null) {
            imagen = new ImageIcon(
                    getClass().getResource(nombreImagen)
            ).getImage();
        } else {

            imagen = null;
        }

        repaint();
    }

    public void setImagen(Image nuevaImagen) {
        imagen = nuevaImagen;

        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (imagen != null) {
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(),
                    this);
            setOpaque(false);
        } else{
            setOpaque(true);
        }

        super.paint(g);
    }
}

