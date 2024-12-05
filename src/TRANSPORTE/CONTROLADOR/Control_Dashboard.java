/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR;

import TRANSPORTE.CONTROLADOR.CLIENTES.Control_FormCliente;
import TRANSPORTE.CONTROLADOR.GUIAS.Control_FormGuia;
import TRANSPORTE.CONTROLADOR.UNIDADES.Control_FormUnidades;
import TRANSPORTE.VISTAS.dashboard;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.Timer;

/**
 *
 * @author arnal
 */
public class Control_Dashboard {
    public dashboard vista;
    Timer timer;

    public Control_Dashboard() {
        this.vista = new dashboard();
        vista.setVisible(true);
        actions();
        timer.start();
        
    }
    
    private void actualizarHora() { 
        LocalDateTime ahora = LocalDateTime.now(); 
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
        String textoHora = ahora.format(formatter); 
        vista.lblFecha.setText(textoHora); 
    }
    
    @SuppressWarnings("unused")
    private void actions(){
        timer = new Timer(1000, (ActionEvent e) -> {
            actualizarHora();
        });
        
        vista.btnNewCliente.addActionListener((evt) -> {
            new Control_FormCliente().vista.setLocationRelativeTo(vista);
        });
        
        vista.btnNewUnidad.addActionListener((evt) -> {
            new Control_FormUnidades().vFormUnidades.setLocationRelativeTo(vista);
        });
        
        vista.btnNewGuia.addActionListener((evt) -> {
            new Control_FormGuia().vista.setLocationRelativeTo(vista);
        });   
    };
}
