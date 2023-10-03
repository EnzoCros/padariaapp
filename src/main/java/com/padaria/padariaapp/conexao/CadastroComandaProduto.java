/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.conexao;

import com.padaria.padariaapp.entidades.ComandaProduto;
import com.padaria.padariaapp.entidades.Produto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Enzo Teves
 */
public class CadastroComandaProduto {
    
    public void cadastrar(ComandaProduto comandaProduto) {
        Connection conexao = ConexaoMySQL.obterConexao();

        int codigoComanda = comandaProduto.getComanda().getCodigo();
        int codigoProduto = comandaProduto.getProduto().getCodigo();
        int quantidadeProduto = comandaProduto.getQuantidade();
        double subtotalProduto = comandaProduto.getSubtotal();

        try {
            String verificaExistencia = "SELECT COUNT(*) FROM comanda_produto WHERE codigo_comanda = ? AND codigo_produto = ?";
            PreparedStatement verificaExistenciaStmt = conexao.prepareStatement(verificaExistencia);
            verificaExistenciaStmt.setInt(1, codigoComanda);
            verificaExistenciaStmt.setInt(2, codigoProduto);

            int registrosExistentes = 0;
            try (var resultSet = verificaExistenciaStmt.executeQuery()) {
                if (resultSet.next()) {
                    registrosExistentes = resultSet.getInt(1);
                }
            }

            if (registrosExistentes > 0) {
                // Se o registro já existe, faça uma atualização (update)
                String atualizaRegistro = "UPDATE comanda_produto SET quantidade_produto = ?, subtotal_produto = ? WHERE codigo_comanda = ? AND codigo_produto = ?";
                PreparedStatement atualizaRegistroStmt = conexao.prepareStatement(atualizaRegistro);
                atualizaRegistroStmt.setInt(1, quantidadeProduto);
                atualizaRegistroStmt.setDouble(2, subtotalProduto);
                atualizaRegistroStmt.setInt(3, codigoComanda);
                atualizaRegistroStmt.setInt(4, codigoProduto);
                // Execute a atualização
                int linhasAfetadas = atualizaRegistroStmt.executeUpdate();
                if (linhasAfetadas > 0) {
                    System.out.println("Registro atualizado com sucesso.");
                } else {
                    System.out.println("Falha ao atualizar registro.");
                }
            } else {
                // Se o registro não existe, faça uma inserção (insert)
                String insereRegistro = "INSERT INTO comanda_produto (codigo_comanda, codigo_produto, quantidade_produto, subtotal_produto) VALUES (?, ?, ?, ?)";
                PreparedStatement insereRegistroStmt = conexao.prepareStatement(insereRegistro);
                insereRegistroStmt.setInt(1, codigoComanda);
                insereRegistroStmt.setInt(2, codigoProduto);
                insereRegistroStmt.setInt(3, quantidadeProduto);
                insereRegistroStmt.setDouble(4, subtotalProduto);
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
