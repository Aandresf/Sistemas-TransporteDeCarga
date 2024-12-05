package TRANSPORTE.CONTROLADOR.RUTAS;

import TRANSPORTE.MODELO.*;
import TRANSPORTE.MODELO.DAO.*;
import TRANSPORTE.VISTAS.RUTAS.formRuta;
import java.awt.event.*;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.*;

@SuppressWarnings({"unused", "unchecked", "OverridableMethodCallInConstructor"})
public class Control_FormRuta {

    public formRuta vista;
    int idPersona;
    public boolean accion;

    public Control_FormRuta() {
        this.vista = new formRuta();
        loadFormCreateTransportista();
        events();
    }

    public Control_FormRuta(int idPersona) {
        this.vista = new formRuta();
        this.idPersona = idPersona;

        loadFormModifyTransportista(idPersona);
        events();
    }

    // LIMPIAR EL FORMULARIO
    public void cleanFormModifyTransportista() {
        if (vista.lblControlFormPersona.getText().equals("1")) {
            vista.txtNombrePersona.setText("");
            vista.txtCorreoPersona.setText("");
            vista.lblEstatusPersona.setText("");

            vista.lblInfoPersona.setText("");
            vista.lblInfoPersona.setVisible(false);

            showLicencias();
        } else {
            loadFormModifyTransportista(idPersona);
        }
    }

    // CARGAR FORMULARIO PARA INSERTAR UN TRANSPORTISTA
    public void loadFormCreateTransportista() {
        vista.lblControlFormPersona.setText("1");
        vista.lblControlFormPersona.setVisible(false);
        vista.lblTitlePersona.setText("CREAR RUTA");

        vista.txtNombrePersona.setText("");
        vista.txtCorreoPersona.setText("");
        vista.lblEstatusPersona.setText("");

        vista.lblInfoPersona.setText("");
        vista.lblInfoPersona.setVisible(false);

        showLicencias();
        vista.setVisible(true);
    }

    // CARGAR FORMULARIO PARA MODIFICAR UN TRANSPORTISTA
    public void loadFormModifyTransportista(int id) {

        if (id > 0) {

            vista.lblControlFormPersona.setText("2");
            vista.lblTitlePersona.setText("MODIFICAR RUTA");

            Model_Rutas obj = new DAO_Rutas().getRuta(id);

            vista.lblEstatusPersona.setText(String.valueOf(obj.getId()));
            vista.txtCorreoPersona.setText(obj.getDescripcion());
            vista.txtNombrePersona.setText(String.valueOf(obj.getKilometros()));

            vista.lblInfoPersona.setText("");
            vista.lblInfoPersona.setVisible(false);

            showLicencias();
            vista.setVisible(true);
        }
    }

    // METODO DE INSERCION DE UN TRANSPORTISTA A LA BASE DE DATOS
    public void insertTransportista() {

        if (vista.tblFormPersonas.getCellEditor() != null) {
            vista.tblFormPersonas.getCellEditor().stopCellEditing();
        }

        int idRuta;

        if (vista.lblControlFormPersona.getText().equals("1")) {
            idRuta = new DAO_Rutas().insertRuta(
                    Integer.parseInt(vista.txtNombrePersona.getText()),
                    vista.txtCorreoPersona.getText());
        } else {
            if (new DAO_Rutas().updateRuta(
                    Integer.parseInt(vista.lblEstatusPersona.getText()),
                    vista.txtCorreoPersona.getText(),
                    Integer.parseInt(vista.txtNombrePersona.getText())
            ) > 0) {
                idRuta = Integer.parseInt(vista.lblEstatusPersona.getText());
            } else {
                idRuta = 0;
            }
        }

        if (idRuta >= 1) {
            for (int i = 0; i < vista.tblFormPersonas.getRowCount(); i++) {

                String descripcionControl = vista.tblFormPersonas.getModel().getValueAt(i, 1).toString();
                String coordX = vista.tblFormPersonas.getModel().getValueAt(i, 2).toString();
                String coordY = vista.tblFormPersonas.getModel().getValueAt(i, 3).toString();
                
                int idControl = vista.tblFormPersonas.getModel().getValueAt(i, 0).toString().equals("") ? 
                    0 : Integer.parseInt(vista.tblFormPersonas.getModel().getValueAt(i, 0).toString());


                if (idControl > 0) {
                    new DAO_Rutas().updateControl(idControl, descripcionControl, coordX, coordY);
                } else {
                    idControl = new DAO_Rutas().insertControl(descripcionControl, coordX, coordY);
                }

                new DAO_Rutas().insertRutaControl(idControl, idRuta);
            }

            accion = true;
            vista.dispose();
        } else {
            vista.lblInfoPersona.setText("Error al registar");
            vista.lblInfoPersona.setVisible(true);
        }
    }

