public class Musico {
    private int id;
    private String nome;
    private String estiloMusical;
    private Double horasTocadas;
    private Double valorHoraTocada;

    public Musico(int id, String nome, String estiloMusical, Double horasTocadas, Double valorHoraTocada) {
        this.id = id;
        this.nome = nome;
        this.estiloMusical = estiloMusical;
        this.horasTocadas = horasTocadas;
        this.valorHoraTocada = valorHoraTocada;
    }

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

    public String getEstiloMusical() {
        return estiloMusical;
    }

    public void setEstiloMusical(String estiloMusical) {
        this.estiloMusical = estiloMusical;
    }

    public Double getHorasTocadas() {
        return horasTocadas;
    }

    public void setHorasTocadas(Double horasTocadas) {
        this.horasTocadas = horasTocadas;
    }

    public Double getValorHoraTocada() {
        return valorHoraTocada;
    }

    public void setValorHoraTocada(Double valorHoraTocada) {
        this.valorHoraTocada = valorHoraTocada;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Musico{");
        sb.append("id=").append(id);
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", estiloMusical='").append(estiloMusical).append('\'');
        sb.append(", horasTocadas=").append(horasTocadas);
        sb.append(", valorHoraTocada=").append(valorHoraTocada);
        sb.append('}');
        return sb.toString();
    }
}
