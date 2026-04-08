# Sistema de Aluguel de Filmes Online

## Descrição
Aplicação para gerenciar aluguel de filmes, permitindo cadastro, aluguel e devolução.

## Regras de Negócio Testadas
1. Um filme não pode ser alugado se já estiver alugado
2. Um filme não pode ser devolvido se não estiver alugado
3. O título do filme não pode ser vazio
4. O ano do filme deve ser válido (entre 1888 e 2025)
5. A listagem de disponíveis só retorna filmes não alugados

## Tecnologias
- Java
- JUnit 5

## Como executar os testes
```bash
javac -cp junit.jar src/*.java tests/*.java
java -cp .:junit.jar org.junit.runner.JUnitCore AluguelServiceTest
```