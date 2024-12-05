package TRANSPORTE.CONTROLADOR.GUIAS;

import TRANSPORTE.CONTROLADOR.CLIENTES.Control_Clientes;
import TRANSPORTE.CONTROLADOR.UTILS.Validaciones;
import TRANSPORTE.VISTAS.CLIENTES.mainClientes;
import TRANSPORTE.VISTAS.GUIAS.formGuia;
import TRANSPORTE.VISTAS.GUIAS.formSelectionUnidad;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.text.AbstractDocument;

@SuppressWarnings({"unused", "unchecked", "OverridableMethodCallInConstructor"})
public class Control_FormGuia {

    public formGuia vista;
    int idPersona;
    public boolean accion;

    public Control_FormGuia() {
        this.vista = new formGuia();
        vista.setVisible(true);
        events();
    }

    public Control_FormGuia(int idPersona) {
        this.vista = new formGuia();
        this.idPersona = idPersona;

        vista.lblControlFormPersona.setVisible(false);
        vista.lblEstatusPersona.setVisible(false);

        events();
    }

    public void loadFormCliente() {
        Control_Clientes main = new Control_Clientes(new mainClientes());
        formSelectionUnidad frame = new formSelectionUnidad();
        frame.setLocationRelativeTo(vista);

        frame.lblTitlePersona.setText("SELECCIONAR CLIENTE");
        frame.lblInfoForm.setVisible(false);
        frame.lbltipoCarga.setVisible(false);
        frame.lblTipoUnidad.setVisible(false);
        frame.jcbxTipoCarga.setVisible(false);
        frame.jcbxTipoUnidad.setVisible(false);
        frame.btnCleanForm.setVisible(false);

        frame.tblForm.setModel(main.vista.tblSedes1.getModel());
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(5));
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(4));

        frame.btnSetForm.addActionListener(e -> {
            String cedula = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 0).toString();

            String nombre = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 1).toString();

            vista.txtNombrePersona4.setText(nombre);
            vista.txtDocumentoPersona5.setText(cedula);

            frame.dispose();
        });

        frame.txtSearchForm.addKeyListener((KeyListener) new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) frame.txtSearchForm.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            @Override
            public void keyReleased(KeyEvent evt) {
                main.filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
            }
        });
        
        main.filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
        frame.setVisible(true);
    }

    public void loadFormUnidad() {
        formSelectionUnidad frame = new formSelectionUnidad();
        frame.setLocationRelativeTo(vista);

        frame.lblTitlePersona.setText("SELECCIONAR UNIDAD");
        frame.setVisible(true);
    }

    public void loadFormTransportistas() {
        Control_Clientes main = new Control_Clientes(new mainClientes());
        formSelectionUnidad frame = new formSelectionUnidad();
        frame.setLocationRelativeTo(vista);

        frame.lblTitlePersona.setText("SELECCIONAR TRANSPORTISTA");
        frame.lblInfoForm.setVisible(false);
        frame.lbltipoCarga.setVisible(false);
        frame.lblTipoUnidad.setVisible(false);
        frame.jcbxTipoCarga.setVisible(false);
        frame.jcbxTipoUnidad.setVisible(false);
        frame.btnCleanForm.setVisible(false);

        frame.tblForm.setModel(main.vista.tblSedes1.getModel());
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(5));
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(4));

        frame.btnSetForm.addActionListener(e -> {
            String cedula = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 0).toString();

            String nombre = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 1).toString();

            vista.txtNombrePersona4.setText(nombre);
            vista.txtDocumentoPersona5.setText(cedula);

            frame.dispose();
        });

        frame.txtSearchForm.addKeyListener((KeyListener) new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) frame.txtSearchForm.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            @Override
            public void keyReleased(KeyEvent evt) {
                main.filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
            }
        });
        
        main.filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
        frame.setVisible(true);
    }

    public void loadFormRuta() {
        formSelectionUnidad frame = new formSelectionUnidad();
        frame.setLocationRelativeTo(vista);

        frame.lblTitlePersona.setText("SELECCIONAR RUTA");
        frame.lbltipoCarga.setVisible(false);
        frame.lblTipoUnidad.setVisible(false);
        frame.jcbxTipoCarga.setVisible(false);
        frame.jcbxTipoUnidad.setVisible(false);

        frame.setVisible(true);
    }

    //ASIGNACION DE EVENTOS
    private void events() {

        vista.btnCancelFormGuia.addActionListener(e -> {
            vista.dispose();
        });

        vista.btnSearchCliente.addActionListener(e -> {
            loadFormCliente();
        });

        vista.btnSearchUnidad.addActionListener(e -> {
            loadFormUnidad();
        });

        vista.btnSearchTransportista.addActionListener(e -> {
            loadFormTransportistas();
        });
        vista.btnSearchRuta.addActionListener(e -> {
            loadFormRuta();
        });

    }

}
