/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class CadastroProduto {
    
    public void cadastrar(Produto produto) {
        Connection conexao = ConexaoMySQL.obterConexao();

        try {
            String sql = "INSERT INTO produto (descricao, disponivel, valor, codigo_fornecedor) VALUES (?, ?, ?, ?)";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, produto.getDescricao());
            preparedStatement.setBoolean(2, produto.isDisponivel());
            preparedStatement.setDouble(3, produto.getValor());
            preparedStatement.setInt(4, produto.getFornecedor().getCodigo());
            
            int linhasAfetadas = preparedStatement.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Produto inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir produto.");
            }

            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
