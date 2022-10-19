package Users;

import java.util.Scanner;

public abstract class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String tipo;

    public Usuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Criando Usuário...");
        System.out.print("Nome: ");
        this.setNome(sc.nextLine());
        System.out.print("Email: ");
        this.setEmail(sc.nextLine());
        System.out.print("Senha: ");
        this.setSenha(sc.nextLine());
    }

    public void editarInformacoesUsuario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEditar as informações do usuário:\n1-Editar nome"+
        "\n2-Editar Email\n3-Editar Senha");
        int op = sc.nextInt();
        sc.nextLine();

        switch(op){
            case 1:
                System.out.print("Digite o nome: ");
                this.setNome(sc.nextLine());
                break;
            case 2:
                System.out.print("Digite o email: ");
                this.setEmail(sc.nextLine());
                break;
            case 3:
                System.out.print("Digite a senha: ");
                this.setSenha(sc.nextLine());
                break;
            default:
                break;
        }
    }

    public void exibirInformacoes(){
        System.out.println("\nInformações do Usuário: ");
        System.out.println("Nome: "+this.getNome());
        System.out.println("Email: "+this.getEmail());
        System.out.println("Tipo: "+this.getTipo());
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    
}
