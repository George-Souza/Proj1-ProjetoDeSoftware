package Users;

import ProjetosAtividades.ProjetoBuilder;
import ProjetosAtividades.Projetos;

public class Coordenador extends Academico implements PagaBolsa{
    private Projetos projeto;
    private boolean temProjeto = false;

    public Coordenador(){
        super();
    }

    public boolean temProjeto(){
        return this.temProjeto;
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
        ProjetoBuilder pjB = new ProjetoBuilder();
        // Projetos pj = new Projetos();
        this.projeto = pjB.getProjeto();
        projeto.setCoordenador(this);
        this.temProjeto = true;
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
