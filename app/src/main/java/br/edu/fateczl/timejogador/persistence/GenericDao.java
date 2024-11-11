package br.edu.fateczl.timejogador.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GenericDao extends SQLiteOpenHelper {

    // Nome do banco de dados e versão
    private static final String DATABASE = "FUTEBOL.DB";
    private static final int DATABASE_VER = 1;

    // Criação da tabela Time
    private static final String CREATE_TABLE_TIME =
            "CREATE TABLE time (" +
                    "codigo INTEGER PRIMARY KEY, " +
                    "nome VARCHAR(50) NOT NULL, " +
                    "cidade VARCHAR(80) NOT NULL);";

    // Criação da tabela Jogador
    private static final String CREATE_TABLE_JOGADOR =
            "CREATE TABLE jogador (" +
                    "id INTEGER PRIMARY KEY, " +
                    "nome VARCHAR(100) NOT NULL, " +
                    "data_nasc VARCHAR(10) NOT NULL, " +
                    "altura REAL NOT NULL, " +
                    "peso REAL NOT NULL, " +
                    "codigo_time INTEGER NOT NULL, " +
                    "FOREIGN KEY (codigo_time) REFERENCES time(codigo));";

    // Construtor da classe
    public GenericDao(Context context) {
        super(context, DATABASE, null, DATABASE_VER);
    }

    // Método para criar as tabelas no banco de dados
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TIME);
        db.execSQL(CREATE_TABLE_JOGADOR);
    }

    // Método para atualizar o banco de dados em caso de mudança de versão
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            db.execSQL("DROP TABLE IF EXISTS jogador");
            db.execSQL("DROP TABLE IF EXISTS time");
            onCreate(db);
        }
    }
}
