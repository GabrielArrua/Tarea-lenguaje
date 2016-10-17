/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package py.edu.facitec.mec.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import py.edu.facitec.mec.model.Cliente;
import py.edu.facitec.mec.util.ConexionManager;

/**
 *
 * @author user
 */
public class ClienteDaoImpl implements ClienteDao{

    @Override
    public void guardar(Cliente cliente) {
        
        String sql  =  "insert into clientes ( nombres ,apellido,direccion,credito)"
        +" values('"+cliente.getNombre()+"', '"+cliente.getApellido()+"', "
                    + "'"+cliente.getDireccion()+"', "+cliente.getCredito()+" )";
         
        System.out.println("SQL = "+sql);
        
        
         ConexionManager.conectar();
        try {
            ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
         
         ConexionManager.desconectar();
        
    }

    @Override
    public Cliente buscarClientePorCodigo(int codigo) {
        String sql ="select nombres, apellidos,direccion from cliente where codigo="+codigo+"";
  Cliente cliente = null;
    ConexionManager.conectar();
  ResultSet rs;
        try {
            rs = ConexionManager.stm.executeQuery(sql);
           if(rs.next()){// si hubo resultado el sql
             cliente = new Cliente();// instanciamos la clase cliente
      cliente.setNombre(rs.getString("nombres"));//seteamos los valores a los atributos
      cliente.setApellido(rs.getString("apellidos"));
      cliente.setDireccion(rs.getString("direccion"));
      //cliente.setCodigo(rs.getDouble("codigo"));
        }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
      ConexionManager.desconectar();//cerramos la conxion
     return cliente;//retornamos el obj cliente
    
      
  }

    @Override
    public boolean modificarCliente(Cliente cliente) {
    String sql ="update clientes set nombres='"+cliente.getNombre()+"','"
            + "apellido'"+cliente.getApellido()+"',direccion'"+cliente.getDireccion()+"' "
            +"where codigo"+cliente.getCodigo();
            
    boolean resultado = false ;//decclarar inicializar una variable
            ConexionManager.conectar();
        try {
         resultado = ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            ConexionManager.desconectar();
            return resultado;
            
            
            
            
            
            
            
            
          //  where codigo=  ";
    }
// + "//% tiene q considirr
    @Override
    public void eliminar(int codigo) {
      //sql
      String sql ="delete from clientes where codigo"+codigo+"";
      ConexionManager.conectar();
        try {
          ConexionManager.stm.execute(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        ConexionManager.desconectar();//cerramos la conxion
   //  return cliente;//retornamos el obj cliente
    
            
    }

    @Override// colliction  generic<>_>
    public List<Cliente> buscarClientesPorFiltro(String filtro) {
   String sql ="select codigo,nombres,apellidos,direccion from clientes"
           + "where nombre LIKE '%"+filtro+"'or apellido LIKE '"+filtro+"%'"
           + "or direcccion LIke '"+filtro+"%' ";
   
   // crear una list para almacenar
   List<Cliente> List = new ArrayList<>();
   ConexionManager.conectar();
     ResultSet rs;
        try {
            rs = ConexionManager.stm.executeQuery(sql);
             if (rs.next()){// resultad
         Cliente c = new Cliente();// nuevo object
         c.setCodigo(rs.getInt("codigo"));
         c.setNombre(rs.getString("nombres"));
         c.setApellido(rs.getString("apellido"));
         c.setDireccion(rs.getString("direccion"));
         
         List.add(c);
             }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    ConexionManager.desconectar();
         return List;
     }
           
          
    }
    
    
    
    
    
                
   
    

