import java.util.List;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo();


        grafo.adicionarCidade("Mirim");
        grafo.adicionarCidade("Nova Brasilia");
        grafo.adicionarCidade("Paes Leme");
        grafo.adicionarCidade("Centro");
        grafo.adicionarCidade("Vila");
        grafo.adicionarCidade("Divineia");


        grafo.adicionarAresta(5, "Mirim", "Nova Brasilia");
        grafo.adicionarAresta(10, "Mirim", "Paes Leme");
        grafo.adicionarAresta(9, "Paes Leme", "Centro");
        grafo.adicionarAresta(1, "Paes Leme", "Vila");
        grafo.adicionarAresta(164, "Nova Brasilia", "Divineia");
        grafo.adicionarAresta(275, "Divineia", "Centro");
        grafo.adicionarAresta(3, "Vila", "Centro");
        grafo.adicionarAresta(9, "Centro", "Paes Leme");
        grafo.adicionarAresta(12, "Centro", "Nova Brasilia");

        // Solicitando a menor distância entre São Paulo e Brasília
        List<Cidade> menorDistancia = grafo.calcularMenorDistancia("Nova Brasilia", "Centro");

        System.out.println("A menor distância entre é:");
        Double distanciaTotal = 0.0;
        for (int i = 0; i < menorDistancia.size(); i++) {
            if (i < menorDistancia.size() - 1) {
                Rota aresta = menorDistancia.get(i).getArestaPara(menorDistancia.get(i + 1));
                System.out.println(menorDistancia.get(i).getNome() + " para " + menorDistancia.get(i + 1).getNome() + ": " + aresta.getDistancia() + " km");

                distanciaTotal = distanciaTotal + aresta.getDistancia();
            }
        }
        System.out.println("A distância total é:"+distanciaTotal);
        System.out.println("Os gastos com gasolina para um carro:"+ ((distanciaTotal/15)*5.59));
        Double tempo = (distanciaTotal/75);
        System.out.println("Os tempo com um carro:"+ tempo);
        System.out.println("Os preço comida com um carro:"+ ((tempo/3)*10));
    }
}