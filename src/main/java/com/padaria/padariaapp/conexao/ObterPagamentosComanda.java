/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.ComandaPagamento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Enzo Teves
 */
public class ObterPagamentosComanda {
    
    public List<ComandaPagamento> obter(int codigoBusca) {
        Connection conexao = ConexaoMySQL.obterConexao();
        List<ComandaPagamento> pagamentos = new ArrayList<>();
        
        try {
            String sql = "SELECT codigo_comanda, codigo_forma_pagamento, valor FROM comanda_pagamento WHERE codigo_comanda = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, codigoBusca);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                double valor = resultSet.getDouble("valor");

                ComandaPagamento comandaPagamento = new ComandaPagamento();
                comandaPagamento.setValor(valor);
                
                pagamentos.add(comandaPagamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return pagamentos;
    }
}
