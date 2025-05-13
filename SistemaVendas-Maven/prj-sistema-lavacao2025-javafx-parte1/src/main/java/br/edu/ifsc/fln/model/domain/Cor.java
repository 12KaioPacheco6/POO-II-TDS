/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifsc.fln.model.domain;

public class Cor {
    private int id;
    private String cor;

    public Cor(String descricao) {
        this.descricao = cor;
    }

    public Cor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return cor;
    }

    public void setDescricao(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return cor;
    }
    
}