    public void actionBtnModifyControl(JTable tabla) {
        int idRow = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());
        if (idRow > 0) {
            Control_FormPuntoControl frame = new Control_FormPuntoControl(idRow);
            frame.vista.setLocationRelativeTo(vista);
            frame.vista.setVisible(true);

            frame.vista.addWindowListener(new WindowAdapter() {
                @Override
                public void windowDeactivated(WindowEvent e) {
                    showLicencias();
                }
            });
            System.out.println("UNIDAD " + idRow + " Modificar");
        }
    }

    public DefaultTableModel modelControlsRuta() {
        
        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] columnas = {"ID", "DESCRIPCION", "COORD. X", "COORD. Y", ""};
        modelo.setColumnIdentifiers(columnas);

        for (int i = 0; i < vista.tblFormPersonas.getRowCount(); i++) {

            JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));
                btnModify.addActionListener((ActionEvent e) -> {
                    actionBtnModifyControl(vista.tblFormPersonas);
                });

            String descripcionControl = vista.tblFormPersonas.getModel().getValueAt(i, 1).toString();
            String coordX = vista.tblFormPersonas.getModel().getValueAt(i, 2).toString();
            String coordY = vista.tblFormPersonas.getModel().getValueAt(i, 3).toString();

            Object[] renglon = {
                "",
                descripcionControl,
                coordX,
                coordY,
                btnModify
            };

            modelo.addRow(renglon);
            
        }

        return modelo;
    }

    public void createControl(Model_PuntoControl obj){
        DefaultTableModel modelo = modelControlsRuta();

        JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));
                btnModify.addActionListener((ActionEvent e) -> {
                    actionBtnModifyControl(vista.tblFormPersonas);
                });

                Object[] renglon = {
                    "",
                    obj.getDescripcion(),
                    obj.getCoordX(),
                    obj.getCoordY(),
                    btnModify
                };

        modelo.addRow(renglon);
        vista.tblFormPersonas.setModel(modelo);
    }

    //MOSTRAR LAS LICENCIAS DEL TRANSPORTISTA
    public final void showLicencias() {

        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String[] columnas = {"ID", "DESCRIPCION", "COORD. X", "COORD. Y", ""};
        modelo.setColumnIdentifiers(columnas);

        if (!vista.lblControlFormPersona.getText().equals("1")) {

            int id = (vista.lblEstatusPersona.getText().isEmpty()) ? 0 : Integer.parseInt(vista.lblEstatusPersona.getText());
            List<Model_RutaControl> listObjs = new DAO_Rutas().getRutaAllControl(id);

            for (Model_RutaControl obj : listObjs) {

                Model_PuntoControl objControl = new DAO_Rutas().getControl(obj.getControl());

                JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));
                btnModify.addActionListener((ActionEvent e) -> {
                    actionBtnModifyControl(vista.tblFormPersonas);
                });

                Object[] renglon = {
                    objControl.getId(),
                    objControl.getDescripcion(),
                    objControl.getCoordX(),
                    objControl.getCoordY(),
                    btnModify
                };

                modelo.addRow(renglon);

            }
        }

        vista.tblFormPersonas.setModel(modelo);
    }

    //ASIGNACION DE EVENTOS
    private void events() {

        vista.btnCancelFormPersona.addActionListener(e -> {
            if (vista.tblFormPersonas.getCellEditor() != null) {
                vista.tblFormPersonas.getCellEditor().stopCellEditing();
            }
            vista.dispose();
        });

        vista.btnCleanFormPersona.addActionListener((actionEvent) -> {
            cleanFormModifyTransportista();
        });

        vista.btnSetFormPersona1.addActionListener((actionEvent) -> {
            insertTransportista();
        });

        vista.btnSetFormPersona.addActionListener((actionEvent) -> {
            Control_FormPuntoControl frame = new Control_FormPuntoControl();
                frame.vista.setLocationRelativeTo(vista);
                frame.vista.setVisible(true);
                
                frame.vista.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e){
                        if(frame.puntoControl != null){
                            createControl(frame.puntoControl);
                        }
                    }
                });
        });
    }

}
