/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.padaria.padariaapp.entidades;

/**
 *
 * @author Enzo Teves
 */
public class Endereco {
    private int codigo;
    private String cep;
    private String cidade;
    private String estado;
    
    public void setCodigo(int codigo){
            this.codigo = codigo;
    }
    
        public int getCodigo(){
            return this.codigo;
        }
        
        public void setCep(String cep){
            this.cep = cep;
        }
        
        public String getCep(){
          return this.cep;
        }
        
        public void setCidade(String cidade){
            this.cidade = cidade;
        }
        public String getCidade(){
            return this.cidade;
        }
        
        public void setEstado(String estado){
            this.estado = estado;
        }
        
        public String getEstado(){
            return this.estado;
        }
}
