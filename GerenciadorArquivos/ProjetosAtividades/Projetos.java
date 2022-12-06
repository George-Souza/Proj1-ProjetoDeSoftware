package ProjetosAtividades;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

import Users.Coordenador;
import Users.Profissional;

public class Projetos {
    private String descricao;
    private String data_hora_inicio;
    private String data_hora_fim;
    private String status;
    private Coordenador coordenador;
    private ArrayList<Profissional> profissionais;
    private ArrayList<Atividades> atividades;
    private double[] bolsas;
    private Stack<Profissional> pilhaDeEspera;
    private String vigenciaBolsa;
    private String id;

    public Projetos(){
        this.profissionais = new ArrayList<>();
        this.atividades = new ArrayList<>();
        this.bolsas = new double[4];
        this.pilhaDeEspera = new Stack<>();
    }

    public void exibirInformacoes(){
        System.out.println("\nInformações sobre o Projeto:");
        System.out.println("Coordenador: "+this.coordenador.getEmail());
        System.out.println("Nome do Projeto: "+this.getId());
        System.out.println("Descrição: "+this.getDescricao());
        System.out.println("Status: "+this.getStatus());
        System.out.println("Data e Hora do início: "+this.getData_hora_inicio());
        System.out.println("Data e Hora do fim: "+this.getData_hora_fim());

    }

    public void listaDeProfissionais(){
        System.out.println("\nProfissionais no projeto...");
        for(Profissional p : profissionais){
            p.exibirInformacoes();
            System.out.println("Índice: "+profissionais.indexOf(p));
        }
    }

    public void editarInformacoesProjeto(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nO que deseja editar?\n"+"1-Descrição\n2-Data e hora início"+
        "\n3-Data e hora fim\n4-Período de vigência da bolsa\n5-Alterar o Status"+
        "\n6-Bolsas");
        int op = sc.nextInt();
        sc.nextLine();
        try {
            switch (op) {
                case 1:
                    System.out.print("Digite a Descrição: ");
                    this.setDescricao(sc.nextLine());
                    break;
                case 2:
                    System.out.print("Digite a data e hora: ");
                    this.setData_hora_inicio(sc.nextLine());
                    break;
                case 3:
                    System.out.print("Digite a data e hora: ");
                    this.setData_hora_fim(sc.nextLine());
                    break;
                case 4:
                    System.out.print("Digite o período de vigência das bolsas: ");
                    this.setVigenciaBolsa(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Digite o Estado:\n1-Iniciado\n2-Concluído\n");
                    int np = sc.nextInt();
                    if(np == 1) this.setStatus("Iniciado");
                    else if(np == 2) this.setStatus("Concluído");
                    sc.nextLine();
                    break;
                case 6:
                    this.setBolsas();
                    break;
                default:
                    break;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            editarInformacoesProjeto();
        }
       
    }

    public void criaAtividade(){
        Atividades atv = new Atividades();
        this.atividades.add(atv);
        atv.setProjetoCriador(this);
    }

    public void setBolsas(){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.print("Digite a Bolsa para Desenvolvedor: ");
            bolsas[0] = sc.nextDouble();
            System.out.print("Digite a Bolsa para Testador: ");
            bolsas[1] = sc.nextDouble();
            System.out.print("Digite a Bolsa para Analista: ");
            bolsas[2] = sc.nextDouble();
            System.out.print("Digite a Bolsa para Técnico: ");
            bolsas[3] = sc.nextDouble();
            sc.nextLine();

        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public void listaDeAtividades(){
        for(Atividades atv : atividades){
            atv.exibirInformacoes();
        }
    }

    public void exibirBolsas(){
        System.out.println("Valor da bolsa para desenvolvedor: R$"+bolsas[0]);
        System.out.println("Valor da bolsa para testador: R$"+bolsas[1]);
        System.out.println("Valor da bolsa para analista: R$"+bolsas[2]);
        System.out.println("Valor da bolsa para técnico: R$"+bolsas[3]);
    }

    public double[] getBolsas(){
        return this.bolsas;
    }

    public void addNaPilha(Profissional p){
        this.pilhaDeEspera.add(p);
    }

    public String getDescricao() {
        return descricao;
    }

    public String getData_hora_inicio() {
        return data_hora_inicio;
    }

    public String getData_hora_fim() {
        return data_hora_fim;
    }

    public String getStatus() {
        return status;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setData_hora_inicio(String data_hora_inicio) {
        this.data_hora_inicio = data_hora_inicio;
    }

    public void setData_hora_fim(String data_hora_fim) {
        this.data_hora_fim = data_hora_fim;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Coordenador getCoordenador() {
        return coordenador;
    }

    public void setCoordenador(Coordenador coordenador) {
        this.coordenador = coordenador;
    }

    public void addProfissional(Profissional p){
        profissionais.add(p);
        p.addProjeto(this);
    }
    
    public void removeProfissional(Profissional p){
        profissionais.remove(p);
    }

    public Atividades getAtv(String index){
        for(Atividades atv : this.atividades){
            if(atv.getId().equalsIgnoreCase(index))
                return atv;
        }
        return null;
    }

    public String getVigenciaBolsa() {
        return vigenciaBolsa;
    }

    public void setVigenciaBolsa(String vigenciaBolsa) {
        this.vigenciaBolsa = vigenciaBolsa;
    }

    public ArrayList<Profissional> getProfissionais() {
        return profissionais;
    }

    public ArrayList<Atividades> getAtividades() {
        return atividades;
    }

    public Stack<Profissional> getPilhaDeEspera() {
        return pilhaDeEspera;
    }
    
    public Profissional getProfissional(String n){
        for(Profissional p : this.profissionais){
            if(p.getNome().equalsIgnoreCase(n)){
                return p;
            }
        }
        return null;
    }
}
