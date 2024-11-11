/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.timejogador.model;

public class Jogador {

    private int id;
    private String nome;
    private String dataNasc;
    private float altura;
    private float peso;
    private Time time;

    // Construtor vazio
    public Jogador() {}

    // Construtor com parâmetros
    public Jogador(int id, String nome, String dataNasc, float altura, float peso, Time time) {
        this.id = id;
        this.nome = nome;
        this.dataNasc = dataNasc;
        this.altura = altura;
        this.peso = peso;
        this.time = time;
    }

    // Métodos getters e setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    // Sobrescrita do método toString()
    @Override
    public String toString() {
        return id + " - " + nome + " - " + dataNasc + " - Altura: " + altura + "m - Peso: " + peso + "kg - Time: " + (time != null ? time.getNome() : "Nenhum");
    }
}
