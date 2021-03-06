/*
 * Copyright (C) 2015 codified
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.eci.pdsw.webappsintro.jdbc.example.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hcadavid
 */
public class JDBCExample {
    
    public static void main(String args[]){
        try {
        	String url="jdbc:mysql://desarrollo.is.escuelaing.edu.co:3306/bdprueba";
            String driver="com.mysql.jdbc.Driver";
            String user="bdprueba";
            String pwd="bdprueba";
                        
            Class.forName(driver);
            Connection con=DriverManager.getConnection(url,user,pwd);
            con.setAutoCommit(false);
                 
            
            System.out.println("Valor total pedido 1:"+valorTotalPedido(con, 1));
            
            List<String> prodsPedido=nombresProductosPedido(con, 1);
            
            
            System.out.println("Productos del pedido 1:");
            System.out.println("-----------------------");
            for (String nomprod:prodsPedido){
                System.out.println(nomprod);
            }
            System.out.println("-----------------------");
            
            
            int suCodigoECI=2138850;
            //registrarNuevoProducto(con, suCodigoECI, "Sergio Ruiz", 99999999);            
            con.commit();
                        
            
            con.close();
                                   
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(JDBCExample.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     * Agregar un nuevo producto con los parámetros dados
     * @param con la conexión JDBC
     * @param codigo
     * @param nombre
     * @param precio
     * @throws SQLException 
     */
    public static void registrarNuevoProducto(Connection con, int codigo, String nombre,int precio) throws SQLException{
    	PreparedStatement registerNewProduct = null;
    	
    	String insertString = 
    			"INSERT INTO bdprueba.ORD_PRODUCTOS (codigo, nombre, precio) " + 
    			"VALUES (?, ?, ?)";
   
    	registerNewProduct = con.prepareStatement(insertString);
    	registerNewProduct.setInt(1, codigo);
    	registerNewProduct.setString(2, nombre);
    	registerNewProduct.setInt(3, precio);
    	registerNewProduct.execute();
    	
    	con.commit();
    }
    
    /**
     * Consultar los nombres de los productos asociados a un pedido
     * @param con la conexión JDBC
     * @param codigoPedido el código del pedido
     * @return 
     */
    public static List<String> nombresProductosPedido(Connection con, int codigoPedido){
        List<String> np=new LinkedList<>();
        PreparedStatement namesOrderProducts = null;
        
        String selectString = 
        		"SELECT pr.nombre FROM ORD_PEDIDOS p, ORD_DETALLES_PEDIDO dp, ORD_PRODUCTOS pr "
        		+ "WHERE p.codigo = dp.pedido_fk AND pr.codigo = dp.producto_fk AND p.codigo = ?";
        
        try {
			namesOrderProducts = con.prepareStatement(selectString);
			namesOrderProducts.setInt(1, codigoPedido);
			ResultSet result = namesOrderProducts.executeQuery();
			while (result.next()) {
				np.add(result.getString(1));
			}
			con.commit();
		} catch (SQLException e) {
			System.out.println("Something went wrong");
			e.printStackTrace();
		}
        
        return np;
    }

    
    /**
     * Calcular el costo total de un pedido
     * @param con
     * @param codigoPedido código del pedido cuyo total se calculará
     * @return el costo total del pedido (suma de: cantidades*precios)
     */
    public static int valorTotalPedido(Connection con, int codigoPedido){
        PreparedStatement valueTotalOrder = null;
    	
        String selectString = 
        		"SELECT sum(pr.precio * dp.cantidad) FROM ORD_DETALLES_PEDIDO dp, ORD_PRODUCTOS pr "
        		+ "WHERE dp.producto_fk = pr.codigo AND dp.pedido_fk = ?";
        
        ResultSet result;
        
        try {
			valueTotalOrder = con.prepareStatement(selectString);
			valueTotalOrder.setInt(1, codigoPedido);
			result = valueTotalOrder.executeQuery();
			result.next();
			return result.getInt(1);
		} catch (SQLException e) {
			System.out.println("Bad sum");
			e.printStackTrace();
		}
        return 0;
    }
 
}
