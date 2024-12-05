/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR.RUTAS;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.AbstractDocument;

import TRANSPORTE.CONTROLADOR.UTILS.RenderJTable;
import TRANSPORTE.CONTROLADOR.UTILS.Validaciones;
import TRANSPORTE.MODELO.DAO.DAO_Rutas;
import TRANSPORTE.MODELO.Model_Rutas;
import TRANSPORTE.VISTAS.RUTAS.mainRutas;

/**
 *
 * @author arnal
 */
@SuppressWarnings({"unused","unchecked"})
public class Control_Rutas {

    public mainRutas vMain;

    public Control_Rutas() {
    }

    public Control_Rutas(mainRutas vMain) {
        this.vMain = vMain;

        actions();
        showUnidades(vMain.tblSedes2);

        System.out.println("Constructor Mayor");
    }

    //Metodo de asignacion de funciones
    private void actions() {

        vMain.btnHeader1.addActionListener((evt) -> {
            btnSelectPanel(vMain.btnHeader1);
        });

        //METODOS DE LAS RUTAS ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️
        vMain.txtFilterSede3.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) vMain.txtFilterSede3.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                filterStateUnidades(vMain.tblSedes2);
            }
        });

        vMain.btnFormModifyTransportista1.addActionListener((evt) -> {
            Control_FormRuta frame = new Control_FormRuta();
                frame.vista.setLocationRelativeTo(vMain);

                frame.vista.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        showUnidades(vMain.tblSedes2);
                    }
                });
                System.out.println("Registar ruta");
        });

        vMain.btnRecargar1.addActionListener((evt) -> {
            showUnidades(vMain.tblSedes2);
        });

        vMain.tblSedes2.addMouseListener(new MouseAdapter() {
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

    // Metodos generales del menu Sedes
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

    public void btnSelectPanel(JToggleButton btn) {

        if (btn.equals(vMain.btnHeader1)) {
            vMain.btnHeader1.setSelected(true);
            vMain.pnlMain1.setVisible(true);
        }
    }

    // METODOS DE LAS UINDADES ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️

    public void filterStateUnidades(JTable tabla) {    
            filtrarTabla(tabla, "", vMain.txtFilterSede3.getText(), "");
    }

    public void actionBtnModifyUnidad(JTable tabla) {
        int idRow = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());
        if(idRow>0){
            Control_FormRuta frame = new Control_FormRuta();
                frame.vista.setLocationRelativeTo(vMain);
                frame.loadFormModifyTransportista(idRow);
                frame.vista.setVisible(true);
                
                frame.vista.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e){
                        showUnidades(tabla);
                    }
                });
            System.out.println("RUTA " + idRow + " Modificar");
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

        List<Model_Rutas> listObj = new DAO_Rutas().getAllRutas();

        String[] columnas = {"CODIGO", "DESCRIPCION", "KILOMETROS", ""};
        modelo.setColumnIdentifiers(columnas);

        tabla.getColumnModel().setColumnMargin(10);
        tabla.setRowMargin(10);


        for (Model_Rutas obj : listObj) {

            JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));
            btnModify.addActionListener((ActionEvent e) -> {
                actionBtnModifyUnidad(tabla);
            });

            Object[] renglon = {
                String.valueOf(obj.getId()),
                obj.getDescripcion(),
                String.valueOf(obj.getKilometros()),
                btnModify
            };

            modelo.addRow(renglon);
        }

        tabla.setModel(modelo);

        filterStateUnidades(tabla);
    }
}
