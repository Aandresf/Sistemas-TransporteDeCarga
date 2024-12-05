/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR.UNIDADES;

import TRANSPORTE.MODELO.DAO.DAO_Unidades;
import TRANSPORTE.MODELO.Model_Unidades;
import TRANSPORTE.VISTAS.UNIDADES.formUnidades;
import java.awt.event.*;

/**
 *
 * @author arnal
 */
@SuppressWarnings({"unused"})
public class Control_FormUnidades extends Control_Unidades {

    public final formUnidades vFormUnidades;
    Control_FormSelectPropietario framePropietario;
    public Control_FormLocalizador frameLocalizador;

    public Control_FormUnidades() {
        super();
        this.vFormUnidades = new formUnidades();

        vFormUnidades.setLocationRelativeTo(vMain);
        vFormUnidades.setVisible(true);

        actions();
        System.out.println("Constructor");
    }

    private void actions() {
        vFormUnidades.btnSetFormPersona4.addActionListener((evt) -> {
            framePropietario = new Control_FormSelectPropietario();
            framePropietario.vSelectPropoetario.setLocationRelativeTo(vFormUnidades);

            framePropietario.vSelectPropoetario.addWindowListener(new WindowAdapter() {
                @Override
                public void windowDeactivated(WindowEvent e) {
                    vFormUnidades.txtDocumentoPersona5.setText(framePropietario.documento);
                    vFormUnidades.txtNombrePersona4.setText(framePropietario.nombre);
                }
            });
            System.out.println("Seleccionar Propietario");
        });

        vFormUnidades.btnSetFormPersona3.addActionListener((evt) -> {
            frameLocalizador = new Control_FormLocalizador();
            frameLocalizador.vLocalizador.setLocationRelativeTo(vMain);

            frameLocalizador.vLocalizador.addWindowListener(new WindowAdapter() {
                @Override
                public void windowDeactivated(WindowEvent e) {
                    vFormUnidades.txtDocumentoPersona3.setText(frameLocalizador.codigo);
                }
            });
            System.out.println("Seleccionar Localizador");
        });

        vFormUnidades.btnCancelFormPersona.addActionListener((evt) -> {
            vFormUnidades.dispose();
        });

        vFormUnidades.btnSetFormPersona.addActionListener((evt) -> {
            if (frameLocalizador != null) {
                frameLocalizador.insert();
                frameLocalizador.vLocalizador.dispose();
            }
            insert();
            vFormUnidades.dispose();
        });

        vFormUnidades.btnCleanFormPersona.addActionListener((evt) -> {
            cleanFormunidades();
        });
    }

    public void cleanFormunidades() {
        vFormUnidades.txtDocumentoPersona.setText("");
        vFormUnidades.txtCorreoPersona.setText("");
        vFormUnidades.txtNombrePersona.setText("");
        vFormUnidades.txtTelefonoPersona.setText("");
        vFormUnidades.txtTelefonoPersona2.setText("");
        vFormUnidades.txtTelefonoPersona1.setText("");
        vFormUnidades.txtDocumentoPersona5.setText("");
        vFormUnidades.txtDocumentoPersona3.setText("");
        vFormUnidades.txtNombrePersona4.setText("");

        vFormUnidades.jcbxTipoPersona1.setSelectedIndex(0);
        vFormUnidades.jcbxTipoPersona.setSelectedIndex(0);

        vFormUnidades.lblInfoPersona.setText("");
        vFormUnidades.lblInfoPersona.setVisible(false);

        frameLocalizador.vLocalizador.dispose();
    }

    public void loadModifyUnidades(int id) {
        if (id > 0) {
            vFormUnidades.lblControlFormPersona.setText("2");
            vFormUnidades.lblTitlePersona.setText("MODIFICAR UNIDAD");
            vFormUnidades.txtDocumentoPersona.setEnabled(false);

            Model_Unidades obj = new DAO_Unidades().getUnidad(id);

            vFormUnidades.txtDocumentoPersona3.setText(obj.getLocalizador());
            vFormUnidades.jcbxTipoPersona1.setSelectedIndex(obj.getTipoUnidad() - 1);
            vFormUnidades.txtDocumentoPersona.setText(obj.getPlaca());
            vFormUnidades.txtCorreoPersona.setText(obj.getMarca());
            vFormUnidades.txtNombrePersona.setText(obj.getModelo());
            vFormUnidades.txtTelefonoPersona.setText(obj.getAnio());
            vFormUnidades.txtTelefonoPersona1.setText(obj.getColor());
            vFormUnidades.txtDocumentoPersona5.setText(String.valueOf(obj.getPropietario()));
            vFormUnidades.jcbxTipoPersona.setSelectedIndex(obj.getTipoCarga() - 1);
            vFormUnidades.txtTelefonoPersona2.setText(String.valueOf(obj.getCapacidadCarga()));
            vFormUnidades.lblEstatusPersona1.setText(String.valueOf(obj.getEstado()));
            vFormUnidades.lblEstatusPersona.setText(String.valueOf(obj.getCodigo()));
        }
    }

    public void insert() {

        int result;

        if (vFormUnidades.lblControlFormPersona.getText().equals("1")) {
            result = new DAO_Unidades().insertUnidad(
                    vFormUnidades.txtDocumentoPersona3.getText(),
                    vFormUnidades.jcbxTipoPersona1.getSelectedIndex() + 1,
                    vFormUnidades.txtDocumentoPersona.getText(),
                    vFormUnidades.txtCorreoPersona.getText(),
                    vFormUnidades.txtNombrePersona.getText(),
                    vFormUnidades.txtTelefonoPersona.getText(),
                    vFormUnidades.txtTelefonoPersona1.getText(),
                    Integer.parseInt(vFormUnidades.txtDocumentoPersona5.getText()),
                    vFormUnidades.jcbxTipoPersona.getSelectedIndex() + 1,
                    Integer.parseInt(vFormUnidades.txtTelefonoPersona2.getText()),
                    1,
                    Integer.parseInt(vFormUnidades.lblEstatusPersona.getText())
            );
        } else {
            result = new DAO_Unidades().updateUnidad(
                    vFormUnidades.txtDocumentoPersona3.getText(),
                    vFormUnidades.jcbxTipoPersona1.getSelectedIndex() + 1,
                    vFormUnidades.txtDocumentoPersona.getText(),
                    vFormUnidades.txtCorreoPersona.getText(),
                    vFormUnidades.txtNombrePersona.getText(),
                    vFormUnidades.txtTelefonoPersona.getText(),
                    vFormUnidades.txtTelefonoPersona1.getText(),
                    Integer.parseInt(vFormUnidades.txtDocumentoPersona5.getText()),
                    vFormUnidades.jcbxTipoPersona.getSelectedIndex() + 1,
                    Integer.parseInt(vFormUnidades.txtTelefonoPersona2.getText()),
                    Integer.parseInt(vFormUnidades.lblEstatusPersona1.getText()),
                    Integer.parseInt(vFormUnidades.lblEstatusPersona.getText()));
        }

        if (result >= 1) {
            vFormUnidades.dispose();
        } else {
            vFormUnidades.lblInfoPersona.setText("Error al registar");
            vFormUnidades.lblInfoPersona.setVisible(true);
        }
    }
}
