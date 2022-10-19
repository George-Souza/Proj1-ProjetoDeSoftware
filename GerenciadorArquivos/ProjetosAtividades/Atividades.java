package ProjetosAtividades;

import java.util.ArrayList;
import java.util.Scanner;
import Users.Profissional;
import Users.Usuario;

public class Atividades {
    private String descricao;
    private String data_hora_inicio;
    private String data_hora_final;
    private Usuario responsavel;
    private Projetos projetoCriador;
    private ArrayList<Profissional> profissionais;
    private String id;

    public Atividades(){
        System.out.println("Criando Atividade...");
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o nome da Atividade: ");
        this.setId(sc.nextLine());
        System.out.print("Digite a Descrição da Atividade: ");
        this.setDescricao(sc.nextLine());
        System.out.print("Data e Hora do início: ");
        this.setData_hora_inicio(sc.nextLine());
        System.out.print("Data e Hora do final: ");
        this.setData_hora_final(sc.nextLine());

        this.profissionais = new ArrayList<>();
    }

    public void editarInformacoesAtividade(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Editar informações\n1-Descrição\n2-Data e hora início"+
        "\n3-Data e hora fim");
        int op = sc.nextInt();
        sc.nextLine();

        switch(op){
            case 1:
                System.out.print("Digite a descrição: ");
                this.setDescricao(sc.nextLine());
                break;
            case 2:
                System.out.print("Digite data e hora inicial: ");
                this.setData_hora_inicio(sc.nextLine());
                break;
            case 3:
                System.out.print("Digite data e hora final: ");
                this.setData_hora_final(sc.nextLine());
                break;
            default:
                break;
        }
    }
    public void exibirInformacoes(){
        System.out.println("\nInformações sobre a Atividade: ");
        System.out.println("Descrição: "+this.getDescricao());
        System.out.println("ID: "+this.getId());
        System.out.println("Data e Hora do início: "+this.getData_hora_inicio());
        System.out.println("Data e Hora do fim: "+this.getData_hora_final());
    }

    public void listaDeProfissionais(){
        System.out.println("\nProfissionais na atividade...");
        for(Profissional p : profissionais){
            p.exibirInformacoes();
        }
    }

    public Profissional getPessoa(String nome){
        for(Profissional p : this.profissionais){
            if(p.getNome().equalsIgnoreCase(nome))
                return p;
        }
        return null;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getData_hora_inicio() {
        return data_hora_inicio;
    }

    public void setData_hora_inicio(String data_hora_inicio) {
        this.data_hora_inicio = data_hora_inicio;
    }

    public String getData_hora_final() {
        return data_hora_final;
    }

    public void setData_hora_final(String data_hora_final) {
        this.data_hora_final = data_hora_final;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addProfissional(Profissional p){
        profissionais.add(p);
        p.addAtividade(this);
    }
    
    public void removeProfissional(Profissional p){
        profissionais.remove(p);
        
    }
    
    public void setProjetoCriador(Projetos p){
        this.projetoCriador = p;
    }

    public Projetos getProjetoCriador(){
        return this.projetoCriador;
    }
}
