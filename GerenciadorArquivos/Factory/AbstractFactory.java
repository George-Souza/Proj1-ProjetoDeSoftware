package Factory;
import Users.Academico;
import Users.Coordenador;
import Users.Profissional;

public abstract class AbstractFactory{
    public abstract Coordenador getCoordenador(String coordenador);
    public abstract Profissional getProfissional(String profissional);
    public abstract Academico getAcademico(String academico);
}