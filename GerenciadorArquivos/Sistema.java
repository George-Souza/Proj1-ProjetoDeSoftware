import java.util.ArrayList;
import java.util.Scanner;

import ProjetosAtividades.Atividades;
import ProjetosAtividades.Projetos;
import Users.Analista;
import Users.Coordenador;
import Users.Desenvolvedor;
import Users.Doutorando;
import Users.Graduando;
import Users.Mestrando;
import Users.Pesquisador;
import Users.Professor;
import Users.Profissional;
import Users.Tecnico;
import Users.Testador;
import Users.Usuario;

public class Sistema {
    private ArrayList<Usuario> users;
    private ArrayList<Projetos> projs;
    Scanner sc;

    public Sistema(){
        users = new ArrayList<>();
        projs = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void inicio(){
        System.out.println("\nBem Vindo ao Sistema de Projetos!\nEscolha uma das opções:");
        System.out.println("1-Login\n2-Cadastro\n3-Lista de Usuários\n4-Lista de Projetos"+
        "\n5-Buscar usuário\n6-Buscar Projeto\n7-Sair");
        int op = sc.nextInt();
        sc.nextLine();

        switch(op){
            case 1:
                Login();
                break;
            case 2:
                Cadastro();
                break;
            case 3:
                listaDeUsuarios();
                break;
            case 4:
                listaDeProjetos();
                break;
            case 5:
                System.out.print("Digite o nome do Usuário: ");
                String nome = sc.nextLine();
                System.out.println("Usuário: " + buscaUser(nome).getEmail());
                inicio();
                break;
            case 6:
                System.out.print("Digite o nome do Projeto: ");
                String id = sc.nextLine();
                Projetos p = buscaProjetos(id);
                if(p == null)
                    System.out.println("Projeto não existe");
                else
                    p.exibirInformacoes();

                inicio();
            case 7:
                break;
            default:
                inicio();
        }
    }

    public void Login(){
        System.out.println("\nLogin...");
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.println("Senha: ");
        String senha = sc.nextLine();
        Usuario u = buscaUser(email, senha);

        if(u != null){
            if(u.getTipo().equalsIgnoreCase("professor")||u.getTipo().equalsIgnoreCase("pesquisador")){
                Coordenador c = (Coordenador) u;
                telaUsuario(c);
            }
            else if(u.getTipo().equalsIgnoreCase("Desenvolvedor")||
            u.getTipo().equalsIgnoreCase("Analista") || u.getTipo().equalsIgnoreCase("Testador")||
            u.getTipo().equalsIgnoreCase("Técnico")){
                Profissional p = (Profissional) u;
                telaUsuario(p);
            }
            telaUsuario(u);
            
        } else{
            System.out.println("Algo deu errado...\nDeseja tentar novamente? (sim/nao)");
            String resposta = sc.nextLine();
            if(resposta.equalsIgnoreCase("sim")) Login();
            if(resposta.equalsIgnoreCase("nao")) inicio();
        }
        
    }

    public void telaUsuario(Coordenador c){
        System.out.println("\nTela do Usuário "+ c.getNome() +":");
        c.exibirInformacoes();
        System.out.println("\nAções:\n1-Editar usuário\n2-Criar Projeto"+
            "\n3-Verificar Projeto\n4-Pagar Profissionais\n5-Retornar");
            int op = sc.nextInt();
            switch(op){
                case 1:
                    c.editarInformacoesUsuario();
                    telaUsuario(c);
                case 2:
                    criaProjeto(c);
                    telaUsuario(c);
                case 3:
                    if(c.temProjeto())
                        telaProjeto(c.getProjeto());
                    telaUsuario(c);
                case 4:
                    c.pagaBolsa();
                    telaUsuario(c);
                case 5:
                    inicio();
                default:
                    telaUsuario(c);
            }

    }

    public void telaUsuario(Usuario u){
        System.out.println("\nTela do Usuário "+ u.getNome() +":");
        u.exibirInformacoes();
        System.out.println("\nAções:\n1-Editar usuário\n2-Lista de Projetos\n"+
        "\n3-Retornar");
        int op = sc.nextInt();
        sc.nextLine();
        switch(op){
            case 1:
                u.editarInformacoesUsuario();
                telaUsuario(u);
            case 2:
                System.out.print("\nDigite o nome do projeto: ");
                String nome = sc.nextLine();
                buscaProjetos(nome).exibirInformacoes();
                telaUsuario(u);
            case 3:
                inicio();
            default:
                telaUsuario(u);
        }
        
    }

    public void telaUsuario(Profissional u){
        System.out.println("\nTela do Usuário "+ u.getNome() +":");
        u.exibirInformacoes();
        System.out.println("\nAções:\n1-Editar usuário\n2-Lista de Projetos\n3-Solicitar participação"+
        "\n4-Retornar");
        int op = sc.nextInt();
        sc.nextLine();
        switch(op){
            case 1:
                u.editarInformacoesUsuario();
                telaUsuario(u);
            case 2:
                System.out.print("\nDigite o nome do projeto: ");
                String nome = sc.nextLine();
                buscaProjetos(nome).exibirInformacoes();
                telaUsuario(u);
            case 3:
                String id = sc.nextLine();
                solicitarParticipar(id, u);
                telaUsuario(u);
            case 4:
                inicio();
            default:
                telaUsuario(u);
        }
        
    }

    private void solicitarParticipar(String nome, Profissional u){
        buscaProjetos(nome).addNaPilha(u);
        telaUsuario(u);
    }

    private Projetos buscaProjetos(String nome){
        for(Projetos p : projs){
            if(p.getId().equalsIgnoreCase(nome)){
                return p;
            }
        }
        return null;
    }

    private void criaProjeto(Coordenador c){
        c.criaProjeto();
        projs.add(c.getProjeto());
        telaUsuario(c);
    }

    private Usuario buscaUser(String email, String senha){
        for(Usuario u : users){
            if(u.getEmail().equalsIgnoreCase(email) && u.getSenha().equalsIgnoreCase(senha)){
                return u;
            }
        }
        return null;
    }

    public void Cadastro(){
        System.out.println("Cadastro de Usuário");
        System.out.println("\nEscolha seu tipo de usuário:\n1-Graduando\n2-Mestrando\n3-Doutorando"+
        "\n4-Professor\n5-Pesquisador\n6-Desenvolvedor\n7-Analista\n8-Testador\n9-Técnico\n10-Voltar");
        Usuario u;
        int op = sc.nextInt();
        sc.nextLine();
        switch(op){
            case 1:
                u = new Graduando();
                users.add(u);
                inicio();
            case 2:
                u = new Mestrando();
                users.add(u);
                inicio();
            case 3:
                u = new Doutorando();
                users.add(u);
                inicio();
            case 4:
                u = new Professor();
                users.add(u);
                inicio();
            case 5:
                u = new Pesquisador();
                users.add(u);
                inicio();
            case 6:
                u = new Desenvolvedor();
                users.add(u);
                inicio();
            case 7:
                u = new Analista();
                users.add(u);
                inicio();
            case 8:
                u = new Testador();
                users.add(u);
                inicio();
            case 9:
                u = new Tecnico();
                users.add(u);
                inicio();
            case 10:
                inicio();
            default:
                Cadastro();
        }
    }

    public void listaDeUsuarios(){
        System.out.println("\nLista de Usuários do Sistema:\n");
        for(Usuario u : users){
            u.exibirInformacoes();
            System.out.println();
        }
        inicio();
    }

    private void listaDeProjetos(){
        System.out.println("\nLista de Projetos do Sistema:\n");
        for(Projetos p : projs){
            p.exibirInformacoes();
            p.exibirBolsas();
            System.out.println();
        }
        inicio();
    }

    private Usuario buscaUser(String nome){
        for(Usuario u : users){
            if(u.getNome().equalsIgnoreCase(nome)){
                return u;
            }
        }
        return null;
    }

    public void telaProjeto(Projetos p){
        System.out.println("\nTela do Projeto "+p.getId());
        p.exibirInformacoes();

        System.out.println("\nAções:1-Editar as Informações\n2-Criar Atividade"+
        "\n3-Verificar Lista de Participantes\n4-Adicionar novo participante\n5-Retornar"+
        "\n6-Lista de Solicitantes\n7-Verificar Atividades\n8-Ir até atividade");
        int op = sc.nextInt();
        sc.nextLine();

        switch(op){
            case 1:
                p.editarInformacoesProjeto();
                telaProjeto(p);
            case 2:
                p.criaAtividade();
                telaProjeto(p);
            case 3:
                p.listaDeProfissionais();
                telaProjeto(p);
            case 4:
                p.addProfissional(p.getPilhaDeEspera().firstElement());
                telaProjeto(p);
            case 5:
                telaUsuario(p.getCoordenador());
            case 6:
                for(Profissional pr : p.getPilhaDeEspera()){
                    pr.exibirInformacoes();
                }
                telaProjeto(p);
            case 7:
                p.listaDeAtividades();
                telaProjeto(p);
            case 8:
                System.out.print("Digite o nome da atividade: ");
                String id = sc.nextLine();
                Atividades atv = p.getAtv(id);
                if(atv == null){
                    System.out.println("Atividade não existe");
                    telaProjeto(p);
                }
                telaAtividade(atv);
            default:
                telaProjeto(p);
        }
    }

    public void telaAtividade(Atividades atv){
        System.out.println("\nTela da Atividade "+atv.getId());
        atv.exibirInformacoes();
        System.out.println("\nAções:\n1-Editar informações\n2-Adicionar Participante"+
        "\n3-Lista de Profissionais\4-Responsável\n5-Retorno");
        int op = sc.nextInt();
        sc.nextLine();
        switch(op){
            case 1:
                atv.editarInformacoesAtividade();
                telaAtividade(atv);
            case 2:
                System.out.print("Digite o nome do Participante: ");
                String n = sc.nextLine();
                Profissional p = atv.getProjetoCriador().getProfissional(n);
                if(p == null){
                    System.out.println("Profissional não encontrado...");
                    telaAtividade(atv);
                }
                atv.addProfissional(p);
                telaAtividade(atv);
            case 3:
                atv.listaDeProfissionais();
                telaAtividade(atv);
            case 4:
                System.out.print("Digite o nome do usuário: ");
                String k = sc.nextLine();
                Profissional l = atv.getPessoa(k);
                atv.setResponsavel(l);
                telaAtividade(atv);
            case 5:
                telaProjeto(atv.getProjetoCriador());
        }
    }

}
