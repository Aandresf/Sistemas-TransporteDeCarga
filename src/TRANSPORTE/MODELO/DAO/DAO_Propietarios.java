/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TRANSPORTE.MODELO.DAO;

import TRANSPORTE.MODELO.Model_Clientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import TRANSPORTE.MODELO.UTILS.Database;

/**
 *
 * @author arnal
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
public class DAO_Propietarios {

        public int deletePropietario(int id){
        
        // EL ESTATUS 99 ES PARA LOS TRANSPORTISTAS ELIMINADO LOGICAMENTE
        String sql = "UPDATE PROPIETARIOS SET ESTATUS = 99 WHERE DOCUMENTO = "+ id +";";
        return new Database().actualizar(sql);
    }

    public int updatePropietario(int identificacion, String nombre, String telefono, String correo, String tipo,  int estatus){
        String sql = "UPDATE PROPIETARIOS SET "
        +"DOCUMENTO = '"+ identificacion
        +"', NOMBRE = '"+ nombre
        +"', TELEFONO = '"+ telefono 
        +"', CORREO = '"+ correo
        +"', TIPO_DOCUMENTO = '"+ tipo
        +"', ESTATUS = "+ estatus 
        +" WHERE DOCUMENTO = "+ identificacion +";";

        return new Database().actualizar(sql);
    };

    public int insertPropietario(int identificacion, String nombre, String telefono, String correo, String tipo, int estatus){
        int result;

        // COMPROBAMOS QUE NO ESTE ELIMINADO LOGICAMENTE
        if(new Database().ejecutar("SELECT * FROM PROPIETARIOS WHERE DOCUMENTO = " + identificacion + " AND ESTATUS = 99;").isEmpty()){

            String sql = "INSERT INTO PROPIETARIOS (DOCUMENTO, NOMBRE, TELEFONO, CORREO, TIPO_DOCUMENTO, ESTATUS) VALUES (" 
            + identificacion + ",'" + nombre + "','" + telefono + "','" + correo + "','" + tipo + "'," + estatus + ");";
    
            result = new Database().actualizar(sql);
            
        }else{ // SI ESTA ELIMINADO LOGICAMENTE LO ACTUALIZAMOS
            result = updatePropietario(identificacion, nombre, telefono, correo, tipo, estatus);
        }
        return result;
    };

    public Model_Clientes getPropietario(int id){
        String sql = "SELECT * FROM PROPIETARIOS WHERE DOCUMENTO = "+ id +" AND ESTATUS != 99;";

        List<Map> registros = new Database().ejecutar(sql);
        Model_Clientes obj = null;

        for (Map registro : registros) {
            obj = new Model_Clientes(
            (int)registro.get("documento"),
            (String)registro.get("nombre"),
            (String)registro.get("telefono"),
            (String)registro.get("correo"),
            (String)registro.get("tipo_documento"),
            (int)registro.get("estatus")
            );
        }

        return obj;
    }

    public List getAllPropietarios(){
        String sql = "SELECT * FROM PROPIETARIOS WHERE ESTATUS != 99;";
        List<Map> registros = new Database().ejecutar(sql);
        List<Model_Clientes> listObj = new ArrayList();

        for (Map registro : registros) {
  
            Model_Clientes obj = new Model_Clientes(
                (int)registro.get("documento"),
                (String)registro.get("nombre"),
                (String)registro.get("telefono"),
                (String)registro.get("correo"),
                (String)registro.get("tipo_documento"),
                (int)registro.get("estatus")
                );

            listObj.add(obj);
        }

        return listObj;
    }
    
}
