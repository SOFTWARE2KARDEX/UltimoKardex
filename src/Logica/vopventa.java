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
public class vopventa extends voperacion  {
    private int idCliente;
    private String Documento;

    
    
    
    public vopventa() {
    }

    public vopventa(int idCliente, String Documento) {
        this.idCliente = idCliente;
        this.Documento = Documento;
    }

    
    
    
    
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }
    
    
    
}
