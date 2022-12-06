package Factory;
import Users.*;

public class AcademicoFactory extends AbstractFactory{

    @Override
    public Coordenador getCoordenador(String coordenador) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Profissional getProfissional(String profissional) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Academico getAcademico(String academico) {
        if(academico == null) return null;
        else{
            if(academico.equalsIgnoreCase("Graduando")) return new Graduando();
            else if(academico.equalsIgnoreCase("Mestrando")) return new Mestrando();
            else if(academico.equalsIgnoreCase("Doutorando")) return new Doutorando();
        }
        return null;
    }
    
}
