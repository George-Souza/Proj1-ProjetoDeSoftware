public class Usuario {
    String nome;
    String email;
    String senha;
    String tipo;
    boolean isCoordenador;
    Projeto projetoVinculado;
    Atividade atividadeVinculada;
    
    public Usuario(String nome, String email, String senha, String tipo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.projetoVinculado = null;
    }
    
    public Usuario() {
        this.projetoVinculado = null;
    }

    public String toString(){
        String retorno = "";
    
        retorno = "Nome do Usuário: " + this.getNome() +
        "\nEmail: " + this.getEmail() + "\nTipo de usuário: " + this.getTipo() + 
        "\n\n";
    
        return retorno;
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
    
    public Projeto getProjetoVinculado() {
        return projetoVinculado;
    }

    public void setProjetoVinculado(Projeto projetoVinculado) {
        this.projetoVinculado.addUsuario(this);
    }

    public Atividade getAtividadeVinculada() {
        return atividadeVinculada;
    }

    public void setAtividadeVinculada(Atividade atividadeVinculada) {
        this.atividadeVinculada.addProfissional(this);
    }

    public boolean isCoordenador() {
        return isCoordenador;
    }

    public void setCoordenador(boolean isCoordenador) {
        this.isCoordenador = isCoordenador;
    }
    
}
