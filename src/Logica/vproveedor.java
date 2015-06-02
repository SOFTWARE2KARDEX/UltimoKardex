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
public class vproveedor {
    private int idProveedor;
    private String RUC;
    private String RazonSocial;
    private String Direccion;
    private String Telefono;

    
    
    public vproveedor() {
    }

    public vproveedor(int idProveedor, String RUC, String RazonSocial, String Direccion, String Telefono) {
        this.idProveedor = idProveedor;
        this.RUC = RUC;
        this.RazonSocial = RazonSocial;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String RazonSocial) {
        this.RazonSocial = RazonSocial;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
    
    
    
    
}
