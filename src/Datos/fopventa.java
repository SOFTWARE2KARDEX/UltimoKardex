/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.vopventa;
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
public class fopventa {
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    private String sSQL2="";
    public Integer totalregistros;
    
    //Mostrar Consulta
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","IdOperacion","IdCliente","Cliente","IdPlancha","Plancha","IdUsuario","Usuario","Cantidad","Fecha","Documento"};
       
       String [] registro =new String [11];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select o.idOperacion,o.idTipooperacion,v.idCliente,c.RazonSocial,o.idPlancha,p.Tamaño,p.Medida, " +
                "o.idUsuario,u.nombre,u.apellido,o.Cantidad,o.Fecha,v.Documento " +
                "from Opventa v inner join Operacion o " +
                " on v.idOperacion=o.idOperacion inner join Plancha p " +
                " on o.idPlancha=p.idPlancha inner join Tipooperacion t " +
                " on o.idTipooperacion=t.idTipooperacion inner join Usuario u " +
                " on o.idUsuario=u.idUsuario inner join Cliente c " +
                " on v.idCliente=c.idCliente " +
                "where o.Fecha like '%"+ buscar + "%'" +
                " order by v.idOperacion desc"; 
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idOperacion");
               registro [1]=rs.getString("idTipooperacion");
               registro [2]=rs.getString("idCliente");
               registro [3]=rs.getString("RazonSocial");
               
               registro [4]=rs.getString("idPlancha");
               registro [5]=rs.getString("Tamaño") + " " + rs.getString("Medida");
               registro [6]=rs.getString("idUsuario");
               registro [7]=rs.getString("nombre") + " " + rs.getString("apellido");
               registro [8]=rs.getString("Cantidad");
               registro [9]=rs.getString("Fecha");
               registro [10]=rs.getString("Documento");
               
                                             
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
   public boolean insertar (vopventa dts){
       sSQL="insert into Operacion (idTipooperacion,idPlancha,idUsuario,Cantidad,Fecha)" +
               "values ((select idTipooperacion from Tipooperacion where Operacion='Venta'),?,?,?,?)";
       
       sSQL2="insert into Opventa (idOperacion,idCliente,Documento)" +
               "values ((select idOperacion from Operacion order by idOperacion desc limit 1),?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           PreparedStatement pst2=cn.prepareStatement(sSQL2);
           
           pst.setInt(1, dts.getIdPlancha());
           pst.setInt(2, dts.getIdUsuario());
           pst.setInt(3, dts.getCantidad());
           pst.setDate(4, dts.getFecha());
           
           pst2.setInt(1, dts.getIdCliente());
           pst2.setString(2, dts.getDocumento());
           
                                 
           int n=pst.executeUpdate();
           
           if (n!=0){
               int n2=pst2.executeUpdate();
               
               if (n2!=0) {
                   return true;
               }
               else
                   return false;
               
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
   public boolean editar (vopventa dts){
       sSQL="update Operacion set idPlancha=?,idUsuario=?,Cantidad=?,Fecha=?"+
               " where idOperacion=?";
       sSQL="update Opventa set idCliente=?,Documento=?"+
               " where idOperacion=?";
                  
       try {
            
           PreparedStatement pst=cn.prepareStatement(sSQL);
           PreparedStatement pst2=cn.prepareStatement(sSQL2);
           
           pst.setInt(1, dts.getIdPlancha());
           pst.setInt(2, dts.getIdUsuario());
           pst.setInt(3, dts.getCantidad());
           pst.setDate(4, dts.getFecha());
           pst.setInt(5, dts.getIdOperacion());
           
           pst2.setInt(1, dts.getIdCliente());
           pst2.setString(2, dts.getDocumento());
           pst2.setInt(3, dts.getIdOperacion());
           
                                 
           int n=pst.executeUpdate();
           
           if (n!=0){
               int n2=pst2.executeUpdate();
               if (n2!=0) {
                   return true;
               }
               else
                   return false;
               
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
   public boolean eliminar (vopventa dts){
       sSQL="delete from Opventa where idOperacion=?";
       sSQL2="delete from Operacion where idOperacion=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           PreparedStatement pst2=cn.prepareStatement(sSQL2);
           
           pst.setInt(1, dts.getIdOperacion());
           
           pst2.setInt(1, dts.getIdOperacion());
           
                                 
           int n=pst.executeUpdate();
           
           if (n!=0){
               int n2=pst2.executeUpdate();
               if (n2!=0) {
                   return true;
               }
               else
                   return false;
               
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
