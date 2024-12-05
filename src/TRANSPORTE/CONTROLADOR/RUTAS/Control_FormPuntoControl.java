/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR.RUTAS;

import TRANSPORTE.MODELO.DAO.DAO_Rutas;
import TRANSPORTE.MODELO.Model_PuntoControl;
import TRANSPORTE.VISTAS.RUTAS.formControl;

/**
 *
 * @author arnal
 */
@SuppressWarnings("unused")
public class Control_FormPuntoControl {

    public formControl vista;
    public Model_PuntoControl puntoControl;
    public int id;

    public Control_FormPuntoControl() {
        this.vista = new formControl();
        vista.setVisible(true);

        actions();
    }

    public Control_FormPuntoControl(int id) {
        this.id = id;
        this.vista = new formControl();
        vista.setVisible(true);

        actions();

        loadFormModify();
    }

    private void loadFormModify() {
        vista.lblControlFormPersona.setText("2");
        Model_PuntoControl obj = new DAO_Rutas().getControl(id);
        vista.txtDocumentoPersona.setText(obj.getCoordX());
        vista.txtDocumentoPersona1.setText(obj.getCoordY());
        vista.txtNombrePersona.setText(obj.getDescripcion());
        vista.lblEstatusPersona.setText(String.valueOf(obj.getId()));
    }

    public void insert() {
        puntoControl = new Model_PuntoControl();
        puntoControl.setCoordX(vista.txtDocumentoPersona.getText());
        puntoControl.setCoordY(vista.txtDocumentoPersona1.getText());
        puntoControl.setDescripcion(vista.txtNombrePersona.getText());

        if (vista.lblControlFormPersona.getText().equals("2")) {
            puntoControl.setId(Integer.parseInt(vista.lblEstatusPersona.getText()));
        }
    }

    public void clean() {
        if (vista.lblControlFormPersona.getText().equals("2")) {
            loadFormModify();
        } else {
            vista.txtDocumentoPersona.setText("");
            vista.txtDocumentoPersona1.setText("");
            vista.txtNombrePersona.setText("");
            vista.lblEstatusPersona.setText("");
        }
    }

    private void actions() {
        vista.btnCancelFormPersona.addActionListener((evt) -> {
            vista.dispose();
        });

        vista.btnCleanFormPersona.addActionListener((evt) -> {
            clean();
        });

        vista.btnSetFormPersona.addActionListener((evt) -> {
            insert();
            vista.dispose();
        });
    }
}
