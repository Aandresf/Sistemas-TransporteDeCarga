/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO.DAO;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import TRANSPORTE.MODELO.Model_Unidades;
import TRANSPORTE.MODELO.UTILS.Database;

/**
 *
 * @author arnal
 */
@SuppressWarnings({"rawtypes", "unchecked"})
public class DAO_Unidades {

    public int deleteUnidad(int id) {

        // EL ESTATUS 99 ES PARA LOS TRANSPORTISTAS ELIMINADO LOGICAMENTE
        String sql = "UPDATE UNIDADES SET ESTATUS = 99 WHERE CODIGO = " + id + ";";
        return new Database().actualizar(sql);
    }

    public int updateUnidad(
            String localizador,
            int tipoUnidad,
            String placa,
            String marca,
            String modelo,
            String anio,
            String color,
            int propietario,
            int tipoCarga,
            int capacidadCarga,
            int estatus,
            int codigo) {

        String sql = "UPDATE UNIDADES SET "
                + "LOCALIZADOR = '" + localizador
                + "', TIPO_UNIDAD = " + tipoUnidad
                + ", PLACA = '" + placa
                + "', MARCA = '" + marca
                + "', MODELO = '" + modelo
                + "', ANIO = '" + anio
                + "', COLOR = '" + color
                + "', PROPIETARIO = " + propietario
                + ", TIPO_CARGA = " + tipoCarga
                + ", CAPACIDAD_CARGA = " + capacidadCarga
                + ", ESTATUS = " + estatus
                + " WHERE PLACA = '" + placa + "';";

        return new Database().actualizar(sql);
    }

    ;

    public int insertUnidad(String localizador,
            int tipoUnidad,
            String placa,
            String marca,
            String modelo,
            String anio,
            String color,
            int propietario,
            int tipoCarga,
            int capacidadCarga,
            int estatus,
            int codigo) {
        int result;

        // COMPROBAMOS QUE NO ESTE ELIMINADO LOGICAMENTE
        if (new Database().ejecutar("SELECT * FROM UNIDADES WHERE PLACA = '" + placa + "' AND ESTATUS = 99;").isEmpty()) {

            String sql = "INSERT INTO UNIDADES ( LOCALIZADOR, TIPO_UNIDAD, PLACA, MARCA, MODELO, ANIO, COLOR, PROPIETARIO, TIPO_CARGA, CAPACIDAD_CARGA, ESTATUS) VALUES ("
                    + "'" + localizador + "',"
                    + tipoUnidad + ",'"
                    + placa + "','"
                    + marca + "','"
                    + modelo + "','"
                    + anio + "','"
                    + color + "',"
                    + propietario + ","
                    + tipoCarga + ","
                    + capacidadCarga + ","
                    + estatus + ");";

            result = new Database().actualizar(sql);

        } else { // SI ESTA ELIMINADO LOGICAMENTE LO ACTUALIZAMOS
            result = updateUnidad(localizador,
                    tipoUnidad,
                    placa,
                    marca,
                    modelo,
                    anio,
                    color,
                    propietario,
                    tipoCarga,
                    capacidadCarga,
                    estatus,
                    codigo);
        }
        return result;
    }

    ;

    
    public Model_Unidades getUnidad(int id) {
        String sql = "SELECT * FROM UNIDADES WHERE CODIGO = " + id + " AND ESTATUS != 99;";

        List<Map> registros = new Database().ejecutar(sql);
        Model_Unidades obj = null;

        for (Map registro : registros) {
            obj = new Model_Unidades(
                    (int) registro.get("codigo"),
                    (String) registro.get("localizador"),
                    (int) registro.get("tipo_unidad"),
                    (String) registro.get("placa"),
                    (String) registro.get("marca"),
                    (String) registro.get("modelo"),
                    (String) registro.get("anio"),
                    (String) registro.get("color"),
                    (int) registro.get("propietario"),
                    (int) registro.get("tipo_carga"),
                    (int) registro.get("capacidad_carga"),
                    (int) registro.get("estatus")
            );
        }

        return obj;
    }

    public List getAllUnidades() {
        String sql = "SELECT * FROM UNIDADES WHERE ESTATUS != 99;";
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_Unidades> listObj = new ArrayList();

        for (Map registro : registros) {

            Model_Unidades obj = new Model_Unidades(
                    (int) registro.get("codigo"),
                    (String) registro.get("localizador"),
                    (int) registro.get("tipo_unidad"),
                    (String) registro.get("placa"),
                    (String) registro.get("marca"),
                    (String) registro.get("modelo"),
                    (String) registro.get("anio"),
                    (String) registro.get("color"),
                    (int) registro.get("propietario"),
                    (int) registro.get("tipo_carga"),
                    (int) registro.get("capacidad_carga"),
                    (int) registro.get("estatus")
            );

            listObj.add(obj);
        }

        return listObj;
    }

}
