package ProjetosAtividades;

import java.util.Scanner;

public class ProjetoBuilder {
    private Projetos p;

    public ProjetoBuilder(){
        p = new Projetos();
        build(p);
    }

    private void build(Projetos p){
        Scanner sc = new Scanner(System.in);
        p.setStatus("Em Processo de Criação");
        System.out.println("Status do Projeto: "+p.getStatus()+"...\n");
        System.out.print("Digite o Nome do Projeto: ");
        p.setId(sc.nextLine());
        System.out.print("Digite a Descrição do Projeto: ");
        p.setDescricao(sc.nextLine());
        System.out.print("Data e Hora do início: ");
        p.setData_hora_inicio(sc.nextLine());
        System.out.print("Data e Hora do final: ");
        p.setData_hora_fim(sc.nextLine());
    }

    public Projetos getProjeto(){
        return this.p;
    }
}
