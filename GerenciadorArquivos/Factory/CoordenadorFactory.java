package Factory;
import Users.*;

public class CoordenadorFactory extends AbstractFactory{

    @Override
    public Coordenador getCoordenador(String coordenador) {
        if(coordenador == null) return null;
        else{
            if(coordenador.equalsIgnoreCase("Pesquisador")) return new Pesquisador();
            else if(coordenador.equalsIgnoreCase("Professor")) return new Professor();
        }
        return null;
    }

    @Override
    public Profissional getProfissional(String profissional) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Academico getAcademico(String academico) {
        // TODO Auto-generated method stub
        return null;
    }
    
}
