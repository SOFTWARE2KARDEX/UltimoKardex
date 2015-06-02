/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logica;

import java.sql.Date;

/**
 *
 * @author HENRY
 */
public class voperacion {
    private int idOperacion;
    private int idTipooperacion;
    private int idPlancha;
    private int idUsuario;
    private int Cantidad;
    private int Existencia;
    private Date Fecha;

    public voperacion() {
    }

    public voperacion(int idOperacion, int idTipooperacion, int idPlancha, int idUsuario, int Cantidad, int Existencia, Date Fecha) {
        this.idOperacion = idOperacion;
        this.idTipooperacion = idTipooperacion;
        this.idPlancha = idPlancha;
        this.idUsuario = idUsuario;
        this.Cantidad = Cantidad;
        this.Existencia = Existencia;
        this.Fecha = Fecha;
    }

    public int getIdOperacion() {
        return idOperacion;
    }

    public void setIdOperacion(int idOperacion) {
        this.idOperacion = idOperacion;
    }

    public int getIdTipooperacion() {
        return idTipooperacion;
    }

    public void setIdTipooperacion(int idTipooperacion) {
        this.idTipooperacion = idTipooperacion;
    }

    public int getIdPlancha() {
        return idPlancha;
    }

    public void setIdPlancha(int idPlancha) {
        this.idPlancha = idPlancha;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    
    
    
    
    
}
