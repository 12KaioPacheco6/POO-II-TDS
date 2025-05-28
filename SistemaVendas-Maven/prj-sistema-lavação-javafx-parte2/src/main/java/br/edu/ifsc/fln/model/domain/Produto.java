package br.edu.ifsc.fln.model.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class Produto implements Serializable {

    private int id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    
    private Cor cor;
//    private int id_cor.; ISSO É UM CRIME CONTRA A POO
    
    private Motor motor; //implementação do conceito de COMPOSIÇÃO - requer que o objeto seja construído pelo seu construtor, ou durante a declaração da variável
    // ou private Motor motor = new Motor(); //como o Motor é definido pela composição, também não é recomendado o método set para este atributo

    public Produto() {
        //qualquer construtor de Produto vai passar por este método para a a criação de motor
        this.createEstoque();
    }

    public Produto(int id, String nome, String descricao, BigDecimal preco) {
        this();
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        //this.createEstoque();
    }
    
    public Produto(int id, String nome, String descricao, BigDecimal preco, Cor cor) {
        this(id, nome, descricao, preco);
        this.cor = cor;
        //this.createEstoque();
    }

    private void createEstoque() {
        //associação bidirecional - define o motor do produto
        this.motor = new Motor();
        //atribui o produto ao motor
        this.motor.setProduto(this);
    }    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
    public Motor getEstoque() {
        return motor;
    }

    @Override
    public String toString() {
        return this.nome;
    }
    
}
