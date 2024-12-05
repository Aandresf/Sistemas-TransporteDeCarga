/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO.DAO;

import TRANSPORTE.MODELO.TABLES_VIEWS.Model_View_DetallesGuias;
import TRANSPORTE.MODELO.UTILS.Database;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author arnal
 */
public class DAO_Guias {

    public int deleteGuia(int id){
        
        // EL ESTATUS 99 ES PARA LOS TRANSPORTISTAS ELIMINADO LOGICAMENTE
        String sql = "UPDATE GUIAS SET ESTATUS = 99 WHERE CODIGO = "+ id +";";
        return new Database().actualizar(sql);
    }

    public int updateGuia(
        int codigo,
        int cliente,
        int unidad,
        int transportista,
        int servicio,
        int ruta,
        int cargaTotal,
     String fechaLlegada, 
     String fechaSalida, 
     String detallesCarga, 
     String observaciones,  
     int estatus){
        String sql = "UPDATE GUIAS SET "
        +"CLIENTE = "+ cliente
        +", UNIDAD = "+ unidad
        +", TRANSPORTISTA = "+ transportista 
        +", SERVICIO = "+ servicio
        +", RUTA = "+ ruta
        +", FECHA_SALIDA = '"+ fechaSalida
        +"', FECHA_LLEGADA = '"+ fechaLlegada
        +"', CARGA_TOTAL = "+ cargaTotal
        +", DETALLES_CARGA = '"+ detallesCarga
        +"', OBSERVACIONES = '"+ observaciones
        +"', ESTATUS = "+ estatus 
        +" WHERE CODIGO = "+ codigo +";";

        return new Database().actualizar(sql);
    };

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int insertGuia(
        int cliente,
        int unidad,
        int transportista,
        int servicio,
        int ruta,
        int cargaTotal,
     String fechaLlegada, 
     String fechaSalida, 
     String detallesCarga, 
     String observaciones,  
     int estatus){
        
        String sql = "INSERT INTO GUIAS (CLIENTE, UNIDAD, TRANSPORTISTA, SERVICIO, RUTA, FECHA_SALIDA, FECHHA_LLEGADA, CARGA_TOTAL, DETALLES_CARGA, OBSERVACIONES, ESTATUS) VALUES ("
        + cliente + ", " 
        + unidad + ", " 
        + transportista + ", " 
        + servicio + ", " 
        + ruta + ", '" 
        + fechaSalida + "', '" 
        + fechaLlegada + "', " 
        + cargaTotal + ", '" 
        + detallesCarga + "', '" 
        + observaciones + "'," 
        + estatus + ");";
        
        Database conexion = new Database();
    
        if( conexion.actualizar(sql) > 0 ){
            List<Map> obj = conexion.ejecutar("SELECT currval(pg_get_serial_sequence('GUIAS', 'codigo'));");
            int i = Integer.parseInt(obj.getFirst().get("currval").toString());
            
            return i;
        } else return 0;
    };

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public Model_View_DetallesGuias getGuia(int codigo){
        String sql = "SELECT * FROM \"DETALLES GUIAS\" WHERE \"CODIGO\" = "+ codigo +";";
    
        List<Map> registros = new Database().ejecutar(sql);
        Model_View_DetallesGuias obj = null;

        for (Map registro : registros) {
            obj = new Model_View_DetallesGuias(
                (int)registro.get("TOTAL DE CARGA"),
                (int)registro.get("CODIGO"),
                (String)registro.get("DETALLES DE CARGA"),
                (int)registro.get("DOCUMENTO CLIENTE"),
                (int)registro.get("DOCUMENTO TRANSPORTISTA"),
                (int)registro.get("estatus"),
                (String)registro.get("LOCALIZADOR UNIDAD"),
                (String)registro.get("MODELO UNIDAD"),
                (String)registro.get("NOMBRE CLIENTE"),
                (String)registro.get("NOMBRE TRANSPORTISTA"),
                (String)registro.get("OBSERVACIONES DE GUIA"),
                (String)registro.get("PLACA UNIDAD"),
                (String)registro.get("PUNTO FINAL"),
                (String)registro.get("PUNTO INICIO"),
                (int)registro.get("RUTA")
            );
        }

        return obj;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List getAllGuia(){
        String sql = "SELECT * FROM \"DETALLES GUIAS\" ;";
    
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_View_DetallesGuias> listObjs = new ArrayList();

        for (Map registro : registros) {
        Model_View_DetallesGuias obj = new Model_View_DetallesGuias(
                (int)registro.get("TOTAL DE CARGA"),
                (int)registro.get("CODIGO"),
                (String)registro.get("DETALLES DE CARGA"),
                (int)registro.get("DOCUMENTO CLIENTE"),
                (int)registro.get("DOCUMENTO TRANSPORTISTA"),
                (int)registro.get("estatus"),
                (String)registro.get("LOCALIZADOR UNIDAD"),
                (String)registro.get("MODELO UNIDAD"),
                (String)registro.get("NOMBRE CLIENTE"),
                (String)registro.get("NOMBRE TRANSPORTISTA"),
                (String)registro.get("OBSERVACIONES DE GUIA"),
                (String)registro.get("PLACA UNIDAD"),
                (String)registro.get("PUNTO FINAL"),
                (String)registro.get("PUNTO INICIO"),
                (int)registro.get("RUTA")
            );

            listObjs.add(obj);
        }

        return listObjs;
    }
    
}
