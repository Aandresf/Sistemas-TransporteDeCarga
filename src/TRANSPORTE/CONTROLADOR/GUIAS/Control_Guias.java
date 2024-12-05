/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR.GUIAS;

import TRANSPORTE.CONTROLADOR.UTILS.RenderJTable;
import TRANSPORTE.CONTROLADOR.UTILS.Validaciones;
import TRANSPORTE.MODELO.DAO.DAO_Guias;
import TRANSPORTE.MODELO.TABLES_VIEWS.Model_View_DetallesGuias;
import TRANSPORTE.VISTAS.GUIAS.mainGuias;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

/**
 *
 * @author arnal
 */
@SuppressWarnings({ "unchecked", "unused" })
public class Control_Guias {

    public mainGuias vMain;

    public Control_Guias() {
    }

    public Control_Guias(mainGuias vMain) {
        this.vMain = vMain;

        actions();
        showUnidades(vMain.tblSedes2);
    }

    public void actionBtnLocalizarUnidad(JTable tabla) {
        int idRow = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 5).toString());
        if(idRow>0){
            String url = "http://localhost:8082"; 
            Desktop desktop = Desktop.getDesktop();
            try {
                desktop.browse(new URI(url));
            } catch (IOException | URISyntaxException e) {}

            System.out.println("UNIDAD " + idRow + " localizar");
        }
    }
    
    public final void showUnidades(JTable tabla) {

        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setDefaultRenderer(Object.class, new RenderJTable());

        List<Model_View_DetallesGuias> listObj = new DAO_Guias().getAllGuia();

        String[] columnas = {"CODIGO", "DOCUMENTO CLIENTE", "NOMBRE CLIENTE", "PLACA UNIDAD", "MODELO UNIDAD", "LOCALIZADOR UNIDAD", "DOCUMENTO TRANSPORTISTA", "NOMBRE TRANSPORTISTA", "RUTA", "PUNTO INICIO", "PUNTO FINAL", "TOTAL DE CARGA", "DETALLES DE CARGA", "OBSERVACIONES DE GUIA", "estatus", "", ""};
        modelo.setColumnIdentifiers(columnas);

        tabla.getColumnModel().setColumnMargin(10);
        tabla.setRowMargin(10);

        for (Model_View_DetallesGuias obj : listObj) {

            JButton btnLocalizador = new JButton(new ImageIcon(getClass().getResource("/img/iconLocalizador.png")));
            btnLocalizador.addActionListener((ActionEvent e) -> {
                actionBtnLocalizarUnidad(tabla);
            });

            JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));
            btnModify.addActionListener((ActionEvent e) -> {
                //actionBtnModifyUnidad(tabla);
            });

            Object[] renglon = {
                String.valueOf(obj.getCodigo()),
                String.valueOf(obj.getDocumentoCliente()),
                obj.getNombreCliente(),
                obj.getPlacaUnidad(),
                obj.getModeloUnidad(),
                obj.getLocalizadorUnidad(),
                String.valueOf(obj.getDocumentoTransportista()),
                obj.getNombreTransportista(),
                String.valueOf(obj.getRuta()),
                obj.getPuntoInicio(),
                obj.getPuntoFinal(),
                String.valueOf(obj.getCargaTotal()),
                obj.getDetallesCarga(),
                obj.getObservacionesGuia(),
                String.valueOf(obj.getEstatus()),
                btnLocalizador, btnModify
            };

            modelo.addRow(renglon);
        }

        tabla.setModel(modelo);
        tabla.removeColumn(tabla.getColumnModel().getColumn(14));
        tabla.removeColumn(tabla.getColumnModel().getColumn(13));
        tabla.removeColumn(tabla.getColumnModel().getColumn(8));
        tabla.removeColumn(tabla.getColumnModel().getColumn(7));
        tabla.removeColumn(tabla.getColumnModel().getColumn(6));
        tabla.removeColumn(tabla.getColumnModel().getColumn(5));
        tabla.removeColumn(tabla.getColumnModel().getColumn(1));
        tabla.removeColumn(tabla.getColumnModel().getColumn(0));
        //filterStatePropietario(tabla);

        tabla.addMouseListener((MouseListener) new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int column = vMain.tblSedes2.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / vMain.tblSedes2.getRowHeight();

                if (row < vMain.tblSedes2.getRowCount() && row >= 0 && column < vMain.tblSedes2.getColumnCount() && column >= 0) {
                    Object value = vMain.tblSedes2.getValueAt(row, column);
                    if (value instanceof JButton jButton) {
                        jButton.doClick();
                    }
                }
            }
        });
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


    private void actions() {

        vMain.btnLoadForm.addActionListener((e) -> {
            Control_FormGuia cForm = new Control_FormGuia();
            cForm.vista.setLocationRelativeTo(vMain);
            cForm.vista.setVisible(true);
        });

        vMain.txtFilterSede3.addKeyListener((KeyListener) new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) vMain.txtFilterSede7.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                filtrarTabla(vMain.tblSedes2, "", vMain.txtFilterSede3.getText(), "");
            }
        });

        

    }
}
