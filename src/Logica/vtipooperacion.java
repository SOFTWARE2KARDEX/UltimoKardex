/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

/**
 *
 * @author HENRY
 */
public class vtipooperacion {
    private int idTipooperacion;
    private String Operacion;

    public vtipooperacion() {
    }

    public vtipooperacion(int idTipooperacion, String Operacion) {
        this.idTipooperacion = idTipooperacion;
        this.Operacion = Operacion;
    }

    public int getIdTipooperacion() {
        return idTipooperacion;
    }

    public void setIdTipooperacion(int idTipooperacion) {
        this.idTipooperacion = idTipooperacion;
    }

    public String getOperacion() {
        return Operacion;
    }

    public void setOperacion(String Operacion) {
        this.Operacion = Operacion;
    }
    
    

   
    
    
    
}
