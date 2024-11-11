package br.edu.fateczl.timejogador.persistence;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.edu.fateczl.timejogador.model.Time;

public class TimeDao implements ITimeDao, ICRUDDao<Time> {

    private final Context context;
    private GenericDao gDao;
    private SQLiteDatabase database;

    // Construtor para inicializar o contexto
    public TimeDao(Context context) {
        this.context = context;
    }

    // Método para abrir a conexão com o banco de dados
    @Override
    public TimeDao open() throws SQLException {
        gDao = new GenericDao(context);
        database = gDao.getWritableDatabase();
        return this;
    }

    // Método para fechar a conexão com o banco de dados
    @Override
    public void close() {
        if (gDao != null) {
            gDao.close();
        }
    }

    // Método para inserir um novo time no banco de dados
    @Override
    public void insert(Time time) throws SQLException {
        ContentValues contentValues = getContentValues(time);
        database.insert("time", null, contentValues);
    }

    // Método para atualizar um time existente
    @Override
    public int update(Time time) throws SQLException {
        ContentValues contentValues = getContentValues(time);
        return database.update("time", contentValues, "codigo = ?", new String[]{String.valueOf(time.getCodigo())});
    }

    // Método para deletar um time do banco de dados
    @Override
    public void delete(Time time) throws SQLException {
        database.delete("time", "codigo = ?", new String[]{String.valueOf(time.getCodigo())});
    }

    // Método para buscar um time específico pelo código
    @SuppressLint("Range")
    @Override
    public Time findOne(Time time) throws SQLException {
        String sql = "SELECT * FROM time WHERE codigo = ?";
        Cursor cursor = database.rawQuery(sql, new String[]{String.valueOf(time.getCodigo())});

        if (cursor != null && cursor.moveToFirst()) {
            time.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
            time.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            time.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
            cursor.close();
            return time;
        }

        if (cursor != null) {
            cursor.close();
        }
        return null;
    }

    // Método para listar todos os times
    @SuppressLint("Range")
    @Override
    public List<Time> findAll() throws SQLException {
        List<Time> times = new ArrayList<>();
        String sql = "SELECT * FROM time";
        Cursor cursor = database.rawQuery(sql, null);

        if (cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    Time time = new Time();
                    time.setCodigo(cursor.getInt(cursor.getColumnIndex("codigo")));
                    time.setNome(cursor.getString(cursor.getColumnIndex("nome")));
                    time.setCidade(cursor.getString(cursor.getColumnIndex("cidade")));
                    times.add(time);
                } while (cursor.moveToNext());
            }
            cursor.close();
        }
        return times;
    }

    // Método utilitário para converter um objeto Time em ContentValues
    private static ContentValues getContentValues(Time time) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("codigo", time.getCodigo());
        contentValues.put("nome", time.getNome());
        contentValues.put("cidade", time.getCidade());
        return contentValues;
    }
}
