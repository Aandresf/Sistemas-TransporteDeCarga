package TRANSPORTE.CONTROLADOR.TRANSPORTISTAS;

import TRANSPORTE.CONTROLADOR.UTILS.*;
import TRANSPORTE.MODELO.*;
import TRANSPORTE.MODELO.DAO.*;
import TRANSPORTE.VISTAS.TRANSPORTISTAS.mainTransportistas;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.text.*;

@SuppressWarnings({ "unused", "unchecked" })
public class Control_Transportistas {
    public mainTransportistas vista;
    public String sede;
    
    public Control_Transportistas() {
    }

    public Control_Transportistas(mainTransportistas vista) {
        this.vista = vista;
        this.sede = "";

        actions();
        vista.btnHeader1.setSelected(true);
        vista.btnHeader2.setSelected(false);
        vista.pnlMain2.setVisible(false);
        showTransportistas();

        vista.btnModificarSede1.setVisible(false);
    }

    //METODOS DE LOS TRANSPORTISTAS

    // FILTAR TABLA DE TRANSPORTISTAS
    public void filterStateTransportistas(){
        // new SistemaBibliotecas().cbxSedes.getSelectedItem().toString()
        if (vista.checkEstado2.isSelected()){
            filtrarTabla(vista.tblSedes1,vista.txtFilterSede1.getText(),"", "");
        }else filtrarTabla(vista.tblSedes1,"DISPONIBLE", vista.txtFilterSede1.getText(), "");
    }

    public void deleteTransportista(){
        int id = Integer.parseInt(vista.tblSedes1.getModel().getValueAt(vista.tblSedes1.getSelectedRow(), 0).toString());
        new DAO_Personas().deletePersona(id);
    }

    public final void showTransportistas() {      

        DefaultTableModel modelo;  
        modelo = new DefaultTableModel(){  
            @Override
            public boolean isCellEditable(int row, int column) {
                return  false;
            }
        };

        vista.tblSedes1.setDefaultRenderer(Object.class, new RenderJTable());

        List<Model_Personas> transportistas = new DAO_Personas().getAllTransportistas();

        String[] columnas = {"IDENTIFICACION", "NOMBRE", "TELEFONO", "CORREO", "ESTADO", ""};
        modelo.setColumnIdentifiers(columnas);

        vista.tblSedes1.getColumnModel().setColumnMargin(10);
        vista.tblSedes1.setRowMargin(10);

        for (Model_Personas transportista : transportistas) {
            
            JButton btnModify = new JButton(new ImageIcon(getClass().getResource("/img/iconTableEdit.png")));

            btnModify.addActionListener((ActionEvent) -> {
                System.out.println("mdify click");
                int idTrans = Integer.parseInt(vista.tblSedes1.getModel().getValueAt(vista.tblSedes1.getSelectedRow(), 0).toString());
                Control_FormPersonas frame = new Control_FormPersonas(idTrans);
                
                frame.vista.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e){
                        showTransportistas();
                    }
                });
                
                frame.vista.setLocationRelativeTo(vista);
                frame.loadFormModifyTransportista();
            });

            Object[] renglon = {
                String.valueOf(transportista.getDocumento()),
                transportista.getNombre(),
                transportista.getTelefono(),
                transportista.getCorreo(),
                transportista.getEstado(),
                btnModify
            };

            modelo.addRow(renglon);
        }

        vista.tblSedes1.setModel(modelo);

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
    }

 
    // Metodos generales del menu Sedes

    public void filtrarTabla(JTable tabla, String busqueda1, String busqueda2, String sede) {
    
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

        // Agregamos el segundo filtro
        if (!sede.equals("TODAS")) {
            filtros.add(RowFilter.regexFilter("(?i)" + sede));
        }

        // Combinamos los filtros y los asignamos.
        RowFilter<Object, Object> filtroCompuesto = RowFilter.andFilter(filtros);
        filtro.setRowFilter(filtroCompuesto);
    }

    public void btnSelectPanel(JToggleButton btn){
        
        if(btn.equals(vista.btnHeader1)){
            vista.btnHeader1.setSelected(true);
            vista.pnlMain1.setVisible(true);

            vista.btnHeader2.setSelected(false);
            vista.pnlMain2.setVisible(false);
        }

        if(btn.equals(vista.btnHeader2)){
            vista.btnHeader1.setSelected(false);
            vista.pnlMain1.setVisible(false);

            vista.btnHeader2.setSelected(true);
            vista.pnlMain2.setVisible(true);
        }
    }

    //Metodo de asignacion de funciones
    private void actions(){

        vista.txtFilterSede1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent evt) {
                ((AbstractDocument) vista.txtFilterSede1.getDocument()).setDocumentFilter(new Validaciones.filtroAlphaNumerico());
            }
            @Override
            public void keyReleased(KeyEvent evt) {
                filterStateTransportistas();
            }
        });

/*
        vista.btnFormModifyTransportista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                Control_FormPersonas frame = new Control_FormPersonas();
                frame.vista.setLocationRelativeTo(vista);
                frame.loadFormCreateTransportista();
                
                frame.vista.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e){
                        showTransportistas();
                    }
                });
            }
        });
        
        vista.btnDeleteFromTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                deleteTransportista();
                showTransportistas();
            }
        });
        vista.btnFormModifyTransportista.addActionListener((evt) -> {
            Control_FormPersonas frame = new Control_FormPersonas();
                frame.vista.setLocationRelativeTo(vista);
                frame.loadFormCreateTransportista();
                
                frame.vista.addWindowListener( new WindowAdapter() {
                    @Override
                    public void windowDeactivated(WindowEvent e){
                        showTransportistas();
                    }
                });
        });
*/
        
        vista.btnDeleteFromTable.addActionListener((evt) -> {
            deleteTransportista();
            showTransportistas();
        });

        vista.checkEstado2.addItemListener((ItemEvent) -> {
            
        });

        vista.btnHeader1.addActionListener((evt) -> {
            btnSelectPanel(vista.btnHeader1);
        });
        vista.btnHeader2.addActionListener((evt) -> {
            btnSelectPanel(vista.btnHeader2);
        });

    }

}
