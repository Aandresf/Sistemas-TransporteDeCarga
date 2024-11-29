package TRANSPORTE.MODELO.TABLES_VIEWS;

import java.util.Date;

public class Model_View_DetallesLicencias {
    private int id;
    private int cedula;
    private String transportista;
    private String codigo;
    private String tipo;
    private String descripcion;
    private Date fechaVencimiento;
    private int estado;

    public Model_View_DetallesLicencias(int id, int cedula, String transportista, String codigo, String tipo,
            String descripcion, Date fechaVencimiento, int estado) {
        this.id = id;
        this.cedula = cedula;
        this.transportista = transportista;
        this.codigo = codigo;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getTransportista() {
        return transportista;
    }

    public void setTransportista(String transportista) {
        this.transportista = transportista;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento.toString();
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getStringEstado() {
        return  (estado == 0) ? "VENCIDA" : "VIGENTE";
    }

    public int getEstado() {
        return  estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
