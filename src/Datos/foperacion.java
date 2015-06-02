/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Logica.voperacion;
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
public class foperacion {
   private conexion mysql= new conexion();
    private Connection cn=mysql.conectar();
    private String sSQL="";
    public Integer totalregistros;
    
    //Mostrar Consulta
    public DefaultTableModel mostrarOperacion(String buscar){
       DefaultTableModel modelo;
       
       String [] titulos = {"ID","IdTipo","Operación","IdPlancha","Plancha","IdUsuario","Usuario","Cantidad","Fecha"};
       
       String [] registro =new String [9];
       
       totalregistros=0;
       modelo = new DefaultTableModel(null,titulos);
       
//       sSQL="select o.idOperacion,o.idTipooperacion,(select Operacion from Tipooperacion where idTipooperacion=o.idTipooperacion)as Operacion,"+
//            "o.idPlancha,p.Tamaño,p.Medida,o.idUsuario,(select nombre from Usuario where idUsuario=o.idUsuario)as nomb,"+
//            "(select apellido from Usuario where idUsuario=o.idUsuario)as apel,o.Cantidad,"+
//            "o.Fecha from Operacion o inner join Plancha p on o.idPlancha=p.idPlancha where o.Fecha like '"+ buscar + "' order by idOperacion desc";
        sSQL="select o.idOperacion, o.idTipooperacion,t.Operacion,o.idPlancha,p.Tamaño,p.Medida,o.idUsuario, u.nombre,"+
                "u.apellido,o.Cantidad,o.Fecha "+
                " from Operacion o inner join Tipooperacion t "+
                " on o.idTipooperacion=t.idTipooperacion inner join Plancha p "+
                " on o.idPlancha=p.idPlancha inner join Usuario u "+
                " on o.idUsuario=u.idUsuario where o.Fecha like '%"+ buscar + "%' and (t.idTipooperacion=3 or t.idTipooperacion=4) order by o.idOperacion desc";
       try {
           Statement st= cn.createStatement();
           ResultSet rs=st.executeQuery(sSQL);
           
           while(rs.next()){
               registro [0]=rs.getString("idOperacion");
               registro [1]=rs.getString("idTipooperacion");
               registro [2]=rs.getString("Operacion");
               registro [3]=rs.getString("idPlancha");
               registro [4]=rs.getString("Tamaño") + " " + rs.getString("Medida");
               registro [5]=rs.getString("idUsuario");
               registro [6]=rs.getString("nombre") + " " + rs.getString("apellido");
               registro [7]=rs.getString("Cantidad");
             //  registro [8]=rs.getString("Existencia");
               registro [8]=rs.getString("Fecha");
               
                                             
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
   public boolean insertar (voperacion dts){
       sSQL="insert into Operacion (idTipooperacion,idPlancha,idUsuario,Cantidad,Fecha)" +
               "values (?,?,?,?,?)";
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdTipooperacion());
           pst.setInt(2, dts.getIdPlancha());
           pst.setInt(3, dts.getIdUsuario());
           pst.setInt(4, dts.getCantidad());
          // pst.setInt(5, dts.getExistencia());
           pst.setDate(5, dts.getFecha());
                                 
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
   public boolean editar (voperacion dts){
       sSQL="update Operacion set idTipooperacion=?,idPlancha=?,idUsuario=?,Cantidad=?,Fecha=?"+
               " where idOperacion=?";
                  
       try {
            
           PreparedStatement pst=cn.prepareStatement(sSQL);
           pst.setInt(1, dts.getIdTipooperacion());
           pst.setInt(2, dts.getIdPlancha());
           pst.setInt(3, dts.getIdUsuario());
           pst.setInt(4, dts.getCantidad());
          // pst.setInt(5, dts.getExistencia());
           pst.setDate(5, dts.getFecha());
           pst.setInt(6, dts.getIdOperacion());
                                 
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
   public boolean eliminar (voperacion dts){
       sSQL="delete from Operacion where idOperacion=?";
       
       try {
           
           PreparedStatement pst=cn.prepareStatement(sSQL);
           
           pst.setInt(1, dts.getIdOperacion());
           
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
