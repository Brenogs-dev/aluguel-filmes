package org.example;

import java.util.ArrayList;
import java.util.List;
import org.example.Filme;

public class AluguelService {
    private List<Filme> filmes = new ArrayList<>();

    public void cadastrarFilme(Filme filme) {
        filmes.add(filme);
    }

    public void alugarFilme(String titulo) {
        Filme filme = buscarPorTitulo(titulo);
        if (filme == null) {
            throw new IllegalArgumentException("Filme não encontrado");
        }
        if (filme.isAlugado()) {
            throw new IllegalStateException("Filme já está alugado");
        }
        filme.setAlugado(true);
    }

    public void devolverFilme(String titulo) {
        Filme filme = buscarPorTitulo(titulo);
        if (filme == null) {
            throw new IllegalArgumentException("Filme não encontrado");
        }
        if (!filme.isAlugado()) {
            throw new IllegalStateException("Filme não estava alugado");
        }
        filme.setAlugado(false);
    }

    public List<Filme> listarDisponiveis() {
        List<Filme> disponiveis = new ArrayList<>();
        for (Filme f : filmes) {
            if (!f.isAlugado()) {
                disponiveis.add(f);
            }
        }
        return disponiveis;
    }

    private Filme buscarPorTitulo(String titulo) {
        for (Filme f : filmes) {
            if (f.getTitulo().equalsIgnoreCase(titulo)) {
                return f;
            }
        }
        return null;
    }
}