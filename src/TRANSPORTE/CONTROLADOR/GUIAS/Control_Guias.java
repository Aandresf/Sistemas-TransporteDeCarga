/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR.GUIAS;

import TRANSPORTE.VISTAS.GUIAS.formGuia;
import TRANSPORTE.VISTAS.GUIAS.mainGuias;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 *
 * @author arnal
 */
public class Control_Guias {
    public mainGuias vMain;

    public Control_Guias() {
    }
    
    public Control_Guias(mainGuias vMain) {
        this.vMain = vMain;
        
        actions();
    }
    
    public void actions(){
    
        vMain.btnHeader6.addActionListener((evt) -> {
            vMain.btnHeader6.setSelected(false);
            String url = "http://localhost:8082"; 
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {}
        });
        
        vMain.btnLoadForm.addActionListener((e) -> {
            Control_FormGuia cForm = new Control_FormGuia();
            cForm.vista.setLocationRelativeTo(vMain);
            cForm.vista.setVisible(true);
        });
    
    
    
    
    }
}
