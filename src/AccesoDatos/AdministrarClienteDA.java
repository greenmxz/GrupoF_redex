/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AccesoDatos;


import Modelo.database;
import Modelo.persona;
import Modelo.cliente;
import Modelo.usuario;
import Controlador.personaBL;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Nowa
 */
public class AdministrarClienteDA {
    
    private personaBL controlador_persona = new personaBL();
    
    public cliente obtenerCliente(int id_cliente){
        try {
            
            database connect = new database();
            String query = "select * from cliente where id = " + id_cliente + ";";
            Statement sentencia= connect.getConnection().createStatement();
            ResultSet rs = sentencia.executeQuery(query);

            while (rs.next( )){

                
                
                cliente cliente = new cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setCantidad_pedidos(rs.getInt("cantidad_pedidos"));
                cliente.setCodigo(rs.getString("codigo"));
                
                //obtener persona
                cliente.setPersona(controlador_persona.obtenerPersona(rs.getInt("id_persona")));
                //
                
                
                return cliente;
            }
            connect.closeConnection();
            System.out.println("El cliente no ha sido encontrado");
            return null;
            
        }catch(Exception e){
            System.out.println("ERROR en obtenerCliente "+e.getMessage());
            return null;
        }
    }
    
    
    public cliente obtenerClienteDNI(int dni){
        try {
            
            database connect = new database();
            
            
            persona persona = controlador_persona.obtenerPersonaxDNI(dni);
            
            if (persona != null){
                int id_persona = persona.getId();
            
                String query = "select * from cliente where id_persona = " + id_persona + ";";
                Statement sentencia= connect.getConnection().createStatement();
                ResultSet rs = sentencia.executeQuery(query);

                while (rs.next( )){

                    cliente cliente = new cliente();

                    cliente.setId(rs.getInt("id"));
                    cliente.setCantidad_pedidos(rs.getInt("cantidad_pedidos"));
                    cliente.setCodigo(rs.getString("codigo"));

                    //obtener persona
                    cliente.setPersona(persona);
                    //


                return cliente;
                }
            }
            connect.closeConnection();
            System.out.println("El cliente no ha sido encontrado");
            return null;
            
        }catch(Exception e){
            System.out.println("ERROR "+e.getMessage());
            return null;
        }
    }
    
    
    
