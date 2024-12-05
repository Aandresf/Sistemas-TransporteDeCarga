/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO;

/**
 *
 * @author arnal
 */
public class Model_RutaControl {
    private int control;
    private int ruta;

    public Model_RutaControl() { }

    public Model_RutaControl(int control, int ruta) {
        this.control = control;
        this.ruta = ruta;
    }

    public int getControl() { return control; }

    public void setControl(int control) { this.control = control; }

    public int getRuta() { return ruta; }

    public void setRuta(int ruta) { this.ruta = ruta; }
    
}
