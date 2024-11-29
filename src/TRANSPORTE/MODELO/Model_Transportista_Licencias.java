package TRANSPORTE.MODELO;

import java.util.Date;

public class Model_Transportista_Licencias {
    private int id;
    private int transportista;
    private int licencia;
    private String codigo;
    private java.util.Date vencimiento;
    private String estatus;

    public Model_Transportista_Licencias() {
    }

    public Model_Transportista_Licencias(int transportista, int licencia, String codigo, Date vencimiento) {
        this.transportista = transportista;
        this.licencia = licencia;
        this.codigo = codigo;
        this.vencimiento = vencimiento;
    }

    public Model_Transportista_Licencias(int id, int transportista, int licencia, String codigo, Date vencimiento) {
        this.id = id;
        this.transportista = transportista;
        this.licencia = licencia;
        this.codigo = codigo;
        this.vencimiento = vencimiento;
    }

    public Model_Transportista_Licencias(int id, int transportista, int licencia, String codigo, Date vencimiento,
            String estatus) {
        this.id = id;
        this.transportista = transportista;
        this.licencia = licencia;
        this.codigo = codigo;
        this.vencimiento = vencimiento;
        this.estatus = estatus;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTransportista() {
        return transportista;
    }

    public void setTransportista(int transportista) {
        this.transportista = transportista;
    }

    public int getLicencia() {
        return licencia;
    }

    public void setLicencia(int licencia) {
        this.licencia = licencia;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public java.util.Date getVencimiento() {
        return vencimiento;
    }
    
    public void setVencimiento(java.util.Date vencimiento) {
        this.vencimiento = vencimiento;
    }

    
}
