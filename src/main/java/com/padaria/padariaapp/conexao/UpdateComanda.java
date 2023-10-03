/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.Comanda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class UpdateComanda {
    
    public void alterarComanda(Comanda comanda) {
        Connection conexao = ConexaoMySQL.obterConexao();
        
        try {
            String sql = "UPDATE comanda SET pago = ?, total = ? WHERE codigo = ?";

            PreparedStatement preparedStatement = conexao.prepareStatement(sql);

            preparedStatement.setBoolean(1, comanda.isPago());
            preparedStatement.setDouble(2, comanda.getTotal());
            preparedStatement.setInt(3, comanda.getCodigo());

            int linhasAfetadas = preparedStatement.executeUpdate();

            if (linhasAfetadas > 0) {
                System.out.println("Registro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum registro atualizado.");
            }
            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
