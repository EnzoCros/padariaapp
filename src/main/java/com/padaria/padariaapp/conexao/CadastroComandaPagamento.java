/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.ComandaPagamento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class CadastroComandaPagamento {
    
    public void cadastrar(ComandaPagamento comandaPagamento) {
        Connection conexao = ConexaoMySQL.obterConexao();

        int codigoComanda = comandaPagamento.getComanda().getCodigo();
        int codigoFormaPagamento = comandaPagamento.getFormapagamento().getCodigo();
        double valorPagamento = comandaPagamento.getValor();

        try {
            String verificaExistencia = "SELECT COUNT(*) FROM comanda_pagamento WHERE codigo_comanda = ? AND codigo_forma_pagamento = ?";
            PreparedStatement verificaExistenciaStmt = conexao.prepareStatement(verificaExistencia);
            verificaExistenciaStmt.setInt(1, codigoComanda);
            verificaExistenciaStmt.setInt(2, codigoFormaPagamento);

            int registrosExistentes = 0;
            try (var resultSet = verificaExistenciaStmt.executeQuery()) {
                if (resultSet.next()) {
                    registrosExistentes = resultSet.getInt(1);
                }
            }

            if (registrosExistentes > 0) {
                // Se o registro já existe, faça uma atualização (update)
                String atualizaRegistro = "UPDATE comanda_pagamento SET valor = ? WHERE codigo_comanda = ? AND codigo_forma_pagamento = ?";
                PreparedStatement atualizaRegistroStmt = conexao.prepareStatement(atualizaRegistro);
                atualizaRegistroStmt.setDouble(1, valorPagamento);
                atualizaRegistroStmt.setInt(2, codigoComanda);
                atualizaRegistroStmt.setInt(3, codigoFormaPagamento);
                // Execute a atualização
                int linhasAfetadas = atualizaRegistroStmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Registro atualizado com sucesso.");
                } else {
                    System.out.println("Falha ao atualizar registro.");
                }
            } else {
                // Se o registro não existe, faça uma inserção (insert)
                String insereRegistro = "INSERT INTO comanda_pagamento (codigo_comanda, codigo_forma_pagamento, valor) VALUES (?, ?, ?)";
                PreparedStatement insereRegistroStmt = conexao.prepareStatement(insereRegistro);
                insereRegistroStmt.setInt(1, codigoComanda);
                insereRegistroStmt.setInt(2, codigoFormaPagamento);
                insereRegistroStmt.setDouble(3, valorPagamento);
                // Execute a inserção
                int linhasAfetadas = insereRegistroStmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Registro inserido com sucesso.");
                } else {
                    System.out.println("Falha ao inserir registro.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
