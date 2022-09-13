import java.util.ArrayList;

public class Projeto {
    int numero;
    String id;
    String descricao;
    String status;
    String dataInicio;
    String dataFinal;
    String horaInicio;
    String horaFinal;
    Usuario coordenador;
    ArrayList<Usuario> profissionaisEnvolv;
    ArrayList<Atividade> atividades;
    Double valorBolsa;
    String periodoVigenciaBolsa;

    public Projeto(){
        this.status = "Em processo de criação";
        profissionaisEnvolv = new ArrayList<>();
        atividades = new ArrayList<>();
        this.coordenador = null;
    }
    
    public String toString(){
        String retorno = "";

        retorno = "Número do projeto: " + this.getNumero() + 
        "\nNome do projeto: " + this.getId() + 
        "\nDescrição do projeto: " + this.getDescricao() +
        "\nData de início: " + this.getDataInicio() + 
        "\nData de término: " + this.getDataFinal() +
        "\nCoordenador: " + this.getCoordenador().getEmail() +
        "\n\n";

        return retorno;
    }

    public void addCoordenador(Usuario coord){
        this.addUsuario(coord);
        this.coordenador = coord;
        coord.setCoordenador(true);
    }
    
    public void addUsuario(Usuario user){
        profissionaisEnvolv.add(user);
        user.projetoVinculado = this;
    }

    public void addAtividade(Atividade atv){
        this.atividades.add(atv);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorBolsa() {
        return valorBolsa;
    }

    public void setValorBolsa(Double valorBolsa) {
        this.valorBolsa = valorBolsa;
    }

    public Usuario getCoordenador(){
        return this.coordenador;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Usuario buscaUsuario(String email){
        for(Usuario u : profissionaisEnvolv){
            if(u.getEmail().equalsIgnoreCase(email)){
                return u;
            }
        }
        return null;
    }
}
