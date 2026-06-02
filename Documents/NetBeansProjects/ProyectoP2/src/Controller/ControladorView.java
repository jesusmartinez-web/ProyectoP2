/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import View.VentanaPrincipal;
/**
 *
 * @author ThinkPad
 */
public class ControladorView {
    
    static int opcion;
    static public String menuSeleccionado;
    public static boolean activo = true;
    
   public static void controlMenuPrincipal() {
        java.awt.EventQueue.invokeLater(() -> {
            VentanaPrincipal ventanaPrincipal = new VentanaPrincipal();
            ventanaPrincipal.setVisible(true);
        });
    }
    
}
