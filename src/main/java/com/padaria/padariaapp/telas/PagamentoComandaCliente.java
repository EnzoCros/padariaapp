/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.padaria.padariaapp.telas;

import com.padaria.padariaapp.conexao.CadastroComandaPagamento;
import com.padaria.padariaapp.conexao.ListarFormasPagamento;
import com.padaria.padariaapp.conexao.ObterComanda;
import com.padaria.padariaapp.conexao.ObterPagamentosComanda;
import com.padaria.padariaapp.entidades.Comanda;
import com.padaria.padariaapp.entidades.ComandaPagamento;
import com.padaria.padariaapp.entidades.FormaPagamento;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.DefaultListModel;

/**
 *
 * @author Enzo Teves
 */
public class PagamentoComandaCliente extends javax.swing.JFrame {

    private Comanda comanda = new Comanda();
    AtomicReference<Double> totalPagoComanda = new AtomicReference<>(0d);
    private DefaultListModel<FormaPagamento> listaFormasPagamento = new DefaultListModel<>();
    private FormaPagamento formaPagamentoSelecionada = null;
    /**
     * Creates new form Comanda
     */
    public PagamentoComandaCliente(Comanda comanda) {
        initComponents();
        listarFormasPagamento();
        obterComanda(comanda.getCodigo());
        
        List<ComandaPagamento> pagamentos = new ObterPagamentosComanda().obter(this.comanda.getCodigo());
       
        for (ComandaPagamento item : pagamentos) {
            totalPagoComanda.set(totalPagoComanda.get() + item.getValor());
        }

        totalPago.setText(totalPagoComanda.toString());
    }
    
    private void obterComanda(int codigoComanda) {
        Comanda comanda = new ObterComanda().obter(codigoComanda);
        
        this.comanda = comanda;        
        this.codigoComanda.setText(Integer.toString(comanda.getCodigo()));
        this.totalComanda.setText(Double.toString(comanda.getTotal()));
    }
    
    private void listarFormasPagamento() {
        listaFormasPagamento.clear();
        ArrayList<FormaPagamento> formasPagamento = new ListarFormasPagamento().listar();

        formasPagamento.forEach(f -> {
            listaFormasPagamento.addElement(f);
        });
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tituloPaginaComanda = new javax.swing.JLabel();
        labelCodigoComanda = new javax.swing.JLabel();
        codigoComanda = new javax.swing.JTextField();
        labelTotalComanda = new javax.swing.JLabel();
        totalComanda = new javax.swing.JTextField();
        labelFormaPagamento = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        formasPagamento = new javax.swing.JList<>();
        labelValorPagamento = new javax.swing.JLabel();
        valorPagamento = new javax.swing.JFormattedTextField();
        pagarComanda = new javax.swing.JButton();
        labelTotalPago = new javax.swing.JLabel();
        totalPago = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tituloPaginaComanda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tituloPaginaComanda.setText("PAGAMENTO COMANDA");

        labelCodigoComanda.setText("Comanda");

        codigoComanda.setEnabled(false);

        labelTotalComanda.setText("Total da Comanda");

        totalComanda.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        totalComanda.setEnabled(false);
        totalComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalComandaActionPerformed(evt);
            }
        });

        labelFormaPagamento.setText("Forma de Pagamento");

        formasPagamento.setModel(listaFormasPagamento);
        formasPagamento.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        formasPagamento.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                formasPagamentoValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(formasPagamento);

        labelValorPagamento.setText("Valor Pagamento");

        valorPagamento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0.00"))));

        pagarComanda.setText("Pagar");
        pagarComanda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarComandaActionPerformed(evt);
            }
        });

        labelTotalPago.setText("Total Pago");

        totalPago.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pagarComanda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTotalComanda)
                            .addComponent(labelTotalPago))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(totalComanda, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                            .addComponent(totalPago)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelFormaPagamento)
                            .addComponent(labelValorPagamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorPagamento)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(tituloPaginaComanda)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(labelCodigoComanda)
                        .addGap(68, 68, 68)
                        .addComponent(codigoComanda)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tituloPaginaComanda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(codigoComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCodigoComanda))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTotalComanda, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalComanda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotalPago)
                    .addComponent(totalPago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFormaPagamento)
                        .addGap(0, 74, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelValorPagamento)
                    .addComponent(valorPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pagarComanda)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void pagarComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarComandaActionPerformed
        String valorString = this.valorPagamento.getText().replace(",", ".");
        double valorDouble = Double.parseDouble(valorString);

        ComandaPagamento comandaPagamento = new ComandaPagamento();
        comandaPagamento.setComanda(comanda);
        comandaPagamento.setFormapagamento(formaPagamentoSelecionada);
        comandaPagamento.setValor(valorDouble);

        new CadastroComandaPagamento().cadastrar(comandaPagamento);
        this.dispose();
    }//GEN-LAST:event_pagarComandaActionPerformed

    private void totalComandaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalComandaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totalComandaActionPerformed

    private void formasPagamentoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_formasPagamentoValueChanged
        formaPagamentoSelecionada = formasPagamento.getSelectedValue();
    }//GEN-LAST:event_formasPagamentoValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codigoComanda;
    private javax.swing.JList<FormaPagamento> formasPagamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCodigoComanda;
    private javax.swing.JLabel labelFormaPagamento;
    private javax.swing.JLabel labelTotalComanda;
    private javax.swing.JLabel labelTotalPago;
    private javax.swing.JLabel labelValorPagamento;
    private javax.swing.JButton pagarComanda;
    private javax.swing.JLabel tituloPaginaComanda;
    private javax.swing.JTextField totalComanda;
    private javax.swing.JTextField totalPago;
    private javax.swing.JFormattedTextField valorPagamento;
    // End of variables declaration//GEN-END:variables
}
