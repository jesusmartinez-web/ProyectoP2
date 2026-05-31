package View;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class BotonAmarilloAlPasar extends JButton {

    // Constructor obligatorio: Aquí configuras el diseño base del botón
    public BotonAmarilloAlPasar() {
        this.setText("Mi Boton");
        this.setFocusPainted(false);        
        this.setBorderPainted(false);
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                BotonAmarilloAlPasar.this.setForeground(Color.YELLOW);
            }

            @Override
            public void mouseExited(MouseEvent e) {
               BotonAmarilloAlPasar.this.setForeground(Color.BLACK);
                
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Escribe aquí lo que quieres que pasa cuando hacen CLIC (Presionan)
                
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Escribe aquí lo que pasa cuando SUELTAN el clic
                
            }
        });
    }
}