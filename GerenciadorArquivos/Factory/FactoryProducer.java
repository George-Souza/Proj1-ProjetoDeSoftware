package Factory;

public class FactoryProducer {
    public static AbstractFactory getFactory(String escolha){
        if(escolha.equalsIgnoreCase("Profissional")) return new ProfissionalFactory();
        else if(escolha.equalsIgnoreCase("Coordenador")) return new CoordenadorFactory();
        else if(escolha.equalsIgnoreCase("Academico")) return new AcademicoFactory();
        else return null;
    }
}
