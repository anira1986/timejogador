/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.timejogador.controller;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.timejogador.model.Jogador;
import br.edu.fateczl.timejogador.persistence.JogadorDao;

public class JogadorController implements IController<Jogador> {

    private final JogadorDao jDao;

    // Construtor para inicializar o JogadorDao
    public JogadorController(JogadorDao jDao) {
        this.jDao = jDao;
    }

    @Override
    public void inserir(Jogador jogador) throws SQLException {
        try {
            jDao.open();
            jDao.insert(jogador);
        } finally {
            jDao.close();
        }
    }

    @Override
    public void modificar(Jogador jogador) throws SQLException {
        try {
            jDao.open();
            jDao.update(jogador);
        } finally {
            jDao.close();
        }
    }

    @Override
    public void deletar(Jogador jogador) throws SQLException {
        try {
            jDao.open();
            jDao.delete(jogador);
        } finally {
            jDao.close();
        }
    }

    @Override
    public Jogador buscar(Jogador jogador) throws SQLException {
        Jogador encontrado;
        try {
            jDao.open();
            encontrado = jDao.findOne(jogador);
        } finally {
            jDao.close();
        }
        return encontrado;
    }

    @Override
    public List<Jogador> listar() throws SQLException {
        List<Jogador> jogadores;
        try {
            jDao.open();
            jogadores = jDao.findAll();
        } finally {
            jDao.close();
        }
        return jogadores;
    }
}
