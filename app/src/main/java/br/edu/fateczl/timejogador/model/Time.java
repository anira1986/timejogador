/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */


package br.edu.fateczl.timejogador.model;

public class Time {

    private int codigo;
    private String nome;
    private String cidade;

    // Construtor vazio
    public Time() {}

    // Construtor com parâmetros
    public Time(int codigo, String nome, String cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.cidade = cidade;
    }

    // Métodos getters e setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    // Sobrescrita do método toString()
    @Override
    public String toString() {
        return codigo + " - " + nome + " - " + cidade;
    }
}
