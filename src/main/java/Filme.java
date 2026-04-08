package org.example;

public class Filme {
    private String titulo;
    private int ano;
    private boolean alugado;

    public Filme(String titulo, int ano) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título não pode ser vazio");
        }
        if (ano < 1888 || ano > 2025) {
            throw new IllegalArgumentException("Ano inválido");
        }
        this.titulo = titulo;
        this.ano = ano;
        this.alugado = false;
    }

    public String getTitulo() { return titulo; }
    public int getAno() { return ano; }
    public boolean isAlugado() { return alugado; }
    public void setAlugado(boolean alugado) { this.alugado = alugado; }
}