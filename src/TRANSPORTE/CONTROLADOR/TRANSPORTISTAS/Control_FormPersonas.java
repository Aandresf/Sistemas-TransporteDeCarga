package TRANSPORTE.CONTROLADOR.TRANSPORTISTAS;

import TRANSPORTE.MODELO.*;
import TRANSPORTE.MODELO.DAO.*;
import TRANSPORTE.MODELO.TABLES_VIEWS.Model_View_DetallesLicencias;
import TRANSPORTE.VISTAS.TRANSPORTISTAS.formTransportista;
import java.awt.event.*;
import java.util.List;
import javax.swing.table.*;

@SuppressWarnings({"unused", "unchecked", "OverridableMethodCallInConstructor"})
public class Control_FormPersonas {

    public formTransportista vista;
    int idPersona;
    public boolean accion;

    public Control_FormPersonas() {
        this.vista = new formTransportista();
        loadFormCreateTransportista();
        events();
    }

    public Control_FormPersonas(int idPersona) {
        this.vista = new formTransportista();
        this.idPersona = idPersona;

        loadFormModifyTransportista();
        events();
    }

    // LIMPIAR EL FORMULARIO
    public void cleanFormModifyTransportista() {
        if (vista.lblControlFormPersona.getText().equals("1")) {
            vista.txtDocumentoPersona.setText("");
            vista.txtNombrePersona.setText("");
            vista.txtTelefonoPersona.setText("");
            vista.txtCorreoPersona.setText("");
            vista.jcbxEstadoPersona.setSelectedIndex(1);

            vista.lblInfoPersona.setText("");
            vista.lblInfoPersona.setVisible(false);

            showLicencias();
        } else {
            loadFormModifyTransportista();
        }
    }

    // CARGAR FORMULARIO PARA INSERTAR UN TRANSPORTISTA
    public void loadFormCreateTransportista() {
        vista.lblControlFormPersona.setText("1");
        vista.lblControlFormPersona.setVisible(false);
        vista.lblTitlePersona.setText("REGISTRAR TRANSPORTISTA");
        vista.lblCategoria3.setVisible(false);
        vista.jcbxEstadoPersona.setVisible(false);

        vista.txtDocumentoPersona.setText("");
        vista.txtNombrePersona.setText("");
        vista.txtTelefonoPersona.setText("");
        vista.txtCorreoPersona.setText("");
        vista.jcbxEstadoPersona.setSelectedIndex(1);

        vista.lblInfoPersona.setText("");
        vista.lblInfoPersona.setVisible(false);

        showLicencias();
        vista.setVisible(true);
    }

