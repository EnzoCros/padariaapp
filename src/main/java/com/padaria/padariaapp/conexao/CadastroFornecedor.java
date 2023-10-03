/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.Endereco;
import com.padaria.padariaapp.entidades.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class CadastroFornecedor {
    
    public void cadastrar(Endereco endereco, Fornecedor fornecedor) {
        Connection conexao = ConexaoMySQL.obterConexao();
        
        try {
            String sql = "INSERT INTO endereco (cep, cidade, estado) VALUES (?, ?, ?)";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, endereco.getCep());
            preparedStatement.setString(2, endereco.getCidade());
            preparedStatement.setString(3, endereco.getEstado());
            
            int linhasAfetadas = preparedStatement.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Endereço inserido com sucesso!");

                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int idGerado = generatedKeys.getInt(1);
                    
                    String sqlInserirFornecedor = "INSERT INTO fornecedor (nome, telefone, email, codigo_endereco) VALUES (?, ?, ?, ?)";
                    PreparedStatement preparedStatementFornecedor = conexao.prepareStatement(sqlInserirFornecedor, PreparedStatement.RETURN_GENERATED_KEYS);
                    
                    preparedStatementFornecedor.setString(1, fornecedor.getNome());
                    preparedStatementFornecedor.setString(2, fornecedor.getTelefone());
                    preparedStatementFornecedor.setString(3, fornecedor.getEmail());
                    preparedStatementFornecedor.setInt(4, idGerado);
                    
                    int linhasAfetadasFornecedor = preparedStatementFornecedor.executeUpdate();
                    if(linhasAfetadasFornecedor > 0) {
                        System.out.println("Fornecedor inserido com sucesso!");
                    } else {
                        System.out.println("Falha ao inserir fornecedor.");
                    }
                    
                    preparedStatementFornecedor.close();
                }
            } else {
                System.out.println("Falha ao inserir endereco.");
            }

            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
