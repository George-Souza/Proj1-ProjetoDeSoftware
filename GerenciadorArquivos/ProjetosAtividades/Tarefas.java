package ProjetosAtividades;

import java.util.Scanner;

public class Tarefas {
    private String descricao;
    private String status;

    public Tarefas(){
        System.out.println("Criando Tarefa...");
        Scanner sc = new Scanner(System.in);
        System.out.print("Descrição da Tarefa: ");
        this.setDescricao(sc.nextLine());
        this.setStatus("Incacabada");
        sc.close();
    }

    public void exibirInformacoes(){
        System.out.println("\nInformações sobre a Tarefa:");
        System.out.println("Descrição: "+this.getDescricao());
        System.out.println("Status: "+this.getStatus());
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