    // CARGAR FORMULARIO PARA MODIFICAR UN TRANSPORTISTA
    public void loadFormModifyTransportista() {

        if (idPersona > 0) {

            vista.lblControlFormPersona.setText("2");
            vista.lblTitlePersona.setText("MODIFICAR TRANSPORTISTA");
            vista.lblCategoria3.setVisible(true);
            vista.jcbxEstadoPersona.setVisible(true);

            Model_Personas trans = new DAO_Personas().getTransportista(idPersona);

            vista.txtDocumentoPersona.setEditable(false);
            vista.txtDocumentoPersona.setText(String.valueOf(trans.getDocumento()));
            vista.txtNombrePersona.setText(trans.getNombre());
            vista.txtTelefonoPersona.setText(trans.getTelefono());
            vista.txtCorreoPersona.setText(trans.getCorreo());
            vista.jcbxEstadoPersona.setSelectedItem(trans.getEstado());

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

        int result;

        if (vista.lblControlFormPersona.getText().equals("1")) {
            result = new DAO_Personas().insertPersona(
                    Integer.parseInt(vista.txtDocumentoPersona.getText()),
                    vista.txtNombrePersona.getText(),
                    vista.txtTelefonoPersona.getText(),
                    vista.txtCorreoPersona.getText(),
                    "V",
                    2,
                    1);
        } else {
            result = new DAO_Personas().updatePersona(
                    Integer.parseInt(vista.txtDocumentoPersona.getText()),
                    vista.txtNombrePersona.getText(),
                    vista.txtTelefonoPersona.getText(),
                    vista.txtCorreoPersona.getText(),
                    "V",
                    2,
                    1);
        }

        if (result >= 1) {
            for (int i = 0; i < vista.tblFormPersonas.getRowCount(); i++) {

                int idLicencia = Integer.parseInt(vista.tblFormPersonas.getModel().getValueAt(i, 3).toString());
                int idTransportista = Integer.parseInt(vista.txtDocumentoPersona.getText());
                String codigoLicencia = vista.tblFormPersonas.getModel().getValueAt(i, 1).toString();
                String fechaVencimiento = vista.tblFormPersonas.getModel().getValueAt(i, 2).toString();

                if ((Boolean) vista.tblFormPersonas.getValueAt(i, 0)) {
                    new DAO_Licencias().insertLicencia(
                            idTransportista,
                            idLicencia,
                            codigoLicencia,
                            fechaVencimiento,
                            1);
                } else {
                    new DAO_Licencias().deleteLicencias(idTransportista, idLicencia);
                }
            }

            accion = true;
            vista.setVisible(false);
        } else {
            vista.lblInfoPersona.setText("Error al registar");
            vista.lblInfoPersona.setVisible(true);
        }
    }

    //MOSTRAR LAS LICENCIAS DEL TRANSPORTISTA
    public final void showLicencias() {

        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                if ((Boolean) vista.tblFormPersonas.getValueAt(row, 0)) {
                    return column == 0 || column == 1 || column == 2;
                } else {
                    return column == 0;
                }
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 0) {
                    return Boolean.class;
                }
                return String.class;
            }
        };

        String[] columnas = {"SELECCION", "CODIGO", "VENCIMIENTO", "ID LICENCIA", "GRADO", "DESCRIPCION"};
        modelo.setColumnIdentifiers(columnas);

        int idTransportista = (vista.txtDocumentoPersona.getText().isEmpty()) ? 0 : Integer.parseInt(vista.txtDocumentoPersona.getText());
        List<Model_Licencias> licencias = new DAO_Licencias().getAllLicencias();
        List<Model_View_DetallesLicencias> licTransportista = new DAO_Licencias().getAllViewLicenciasTransportista(idTransportista);

        if (vista.lblControlFormPersona.getText().equals("1")) {
            for (Model_Licencias licencia : licencias) {

                Object[] renglon = {
                    false,
                    "",
                    "",
                    licencia.getCodigo(),
                    licencia.getGrado(),
                    licencia.getDetalles()
                };

                modelo.addRow(renglon);
            }
        } else {
            for (Model_Licencias licencia : licencias) {
                boolean insert = false;

                for (Model_View_DetallesLicencias licTrans : licTransportista) {

                    if (licencia.getCodigo() == licTrans.getId() && licTrans.getEstado() != 99) {

                        Object[] renglon = {
                            true,
                            licTrans.getCodigo(),
                            licTrans.getFechaVencimiento(),
                            licTrans.getId(),
                            licTrans.getTipo(),
                            licTrans.getDescripcion()
                        };

                        modelo.addRow(renglon);
                        insert = true;
                        break;
                    }
                }

                if (!insert) {

                    Object[] renglon = {
                        false,
                        "",
                        "",
                        licencia.getCodigo(),
                        licencia.getGrado(),
                        licencia.getDetalles()
                    };

                    modelo.addRow(renglon);
                }
            }
        }

        vista.tblFormPersonas.setModel(modelo);

        TableColumnModel modeloColumnas = vista.tblFormPersonas.getColumnModel();
        modeloColumnas.removeColumn(modeloColumnas.getColumn(5));
        modeloColumnas.removeColumn(modeloColumnas.getColumn(3));

        vista.tblFormPersonas.getModel().addTableModelListener(e -> {

            if (e.getColumn() == 0 && !(Boolean) vista.tblFormPersonas.getValueAt(e.getFirstRow(), 0)) {
                vista.tblFormPersonas.setValueAt("", e.getFirstRow(), 1);
                vista.tblFormPersonas.setValueAt("", e.getFirstRow(), 2);
            }
        });

    }

    //ASIGNACION DE EVENTOS
    private void events() {

        vista.btnCancelFormPersona.addActionListener(e -> {
            if (vista.tblFormPersonas.getCellEditor() != null) {
                vista.tblFormPersonas.getCellEditor().stopCellEditing();
            }
            vista.setVisible(false);
        });

        vista.btnSetFormPersona.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                insertTransportista();
            }
        });

        vista.btnCleanFormPersona.addActionListener((actionEvent) -> {
            cleanFormModifyTransportista();
        });
    }

}
