package com.example.academiarecyclerview;

public class Aluno {
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String unidadeCadastro;

    // Construtor
    public Aluno(String nome, int idade, double altura, double peso, String unidadeCadastro) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.unidadeCadastro = unidadeCadastro;
    }

    // Métodos Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getUnidadeCadastro() {
        return unidadeCadastro;
    }

    public void setUnidadeCadastro(String unidadeCadastro) {
        this.unidadeCadastro = unidadeCadastro;
    }
}
