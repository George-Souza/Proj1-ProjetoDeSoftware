package Iterator;
import java.util.List;

import ProjetosAtividades.Projetos;

public class ProjetoIterator implements Iterator{

    List<Projetos> projs;
    int pos = 0;

    public ProjetoIterator(List<Projetos> p){
        projs = p;
    }

    @Override
    public boolean hasNext() {
        if(pos >= projs.size() || projs.get(pos) == null)
            return false;
        else return true;
    }

    @Override
    public Object next() {
        Projetos p = projs.get(pos);
        pos++;
        return p;
    }
    
}
