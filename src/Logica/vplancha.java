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
public class vplancha {
    private int idPlancha;
    private String Tamaño;
    private String Medida;
    private String Descripcion;
    private int Stock;
    private String Observacion;
    
    // Constructores
    public vplancha(int idPlancha, String Tamaño, String Medida, String Descripcion, int Stock, String Observacion) {
        this.idPlancha = idPlancha;
        this.Tamaño = Tamaño;
        this.Medida = Medida;
        this.Descripcion = Descripcion;
        this.Stock = Stock;
        this.Observacion = Observacion;
    }

    public vplancha() {
    }
    
    // Sett y Gett

    public int getIdPlancha() {
        return idPlancha;
    }

    public void setIdPlancha(int idPlancha) {
        this.idPlancha = idPlancha;
    }

    public String getTamaño() {
        return Tamaño;
    }

    public void setTamaño(String Tamaño) {
        this.Tamaño = Tamaño;
    }

    public String getMedida() {
        return Medida;
    }

    public void setMedida(String Medida) {
        this.Medida = Medida;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public String getObservacion() {
        return Observacion;
    }

    public void setObservacion(String Observacion) {
        this.Observacion = Observacion;
    }
    
    
}
