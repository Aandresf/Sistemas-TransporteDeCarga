/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.CONTROLADOR.UNIDADES;

import java.awt.Desktop;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
import TRANSPORTE.MODELO.DAO.DAO_Propietarios;
import TRANSPORTE.MODELO.DAO.DAO_Unidades;
import TRANSPORTE.MODELO.Model_Clientes;
import TRANSPORTE.MODELO.Model_Unidades;
import TRANSPORTE.VISTAS.UNIDADES.mainUnidades;

/**
 *
 * @author arnal
 */
@SuppressWarnings({"unused","unchecked"})
public class Control_Unidades {

    public mainUnidades vMain;

    public Control_Unidades() {
    }

    public Control_Unidades(mainUnidades vMain) {
        this.vMain = vMain;

        actions();
        showUnidades(vMain.tblSedes2);
        showPropietarios(vMain.tblSedes6);

        System.out.println("Constructor Mayor");
    }

    //Metodo de asignacion de funciones
    private void actions() {

        vMain.btnHeader1.addActionListener((evt) -> {
            btnSelectPanel(vMain.btnHeader1);
        });

        //METODOS DE LAS UNIDADES ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️
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

        vMain.checkEstado9.addItemListener((ItemEvent) -> {
            filterStateUnidades(vMain.tblSedes2);
        });
        vMain.checkEstado4.addItemListener((ItemEvent) -> {
            filterStateUnidades(vMain.tblSedes2);
        });

        vMain.btnFormModifyTransportista1.addActionListener((evt) -> {
            Control_FormPropietarios frame = new Control_FormPropietarios();
                frame.vista.setLocationRelativeTo(vMain);

                frame.vista.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        showPropietarios(vMain.tblSedes6);
                    }
                });
                System.out.println("Registar unidad");
        });


        vMain.btnDeleteFromTable1.addActionListener((evt) -> {
            deleteUnidad();
            showUnidades(vMain.tblSedes2);
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


        // METODOS DEL PANEL PROPIETARIOS ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️

        vMain.btnHeader2.addActionListener((evt) -> {
            btnSelectPanel(vMain.btnHeader2);
        });

        vMain.txtFilterSede7.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) vMain.txtFilterSede7.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                filterStatePropietario(vMain.tblSedes6);
            }
        });

        vMain.btnModificarSede7.addActionListener((evt) -> {
            actionBtnModifyPropietarios();
        });

        vMain.btnFormModifyTransportista5.addActionListener((evt) -> {
            Control_FormPropietarios frame = new Control_FormPropietarios();
                frame.vista.setLocationRelativeTo(vMain);

                frame.vista.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e) {
                        showPropietarios(vMain.tblSedes6);
                    }
                });
                System.out.println("Registar propietario");
        });

        vMain.btnDeleteFromTable5.addActionListener((evt) -> {
            deletePropietario();
            showPropietarios(vMain.tblSedes6);
        });

        vMain.checkEstado8.addItemListener((ItemEvent) -> {
            filterStatePropietario(vMain.tblSedes6);
        });

        vMain.btnRecargar.addActionListener((evt) -> {
            showPropietarios(vMain.tblSedes6);
            System.out.println("Propietarios Recargados");
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

        RowFilter<Object, Object> filtroNoDisponble = new RowFilter<Object, Object>() {
            @Override
            public boolean include(Entry<? extends Object, ? extends Object> entry) {
                //int columnIndex = tabla.getColumnModel().getColumnIndex(4); 
                String value = entry.getStringValue(4);
                return !value.equalsIgnoreCase("NO DISPONIBLE");
            }
        };

        if (!disponible.equals("NO DISPONIBLE")) {
            filtros.add(filtroNoDisponble);
        }

        // Combinamos los filtros y los asignamos.
        RowFilter<Object, Object> filtroCompuesto = RowFilter.andFilter(filtros);
        filtro.setRowFilter(filtroCompuesto);
    }

    public void btnSelectPanel(JToggleButton btn) {

        if (btn.equals(vMain.btnHeader1)) {
            vMain.btnHeader1.setSelected(true);
            vMain.pnlMain1.setVisible(true);

            vMain.btnHeader2.setSelected(false);
            vMain.pnlMain2.setVisible(false);
        }

        if (btn.equals(vMain.btnHeader2)) {
            vMain.btnHeader1.setSelected(false);
            vMain.pnlMain1.setVisible(false);

            vMain.btnHeader2.setSelected(true);
            vMain.pnlMain2.setVisible(true);
        }
    }

    // METODOS DE LAS UINDADES ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️

    public void filterStateUnidades(JTable tabla) {
        // new SistemaBibliotecas().cbxSedes.getSelectedItem().toString()
         if (vMain.checkEstado9.isSelected()) {
            filtrarTabla(tabla, "", vMain.txtFilterSede3.getText(), "NO DISPONIBLE");
            
        }
        else if (vMain.checkEstado4.isSelected()) {
            filtrarTabla(tabla, "MANTENIMIENTO", vMain.txtFilterSede3.getText(), "");
            
        } else {
            filtrarTabla(tabla, "", vMain.txtFilterSede3.getText(), "");
        }
    }

    public void deleteUnidad(){
        int idRow = Integer.parseInt(vMain.tblSedes2.getModel().getValueAt(vMain.tblSedes2.convertRowIndexToModel(vMain.tblSedes2.getSelectedRow()), 0).toString());
        new DAO_Unidades().deleteUnidad(idRow);
    }

    public void actionBtnModifyUnidad(JTable tabla) {
        int idRow = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());
        if(idRow>0){
            Control_FormUnidades frame = new Control_FormUnidades();
                frame.vFormUnidades.setLocationRelativeTo(vMain);
                frame.loadModifyUnidades(idRow);
                frame.vFormUnidades.setVisible(true);
                
                frame.vFormUnidades.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e){
                        showUnidades(tabla);
                    }
                });
            System.out.println("UNIDAD " + idRow + " Modificar");
        }
    }
    
    public void actionBtnMantenimientoUnidad(JTable tabla) {
        int idRow = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());
        if(idRow>0){
            Control_FormUnidades frame = new Control_FormUnidades();
                frame.vFormUnidades.setLocationRelativeTo(vMain);
                frame.loadModifyUnidades(idRow);
                if (frame.vFormUnidades.lblEstatusPersona1.getText().equals("2")) {
                    frame.vFormUnidades.lblEstatusPersona1.setText("1"); 
                } else {
                    frame.vFormUnidades.lblEstatusPersona1.setText("2"); 
                }
                frame.insert();
                showUnidades(tabla);

            System.out.println("UNIDAD " + idRow + " Mantenimiento");
        }
    }
    
    public void actionBtnLocalizarUnidad(JTable tabla) {
        int idRow = Integer.parseInt(tabla.getModel().getValueAt(tabla.convertRowIndexToModel(tabla.getSelectedRow()), 0).toString());
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

        List<Model_Unidades> listObj = new DAO_Unidades().getAllUnidades();

        String[] columnas = {"CODIGO", "LOCALIZADOR", "PLACA", "MODELO", "TIPO DE CARGA", "CAPACIDAD", "ESTADO", "", "", ""};
        modelo.setColumnIdentifiers(columnas);

        tabla.getColumnModel().setColumnMargin(10);
        tabla.setRowMargin(10);

        String[] cargas = {"PERSONAS","ANIMALES","VARIOS SOLIDOS","VARIOS A GRANEL","VARIOS LIQUIDOS","VARIOS GASEOSOS"};

        for (Model_Unidades obj : listObj) {

            JButton btnLocalizador = new JButton(new ImageIcon(getClass().getResource("/img/iconLocalizador.png")));
            btnLocalizador.addActionListener((ActionEvent e) -> {
                actionBtnLocalizarUnidad(tabla);
            });

            JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));
            btnModify.addActionListener((ActionEvent e) -> {
                actionBtnModifyUnidad(tabla);
            });

            JButton btnMantenimiento = new JButton(new ImageIcon(getClass().getResource("/img/iconMantenimiento.png")));
            btnMantenimiento.addActionListener((ActionEvent e) -> {
                actionBtnMantenimientoUnidad(tabla);
            });

            Object[] renglon = {
                String.valueOf(obj.getCodigo()),
                obj.getLocalizador(),
                obj.getPlaca(),
                obj.getModelo(),
                cargas[obj.getTipoCarga()-1],
                String.valueOf(obj.getCapacidadCarga()),
                (obj.getEstado() == 1) ? "DISPONIBLE" : (obj.getEstado() == 2) ? "MANTENIMIENTO" : "NO DISPONIBLE",
                btnLocalizador, btnMantenimiento, btnModify
            };

            modelo.addRow(renglon);
        }

        tabla.setModel(modelo);
        tabla.removeColumn(tabla.getColumnModel().getColumn(1));
        tabla.removeColumn(tabla.getColumnModel().getColumn(0));
        filterStatePropietario(tabla);
    }

    // METODOS DEL PANEL PROPIETARIOS ⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️⬇️
    
    public void filterStatePropietario(JTable tabla) {
        // new SistemaBibliotecas().cbxSedes.getSelectedItem().toString()
        if (vMain.checkEstado8.isSelected()) {
            filtrarTabla(tabla, vMain.txtFilterSede7.getText(), "", "NO DISPONIBLE");
        } else {
            filtrarTabla(tabla, "", vMain.txtFilterSede7.getText(), "");
        }
    }

    public void deletePropietario() {
        int id = Integer.parseInt(vMain.tblSedes6.getModel().getValueAt(vMain.tblSedes6.getSelectedRow(), 0).toString());
        new DAO_Propietarios().deletePropietario(id);
    }

    public void actionBtnModifyPropietarios() {
        int idTrans = Integer.parseInt(vMain.tblSedes6.getModel().getValueAt(vMain.tblSedes6.getSelectedRow(), 0).toString());
        if(idTrans>0){
            
            Control_FormPropietarios frame = new Control_FormPropietarios(idTrans);
            
            frame.vista.setLocationRelativeTo(vMain);
        }
        System.out.println("mdify click");
    }

    public final void showPropietarios(JTable tabla) {

        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        tabla.setDefaultRenderer(Object.class, new RenderJTable());

        List<Model_Clientes> listObj = new DAO_Propietarios().getAllPropietarios();

        String[] columnas = {"IDENTIFICACION", "NOMBRE", "TELEFONO", "CORREO", "ESTADO", ""};
        modelo.setColumnIdentifiers(columnas);

        tabla.getColumnModel().setColumnMargin(10);
        tabla.setRowMargin(10);

        for (Model_Clientes obj : listObj) {

            JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));
            btnModify.addActionListener((ActionEvent e) -> {
                actionBtnModifyPropietarios();
            });

            Object[] renglon = {
                String.valueOf(obj.getDocumento()),
                obj.getNombre(),
                obj.getTelefono(),
                obj.getCorreo(),
                (obj.getEstado() == 1) ? "DISPONIBLE" : "NO DISPONIBLE",
                btnModify
            };

            modelo.addRow(renglon);
        }

        tabla.setModel(modelo);
        tabla.removeColumn(tabla.getColumnModel().getColumn(5));
        filterStatePropietario(tabla);
    }

}
