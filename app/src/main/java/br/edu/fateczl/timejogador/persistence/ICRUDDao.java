package br.edu.fateczl.timejogador.persistence;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDDao<T> {

    // Método para inserir um novo objeto no banco de dados
    void insert(T t) throws SQLException;

    // Método para atualizar um objeto existente no banco de dados
    int update(T t) throws SQLException;

    // Método para deletar um objeto do banco de dados
    void delete(T t) throws SQLException;

    // Método para buscar um objeto específico no banco de dados
    T findOne(T t) throws SQLException;

    // Método para buscar todos os objetos do banco de dados
    List<T> findAll() throws SQLException;
}
