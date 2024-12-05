/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO.TABLES_VIEWS;

/**
 *
 * @author arnal
 */
public class Model_View_DetallesGuias {

    private int codigo;
    private int documentoCliente;
    private String nombreCliente;
    private String placaUnidad;
    private String modeloUnidad;
    private String localizadorUnidad;
    private int documentoTransportista;
    private String nombreTransportista;
    private int ruta;
    private String puntoInicio;
    private String puntoFinal;
    private int cargaTotal;
    private String detallesCarga;
    private String observacionesGuia;
    private int estatus;

    public Model_View_DetallesGuias(
        int cargaTotal, 
    int codigo, 
    String detallesCarga, 
    int documentoCliente, 
    int documentoTransportista, 
    int estatus, 
    String localizadorUnidad, 
    String modeloUnidad, 
    String nombreCliente, 
    String nombreTransportista, 
    String observacionesGuia, 
    String placaUnidad, 
    String puntoFinal, 
    String puntoInicio, 
    int ruta) {
        this.cargaTotal = cargaTotal;
        this.codigo = codigo;
        this.detallesCarga = detallesCarga;
        this.documentoCliente = documentoCliente;
        this.documentoTransportista = documentoTransportista;
        this.estatus = estatus;
        this.localizadorUnidad = localizadorUnidad;
        this.modeloUnidad = modeloUnidad;
        this.nombreCliente = nombreCliente;
        this.nombreTransportista = nombreTransportista;
        this.observacionesGuia = observacionesGuia;
        this.placaUnidad = placaUnidad;
        this.puntoFinal = puntoFinal;
        this.puntoInicio = puntoInicio;
        this.ruta = ruta;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getDocumentoCliente() {
        return documentoCliente;
    }

    public void setDocumentoCliente(int documentoCliente) {
        this.documentoCliente = documentoCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getPlacaUnidad() {
        return placaUnidad;
    }

    public void setPlacaUnidad(String placaUnidad) {
        this.placaUnidad = placaUnidad;
    }

    public String getModeloUnidad() {
        return modeloUnidad;
    }

    public void setModeloUnidad(String modeloUnidad) {
        this.modeloUnidad = modeloUnidad;
    }

    public String getLocalizadorUnidad() {
        return localizadorUnidad;
    }

    public void setLocalizadorUnidad(String localizadorUnidad) {
        this.localizadorUnidad = localizadorUnidad;
    }

    public int getDocumentoTransportista() {
        return documentoTransportista;
    }

    public void setDocumentoTransportista(int documentoTransportista) {
        this.documentoTransportista = documentoTransportista;
    }

    public String getNombreTransportista() {
        return nombreTransportista;
    }

    public void setNombreTransportista(String nombreTransportista) {
        this.nombreTransportista = nombreTransportista;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public String getPuntoInicio() {
        return puntoInicio;
    }

    public void setPuntoInicio(String puntoInicio) {
        this.puntoInicio = puntoInicio;
    }

    public String getPuntoFinal() {
        return puntoFinal;
    }

    public void setPuntoFinal(String puntoFinal) {
        this.puntoFinal = puntoFinal;
    }

    public int getCargaTotal() {
        return cargaTotal;
    }

    public void setCargaTotal(int cargaTotal) {
        this.cargaTotal = cargaTotal;
    }

    public String getDetallesCarga() {
        return detallesCarga;
    }

    public void setDetallesCarga(String detallesCarga) {
        this.detallesCarga = detallesCarga;
    }

    public String getObservacionesGuia() {
        return observacionesGuia;
    }

    public void setObservacionesGuia(String observacionesGuia) {
        this.observacionesGuia = observacionesGuia;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }


    
}
