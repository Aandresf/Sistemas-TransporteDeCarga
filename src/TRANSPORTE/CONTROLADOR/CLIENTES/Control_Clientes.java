package TRANSPORTE.CONTROLADOR.CLIENTES;

import TRANSPORTE.CONTROLADOR.UTILS.*;
import TRANSPORTE.MODELO.*;
import TRANSPORTE.MODELO.DAO.*;
import TRANSPORTE.VISTAS.CLIENTES.mainClientes;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;

@SuppressWarnings({"unused", "unchecked"})
public class Control_Clientes {

    public mainClientes vista;
    public String sede;

    public Control_Clientes() {
    }

    public Control_Clientes(mainClientes vista) {
        this.vista = vista;
        this.sede = "";

        actions();
        vista.btnHeader1.setSelected(true);

        showClientes();

        vista.btnModificarSede1.setVisible(false);
    }

    public void deleteCliente() {
        int id = Integer.parseInt(vista.tblSedes1.getModel().getValueAt(vista.tblSedes1.getSelectedRow(), 0).toString());
        new DAO_Clientes().deleteCliente(id);
    }

    //METODOS DE LOS TRANSPORTISTAS
    // FILTAR TABLA DE TRANSPORTISTAS
    public void filterStateCliente() {
        // new SistemaBibliotecas().cbxSedes.getSelectedItem().toString()
        if (vista.checkEstado2.isSelected()) {
            filtrarTabla(vista.tblSedes1, vista.txtFilterSede1.getText(), "", "NO DISPONIBLE");
        } else {
            filtrarTabla(vista.tblSedes1, "", vista.txtFilterSede1.getText(), "");
        }
    }

    public void actionBtnModify() {
        System.out.println("mdify click");
        int idTrans = Integer.parseInt(vista.tblSedes1.getModel().getValueAt(vista.tblSedes1.getSelectedRow(), 0).toString());
        Control_FormCliente frame = new Control_FormCliente(idTrans);

        frame.vista.setLocationRelativeTo(vista);
    }

    public final void showClientes() {

        DefaultTableModel modelo;
        modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        vista.tblSedes1.setDefaultRenderer(Object.class, new RenderJTable());

        List<Model_Clientes> listObj = new DAO_Clientes().getAllClientes();

        String[] columnas = {"IDENTIFICACION", "NOMBRE", "TELEFONO", "CORREO", "ESTADO", ""};
        modelo.setColumnIdentifiers(columnas);

        vista.tblSedes1.getColumnModel().setColumnMargin(10);
        vista.tblSedes1.setRowMargin(10);

        for (Model_Clientes obj : listObj) {

            JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));
            btnModify.addActionListener((ActionEvent) -> { actionBtnModify(); });

            Object[] renglon = {
                String.valueOf(obj.getDocumento()),
                obj.getNombre(),
                obj.getTelefono(),
                obj.getCorreo(),
                (obj.getEstado() == 1)?"DISPONIBLE":"NO DISPONIBLE",
                btnModify
            };

            modelo.addRow(renglon);
        }

        vista.tblSedes1.setModel(modelo);
        filterStateCliente();

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

        if (btn.equals(vista.btnHeader1)) {
            vista.btnHeader1.setSelected(true);
            vista.pnlMain1.setVisible(true);
        }
    }

    //Metodo de asignacion de funciones
    private void actions() {

        vista.tblSedes1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                int column = vista.tblSedes1.getColumnModel().getColumnIndexAtX(evt.getX());
                int row = evt.getY() / vista.tblSedes1.getRowHeight();

                if (row < vista.tblSedes1.getRowCount() && row >= 0 && column < vista.tblSedes1.getColumnCount() && column >= 0) {
                    Object value = vista.tblSedes1.getValueAt(row, column);
                    if (value instanceof JButton jButton) {
                        jButton.doClick();
                    }
                }
            }
        });

        vista.txtFilterSede1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) vista.txtFilterSede1.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }

            @Override
            public void keyReleased(KeyEvent evt) {
                filterStateCliente();
            }
        });

        vista.btnFormModifyTransportista.addActionListener((evt) -> {
            Control_FormCliente frame = new Control_FormCliente();
            frame.vista.setLocationRelativeTo(vista);

            frame.vista.addWindowListener(new WindowAdapter() {
                @Override
                public void windowDeactivated(WindowEvent e) {
                    showClientes();
                }
            });

            System.out.println("crete click");
        });

        vista.btnDeleteFromTable.addActionListener((evt) -> {
            deleteCliente();
            showClientes();
        });

        vista.checkEstado2.addItemListener((ItemEvent) -> {
            filterStateCliente();
        });

        vista.btnHeader1.addActionListener((evt) -> {
            btnSelectPanel(vista.btnHeader1);
        });

        vista.btnRecargar.addActionListener((evt) -> {
            showClientes();
            System.out.println("Clientes Recargados");
        });

    }

}
