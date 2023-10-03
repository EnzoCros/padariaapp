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
public class ObterComanda {
    
    public Comanda obter(int codigoBusca) {
        Connection conexao = ConexaoMySQL.obterConexao();
        Comanda comanda = null;
        
        try {
             String sql = "SELECT codigo, pago, total FROM comanda WHERE codigo = ?";
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            
            preparedStatement.setInt(1, codigoBusca);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                int codigo = resultSet.getInt("codigo");
                boolean pago = resultSet.getBoolean("pago");
                double total = resultSet.getDouble("total");
                
                comanda = new Comanda();
                comanda.setCodigo(codigo);
                comanda.setPago(pago);
                comanda.setTotal(total);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return comanda;
    }
}
