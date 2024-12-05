package TRANSPORTE.CONTROLADOR.CLIENTES;

import TRANSPORTE.MODELO.*;
import TRANSPORTE.MODELO.DAO.*;
import TRANSPORTE.VISTAS.CLIENTES.formClientes;
import java.awt.event.*;

@SuppressWarnings({"unused", "OverridableMethodCallInConstructor"})
public class Control_FormCliente {

    public formClientes vista;
    int idPersona;
    public boolean accion;

    public Control_FormCliente() {
        this.vista = new formClientes();
        loadFormCreateCliente();
        events();
    }

    public Control_FormCliente(int idPersona) {
        this.vista = new formClientes();
        this.idPersona = idPersona;

        loadFormModifyCliente();
        events();
    }

    // LIMPIAR EL FORMULARIO
    public void cleanFormModifyCliente() {
        if (vista.lblControlFormPersona.getText().equals("1")) {
            vista.txtDocumentoPersona.setText("");
            vista.jcbxTipoPersona.setSelectedIndex(0);
            vista.txtNombrePersona.setText("");
            vista.txtTelefonoPersona.setText("");
            vista.txtCorreoPersona.setText("");
            vista.jcbxEstadoPersona.setSelectedIndex(1);

            vista.lblInfoPersona.setText("");
            vista.lblInfoPersona.setVisible(false);

        } else {
            loadFormModifyCliente();
        }
    }

    // CARGAR FORMULARIO PARA INSERTAR UN TRANSPORTISTA
    public void loadFormCreateCliente() {
        vista.lblControlFormPersona.setText("1");
        vista.lblControlFormPersona.setVisible(false);
        vista.lblTitlePersona.setText("REGISTRAR CLIENTE");
        vista.lblCategoria3.setVisible(false);
        vista.jcbxEstadoPersona.setVisible(false);

        vista.txtDocumentoPersona.setText("");
        vista.txtNombrePersona.setText("");
        vista.txtTelefonoPersona.setText("");
        vista.txtCorreoPersona.setText("");
        vista.jcbxTipoPersona.setEnabled(true);
        vista.jcbxTipoPersona.setSelectedIndex(0);
        vista.jcbxEstadoPersona.setSelectedIndex(1);

        vista.lblInfoPersona.setText("");
        vista.lblInfoPersona.setVisible(false);

        vista.setVisible(true);
    }

    // CARGAR FORMULARIO PARA MODIFICAR UN TRANSPORTISTA
    public void loadFormModifyCliente() {

        if (idPersona > 0) {

            vista.lblControlFormPersona.setText("2");
            vista.lblTitlePersona.setText("MODIFICAR CLIENTE");
            vista.lblCategoria3.setVisible(true);
            vista.jcbxEstadoPersona.setVisible(true);
            vista.jcbxEstadoPersona.setEnabled(true);

            Model_Clientes obj = new DAO_Clientes().getCliente(idPersona);

            vista.txtDocumentoPersona.setEditable(false);
            vista.txtDocumentoPersona.setText(String.valueOf(obj.getDocumento()));
            vista.txtNombrePersona.setText(obj.getNombre());
            vista.txtTelefonoPersona.setText(obj.getTelefono());
            vista.txtCorreoPersona.setText(obj.getCorreo());
            vista.jcbxTipoPersona.setEnabled(false);
            vista.jcbxTipoPersona.setSelectedItem(obj.getTipoDocumento());
            vista.jcbxEstadoPersona.setSelectedIndex(obj.getEstado());

            vista.lblInfoPersona.setText("");
            vista.lblInfoPersona.setVisible(false);

            vista.setVisible(true);
        }
    }

    // METODO DE INSERCION DE UN TRANSPORTISTA A LA BASE DE DATOS
    public void insertCliente() {

        int result;

        if (vista.lblControlFormPersona.getText().equals("1")) {
            result = new DAO_Clientes().insertCliente(
                    Integer.parseInt(vista.txtDocumentoPersona.getText()),
                    vista.txtNombrePersona.getText(),
                    vista.txtTelefonoPersona.getText(),
                    vista.txtCorreoPersona.getText(),
                    (String)vista.jcbxTipoPersona.getSelectedItem(),
                    1);
        } else {
            result = new DAO_Clientes().updateCliente(
                    Integer.parseInt(vista.txtDocumentoPersona.getText()),
                    vista.txtNombrePersona.getText(),
                    vista.txtTelefonoPersona.getText(),
                    vista.txtCorreoPersona.getText(),
                    (String)vista.jcbxTipoPersona.getSelectedItem(),
                    vista.jcbxEstadoPersona.getSelectedIndex());
        }

        if (result >= 1) {

            vista.setVisible(false);
        } else {
            vista.lblInfoPersona.setText("Error al registar");
            vista.lblInfoPersona.setVisible(true);
        }
    }
    
    //ASIGNACION DE EVENTOS
    private void events() {

        vista.btnCancelFormPersona.addActionListener(e -> {
            vista.setVisible(false);
        });

        vista.btnSetFormPersona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                insertCliente();
            }
        });

        vista.btnCleanFormPersona.addActionListener((actionEvent) -> {
            cleanFormModifyCliente();
        });
    }

}
