package br.mack.ps2.entidades;

public class Pais {
    private long id;
    private String nome;
    private int continente;
    private long populacao;

    public Pais() {}

    public Pais(long id, String nome, int continente, long populacao) {
        this.id = id;
        this.nome = nome;
        this.continente = continente;
        this.populacao = populacao;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getContinente() {
        return continente;
    }

    public void setContinente(int continente) {
        this.continente = continente;
    }

    public long getPopulacao() {
        return populacao;
    }

    public void setPopulacao(long populacao) {
        this.populacao = populacao;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", continente=" + continente +
                ", populacao=" + populacao +
                '}';
    }
}
