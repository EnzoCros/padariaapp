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
import java.util.ArrayList;

/**
 *
 * @author Enzo Teves
 */
public class ListarFormasPagamento {
    
    public ArrayList<FormaPagamento> listar() {
        Connection conexao = ConexaoMySQL.obterConexao();
        ArrayList<FormaPagamento> formasPagamento = new ArrayList<FormaPagamento>();
        
        try {
            String sql = "SELECT codigo, descricao FROM forma_pagamento";
            
            PreparedStatement preparedStatement = conexao.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while(resultSet.next()) {
                int codigo = resultSet.getInt("codigo"); 
                String descricao = resultSet.getString("descricao");
                
                FormaPagamento formaPagamento = new FormaPagamento();
                formaPagamento.setCodigo(codigo);
                formaPagamento.setDescricao(descricao);
                        
                formasPagamento.add(formaPagamento);
            }
            
            preparedStatement.close();
            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return formasPagamento;
    }
}
