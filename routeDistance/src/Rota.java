public class Rota {
    private double distancia;
    private Cidade cidadeInicio;
    private Cidade cidadeFim;

    public Rota(double distancia, Cidade cidadeInicio, Cidade cidadeFim) {
        this.distancia = distancia;
        this.cidadeInicio = cidadeInicio;
        this.cidadeFim = cidadeFim;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public Cidade getCidadeInicio() {
        return cidadeInicio;
    }

    public void setCidadeInicio(Cidade cidadeInicio) {
        this.cidadeInicio = cidadeInicio;
    }

    public Cidade getCidadeFim() {
        return cidadeFim;
    }

    public void setCidadeFim(Cidade cidadeFim) {
        this.cidadeFim = cidadeFim;
    }
}
