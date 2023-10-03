/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.entidades;

import java.util.List;

/**
 *
 * @author Enzo Teves
 */
public class Comanda {
    private int codigo;
    private boolean pago;
    private double total;
    private List<ComandaProduto> produtos;
    private List<ComandaPagamento> pagamentos;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<ComandaProduto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ComandaProduto> produtos) {
        this.produtos = produtos;
    }

    public List<ComandaPagamento> getPagamentos() {
        return pagamentos;
    }

    public void setPagamentos(List<ComandaPagamento> pagamentos) {
        this.pagamentos = pagamentos;
    }
    
}
