/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR.UNIDADES;

import TRANSPORTE.CONTROLADOR.UTILS.Validaciones;
import TRANSPORTE.VISTAS.UNIDADES.formSelectionPropietario;
import TRANSPORTE.VISTAS.UNIDADES.mainUnidades;
import javax.swing.JTable;
import javax.swing.text.AbstractDocument;

import java.awt.event.*;

/**
 *
 * @author arnal
 */
@SuppressWarnings({"unused","OverridableMethodCallInConstructor"})
public class Control_FormSelectPropietario extends Control_Unidades{
    public formSelectionPropietario vSelectPropoetario;
    String documento, nombre;

    public Control_FormSelectPropietario() {
        super(new Control_Unidades(new mainUnidades()).vMain);
        this.vSelectPropoetario = new formSelectionPropietario();
        vSelectPropoetario.setVisible(true);

        actionsFormSelectPropietario();
        loadPropietarios();
        
    }

    public void loadPropietarios(){
        JTable tabla = vSelectPropoetario.tblFormPersonas;
        showPropietarios(tabla);
        tabla.removeColumn(tabla.getColumnModel().getColumn(4));
        tabla.removeColumn(tabla.getColumnModel().getColumn(3));
        tabla.removeColumn(tabla.getColumnModel().getColumn(2));
    }

    private void actionsFormSelectPropietario(){
        vSelectPropoetario.btnCancelFormPersona.addActionListener((evt) -> {
            vSelectPropoetario.setVisible(false);
        });

        vSelectPropoetario.btnSetFormPersona.addActionListener((evt) -> {
            JTable tabla = vSelectPropoetario.tblFormPersonas;
            documento = tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString();
            nombre = tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 1).toString();
            vSelectPropoetario.setVisible(false);
        });

        vSelectPropoetario.btnSetFormPersona1.addActionListener((evt) -> {
            Control_FormPropietarios frame = new Control_FormPropietarios();
            frame.vista.setLocationRelativeTo(vMain);

            frame.vista.addWindowListener(new WindowAdapter() {
                @Override
                public void windowDeactivated(WindowEvent e) {
                    loadPropietarios();
                }
            });
        });

        vSelectPropoetario.txtFilterSede3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) vSelectPropoetario.txtFilterSede3.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                filtrarTabla(vSelectPropoetario.tblFormPersonas, vSelectPropoetario.txtFilterSede3.getText(), "", "");
            }
        });
    }
}
