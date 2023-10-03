/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class ConexaoMySQL {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/padaria";
    private static final String USUARIO = "root";
    private static final String SENHA = "admin";
    
    private static Connection conexao;
    
    public static Connection obterConexao() {
        try {
         if(conexao == null || conexao.isClosed()) {
             Class.forName("com.mysql.cj.jdbc.Driver");
             conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
         }   
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
         
        return conexao;
    }
    
    public static void fecharConexao() {
        try {
            if (conexao != null && !conexao.isClosed()) {
                conexao.close();
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}