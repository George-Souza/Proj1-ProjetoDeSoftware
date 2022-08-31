import java.util.ArrayList;
import java.util.Scanner;

public class SistemaGerenciador{
    ArrayList<Projeto> projetos;
    ArrayList<Usuario> users;
    Scanner sc;

    public SistemaGerenciador() {
        this.projetos = new ArrayList<>();
        this.users = new ArrayList<>();
        sc = new Scanner(System.in);
    }


    private void createProjeto(){
        sc.nextLine();
        Projeto pj = new Projeto();
        projetos.add(pj);
        pj.setNumero(projetos.indexOf(pj));
        System.out.println("Digite o nome do projeto: ");
        pj.setId(sc.nextLine());
        System.out.println("Digite a descrição do projeto: ");
        pj.setDescricao(sc.nextLine());
        System.out.println("Digite a data de inicio: ");
        pj.setDataInicio(sc.nextLine());
        System.out.println("Digite a data de término: ");
        pj.setDataFinal(sc.nextLine());
        System.out.println("Adicionar Coordenador");
        String nome = sc.nextLine();
        for(int i = 0; i < this.users.size(); i++){
            if(users.get(i).getNome() == nome){
                pj.setCoordenador(users.get(i));
            }
        }
        return;
    }

    public void exibirProjetos(){
        System.out.println("---Projetos---");
        for(Projeto p : projetos){
            System.out.println(p);
        }
        return;
    }

    public void addUser(){
        sc.nextLine();
        Usuario user = new Usuario();
        users.add(user);
        System.out.println("Nome: ");
        user.setNome(sc.nextLine());
        System.out.println("Email: ");
        user.setEmail(sc.nextLine());
        System.out.println("Senha: ");
        user.setSenha(sc.nextLine());
        return;
    }

    public void showUsers(){
        System.out.println("---Usuários---");
        for(Usuario u : users){
            System.out.println(u);
        }
    }

    public void inicio(){
        int op = 0;
        while(op != 4){
            System.out.println("------Sistema Gerenciador de projeto------");
            
            System.out.println("1 - Criar um novo projeto");
            System.out.println("2 - Exibir projetos");
            System.out.println("3 - Adicionar novo usuário");
            System.out.println("5 - Exibir usuários");
            System.out.println("4 - Fechar");
            System.out.print("Digite a atividade que deseja realizar: ");
            op = sc.nextInt();
            if(op == 1){
                this.createProjeto();
            } else if(op == 2){
                this.exibirProjetos();
            } else if(op == 3){
                this.addUser();
            } else if(op == 5){
                this.showUsers();
            }else if(op == 4){
                break;
            }
        }
 
    }

    
}
