/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO;

/**
 *
 * @author arnal
 */
public class Model_Unidades {

    private int codigo;
    private String localizador;
    private int tipoUnidad;
    private String placa;
    private String marca;
    private String modelo;
    private String anio;
    private String color;
    private int propietario;
    private int tipoCarga;
    private int capacidadCarga;
    private int estado;

    public Model_Unidades() {
    }

    public Model_Unidades(String localizador, int tipoUnidad, String placa, String marca, String modelo, String anio,
            String color, int propietario, int tipoCarga, int capacidadCarga, int estado) {
        this.localizador = localizador;
        this.tipoUnidad = tipoUnidad;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.propietario = propietario;
        this.tipoCarga = tipoCarga;
        this.capacidadCarga = capacidadCarga;
        this.estado = estado;
    }

    public Model_Unidades(int codigo, String localizador, int tipoUnidad, String placa, String marca, String modelo,
            String anio, String color, int propietario, int tipoCarga, int capacidadCarga, int estado) {
        this.codigo = codigo;
        this.localizador = localizador;
        this.tipoUnidad = tipoUnidad;
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.color = color;
        this.propietario = propietario;
        this.tipoCarga = tipoCarga;
        this.capacidadCarga = capacidadCarga;
        this.estado = estado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public int getTipoUnidad() {
        return tipoUnidad;
    }

    public void setTipoUnidad(int tipoUnidad) {
        this.tipoUnidad = tipoUnidad;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPropietario() {
        return propietario;
    }

    public void setPropietario(int propietario) {
        this.propietario = propietario;
    }

    public int getTipoCarga() {
        return tipoCarga;
    }

    public void setTipoCarga(int tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public int getCapacidadCarga() {
        return capacidadCarga;
    }

    public void setCapacidadCarga(int capacidadCarga) {
        this.capacidadCarga = capacidadCarga;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
