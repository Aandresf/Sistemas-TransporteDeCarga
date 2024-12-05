package TRANSPORTE.CONTROLADOR.GUIAS;

import TRANSPORTE.CONTROLADOR.CLIENTES.Control_Clientes;
import TRANSPORTE.CONTROLADOR.RUTAS.Control_FormRuta;
import TRANSPORTE.CONTROLADOR.RUTAS.Control_Rutas;
import TRANSPORTE.CONTROLADOR.TRANSPORTISTAS.Control_Transportistas;
import TRANSPORTE.CONTROLADOR.UNIDADES.Control_Unidades;
import TRANSPORTE.CONTROLADOR.UTILS.Validaciones;
import TRANSPORTE.MODELO.DAO.DAO_Guias;
import TRANSPORTE.VISTAS.CLIENTES.mainClientes;
import TRANSPORTE.VISTAS.GUIAS.formGuia;
import TRANSPORTE.VISTAS.GUIAS.formSelectionUnidad;
import TRANSPORTE.VISTAS.RUTAS.mainRutas;
import TRANSPORTE.VISTAS.TRANSPORTISTAS.mainTransportistas;
import TRANSPORTE.VISTAS.UNIDADES.mainUnidades;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

@SuppressWarnings({"unused", "OverridableMethodCallInConstructor"})
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

    public void filtrarTabla(JTable tabla, String busqueda1, String busqueda2, String disponible) {

        // Creamos el TableRowSorter y asiganamos a la tabla
        TableRowSorter<TableModel> filtro = new TableRowSorter<>(tabla.getModel());
        tabla.setRowSorter(filtro);

        // creamos una lista con los filtros
        List<RowFilter<Object, Object>> filtros = new ArrayList<>();

        // Agregamos el primer filtro
        if (busqueda1.trim().length() > 0) {
            filtros.add(RowFilter.regexFilter("(?i)" + busqueda1));
        }

        // Agregamos el segundo filtro
        if (busqueda2.trim().length() > 0) {
            filtros.add(RowFilter.regexFilter("(?i)" + busqueda2));
        }

        // Combinamos los filtros y los asignamos.
        RowFilter<Object, Object> filtroCompuesto = RowFilter.andFilter(filtros);
        filtro.setRowFilter(filtroCompuesto);
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
                filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
            }
        });
        
        filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
        frame.setVisible(true);
    }

    public void loadFormUnidad() {
        Control_Unidades main = new Control_Unidades(new mainUnidades());
        formSelectionUnidad frame = new formSelectionUnidad();
        frame.setLocationRelativeTo(vista);

        frame.lblTitlePersona.setText("SELECCIONAR UNIDAD");
        frame.lblInfoForm.setVisible(false);
        frame.lbltipoCarga.setVisible(true);
        frame.lblTipoUnidad.setVisible(true);
        frame.jcbxTipoCarga.setVisible(true);
        frame.jcbxTipoUnidad.setVisible(true);
        frame.btnCleanForm.setVisible(false);

        frame.tblForm.setModel(main.vMain.tblSedes2.getModel());
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(9));
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(8));
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(7));
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(1));
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(0));

        frame.btnSetForm.addActionListener(e -> {
            String placa = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 2).toString();

            String descripcion = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 3).toString();
            
            String unidad = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 0).toString();
            
            vista.lblCodigoUnidad.setText(unidad);
            vista.txtNombrePersona1.setText(descripcion);
            vista.txtDocumentoPersona3.setText(placa);

            frame.dispose();
        });

        frame.txtSearchForm.addKeyListener((KeyListener) new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) frame.txtSearchForm.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            @Override
            public void keyReleased(KeyEvent evt) {
                filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
            }
        });

        frame.jcbxTipoCarga.addActionListener(e -> {
            filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), frame.jcbxTipoCarga.getSelectedItem().toString(), "");
        });

        frame.jcbxTipoCarga.addActionListener(e -> {
            filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), frame.jcbxTipoUnidad.getSelectedItem().toString(), "");
        });
        
        filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
        frame.setVisible(true);
    }

    public void loadFormTransportistas() {
        Control_Transportistas main = new Control_Transportistas(new mainTransportistas());
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
        //frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(4));

        frame.btnSetForm.addActionListener(e -> {
            String cedula = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 0).toString();

            String nombre = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 1).toString();

            vista.txtNombrePersona3.setText(nombre);
            vista.txtDocumentoPersona4.setText(cedula);

            frame.dispose();
        });

        frame.txtSearchForm.addKeyListener((KeyListener) new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) frame.txtSearchForm.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            @Override
            public void keyReleased(KeyEvent evt) {
                filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
            }
        });
        
        filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
        frame.setVisible(true);
    }

    public void loadFormRuta() {
        Control_Rutas main = new Control_Rutas(new mainRutas());
        formSelectionUnidad frame = new formSelectionUnidad();
        frame.setLocationRelativeTo(vista);

        frame.lblTitlePersona.setText("SELECCIONAR RUTA");
        frame.lblInfoForm.setVisible(false);
        frame.lbltipoCarga.setVisible(false);
        frame.lblTipoUnidad.setVisible(false);
        frame.jcbxTipoCarga.setVisible(false);
        frame.jcbxTipoUnidad.setVisible(false);
        frame.btnCleanForm.setVisible(false);

        frame.tblForm.setModel(main.vMain.tblSedes2.getModel());
        frame.tblForm.removeColumn(frame.tblForm.getColumnModel().getColumn(3));
        
        frame.btnSetForm.addActionListener(e -> {

            String ruta = frame.tblForm.getModel().getValueAt(
                    frame.tblForm.convertRowIndexToModel(
                            frame.tblForm.getSelectedRow()), 0).toString();

            Control_FormRuta subFrame = new Control_FormRuta(Integer.parseInt(ruta));

            String salida = subFrame.vista.tblFormPersonas.getModel().getValueAt(
                subFrame.vista.tblFormPersonas.convertRowIndexToModel(
                    0), 1).toString();

            String llegada = subFrame.vista.tblFormPersonas.getModel().getValueAt(
                subFrame.vista.tblFormPersonas.convertRowIndexToModel(
                    subFrame.vista.tblFormPersonas.getRowCount()-1), 1).toString();

            vista.lblCodigoUnidad1.setText(ruta);
            vista.txtDocumentoPersona6.setText(salida);
            vista.txtNombrePersona7.setText(llegada);

            subFrame.vista.dispose();
            frame.dispose();
        });

        frame.txtSearchForm.addKeyListener((KeyListener) new KeyAdapter() {

            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) frame.txtSearchForm.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            @Override
            public void keyReleased(KeyEvent evt) {
                filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
            }
        });
        
        filtrarTabla(frame.tblForm, frame.txtSearchForm.getText(), "", "");
        frame.setVisible(true);
    }

    public void cleanFormGuia(){
        vista.txtDocumentoPersona5.setText("");
        vista.txtNombrePersona4.setText("");
        vista.txtDocumentoPersona3.setText("");
        vista.txtNombrePersona1.setText("");
        vista.txtDocumentoPersona4.setText("");
        vista.txtNombrePersona3.setText("");
        vista.txtNombrePersona6.setText("");
        vista.txtNombrePersona5.setText("");
        vista.txtDocumentoPersona6.setText("");
        vista.txtNombrePersona7.setText("");
        vista.txtNombrePersona2.setText("");
        vista.lblInfoPersona.setText("");
        vista.lblCodigoUnidad1.setText("");
        vista.lblCodigoUnidad.setText("");
    }

    public void insertGuia(){
        if( new DAO_Guias().insertGuia(
            Integer.parseInt(vista.txtDocumentoPersona5.getText()),
            Integer.parseInt(vista.lblCodigoUnidad.getText()),
            Integer.parseInt(vista.txtDocumentoPersona4.getText()),
            1,
            Integer.parseInt(vista.lblCodigoUnidad1.getText()),
            Integer.parseInt(vista.txtNombrePersona6.getText()),
            "2024-12-01", "2024-12-01",
            vista.txtNombrePersona5.getText(),
            vista.txtNombrePersona2.getText(),
            1) > 0){
                vista.dispose();
            } else {
                vista.lblInfoPersona.setText("ERROR AL REGISTRAR");
                vista.lblInfoPersona.setVisible(true);
            }
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
        vista.btnSetFormGuia.addActionListener(e -> {
            insertGuia();
        });

    }

}
