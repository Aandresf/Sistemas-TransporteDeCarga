package TRANSPORTE.CONTROLADOR.GUIAS;

import TRANSPORTE.VISTAS.GUIAS.formGuia;
import TRANSPORTE.VISTAS.GUIAS.formSelectionUnidad;

@SuppressWarnings({"unused", "unchecked", "OverridableMethodCallInConstructor"})
public class Control_FormGuia {

    public formGuia vista;
    int idPersona;
    public boolean accion;

    public Control_FormGuia() {
        this.vista = new formGuia();
        events();
    }

    public Control_FormGuia(int idPersona) {
        this.vista = new formGuia();
        this.idPersona = idPersona;

        vista.lblControlFormPersona.setVisible(false);
        vista.lblEstatusPersona.setVisible(false);

        events();
    }

    //ASIGNACION DE EVENTOS
    private void events() {

        vista.btnCancelFormPersona.addActionListener(e -> {
            vista.setVisible(false);
        });

        vista.btnSetFormPersona4.addActionListener(e -> {
            formSelectionUnidad frame = new formSelectionUnidad();
            frame.setLocationRelativeTo(vista);
            
            frame.lblTitlePersona.setText("SELECCIONAR CLIENTE");
            frame.setVisible(true);
        });

        vista.btnSetFormPersona3.addActionListener(e -> {
            formSelectionUnidad frame = new formSelectionUnidad();
            frame.setLocationRelativeTo(vista);
            
            frame.lblTitlePersona.setText("SELECCIONAR UNIDAD");
            frame.setVisible(true);
        });
        vista.btnSetFormPersona2.addActionListener(e -> {
           formSelectionUnidad frame = new formSelectionUnidad();
            frame.setLocationRelativeTo(vista);
            
            frame.lblTitlePersona.setText("SELECCIONAR TRANSPORTISTA");
            frame.setVisible(true);
        });
        vista.btnSetFormPersona5.addActionListener(e -> {
            formSelectionUnidad frame = new formSelectionUnidad();
            frame.setLocationRelativeTo(vista);
            
            frame.lblTitlePersona.setText("SELECCIONAR RUTA");
            frame.setVisible(true);
        });

    }

}
