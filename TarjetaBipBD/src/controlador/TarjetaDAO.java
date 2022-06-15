/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.TarjetaB;

/**
 *
 * @author ffmor
 */
public class TarjetaDAO 
{
   public boolean ingresarTarjeta(TarjetaB tt)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="insert into tarjeta (codigo,totalD,viajesT) values (?,?,?)";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, tt.getCodigo());
            ps.setInt(2, tt.getTotDinero());
            ps.setInt(3, tt.getCantViajes());
            resultado=ps.executeUpdate()==1;
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }  
   public TarjetaB buscarTarjeta(String codigo)
    {
        TarjetaB tt=null;
        try {
            Connection con=Conexion.getConexion();
            String query="select * from tarjeta where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, codigo);
            ResultSet rs=ps.executeQuery();
            while(rs.next())
                tt=new TarjetaB(rs.getString(1), rs.getInt(2), rs.getInt(3));
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tt;
    }
   public boolean eliminarTarjeta(String codigo)
    {
        boolean resultado=false;
        try {
            Connection con=Conexion.getConexion();
            String query="delete from tarjeta where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setString(1, codigo);
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public ArrayList<TarjetaB> obtenerTodo()
    {
        ArrayList <TarjetaB> ttar=new ArrayList<TarjetaB>();
        try {
            Connection con=Conexion.getConexion();
            String query="select * from tarjeta";
            PreparedStatement ps=con.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            TarjetaB tt;
            while(rs.next())
            {
                tt=new TarjetaB(rs.getString(1), rs.getInt(2), rs.getInt(3));
                ttar.add(tt);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ttar;
    }
    public boolean modificarTarjeta(TarjetaB tt)
    {
        boolean resultado=false;
        try {
            Connection con =Conexion.getConexion();
            String query="update tarjeta set totalD=?,viajesT=? where codigo=?";
            PreparedStatement ps=con.prepareStatement(query);
            ps.setInt(1, tt.getTotDinero());
            ps.setInt(2, tt.getCantViajes());
            ps.setString(3, tt.getCodigo());
            resultado=ps.executeUpdate()==1;
            ps.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TarjetaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
}
