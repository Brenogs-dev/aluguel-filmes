package org.example;

import org.example.AluguelService;
import org.example.Filme;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AluguelServiceTest {

    private AluguelService service;

    @BeforeEach
    void setUp() {
        service = new AluguelService();
    }

    @Test
    void deveAlugarFilmeDisponivel() {
        service.cadastrarFilme(new Filme("Matrix", 1999));
        service.alugarFilme("Matrix");
        assertTrue(service.listarDisponiveis().isEmpty());
    }

    @Test
    void naoDeveAlugarFilmeJaAlugado() {
        service.cadastrarFilme(new Filme("Matrix", 1999));
        service.alugarFilme("Matrix");
        assertThrows(IllegalStateException.class, () ->
                service.alugarFilme("Matrix")
        );
    }

    @Test
    void deveDevolverFilmeAlugado() {
        service.cadastrarFilme(new Filme("Matrix", 1999));
        service.alugarFilme("Matrix");
        service.devolverFilme("Matrix");
        assertEquals(1, service.listarDisponiveis().size());
    }

    @Test
    void naoDeveDevolverFilmeNaoAlugado() {
        service.cadastrarFilme(new Filme("Matrix", 1999));
        assertThrows(IllegalStateException.class, () ->
                service.devolverFilme("Matrix")
        );
    }

    @Test
    void naoDeveCadastrarFilmeComTituloVazio() {
        assertThrows(IllegalArgumentException.class, () ->
                new Filme("", 1999)
        );
    }

    @Test
    void naoDeveCadastrarFilmeComAnoInvalido() {
        assertThrows(IllegalArgumentException.class, () ->
                new Filme("Teste", 1800)
        );
    }

    @Test
    void deveListarApenasFilmesDisponiveis() {
        service.cadastrarFilme(new Filme("Matrix", 1999));
        service.cadastrarFilme(new Filme("Inception", 2010));
        service.alugarFilme("Matrix");
        assertEquals(1, service.listarDisponiveis().size());
        assertEquals("Inception", service.listarDisponiveis().get(0).getTitulo());
    }
}