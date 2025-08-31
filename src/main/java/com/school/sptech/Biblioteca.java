package com.school.sptech;

public class Biblioteca {
    private String nome;
    private Double multaDiaria;
    private Integer qtdLivros;
    private Boolean ativa;

    public Biblioteca(String nome, Double multaDiaria) {
        this.nome = nome;
        this.multaDiaria = multaDiaria;
        this.qtdLivros = 0;
        this.ativa = true;
    }

    public void registrarLivro(Integer quantidade) {
        if (quantidade != null && ativa == true && quantidade > 0) {
            qtdLivros += quantidade;
        }
    }

    public Integer emprestar(Integer quantidade) {
        if (quantidade != null && ativa == true && quantidade > 0 && quantidade <= qtdLivros) {
            qtdLivros -= quantidade;
            return quantidade;
        } else {
            return null;
        }
    }

    public Integer devolver(Integer quantidade) {
        if (quantidade != null && ativa == true && quantidade > 0) {
            qtdLivros += quantidade;
        }
        return quantidade;
    }

    public Integer desativar() {
        if (ativa != true) {
            return null;
        } else {
            Integer qtdAnterior = qtdLivros;
            ativa = false;
            qtdLivros = 0;
            return qtdAnterior;
        }
    }

    public void transferir(Biblioteca destino, Integer quantidade) {
        if (quantidade != null && ativa == true && destino.ativa == true && quantidade > 0 && quantidade <= qtdLivros) {
            qtdLivros -= quantidade;
            destino.registrarLivro(quantidade);
        }
    }

    public Boolean reajustarMulta(Double percentual) {
        if (percentual != null && percentual > 0) {
            multaDiaria += multaDiaria * percentual;
            return true;
        } else {
            return false;
        }
    }

    //Getters
    public String getNome() {
        return nome;
    }

    public Double getMultaDiaria() {
        return multaDiaria;
    }

    public Integer getQtdLivros() {
        return qtdLivros;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    // Setter
    public void setNome(String nome) {

    }

    // Teste uso manual
    public static void main(String[] args) {
        Biblioteca b1 = new Biblioteca("Central", 2.5);
        b1.registrarLivro(10);
        b1.emprestar(4);
        System.out.println(b1.getQtdLivros()); // Saída esperada: 6
    }
}
