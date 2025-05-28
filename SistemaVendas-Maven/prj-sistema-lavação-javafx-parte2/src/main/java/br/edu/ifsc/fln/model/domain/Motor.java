/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

/**
 *
 * @author mpisc
 */
public class Motor {
    private int potencia;
    private int qtdMaxima;
    private int qtdMinima;
    private ESituacao situacao = ESituacao.INATIVO;
    
    private Produto produto;

    public int getQuantidade() {
        return potencia;
    }

    public void setQuantidade(int potencia) {
        this.potencia = potencia;
    }

    public int getQtdMaxima() {
        return qtdMaxima;
    }

    public void setQtdMaxima(int qtdMaxima) {
        this.qtdMaxima = qtdMaxima;
    }

    public int getQtdMinima() {
        return qtdMinima;
    }

    public void setQtdMinima(int qtdMinima) {
        this.qtdMinima = qtdMinima;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public ESituacao getSituacao() {
        return situacao;
    }

    public void setSituacao(ESituacao situacao) {
        this.situacao = situacao;
    }
    
    public void repor(int qtd) throws Exception {
        if (situacao != ESituacao.ATIVO) {
            throw new Exception("Não é possível movimentar o estoque,\npois a situação do mesmo se encontra " + situacao.getDescricao());
        }
        if (this.potencia + qtd <= this.qtdMaxima) {
            this.potencia += qtd;
        } else {
            throw new Exception("A potencia de reposição não pode ser maior do que a capacidade do estoque."); 
        }
    }
    
    public void retirar(int qtd) throws Exception {
        if (situacao != ESituacao.ATIVO) {
            throw new Exception("Não é possível movimentar o estoque,\npois a situação do mesmo se encontra " + situacao.getDescricao());
        }
        if (this.potencia - qtd >= 0) {
            this.potencia -= qtd;
        } else {
            throw new Exception("Não há estoque suficiente para essa transação.");
        }
    }

    @Override
    public String toString() {
        return Integer.toString(this.potencia);
    }
    
    
}
