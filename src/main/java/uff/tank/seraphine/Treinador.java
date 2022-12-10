package uff.tank.seraphine;

import java.util.ArrayList;

public class Treinador extends Identificacao {
    private static int TotalTreinadores = 0;
    private String regiao;
    public ArrayList<Pokemon> pokemons;
    public Pokemon pokemonAtual;
    private static int idAtual;

    public Treinador(String nome, String regiao) {
        // Para criar um novo
        this.nome = nome;
        this.regiao = regiao;
        this.id = TotalTreinadores;
        this.pokemons = new ArrayList<Pokemon>();
        TotalTreinadores++;

        CadastroTreinador.cadastrarTreinador(this);
    }

    public Treinador(String nome, String regiao, int id) {
        // Instânciando treinador já existente
        this.nome = nome;
        this.regiao = regiao;
        this.id = id;
        this.pokemons = new ArrayList<Pokemon>();
    }

    public int getQtdPokemon() {
        return pokemons.size();
    }

    public String getNome() {
        return nome;
    }

    public String getRegiao() {
        return regiao;
    }

    public ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }

    public static int getTotalTreinadores() {
        return TotalTreinadores;
    }

    public static int getIdAtual() {
        return idAtual;
    }

    public void setIdAtual(int idAtual) {
        this.idAtual = idAtual;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void adicionarPokemon(Pokemon pokemon){
        if(pokemons.size() == 0){
            //Quando não se tem outro pokemon na lista, o pokemon atual é o recebido
            this.pokemonAtual = pokemon;
        }
        this.pokemons.add(pokemon);
    }

    @Override
    public String toString() {
        return "Treinador {" + "id = " + id + ", nome = " + nome + ", regiao = " + regiao + "}";
    }
}
