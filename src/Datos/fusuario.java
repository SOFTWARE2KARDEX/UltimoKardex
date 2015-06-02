/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.vusuario;
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
public class fusuario {
    private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    //Mostrar Consulta
    public DefaultTableModel mostrar(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Nombre","Apellido","DNI","Telefono","Direccion","Acceso","Login","Password","Estado"};
       
       String [] registro =new String [10];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select * from Usuario where dni like '%"+ buscar + "%' order by idUsuario";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idUsuario");
               registro [1]=rs.getString("nombre");
               registro [2]=rs.getString("apellido");
               registro [3]=rs.getString("dni");
               registro [4]=rs.getString("telefono");
               registro [5]=rs.getString("direccion");
               registro [6]=rs.getString("acceso");
               registro [7]=rs.getString("login");
               registro [8]=rs.getString("password");
               registro [9]=rs.getString("estado");
                              
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
   public boolean insertar (vusuario dts){
       sSQL="insert into Usuario (nombre,apellido,dni,telefono,direccion,acceso,login,password,estado)" +
               "values (?,?,?,?,?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNombre());
           pst.setString(2, dts.getApellido());
           pst.setString(3, dts.getDni());
           pst.setString(4, dts.getTelefono());
           pst.setString(5, dts.getDireccion());
           pst.setString(6, dts.getAcceso());
           pst.setString(7, dts.getLogin());
           pst.setString(8, dts.getPassword());
           pst.setString(9, dts.getEstado());
                      
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
   public boolean editar (vusuario dts){
       sSQL="update Usuario set nombre=?,apellido=?,dni=?,telefono=?,direccion=?,acceso=?,login=?,password=?,estado=?"+
               " where idUsuario=?";
                  
       try {
            
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setString(1, dts.getNombre());
           pst.setString(2, dts.getApellido());
           pst.setString(3, dts.getDni());
           pst.setString(4, dts.getTelefono());
           pst.setString(5, dts.getDireccion());
           pst.setString(6, dts.getAcceso());
           pst.setString(7, dts.getLogin());
           pst.setString(8, dts.getPassword());
           pst.setString(9, dts.getEstado());
           pst.setInt(10, dts.getIdUsuario());
           
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
   public boolean eliminar (vusuario dts){
       sSQL="delete from Usuario where idUsuario=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdUsuario());
           
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
   
   
   
   
   public DefaultTableModel login(String login, String password){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","Nombre","Apellido","Acceso","Login","Password","Estado"};
       
       String [] registro =new String [7];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
       sSQL="select idUsuario, nombre, apellido, acceso, login, password, estado from Usuario where login='"+ login + "' and password='" + password + "'  and estado='Habilitado' ";
       
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idUsuario");
               registro [1]=rs.getString("nombre");
               registro [2]=rs.getString("apellido");
               registro [3]=rs.getString("acceso");
               registro [4]=rs.getString("login");
               registro [5]=rs.getString("password");
               registro [6]=rs.getString("estado");
                              
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
