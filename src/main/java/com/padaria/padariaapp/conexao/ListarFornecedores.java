/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Enzo Teves
 */
public class ListarFornecedores {
    
    public ArrayList<Fornecedor> listar() {
        Connection conexao = ConexaoMySQL.obterConexao();
        ArrayList<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
        
        try {
            String sql = "SELECT codigo, nome, telefone FROM fornecedor";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                int codigo = resultSet.getInt("codigo"); 
                String nome = resultSet.getString("nome");
                String telefone = resultSet.getString("telefone");

                Fornecedor fornecedor = new Fornecedor();
                fornecedor.setCodigo(codigo);
                fornecedor.setNome(nome);
                fornecedor.setTelefone(telefone);
                        
                fornecedores.add(fornecedor);
            }
            
            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return fornecedores;
    }
}
