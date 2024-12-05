/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO;

/**
 *
 * @author arnal
 */
public class Model_Guia {

    private int codigo;
    private int cliente;
    private int unidad;
    private int transportista;
    private int servicio;
    private int ruta;
    private String fechaSalida;
    private String fechaLlegada;
    private int cargaTotal;
    private String detallesCarga;
    private String observaciones;
    private int estatus;

    public Model_Guia() {
    }

    public Model_Guia(int cargaTotal, int cliente, String detallesCarga, int estatus, String fechaLlegada, String fechaSalida, String observaciones, int ruta, int servicio, int transportista, int unidad) {
        this.cargaTotal = cargaTotal;
        this.cliente = cliente;
        this.detallesCarga = detallesCarga;
        this.estatus = estatus;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.observaciones = observaciones;
        this.ruta = ruta;
        this.servicio = servicio;
        this.transportista = transportista;
        this.unidad = unidad;
    }

    public Model_Guia(int cargaTotal, int cliente, int codigo, String detallesCarga, int estatus, String fechaLlegada, String fechaSalida, String observaciones, int ruta, int servicio, int transportista, int unidad) {
        this.cargaTotal = cargaTotal;
        this.cliente = cliente;
        this.codigo = codigo;
        this.detallesCarga = detallesCarga;
        this.estatus = estatus;
        this.fechaLlegada = fechaLlegada;
        this.fechaSalida = fechaSalida;
        this.observaciones = observaciones;
        this.ruta = ruta;
        this.servicio = servicio;
        this.transportista = transportista;
        this.unidad = unidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getUnidad() {
        return unidad;
    }

    public void setUnidad(int unidad) {
        this.unidad = unidad;
    }

    public int getTransportista() {
        return transportista;
    }

    public void setTransportista(int transportista) {
        this.transportista = transportista;
    }

    public int getServicio() {
        return servicio;
    }

    public void setServicio(int servicio) {
        this.servicio = servicio;
    }

    public int getRuta() {
        return ruta;
    }

    public void setRuta(int ruta) {
        this.ruta = ruta;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(String fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
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

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public int getEstatus() {
        return estatus;
    }

    public void setEstatus(int estatus) {
        this.estatus = estatus;
    }




}
