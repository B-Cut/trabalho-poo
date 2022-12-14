package uff.tank.seraphine;

import org.json.simple.JSONObject;
import uff.tank.seraphine.utils.JSONUtils;
import java.util.ArrayList;
import static uff.tank.seraphine.utils.JSONUtils.getObjectByName;

public class Treinador {
    private String nome;
    protected int id;
    private static int TotalTreinadores = 0;
    private String regiao;
    public ArrayList<Pokemon> pokemons;
    public Pokemon pokemonAtual;

    public Treinador(String nome, String regiao) {
        // Para criar um novo
        this.nome = nome;
        this.regiao = regiao;
        this.id = JSONUtils.getLastId("assets/dados.json") + 1;
        this.pokemons = new ArrayList<Pokemon>();
        TotalTreinadores = JSONUtils.getTotalObjects("assets/dados.json");

        // Cadastro treinado é chamado também em TelaPrimeiraEscolha, o que cria
        // informação dobrada no dados.json
        // CadastroTreinador.cadastrarTreinador(this);
    }

    public Treinador(String nome, String regiao, int id, ArrayList<Pokemon> pokemons) {
        // Instânciando treinador já existente
        this.nome = nome;
        this.regiao = regiao;
        this.id = id;
        this.pokemons = pokemons;
        this.pokemonAtual = pokemons.get(0);
    }

    public int getQtdPokemon() {
        return this.pokemons.size();
    }

    public String getNome() {
        return this.nome;
    }

    public String getRegiao() {
        return this.regiao;
    }

    public ArrayList<Pokemon> getPokemons() {
        return this.pokemons;
    }

    public static int getTotalTreinadores() {
        return TotalTreinadores;
    }

    public void addPokemon(Pokemon pokemon) {
        this.pokemons.add(pokemon);
    }

    public void setPokemonAtual(Pokemon pkmn) {
        this.pokemonAtual = pkmn;
    }

    public Pokemon getPokemonAtual() {
        return this.pokemonAtual;
    }

    public int getId(){
        return this.id;
    }
    public void adicionarPokemon(Pokemon pokemon) {
        if (pokemons.size() == 0) {
            // Quando não se tem outro pokemon na lista, o pokemon atual é o recebido
            this.pokemonAtual = pokemon;
        }
        this.pokemons.add(pokemon);
    }

    public static Treinador getTreinadorFromJSONObject(JSONObject obj) {
        int id = Integer.parseInt(obj.get("Id").toString());
        String nome = obj.get("Nome").toString();
        String regiao = obj.get("Regiao").toString();

        ArrayList<String> listaPkmn = (ArrayList<String>) obj.get("Pokemons");
        ArrayList<Pokemon> pkmns = new ArrayList<Pokemon>();

        for (String pkmnNome : listaPkmn) {
            pkmns.add(
                    Pokemon.getPokemonFromJSONObject(
                            getObjectByName(pkmnNome, "assets/pokemon.json")));
        }

        return new Treinador(nome, regiao, id, pkmns);
    }

    @Override
    public String toString() {
        return "Treinador {" + "id = " + id + ", nome = " + nome + ", regiao = " + regiao + "}";
    }
}
