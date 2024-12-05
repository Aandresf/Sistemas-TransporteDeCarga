/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR.UNIDADES;

import TRANSPORTE.MODELO.UTILS.Database;
import TRANSPORTE.VISTAS.UNIDADES.formLocalizador;

/**
 *
 * @author arnal
 */
@SuppressWarnings("unused")
public class Control_FormLocalizador {

    public formLocalizador vLocalizador;
    public String codigo;

    public Control_FormLocalizador() {
        this.vLocalizador = new formLocalizador();
        vLocalizador.setVisible(true);

        actions();
    }

    public void insert() {

        String sql = "INSERT INTO LOCALIZADOR (CODIGO, URL, DESCRIPCION) VALUES ('"
                + vLocalizador.txtDocumentoPersona.getText() + "','"
                + vLocalizador.txtNombrePersona.getText() + "','');";

        new Database().actualizar(sql);
    }

    private void actions() {
        vLocalizador.btnCancelFormPersona.addActionListener((evt) -> {
            vLocalizador.setVisible(false);
        });

        vLocalizador.btnCleanFormPersona.addActionListener((evt) -> {
            vLocalizador.txtDocumentoPersona.setText("");
            vLocalizador.txtNombrePersona.setText("");
        });

        vLocalizador.btnSetFormPersona.addActionListener((evt) -> {
            codigo = vLocalizador.txtDocumentoPersona.getText();
            vLocalizador.setVisible(false);
        });
    }
}
