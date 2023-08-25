package com.example.model;

public class Cliente{
    private double renda;
    private char sexo;
    private int anoNacimento;
    private String nome;

    public double getRenda() {
        return renda;
    }

    public void setRenda(double renda) {
        this.renda = renda;
    }
    public char getSexo() {
        return sexo;
    }
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }
    public int getAnoNacimento() {
        return anoNacimento;
    }
    public void setAnoNacimento(int anoNacimento) {
        this.anoNacimento = anoNacimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }    

    public String getNome() {
    return nome;
    }

}