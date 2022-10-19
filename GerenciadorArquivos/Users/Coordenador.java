package Users;

import ProjetosAtividades.Projetos;

public class Coordenador extends Academico implements PagaBolsa{
    private Projetos projeto;

    public Coordenador(){
        super();
    }

    public boolean temProjeto(){
        return projeto == null;
    }

    public void addProfissional(Profissional p){
        projeto.addProfissional(p);
    }
    
    public void removeProfissional(Profissional p){
        projeto.removeProfissional(p);
    }

    public void addResponsavel(Usuario u, String indexAtv){
        projeto.getAtv(indexAtv).setResponsavel(u);
    }

    public void criaProjeto(){
        Projetos pj = new Projetos();
        this.projeto = pj;
        pj.setCoordenador(this);
    }

    public void exibeProjetos(){
        projeto.exibirInformacoes();
    }

    public Projetos getProjeto(){
        return this.projeto;
    }

    @Override
    public void pagaBolsa() {
        for(Profissional p : this.getProjeto().getProfissionais()){
            switch(p.getTipo()){
                case "Desenvolvedor":
                    p.receber(this.getProjeto().getBolsas()[0]);
                    break;
                case "Testador":
                    p.receber(this.getProjeto().getBolsas()[1]);
                    break;
                case "Analista":
                    p.receber(this.getProjeto().getBolsas()[2]);
                    break;
                case "Técnico":
                    p.receber(this.getProjeto().getBolsas()[3]);
                    break;
                default:
                    break;
            }
        }
        
    }

    
}
