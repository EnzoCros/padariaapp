/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.FormaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class CadastroComanda {
    
    public int gerarComanda() {
        Connection conexao = ConexaoMySQL.obterConexao();
        int codigo = 0;

        try {
            String sql = "INSERT INTO comanda (pago, total) VALUES (?, ?)";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            preparedStatement.setBoolean(1, false);
            preparedStatement.setDouble(2, 0);
            
            int linhasAfetadas = preparedStatement.executeUpdate();
            
            if (linhasAfetadas > 0) {
                System.out.println("Forma de Pagamento inserido com sucesso!");
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if(generatedKeys.next()) {
                    codigo = generatedKeys.getInt(1);
                }
            } else {
                System.out.println("Falha ao inserir Forma de Pagamento.");
            }

            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return codigo;
    }
}
