/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class CadastroFormaPagamento {
    
    public void cadastrar(FormaPagamento formaPagamento) {
        Connection conexao = ConexaoMySQL.obterConexao();
        
        try {
            String sql = "INSERT INTO forma_pagamento (descricao) VALUES (?)";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, formaPagamento.getDescricao());
            
            int linhasAfetadas = preparedStatement.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Forma de Pagamento inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir Forma de Pagamento.");
            }

            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
