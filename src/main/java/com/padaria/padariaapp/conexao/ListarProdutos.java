/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Enzo Teves
 */
public class ListarProdutos {
    
    public ArrayList<Produto> listar() {
        Connection conexao = ConexaoMySQL.obterConexao();
        ArrayList<Produto> produtos = new ArrayList<Produto>();
        
        try {
            String sql = "SELECT * FROM produto";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                int codigo = resultSet.getInt("codigo"); 
                String descricao = resultSet.getString("descricao");
                boolean disponivel = resultSet.getBoolean("disponivel");
                double valor = resultSet.getDouble("valor");
                
                Produto produto = new Produto();
                produto.setCodigo(codigo);
                produto.setDescricao(descricao);
                produto.setDisponivel(disponivel);
                produto.setValor(valor);
                        
                produtos.add(produto);
            }
            
            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return produtos;
    }
}
