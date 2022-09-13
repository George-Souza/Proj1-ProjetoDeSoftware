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

    // --------------------- Tela Inicial -------------------------------
    public void begin(){
        int op = 0;

        while(op == 0){
            System.out.println("\n--- Sistema de Gerenciamento de Projetos ---");
            System.out.println("Escolha uma das opções abaixo: ");
            System.out.println("1 - Efetuar login");
            System.out.println("2 - Cadastrar novo usuário");
            System.out.println("3 - Sair do sistema");
            System.out.println("4 - Buscar Usuário");
            System.out.println("5 - Buscar Projeto");

            op = sc.nextInt();
            if(op == 1){
                sc.nextLine();
                this.login();

            } else if(op == 2){
                sc.nextLine();
                this.cadastroUser();
            } else if(op == 3){
                return;
            } else if(op == 4){
                sc.nextLine();
                System.out.print("\nDigite o email: ");
                Usuario user = buscaUsuario(sc.nextLine());
                if(user != null){
                    System.out.println("\n"+user);
                    begin();
                } else{
                    System.out.println("Usuário não encontrado");
                    begin();
                }
            } else if(op == 5){
                sc.nextLine();
                System.out.print("\nDigite o nome: ");
                Projeto pj = buscaProjeto(sc.nextLine());
                if(pj != null){
                    System.out.println("\n"+pj);
                    begin();
                }
                begin();
            }
        }
    }

    // ------------------------ Tela de Cadastro -------------------------------

    public void cadastroUser(){
        Usuario u = new Usuario();

        System.out.print("Digite o nome de usuário: ");
        u.setNome(sc.nextLine());
        System.out.println();

        System.out.print("Digite o email: ");
        u.setEmail(sc.nextLine());
        System.out.println();

        System.out.print("Digite a Senha: ");
        u.setSenha(sc.nextLine());
        System.out.println();

        System.out.println("Quanto ao tipo de Usuário\nEscolha uma das opções abaixo: ");
        System.out.println("1 - Graduando\n2 - Mestrado\n3 - Doutorado\n4 - Professor\n"+
        "5 - Pesquisador\n6 - Desenvolvedor\n7 - Analista\n8 - Testador\n9 - Técnico");
        int op = sc.nextInt();

        switch (op) {
            case 1:
                u.setTipo("Graduação");
                break;
            case 2:
                u.setTipo("Mestrado");
                break;
            case 3:
                u.setTipo("Doutorado");
                break;
            case 4:
                u.setTipo("Professor");
                break;
            case 5:
                u.setTipo("Pesquisador");
                break;
            case 6:
                u.setTipo("Desenvolvedor");
                break;
            case 7:
                u.setTipo("Analista");
                break;
            case 8:
                u.setTipo("Testador");
                break;
            case 9:
                u.setTipo("Técnico");
                break;
        }
        sc.nextLine();
        System.out.println("Usuário cadastrado com Sucesso!");
        this.users.add(u);
        begin();
    }




    // ---------------------------- Tela de Login ------------------------------------------

    public void login(){
        System.out.println("\n--- Login ---");
        System.out.print("Digite o e-mail: ");
        String eMail = sc.nextLine();
        //System.out.println(eMail);
        System.out.print("\nDigite a Senha: ");
        String senha = sc.nextLine();
        //System.out.println(senha)
        if(buscaUser(eMail, senha) == "Sucesso"){
            System.out.println("\nEntrando...");
            Usuario user = buscaUsuario(eMail);
            userScreen(user);
            
            //this.telaOptions
        } else{
            System.out.println("Esqueceu a senha? (S-sim, N-não)");
            String resposta = sc.nextLine();
            if(resposta.equalsIgnoreCase("S")){
                System.out.print("Digite seu email: ");
                String email = sc.nextLine();
                String recuperada = buscaUser(email);
                if(!recuperada.equalsIgnoreCase("Usuario não encontrado")){
                    System.out.println("Sua senha é " + recuperada);
                    login();
                } else{
                    System.out.println("Usuário não encontrado");
                    login();
                }
            }
            else{
                System.out.println("Tente novamente...");
                login();
            }
        }
    }


    // -------------------------------- Tela do Usuário --------------------------------
    public void userScreen(Usuario u){
        System.out.println("\n---"+ u.getNome() +"---");

        System.out.println("Informações do Usuário:\nEmail: "+u.getEmail()+
        "\nGrau: "+u.getTipo());

        if(u.getTipo().equalsIgnoreCase("Pesquisador") || u.getTipo().equalsIgnoreCase("professor")){
            System.out.println("1 - Editar informações\n2 - Excluir usuário"+
            "\n3 - Criar novo projeto\n4 - Projetos\n5 - Alterar Status de Projeto"
            +"\n6 - Pagamento de bolsistas\n7 - Retornar");
            int answer = sc.nextInt();
            if(answer == 1){
                sc.nextLine();
                editUser(u);
            } else if(answer == 2){
                users.remove(u);
                begin();
            } else if(answer == 3){
                sc.nextLine();
                criaProjeto(u);
            } else if(answer == 4){
                sc.nextLine();
                telaProjetos(u);
            } else if(answer == 5){

                System.out.println("Diga o status:\n1 - Iniciado\n2 - Em andamento\n3 - Concluído");
                int op = sc.nextInt();
                if(op == 1)
                    u.getProjetoVinculado().setStatus("Iniciado");
                else if(op == 2)
                    u.getProjetoVinculado().setStatus("Em andamento");
                else if(op == 3)
                    u.getProjetoVinculado().setStatus("Concluído");
            } else if(answer == 6){
                sc.nextLine();
                pagaBolsa(u);
            } else if(answer == 7){
                sc.nextLine();
                begin();
            }
        } else{
            System.out.println("Saldo R$ " + u.getSaldo());
            System.out.println("1 - Editar informações\n2 - Excluir usuário"
            +"\n3 - Entrar em Projeto \n4 - Entrar em Atividade\n5 - Retornar");
            int answer = sc.nextInt();
            if(answer == 1){
                sc.nextLine();
                editUser(u);
            } else if(answer == 2){
                users.remove(u);
                begin();
            } else if(answer == 3){
                sc.nextLine();
                System.out.print("Digite o nome do projeto: ");
                Projeto pj = buscaProjeto(sc.nextLine());
                if(pj != null){
                    u.setProjetoVinculado(pj);
                } else{
                    System.out.println("\nProjeto não encontrado");
                    userScreen(u);
                }
            } else if(answer == 4){
                if(u.isVinculado()){
                    sc.nextLine();
                    System.out.print("Digite o nome da atividade: ");
                    Atividade atv = buscaAtividade(sc.nextLine(), u.getProjetoVinculado());
                    if(atv != null){
                        u.setAtividadeVinculada(atv);
                        userScreen(u);
                    }
                } else{
                    System.out.println("Atividade não encontrada");
                    userScreen(u);
                }
            } else if(answer == 5){
                sc.nextLine();
                begin();
            }
        }
    }


    // ------------------------- Tela de Edição Usuário -----------------------------
    public void editUser(Usuario u){
        System.out.println("--- Editar usuário ---");
        System.out.print("Editar nome: ");
        u.setNome(sc.nextLine());
        System.out.print("\nEditar email: ");
        u.setEmail(sc.nextLine());
        System.out.print("\nEditar senha: ");
        u.setSenha(sc.nextLine());
        System.out.println("\nEditar tipo de usuário: ");

        System.out.println("1 - Graduando\n2 - Mestrado\n3 - Doutorado\n4 - Professor\n"+
        "5 - Pesquisador\n6 - Desenvolvedor\n7 - Analista\n8 - Testador\n9 - Técnico");
        int op = sc.nextInt();

        switch (op) {
            case 1:
                u.setTipo("Graduação");
                break;
            case 2:
                u.setTipo("Mestrado");
                break;
            case 3:
                u.setTipo("Doutorado");
                break;
            case 4:
                u.setTipo("Professor");
                break;
            case 5:
                u.setTipo("Pesquisador");
                break;
            case 6:
                u.setTipo("Desenvolvedor");
                break;
            case 7:
                u.setTipo("Analista");
                break;
            case 8:
                u.setTipo("Testador");
                break;
            case 9:
                u.setTipo("Técnico");
                break;
        }
        sc.nextLine();
        System.out.println("Alterações feitas com sucesso");
        userScreen(u);
    }

    // --------------------------------- Tela de Criação de Projeto ---------------------
    public void criaProjeto(Usuario u){
        System.out.println("---Criação de Projeto---");
        Projeto pj = new Projeto();

        System.out.println(pj.getStatus());
        System.out.print("Nome do projeto: ");
        pj.setId(sc.nextLine());
        System.out.print("\nDescrição do Projeto: ");
        pj.setDescricao(sc.nextLine());
        System.out.print("\nData Inicio: ");
        pj.setDataInicio(sc.nextLine());
        System.out.print("\nData Término: ");
        pj.setDataFinal(sc.nextLine());
        System.out.print("\nHora Início: ");
        pj.setHoraInicio(sc.nextLine());
        System.out.print("\nHora Término: ");
        pj.setHoraFinal(sc.nextLine());
        System.out.println("Coordenador do Projeto: "+u.getNome());
        pj.addCoordenador(u);
        System.out.print("\nValor da Bolsa: ");
        pj.setValorBolsa(sc.nextDouble());
        projetos.add(pj);
        pj.setNumero(projetos.indexOf(pj));
        userScreen(u);
    }

    // --------------------------------- Tela de Projeto --------------------------------
    public void telaProjetos(Usuario u){
        Projeto pj = u.getProjetoVinculado();

        System.out.println("\n---Informações sobre o Projeto---");
        System.out.println(pj);

        System.out.println("\n1 - Editar Projeto\n2 - Criar Atividade\n3 - Excluir Projeto"+
        "\n4 - Adicionar Participante\n5 - Exibir Atividades\n6 - Fornecer Relatório");
        int answer = sc.nextInt();
        if(answer == 1){
            sc.nextLine();
            editarProjeto(pj, u);
        } else if(answer == 2){
            sc.nextLine();
            criarAtividade(pj, u);
        } else if(answer == 3){
            sc.nextLine();
            projetos.remove(pj);
            u.setProjetoVinculado(null);
            userScreen(u);
        } else if(answer == 4){
            sc.nextLine();
            System.out.print("Email do Participante: ");
            Usuario n = buscaUsuario(sc.nextLine());
            if(n != null){
                pj.addUsuario(n);
                telaProjetos(u);
            } else{
                System.out.println("Usuário não encontrado");
                telaProjetos(u);
            }
        } else if(answer == 5){
            sc.nextLine();
            exibirAtividades(pj);
            
        } else if(answer == 6){
            Relatorio(pj);
        }
    }

    // -------------------------------- Tela de Edição de Projeto ----------------------
    public void editarProjeto(Projeto pj, Usuario u){
        System.out.println("\n---Editar Projeto---");
        System.out.print("Status: ");
        pj.setStatus(sc.nextLine());
        System.out.print("\nNome do projeto: ");
        pj.setId(sc.nextLine());
        System.out.print("\nDescrição do Projeto: ");
        pj.setDescricao(sc.nextLine());
        System.out.print("\nData Inicio: ");
        pj.setDataInicio(sc.nextLine());
        System.out.print("\nData Término: ");
        pj.setDataFinal(sc.nextLine());
        System.out.print("\nHora Início: ");
        pj.setHoraInicio(sc.nextLine());
        System.out.print("\nHora Término: ");
        pj.setHoraFinal(sc.nextLine());
        System.out.println("Coordenador do Projeto: "+u.getNome());
        pj.addCoordenador(u);
        System.out.print("Valor da Bolsa: ");
        pj.setValorBolsa(sc.nextDouble());
    }

    // --------------------------------- Tela de criação de Atividade ---------------------------------
    
    public void criarAtividade(Projeto pj, Usuario u){
        Atividade atv = new Atividade();

        System.out.println("\n---Criação de Atividade---");
        System.out.print("\nNome da Atividade: ");
        atv.setId(sc.nextLine());
        System.out.print("\nDescrição: ");
        atv.setDescricao(sc.nextLine());
        System.out.print("\nData de Início: ");
        atv.setDataInicio(sc.nextLine());
        System.out.print("\nData de Término: ");
        atv.setDataFim(sc.nextLine());
        System.out.print("\nHora Início: ");
        atv.setHorainicio(sc.nextLine());
        System.out.print("\nHora Término: ");
        atv.setHoraFim(sc.nextLine());
        System.out.print("\nDigite o email do Responsavel: ");
        String email = sc.nextLine();
        Usuario nu = pj.buscaUsuario(email);
        if(nu != null){
            atv.setResponsavel(nu);
        }
        pj.addAtividade(atv);
        telaProjetos(u);
    }


    // ----------------------- Tela de Atividade ----------------------
    public void exibirAtividades(Projeto pj){
        System.out.println("\n-------- Atividades do projeto -------------");
        for(Atividade p : pj.atividades){
            System.out.println(p);
        }
    }

    // -------------------------- Fornecer Relatório ------------------------
    private void Relatorio(Projeto pj){
        System.out.println("\n------------------ Relatório de Projeto -----------");
        System.out.println(pj);
        exibirAtividades(pj);

    }

    // --------------- Paga Bolsas ---------------------
    private void pagaBolsa(Usuario u){
        for(Usuario us : u.getProjetoVinculado().profissionaisEnvolv){
            us.setSaldo(u.getProjetoVinculado().getValorBolsa());
        }
    }




    // ------------------------ Funções Acessórias -----------------------------

    // Função que procura se o usuário está na lista
    private String buscaUser(String email, String senha){
        for(Usuario u : this.users){
            if(u.getEmail().equalsIgnoreCase(email) && u.getSenha().equalsIgnoreCase(senha)){
                return "Sucesso";
            }
        }
        return "Usuario ou senha incorreto";
    }

    // Função que busca usuário e retorna a senha
    private String buscaUser(String email){
        for(Usuario u : this.users){
            if(u.getEmail().equalsIgnoreCase(email)){
                return u.getSenha();
            }
        }
        return "Usuario não encontrado";
    }

    private Usuario buscaUsuario(String email){
        for(Usuario u : users){
            if(u.getEmail().equalsIgnoreCase(email))
                return u;
        }
        return null;
    }

    private Projeto buscaProjeto(String nome){
        for(Projeto pj : projetos){
            if(pj.getId().equalsIgnoreCase(nome)){
                return pj;
            } 
        }
        return null;
    }

    private Atividade buscaAtividade(String nome, Projeto pj){
        for(Atividade atv : pj.atividades){
            if(atv.getId().equalsIgnoreCase(nome)){
                return atv;
            }
        }
        return null;
    }


}
