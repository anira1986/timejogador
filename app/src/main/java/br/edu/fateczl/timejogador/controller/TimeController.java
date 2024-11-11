/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.timejogador.controller;

import java.sql.SQLException;
import java.util.List;

import br.edu.fateczl.timejogador.model.Time;
import br.edu.fateczl.timejogador.persistence.TimeDao;

public class TimeController implements IController<Time> {

    private final TimeDao tDao;

    // Construtor para inicializar o TimeDao
    public TimeController(TimeDao tDao) {
        this.tDao = tDao;
    }

    @Override
    public void inserir(Time time) throws SQLException {
        try {
            tDao.open();
            tDao.insert(time);
        } finally {
            tDao.close();
        }
    }

    @Override
    public void modificar(Time time) throws SQLException {
        try {
            tDao.open();
            tDao.update(time);
        } finally {
            tDao.close();
        }
    }

    @Override
    public void deletar(Time time) throws SQLException {
        try {
            tDao.open();
            tDao.delete(time);
        } finally {
            tDao.close();
        }
    }

    @Override
    public Time buscar(Time time) throws SQLException {
        Time encontrado;
        try {
            tDao.open();
            encontrado = tDao.findOne(time);
        } finally {
            tDao.close();
        }
        return encontrado;
    }

    @Override
    public List<Time> listar() throws SQLException {
        List<Time> times;
        try {
            tDao.open();
            times = tDao.findAll();
        } finally {
            tDao.close();
        }
        return times;
    }
}
