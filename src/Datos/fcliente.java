/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.vcliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HENRY
 */
public class fcliente {
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    //Mostrar Consulta
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","TipoDocumento","Documento","RazonSocial","Direccion","E_ Mail","Telefono"};
       
       String [] registro =new String [7];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from Cliente where Documento like '%"+ buscar + "%' order by idCliente desc";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idCliente");
               registro [1]=rs.getString("TipoDocumento");
               registro [2]=rs.getString("Documento");
               registro [3]=rs.getString("RazonSocial");
               registro [4]=rs.getString("Direccion");
               registro [5]=rs.getString("E_Mail");
               registro [6]=rs.getString("Telefono");
                              
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
 
   
   //Funcion Insertar
   public boolean insertar (vcliente dts){
       sSQL="insert into Cliente (TipoDocumento,Documento,RazonSocial,Direccion,E_Mail,Telefono)" +
               "values (?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getTipoDocumento());
           pst.setString(2, dts.getDocumento());
           pst.setString(3, dts.getRazonSocial());
           pst.setString(4, dts.getDireccion());
           pst.setString(5, dts.getE_Mail());
           pst.setString(6, dts.getTelefono());
                      
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
           
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
   
   
   //Funcion Editar
   public boolean editar (vcliente dts){
       sSQL="update Cliente set TipoDocumento=?,Documento=?,RazonSocial=?,Direccion=?,E_Mail=?,Telefono=?"+
               " where idCliente=?";
                  
       try {
            
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getTipoDocumento());
           pst.setString(2, dts.getDocumento());
           pst.setString(3, dts.getRazonSocial());
           pst.setString(4, dts.getDireccion());
           pst.setString(5, dts.getE_Mail());
           pst.setString(6, dts.getTelefono());
           pst.setInt(7, dts.getIdCliente());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   } 
  
   
   //Funcio Eliminar
   public boolean eliminar (vcliente dts){
       sSQL="delete from Cliente where idCliente=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdCliente());
           
           int n=pst.executeUpdate();
           
           if (n!=0){
               return true;
           }
           else {
               return false;
           }
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return false;
       }
   }
    
    
}
