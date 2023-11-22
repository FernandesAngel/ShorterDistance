import java.util.ArrayList;

public class Cidade {
    private String nome;
    private ArrayList<Rota> rotasEntrada;
    private ArrayList<Rota> rotasSaida;

    public Cidade(String nome) {
        this.nome = nome;
        this.rotasEntrada = new ArrayList<>();
        this.rotasSaida = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarArestaSaida(Rota aresta) {
        this.rotasSaida.add(aresta);
    }

    public void adicionarArestaEntrada(Rota aresta) {
        this.rotasEntrada.add(aresta);
    }

    public ArrayList<Rota> getArestasSaida() {
        return this.rotasSaida;
    }

    public ArrayList<Rota> getArestasEntrada() {
        return this.rotasEntrada;
    }

    public Rota getArestaPara(Cidade cidade) {
        for (Rota aresta : this.rotasSaida) {
            if (aresta.getCidadeFim().equals(cidade)) {
                return aresta;
            }
        }
        return null;
    }
}
