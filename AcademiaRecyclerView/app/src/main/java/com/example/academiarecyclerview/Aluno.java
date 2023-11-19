package com.example.academiarecyclerview;

import java.util.Objects;

public class Aluno {
    // Construtor publico sem parametros (Realtime Database)
    public Aluno(){
    }

    private String id;
    private String nome;
    private int idade;
    private double altura;
    private double peso;
    private String unidadeCadastro;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return Objects.equals(getId(), aluno.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    // Construtor
    public Aluno(String nome, int idade, double altura, double peso, String unidadeCadastro) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
        this.peso = peso;
        this.unidadeCadastro = unidadeCadastro;
    }
    public void setUnidadeCadastro(String unidadeCadastro) {
        this.unidadeCadastro = unidadeCadastro;
    }
}
