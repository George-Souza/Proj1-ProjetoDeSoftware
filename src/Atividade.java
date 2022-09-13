import java.util.ArrayList;

public class Atividade {
    String id;
    String descricao;
    String dataInicio;
    String dataFim;
    String horainicio;
    String horaFim;
    Usuario responsavel;
    ArrayList<Usuario> profissionaisEnvolv;
    ArrayList<Tarefa> tarefas;

    public Atividade(){
        profissionaisEnvolv = new ArrayList<>();
        tarefas = new ArrayList<>();
    }

    public String toString(){
        String retorno = "";

        retorno = "Título: " + this.getId() +
        "\nDescrição: " + this.getDescricao() +
        "\nData de início: " + this.getDataInicio() +
        "\nData de término: " + this.getDataFim() +
        "\nResponsável: " + this.getResponsavel().getNome() +
        "\n\n";
        return retorno;
    }

    public void addProfissional(Usuario p){
        profissionaisEnvolv.add(p);
        p.setAtividadeVinculada(this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public String getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(String horainicio) {
        this.horainicio = horainicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.addProfissional(responsavel);
        this.responsavel = responsavel;
    }
}
