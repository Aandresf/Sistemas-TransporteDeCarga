/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package TRANSPORTE.CONTROLADOR;

/**
 *
 * @author arnal
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
                /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {

            Control_SistemaTransporte menu = new Control_SistemaTransporte();
            menu.vista.setVisible(true);
        });
    }
    
}