    public ArrayList<cliente> listarClientes(String numeroDocumentoIdentidad,String nombre, String apellidoPaterno, String apellidoMaterno){ 
        try {
            ArrayList<cliente> listClientes = new ArrayList<>();       
            database connect = new database();
            boolean primero = true;
            
            String query = "select cliente.id, cliente.cantidad_pedidos, cliente.id_persona, cliente.codigo,\n" +
                        " persona.nombre, persona.apellido_paterno, persona.apellido_materno, persona.numero_documento_identidad,\n" +
                        " persona.direccion, persona.correo, persona.telefono, persona.fecha_nacimiento,\n" +
                        " ciudad.nombre as ciudad\n" +
                        " from cliente\n" +
                        " inner join persona on cliente.id_persona = persona.id\n" +
                        " inner join ciudad on persona.id_ciudad = ciudad.id\n" +
                        " where cliente.activo = 1 ";
            
            if (!numeroDocumentoIdentidad.equals("")||!nombre.equals("")||!apellidoPaterno.equals("")||!apellidoMaterno.equals("")){
                query += " and ";
                
                if (!numeroDocumentoIdentidad.equals("")){
                    query += " persona.numero_documento_identidad = '" + numeroDocumentoIdentidad + "' ";
                    primero = false;
                }
                if (!nombre.equals("")){
                    if(!primero) query += " and ";
                    query += " persona.nombre = '" + nombre + "' ";
                    primero = false;
                }
                if (!apellidoPaterno.equals("")){
                    if(!primero) query += " and ";
                    query += " persona.apellido_paterno = '" + apellidoPaterno + "' ";
                    primero = false;
                }
                if (!apellidoMaterno.equals("")){
                    if(!primero) query += " and ";
                    query += " persona.apellido_materno = '" + apellidoMaterno + "' ";
                    primero = false;
                }
            }
            
            query += ";";
            
            System.out.println("query => " + query);

            Statement sentencia= connect.getConnection().createStatement();
            ResultSet rs = sentencia.executeQuery(query);
            while (rs.next( )){

                persona persona= new persona();
                cliente cliente = new cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setCantidad_pedidos(rs.getInt("cantidad_pedidos"));
                cliente.setCodigo(rs.getString("codigo"));
   
                persona.setNombre(rs.getString("nombre"));
                persona.setApellidoPaterno(rs.getString("apellido_paterno"));
                persona.setApellidoMaterno(rs.getString("apellido_materno"));
                persona.setNumeroDocumentoIdentidad(rs.getInt("numero_documento_identidad"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCorreo(rs.getString("correo"));
                persona.setTelefono(rs.getString("telefono"));
                //persona.setFechaNacimiento(fechaNacimiento);
                persona.setCiudad(rs.getString("ciudad"));
                
                cliente.setPersona(persona);
                
                listClientes.add(cliente);
            }  
            
            connect.closeConnection();
            System.out.println("Cantidad de resultados = " + listClientes.size());
            return listClientes;
        }catch(Exception e){
            System.out.println("ERROR "+e.getMessage());
            return null;
        }
    }
    
    public ArrayList<cliente> listarClientes(){ 
        try {
            ArrayList<cliente> listClientes = new ArrayList<>();       
            database connect = new database();
            boolean primero = true;
            
            String query = "select * \n" +
                        " from cliente\n" +
                        " inner join persona on cliente.id_persona = persona.id\n" +
                        " inner join ciudad on persona.id_ciudad = ciudad.id\n" +
                        " where cliente.activo = 1 ";
            
            
            query += ";";
            
            System.out.println("query => " + query);

            Statement sentencia= connect.getConnection().createStatement();
            ResultSet rs = sentencia.executeQuery(query);
            while (rs.next( )){

                persona persona= new persona();
                cliente cliente = new cliente();
                
                cliente.setId(rs.getInt("id"));
                cliente.setCantidad_pedidos(rs.getInt("cantidad_pedidos"));
                cliente.setCodigo(rs.getString("codigo"));
   
                persona.setNombre(rs.getString("nombre"));
                persona.setApellidoPaterno(rs.getString("apellido_paterno"));
                persona.setApellidoMaterno(rs.getString("apellido_materno"));
                persona.setNumeroDocumentoIdentidad(rs.getInt("numero_documento_identidad"));
                persona.setDireccion(rs.getString("direccion"));
                persona.setCorreo(rs.getString("correo"));
                persona.setTelefono(rs.getString("telefono"));
                //persona.setFechaNacimiento(fechaNacimiento);
                persona.setCiudad(rs.getString("ciudad"));
                
                cliente.setPersona(persona);
                
                listClientes.add(cliente);
            }  
            
            connect.closeConnection();
            System.out.println("Cantidad de resultados = " + listClientes.size());
            return listClientes;
        }catch(Exception e){
            System.out.println("ERROR "+e.getMessage());
            return null;
        }
    }
    
     public int registrarCliente(cliente cliente){
            /*codigos de resultado
            0 - error al insertar en bd
            1 - correcto
            2 - dni repetido
            */
            
            try {
                database connect = new database();
                persona persona = null;
                persona = controlador_persona.obtenerPersonaxDNI(cliente.getPersona().getNumeroDocumentoIdentidad());
            
                if (persona == null){
                    // nuevo cliente
                    controlador_persona.insertarPersona(cliente.getPersona());
            
                    int id_persona = controlador_persona.obtenerPersonaxDNI(cliente.getPersona().getNumeroDocumentoIdentidad()).getId();
            
                    //registrar cliente
            
                    String query="INSERT INTO cliente(cantidad_pedidos,id_persona,codigo,activo)VALUES(?,?,?,?);"; 
	
                    PreparedStatement stmt1 = connect.getConnection().prepareStatement(query);
            
                    stmt1.setInt(1,cliente.getCantidad_pedidos());
                    stmt1.setInt(2,id_persona);
                    stmt1.setString(3,cliente.getCodigo());
                    stmt1.setString(4,"1");
          
                    stmt1.executeUpdate();
                    
                    connect.closeConnection();
                    return 1;
                }else{
                    // cliente con el mismo dni ya registrado
                    
                    connect.closeConnection();
                    return 2;
                }

         }catch(Exception ex){
             System.out.println(ex.getMessage());
             return 0;
         }
         
     }
    public boolean registrarClientes(ArrayList<persona> p){
            /*codigos de resultado
            0 - error al insertar en bd
            1 - correcto
            2 - dni repetido
            */
            
        try {
            System.out.println("->");
            for (persona persona: p){
                database connect = new database();
                String query = "{CALL registrarClientesMasivo(?,?,?,?,?,?,?,?,?,?)}";
                CallableStatement stmt = connect.getConnection().prepareCall(query);
                stmt.setString(1, persona.getNombre());
                stmt.setString(2, persona.getApellidoPaterno());
                stmt.setString(3, persona.getApellidoMaterno());
                stmt.setString(4, persona.getCiudad());
                stmt.setString(5, persona.getCorreo());
                stmt.setString(6, persona.getTipoDocumento());
                stmt.setInt(7, persona.getNumeroDocumentoIdentidad());
                stmt.setString(8, persona.getDireccion());

                
                SimpleDateFormat  sdf;
                String            s;
                sdf = new SimpleDateFormat("yyyy-MM-dd");  // Or whatever format you need
                s = sdf.format(persona.getFechaNacimiento()); 
                DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                java.util.Date fd =   formatter.parse(s);
                java.sql.Date sqlDate = new java.sql.Date(fd.getTime());
                stmt.setDate(9,sqlDate);
                stmt.setString(10,persona.getTelefono());
                

                
                ResultSet rs = stmt.executeQuery();
                System.out.println("OK");
                connect.closeConnection();
            }
            return true;


         }catch(Exception ex){
             System.out.println(ex.getMessage());
             return false;
         }
         
     }
    public int modificarCliente(cliente cliente){
        /*codigos de resultado
            0 - error al insertar en bd
            1 - correcto
            2 - persona no existe
            */
         try {
             
            database connect = new database();

            persona persona = null;
            persona = controlador_persona.obtenerPersonaxDNI(cliente.getPersona().getNumeroDocumentoIdentidad());
            
            if (persona != null){
                
                //modificar persona
                
                if (controlador_persona.modificarPersona(cliente.getPersona()) == true){
                    //modificar cliente
                       
                    String query="UPDATE cliente\n" +
                                "SET\n" +
                                "codigo = ?\n" +
                                "WHERE id_persona = ?;"; 
	
                    PreparedStatement stmt1 = connect.getConnection().prepareStatement(query);
                    
                    stmt1.setString(1,cliente.getCodigo());
                    stmt1.setInt(2,persona.getId());
                    
          
                    stmt1.executeUpdate();
                    connect.closeConnection();    
                    return 1;
                    
                }
                
                
                connect.closeConnection(); 
                return 0;
            
            }else{
                //persona no existe
                connect.closeConnection();
                return 2;
            }
            
         }catch(Exception ex){
             System.out.println(ex.getMessage());
             return 0;
         }
         
     }
    
    
    public boolean eliminarCliente(int id_cliente){
         try {
            database connect = new database();
            /*
            codigo_cliente
            */
            String query = "UPDATE cliente\n" +
                                "SET\n" +
                                "activo = 0\n" +
                                "WHERE id = ?;"; 

            CallableStatement stmt = connect.getConnection().prepareCall(query);
            

            stmt.setInt(1, id_cliente);

            stmt.executeUpdate();
            
            
            
            return true;
            

            
         }catch(Exception ex){
             System.out.println(ex.getMessage());
             return false;
         }
         
     }
}
