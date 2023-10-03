/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class CadastroFuncionario {
    
    public void cadastrar(Funcionario funcionario) {
        Connection conexao = ConexaoMySQL.obterConexao();
        
        try {
            String sql = "INSERT INTO funcionario (nome, cpf, cargo) VALUES (?, ?, ?)";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, funcionario.getNome());
            preparedStatement.setString(2, funcionario.getCpf());
            preparedStatement.setString(3, funcionario.getCargo());
            
            int linhasAfetadas = preparedStatement.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Funcionário inserido com sucesso!");
            } else {
                System.out.println("Falha ao inserir funcionário.");
            }

            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
