/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.vplancha;
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
public class fplancha {
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    //Mostrar Consulta
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Tamaño","Medida","Descripcion","Stock","Observacion"};
       
       String [] registro =new String [6];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from Plancha where Medida like '%"+ buscar + "%' order by idPlancha";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idPlancha");
               registro [1]=rs.getString("Tamaño");
               registro [2]=rs.getString("Medida");
               registro [3]=rs.getString("Descripcion");
               registro [4]=rs.getString("Stock");
               registro [5]=rs.getString("Observacion");
                                             
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
   public boolean insertar (vplancha dts){
       sSQL="insert into Plancha (Tamaño,Medida,Descripcion,Stock,observacion)" +
               "values (?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getTamaño());
           pst.setString(2, dts.getMedida());
           pst.setString(3, dts.getDescripcion());
           pst.setInt(4, dts.getStock());
           pst.setString(5, dts.getObservacion());
                                 
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
   public boolean editar (vplancha dts){
       sSQL="update Plancha set Tamaño=?,Medida=?,Descripcion=?,Stock=?,Observacion=?"+
               " where idPlancha=?";
                  
       try {
            
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getTamaño());
           pst.setString(2, dts.getMedida());
           pst.setString(3, dts.getDescripcion());
           pst.setInt(4, dts.getStock());
           pst.setString(5, dts.getObservacion());
           pst.setInt(6, dts.getIdPlancha());
                                 
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
   public boolean eliminar (vplancha dts){
       sSQL="delete from Plancha where idPlancha=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdPlancha());
           
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
   
   
   
   public DefaultTableModel mostrarvista(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Tamaño","Medida","Descripcion","Stock","Observacion"};
       
       String [] registro =new String [6];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from Plancha where Medida like '%"+ buscar + "%' order by idPlancha";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idPlancha");
               registro [1]=rs.getString("Tamaño");
               registro [2]=rs.getString("Medida");
               registro [3]=rs.getString("Descripcion");
               registro [4]=rs.getString("Stock");
               registro [5]=rs.getString("Observacion");
                                             
               totalregistros=totalregistros+1;
               modelo.addRow(registro);
               
           }
           return modelo;
           
       } catch (Exception e) {
           JOptionPane.showConfirmDialog(null, e);
           return null;
       }
     } 
   
   
}
