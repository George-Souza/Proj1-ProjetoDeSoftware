package Factory;
import Users.*;


public class ProfissionalFactory extends AbstractFactory{

    @Override
    public Coordenador getCoordenador(String coordenador) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Profissional getProfissional(String profissional) {
        if(profissional == null) return null;
        else{
            if(profissional.equalsIgnoreCase("Desenvolvedor")) return new Desenvolvedor();
            else if(profissional.equalsIgnoreCase("Tecnico")) return new Tecnico();
            else if(profissional.equalsIgnoreCase("Testador")) return new Testador(); 
            else if(profissional.equalsIgnoreCase("Analista")) return new Analista();
        }
        return null;
    }

    @Override
    public Academico getAcademico(String academico) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
