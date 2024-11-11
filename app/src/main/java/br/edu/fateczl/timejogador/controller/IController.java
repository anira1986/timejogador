/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.timejogador.controller;

import java.sql.SQLException;
import java.util.List;

public interface IController<T> {

    // Método para inserir um objeto
    void inserir(T t) throws SQLException;

    // Método para modificar um objeto existente
    void modificar(T t) throws SQLException;

    // Método para deletar um objeto
    void deletar(T t) throws SQLException;

    // Método para buscar um objeto específico
    T buscar(T t) throws SQLException;

    // Método para listar todos os objetos
    List<T> listar() throws SQLException;
}
