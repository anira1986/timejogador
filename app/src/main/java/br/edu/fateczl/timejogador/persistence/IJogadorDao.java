package br.edu.fateczl.timejogador.persistence;

import java.sql.SQLException;

public interface IJogadorDao {

    // Método para abrir uma conexão com o banco de dados
    JogadorDao open() throws SQLException;

    // Método para fechar a conexão com o banco de dados
    void close();
}
