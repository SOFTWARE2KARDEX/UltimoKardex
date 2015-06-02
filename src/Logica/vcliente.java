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
public class vcliente {
    private int idCliente;
    private String TipoDocumento;
    private String Documento;
    private String RazonSocial;
    private String Direccion;
    private String E_Mail;
    private String Telefono;

    public vcliente(int idCliente, String TipoDocumento, String Documento, String RazonSocial, String Direccion, String E_Mail, String Telefono) {
        this.idCliente = idCliente;
        this.TipoDocumento = TipoDocumento;
        this.Documento = Documento;
        this.RazonSocial = RazonSocial;
        this.Direccion = Direccion;
        this.E_Mail = E_Mail;
        this.Telefono = Telefono;
    }

    public vcliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(String TipoDocumento) {
        this.TipoDocumento = TipoDocumento;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
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

    public String getE_Mail() {
        return E_Mail;
    }

    public void setE_Mail(String E_Mail) {
        this.E_Mail = E_Mail;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }
    
    
        
}
