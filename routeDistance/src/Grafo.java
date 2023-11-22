import java.util.*;

public class Grafo {

    private ArrayList<Cidade> cidades;
    private ArrayList<Rota> arestas;

    public Grafo() {
        this.cidades = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public void adicionarCidade(String nome) {
        Cidade novaCidade = new Cidade(nome);
        this.cidades.add(novaCidade);
    }

    public Cidade getCidade(String nome) {
        for (Cidade cidade : this.cidades) {
            if (cidade.getNome().equals(nome)) {
                return cidade;
            }
        }
        return null;
    }

    public void adicionarAresta(double distancia, String nomeCidadeInicio, String nomeCidadeFim) {
        Cidade cidadeInicio = this.getCidade(nomeCidadeInicio);
        Cidade cidadeFim = this.getCidade(nomeCidadeFim);
        Rota aresta = new Rota(distancia, cidadeInicio, cidadeFim);
        cidadeInicio.adicionarArestaSaida(aresta);
        cidadeFim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }
    public List<Cidade> calcularMenorDistancia(String nomeCidadeInicio, String nomeCidadeFim) {
        Cidade cidadeInicio = this.getCidade(nomeCidadeInicio);
        Cidade cidadeFim = this.getCidade(nomeCidadeFim);

        Map<Cidade, Double> distancias = new HashMap<>();
        Map<Cidade, Cidade> anteriores = new HashMap<>();
        PriorityQueue<Cidade> fila = new PriorityQueue<>(Comparator.comparingDouble(distancias::get));

        for (Cidade cidade : this.cidades) {
            if (cidade.equals(cidadeInicio)) {
                distancias.put(cidade, 0.0);
            } else {
                distancias.put(cidade, Double.MAX_VALUE);
            }
            fila.add(cidade);
        }

        while (!fila.isEmpty()) {
            Cidade atual = fila.poll();

            for (Rota aresta : atual.getArestasSaida()) {
                Cidade vizinho = aresta.getCidadeFim();
                double distanciaAlternativa = distancias.get(atual) + aresta.getDistancia();

                if (distanciaAlternativa < distancias.get(vizinho)) {
                    fila.remove(vizinho);
                    distancias.put(vizinho, distanciaAlternativa);
                    anteriores.put(vizinho, atual);
                    fila.add(vizinho);
                }
            }
        }

        List<Cidade> caminho = new ArrayList<>();
        for (Cidade cidade = cidadeFim; cidade != null; cidade = anteriores.get(cidade)) {
            caminho.add(cidade);
        }

        Collections.reverse(caminho);
        return caminho;
    }


}
