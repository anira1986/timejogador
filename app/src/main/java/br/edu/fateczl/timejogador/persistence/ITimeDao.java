package br.edu.fateczl.timejogador.persistence;

import java.sql.SQLException;

public interface ITimeDao {

    // Método para abrir uma conexão com o banco de dados
    TimeDao open() throws SQLException;

    // Método para fechar a conexão com o banco de dados
    void close();
}
